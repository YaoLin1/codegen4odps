package org.cliff.codegen4odps.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库模型
 */
public class DataBaseModel {
    /**
     * 作者名
     */
    private String author; 
    
    /**
     * 属于那个包，生成时使用该目录
     */
    private String parentPackage          = null;

    /**
     * 数据库名称
     */
    private String dataBaseName           = null;

    /**
     * 表模型list
     */
    private List   tableModelList         = new ArrayList();

    /**
     * 通用字段list
     */
    private List   commonAppendColumnList = null;

    /**
     * 设置属于那个包，生成时使用该目录
     * 
     * @param parentPackage 属于那个包，生成时使用该目录
     */
    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    /**
     * 获得属于那个包，生成时使用该目录
     * 
     * @return 属于那个包，生成时使用该目录
     */
    public String getParentPackage() {
        return this.parentPackage;
    }

    /**
     * 设置数据库名称
     * 
     * @param dataBaseName 数据库名称
     */
    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    /**
     * 获得数据库名称
     * 
     * @return 数据库名称
     */
    public String getDataBaseName() {
        return this.dataBaseName;
    }

    /**
     * 设置表模型list
     * 
     * @param tableModelList 表模型list
     */
    public void setTableModelList(List tableModelList) {
        this.tableModelList = tableModelList;
    }

    /**
     * 获得表模型list
     * 
     * @return 表模型list
     */
    public List getTableModelList() {
        return this.tableModelList;
    }

    /**
     * 设置通用字段list
     * 
     * @param commonAppendColumnList 通用字段list
     */
    public void setCommonAppendColumnList(List commonAppendColumnList) {
        this.commonAppendColumnList = commonAppendColumnList;
    }

    /**
     * 获得通用字段list
     * 
     * @return 通用字段list
     */
    public List getCommonAppendColumnList() {
        return this.commonAppendColumnList;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
