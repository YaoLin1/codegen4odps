/*
 * TemplateInfo.java Created on 2005-6-16
 * Copyright(c) 2002-2005 by Iswind
 * ALL Rights Reserved.
 */
package org.cliff.codegen4odps.model;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 模版生成信息配置
 * 
 * @time: 18:00:37
 * @author lift
 */
public class TemplateInfo {
    /**
     * 公司名称
     */
    private String companyName = null;
    
    /**
     * 每个文件一个目录的名称类型
     */
    private String dirNameTypePerFile = null;
    
    /**
     * 字符编码
     */
    private String encoding = null;


    /**
     * 是否需要每个文件一个目录
     */
    private boolean isNeedDirPerFile = false;

    /**
     * 是否需要模块前缀
     */
    private boolean modulePrefix = true;

    /**
     * 输出文件扩展名
     */
    private String outputFileExt = null;

    /**
     * 输出文件名称类型
     */
    private String outputFileNameType = null;

    /**
     * 输出文件前缀
     */
    private String outputFilePrefix = null;

    /**
     * 输出文件后缀
     */
    private String outputFileSuffix = null;

    /**
     * 输出子目录
     */
    private String outputSubDir = null;

    /**
     * 项目名称
     */
    private String projectName = null;

    /**
     * 表前缀
     */
    private String tablePrefix = "";

    /**
     * 模版名称
     */
    private String templateName = null;

    /**
     * 模版类型
     */
    private String templateType = null;

    /**
     * 获得公司名称
     * 
     * @return 公司名称
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * 获得每个文件一个目录的名称类型
     * 
     * @return 每个文件一个目录的名称类型
     */
    public String getDirNameTypePerFile() {
        return this.dirNameTypePerFile;
    }

    /**
     * 获得字符编码
     * 
     * @return 字符编码
     */
    public String getEncoding() {
        return this.encoding;
    }

    /**
     * 获得是否需要每个文件一个目录
     * 
     * @return 是否需要每个文件一个目录
     */
    public boolean getIsNeedDirPerFile() {
        return this.isNeedDirPerFile;
    }

    /**
     * 获得是否需要模块前缀
     * 
     * @return 是否需要模块前缀
     */
    public boolean getModulePrefix() {
        return this.modulePrefix;
    }

    /**
     * 获得输出文件扩展名
     * 
     * @return 输出文件扩展名
     */
    public String getOutputFileExt() {
        return this.outputFileExt;
    }
    
    /**
     * 获得输出文件名称类型
     * 
     * @return 输出文件名称类型
     */
    public String getOutputFileNameType() {
        return this.outputFileNameType;
    }
    
    /**
     * 获得输出文件前缀
     * 
     * @return 输出文件前缀
     */
    public String getOutputFilePrefix() {
        return this.outputFilePrefix;
    }

    /**
     * 获得输出文件后缀
     * 
     * @return 输出文件后缀
     */
    public String getOutputFileSuffix() {
        return this.outputFileSuffix;
    }
    
    /**
     * 获得输出子目录
     * 
     * @return 输出子目录
     */
    public String getOutputSubDir() {
        return this.outputSubDir;
    }

    /**
     * 获得项目名称
     * 
     * @return 项目名称
     */
    public String getProjectName() {
        return this.projectName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    /**
     * 获得模版名称
     * 
     * @return 模版名称
     */
    public String getTemplateName() {
        return this.templateName;
    }

    /**
     * 获得模版类型
     * 
     * @return 模版类型
     */
    public String getTemplateType() {
        return this.templateType;
    }

    /**
     * 设置公司名称
     * 
     * @param companyName
     *            公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 设置每个文件一个目录的名称类型
     * 
     * @param dirNameTypePerFile
     *            每个文件一个目录的名称类型
     */
    public void setDirNameTypePerFile(String dirNameTypePerFile) {
        this.dirNameTypePerFile = dirNameTypePerFile;
    }

    /**
     * 设置字符编码
     * 
     * @param encoding
     *            字符编码
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * 设置是否需要每个文件一个目录
     * 
     * @param isNeedDirPerFile
     *            是否需要每个文件一个目录
     */
    public void setIsNeedDirPerFile(boolean isNeedDirPerFile) {
        this.isNeedDirPerFile = isNeedDirPerFile;
    }

    /**
     * 设置是否需要模块前缀
     * 
     * @param modulePrefix
     *            是否需要模块前缀
     */
    public void setModulePrefix(boolean modulePrefix) {
        this.modulePrefix = modulePrefix;
    }

    /**
     * 设置输出文件扩展名
     * 
     * @param outputFileExt
     *            输出文件扩展名
     */
    public void setOutputFileExt(String outputFileExt) {
        this.outputFileExt = outputFileExt;
    }

    /**
     * 设置输出文件名称类型
     * 
     * @param outputFileNameType
     *            输出文件名称类型
     */
    public void setOutputFileNameType(String outputFileNameType) {
        this.outputFileNameType = outputFileNameType;
    }

    /**
     * 设置输出文件前缀
     * 
     * @param outputFilePrefix
     *            输出文件前缀
     */
    public void setOutputFilePrefix(String outputFilePrefix) {
        this.outputFilePrefix = outputFilePrefix;
    }

    /**
     * 设置输出文件后缀
     * 
     * @param outputFileSuffix
     *            输出文件后缀
     */
    public void setOutputFileSuffix(String outputFileSuffix) {
        this.outputFileSuffix = outputFileSuffix;
    }

    /**
     * 设置输出子目录
     * 
     * @param outputSubDir
     *            输出子目录
     */
    public void setOutputSubDir(String outputSubDir) {
        this.outputSubDir = outputSubDir;
    }

    /**
     * 设置项目名称
     * 
     * @param projectName  项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    /**
     * 设置模版名称
     * 
     * @param templateName
     *            模版名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 设置模版类型
     * 
     * @param templateType
     *            模版类型
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
    
    /**
     * 主运行函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            TemplateInfo templateInfo = new TemplateInfo();
            templateInfo.setDirNameTypePerFile("camel");
            templateInfo.setIsNeedDirPerFile(false);
            templateInfo.setOutputFileExt("xml");
            templateInfo.setOutputFileNameType("pascal");
            templateInfo.setOutputFilePrefix("prefix");
            templateInfo.setOutputFileSuffix("suffix");
            templateInfo.setOutputSubDir("subdir");
            XStream xstream = new XStream();
            xstream.alias("templateInfo", TemplateInfo.class);

            List list = new ArrayList();
            list.add(templateInfo);

            FileOutputStream fos = new FileOutputStream("template.xml");
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            xstream.toXML(list, writer);
            writer.flush();
            writer.close();

            FileInputStream fis = new FileInputStream("template.xml");
            Reader reader = new InputStreamReader(fis);
            List list2 = (List) xstream.fromXML(reader);
            Object obj = list2.get(0);
            System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
