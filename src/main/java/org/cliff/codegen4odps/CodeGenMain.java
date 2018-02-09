package org.cliff.codegen4odps;

import com.aliyun.odps.*;
import org.cliff.codegen4odps.model.ColumnModel;
import org.cliff.codegen4odps.model.DataBaseModel;
import org.cliff.codegen4odps.model.TableModel;
import org.cliff.codegen4odps.model.TemplateInfo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 类CodeGenMain.java的实现描述：代码生成入口
 * 
 * @author JianLin.Zhu 2015-7-27 下午4:40:53
 */
public class CodeGenMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStream in = CodeGenMain.class.getClassLoader().getResourceAsStream("codegen4odps.properties");
            Properties p = new Properties();
            p.load(in);
            in.close();
            
            String outputdir = p.getProperty("outputdir","./output/odps/");// 输出目录,可修改,比如改为D:/output
            
            DataBaseModel dataBaseModel = loadDataBaseModel(p);
            String templateSourceDir = "./template4odps/";// 模板根目录，不建议修改
            List<TemplateInfo> list = TemplateConfig.ReadConfigXml("./template4odps/template.xml");// 读取模版配置文件
            for (int i = 0; i < list.size(); i++) {
                TemplateInfo templateInfo = (TemplateInfo) list.get(i);
                System.out.println("start deal template:" + templateInfo.getTemplateName());
                Generator.generateTableContext(dataBaseModel, templateInfo, outputdir, templateSourceDir);// 进行表模版生成
                System.out.println("finish " + templateInfo.getTemplateName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载数据库schema
     */
    private static DataBaseModel loadDataBaseModel(Properties p) throws Exception {
        DataBaseModel dataBaseModel = new ReadOdps().genarateOdpsDataBase(p);
        return dataBaseModel;
    }

    public static class ReadOdps {

        public DataBaseModel genarateOdpsDataBase(Properties p) {
            String accessId = p.getProperty("accessId","");
            String accessKey = p.getProperty("accessKey","");
            String odpsUrl = p.getProperty("odpsUrl","");
            String project = p.getProperty("project","");
            Odps odps = OdpsUtil.getInstance(accessId,accessKey,odpsUrl,project);

            String database = project;
            String packname = p.getProperty("packname","");// bean所属组,默认用空字符串即可
            String tableNamePrefix = p.getProperty("tableNamePrefix","s_");// 设置表名前缀
            String tablename = p.getProperty("tablename","s_body");// 多个用逗号分隔即可
            String author = p.getProperty("author","JianLin.Zhu");
            //--------------生成代码前修改如下配置 end----------------------------//

            DataBaseModel db = new DataBaseModel();
            db.setDataBaseName(database);
            db.setAuthor(author);// 设置签名
            try {
                List<TableModel> tableModelList = new ArrayList<TableModel>();
                List<Table> need = filterTables(odps, tablename);
                tableModelList.addAll(parseTables(need,packname,tableNamePrefix));
                db.setTableModelList(tableModelList);
            }catch (Exception e){
                e.printStackTrace();
            }
            return db;
        }

        private List<Table> filterTables(Odps odps, String tablename) {
            List<String> tableNames = Arrays.asList(tablename.split(","));
            List<Table> need = new ArrayList<Table>();
            for(String t:tableNames){
                Table tmp= null;
                if((tmp=odps.tables().get(t))!=null){
                    need.add(tmp);
                }
            }
            return need;
        }

        /**
         * 开始处理生成所有表 如果不传入表名，表示将数据库中所有表生成bean; 可以指定表名生成bean;
         */
        public List<TableModel> parseTables(List<Table> tables, String packname, String tableNamePrefix) {
            List<TableModel> result = new ArrayList<TableModel>();
            for(Table table:tables){
                result.add(parseTableByShowCreate(table, table.getName(), packname, tableNamePrefix));
            }
            return result;
        }



        /**
         * @param packname
         */
        private TableModel parseTableByShowCreate(Table t,String tablename, String tableNamePrefix, String packname) {
            TableModel table = new TableModel();
            table.setTableName(tablename);
            table.setModuleName(packname);
            table.setTableNamePrefix(tableNamePrefix);
            List<ColumnModel> columnList = new ArrayList<ColumnModel>();
            table.setColumnList(columnList);

            for(Column column:t.getSchema().getColumns()){
                ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(column.getName());
                columnModel.setSourceColumnType(firstUpper(column.getType().name()));
                columnModel.setColumnType(typeTrans(column.getType()));
                columnModel.setRemark(column.getComment());
                columnModel.setColumnChineseName(column.getName());

                columnList.add(columnModel);
            }

            return table;
        }

        private static String firstUpper(String src){
          return  src.substring(0, 1).toUpperCase().concat(src.substring(1).toLowerCase());
        }

        /**
         * mysql的类型转换到java 类型参考文章 http://hi.baidu.com/wwtvanessa/blog/item/9fe555945a07bd16d31b70cd.html
         */
        public String typeTrans(OdpsType odpsType) {
            switch (odpsType){
                case BIGINT:
                    return "Long";
                case DATETIME:
                    return "Date";
                case DECIMAL:
                    return "Double";
                case STRING:
                    return "String";
                case DOUBLE:
                    return "Double";
                case BOOLEAN:
                    return "Boolean";
                case ARRAY:
                case MAP:
                default:
                    throw new IllegalArgumentException(odpsType.name()+" unsupport type");
            }


        }

        public String upperFirestChar(String src) {
            return src.substring(0, 1).toUpperCase().concat(src.substring(1));
        }
    }

}
