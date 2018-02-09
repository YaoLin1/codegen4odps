package org.cliff.codegen4odps;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * FreeMarker模版引擎的管理
 */
public class FreeMarkerManager {

    /**
     * 单例实例
     */
    private static FreeMarkerManager instance = null;

    // -----------------freemarker配置---------------------//
    /**
     * freemarker配置
     */
    private Configuration cfg = null;

    

    /**
     * 构造函数,(单例)
     * 
     * @throws Exception
     *             初始化异常
     */
    protected FreeMarkerManager() throws Exception {
        super();
        cfg = new Configuration();
        // cfg.setEncoding(Locale.getDefault(),"UTF-8");
        cfg.setDirectoryForTemplateLoading(new File("./template4odps"));
    }

    /**
     * retrieve an instance to the current VelocityManager
     * 
     * @throws Exception
     *             初始化异常
     */
    public synchronized static FreeMarkerManager getInstance() throws Exception {
        if (instance == null) {
            instance = new FreeMarkerManager();
        }
        return instance;
    }
    /**
     * 根据模版文件和context生成输出文件
     * @param templateFileName 模版文件
     * @param outputFileName 输出文件
     * @param context 上下文
     * @param encoding 编码
     * @throws Exception 异常
     */
    public void renderTemplate(String templateFileName, String outputFileName,
            Map context,String encoding) throws Exception {
        renderTemplate(templateFileName, outputFileName,
                context,encoding,"./template");
    }
    /**
     * 根据模版文件和context生成输出文件
     * @param templateFileName 模版文件
     * @param outputFileName 输出文件
     * @param context 上下文
     * @param encoding 编码
     * @param directoryForTemplateLoading 模版文件所在目录
     * @throws Exception 异常
     */
    public void renderTemplate(String templateFileName, String outputFileName,
            Map context,String encoding,String directoryForTemplateLoading) throws Exception {
    	context.put("nowDate", new Date());
        cfg.setDirectoryForTemplateLoading(new File(directoryForTemplateLoading));
        Template temp = cfg.getTemplate(templateFileName, Locale
                .getDefault(), encoding);
        
        FileOutputStream fos = new FileOutputStream(outputFileName);
        Writer writer = new OutputStreamWriter(fos, encoding);
        temp.process(context, writer);
        writer.flush();
        writer.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            Map context = new HashMap();
            context.put("name", "李非天2");
            FreeMarkerManager.getInstance().renderTemplate("templateFreemarker.xml","./output/out.xml",context,"UTF-8");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
