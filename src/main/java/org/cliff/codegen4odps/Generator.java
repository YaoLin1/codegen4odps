package org.cliff.codegen4odps;

import org.cliff.codegen4odps.model.DataBaseModel;
import org.cliff.codegen4odps.model.TableModel;
import org.cliff.codegen4odps.model.TemplateInfo;
import org.cliff.codegen4odps.util.DateUtil;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    /**
     * 构造函数
     */
    public Generator() {
        super();
    }

    /**
     * 根据模版信息创建表输出文件
     * 
     * @param dataBaseModel 数据库信息
     * @param templateInfo  模版配置信息
     * @param outputPath  输出根目录路径
     * @param templatePath  模版根目录路径
     * @throws Exception 异常
     */
    public static void generateTableContext(DataBaseModel dataBaseModel,
                                            TemplateInfo templateInfo, String outputPath, String templatePath)
            throws Exception {
        for (int i = 0; i < dataBaseModel.getTableModelList().size(); i++) {
            TableModel tableModel = (TableModel) dataBaseModel
                    .getTableModelList().get(i);
            
            
            Map context = new HashMap();
            context.put("tableModel", tableModel);
            context.put("templateInfo", templateInfo);
            context.put("author", dataBaseModel.getAuthor());
            File f = new File(outputPath);
            if(!f.exists()){
                f.mkdirs();
            }
            String outputDir = outputPath;
            String dir = "";
            File file = null;

        	outputDir += "/"+ DateUtil.convertDateToString(new Date())+"/";
        	file = new File(outputDir);
            file.mkdir();     
        	outputDir += "src/";
        	file = new File(outputDir);
            file.mkdir();     
        	outputDir += "com/";
        	file = new File(outputDir);
            file.mkdir();    
            outputDir += templateInfo.getCompanyName() +"/";
        	file = new File(outputDir);
            file.mkdir();    
            outputDir += templateInfo.getProjectName()+"/";
        	file = new File(outputDir);
            file.mkdir();    
                           
            outputDir += "codegen/";
        	file = new File(outputDir);
            file.mkdir();    
            outputDir += templateInfo.getOutputSubDir()+"/";
        	file = new File(outputDir);
            file.mkdir();
            dir = outputDir  + tableModel.getModuleName() + "/";
            file = new File(dir);
            file.mkdir();
            
            String fileName = null;
        	fileName = templateInfo.getOutputFilePrefix()
            + getStringByNameType(tableModel, templateInfo.getOutputFileNameType(),templateInfo.getModulePrefix())
            + templateInfo.getOutputFileSuffix() + "."
            + templateInfo.getOutputFileExt();
            
           
            FreeMarkerManager.getInstance().renderTemplate(
            		templateInfo.getTemplateName(), dir + fileName, context,
                    templateInfo.getEncoding(), templatePath);
        }

    }

    /**
     * 根据名称类型返回对应的表名称
     * 
     * @param tableModel
     *            表模型
     * @param nameType
     *            名称类型：none,camel,pascal,normal,upper,lower,shortupper,shortlower
     * @param modulePrefix
     *            是否需要模块前缀
     * @return
     */
    public static String getStringByNameType(TableModel tableModel,
            String nameType, boolean modulePrefix) {
        if ("none".equalsIgnoreCase(nameType)) {
            return "";
        } else if ("camel".equalsIgnoreCase(nameType)) {
            return tableModel.getTableName2Camel();
        } else if ("pascal".equalsIgnoreCase(nameType)) {
        	if(modulePrefix){
                return tableModel.getTableName2Pascal();
        	}else{
                return tableModel.getShortTableName2Pascal();
        	}
        } else if ("normal".equalsIgnoreCase(nameType)) {
            return tableModel.getTableNameNoPrefix();
        } else if ("upper".equalsIgnoreCase(nameType)) {
            return tableModel.getTableNameNoPrefix().toUpperCase();
        } else if ("lower".equalsIgnoreCase(nameType)) {
            return tableModel.getTableNameNoPrefix().toLowerCase();//取表前缀后返回
        } else if ("shortupper".equalsIgnoreCase(nameType)) {
            return tableModel.getTableName2Pascal().toUpperCase();
        } else if ("shortlower".equalsIgnoreCase(nameType)) {
            return tableModel.getTableName2Pascal().toLowerCase();
        } else {
            return "";
        }
    }

}
