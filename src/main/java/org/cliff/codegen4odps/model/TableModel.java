/*
 * TableModel.java Created on 2005-6-13
 * Copyright(c) 2002-2005 by Iswind
 * ALL Rights Reserved.
 */
package org.cliff.codegen4odps.model;

import org.cliff.codegen4odps.util.DateUtil;
import org.cliff.codegen4odps.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 表模型
 * 
 * @time: 0:13:53
 * @author lift
 */
public class TableModel {
	

	/**
	 * 工程配置信息
	 */
	private TemplateInfo templateInfo;
	
	/**
	 * 模块名称
	 */
	private String moduleName = null;
	
	/**
	 * 表空间名称
	 */
	private String tableSpaceName = null;
	
	// -----------------表名称---------------------//
	/**
	 * 表名称
	 */
	private String tableName = null;
	
	/**
	 * 表名前缀
	 */
	private String tableNamePrefix = "";

	/**
	 * 设置表名称
	 * 
	 * @param tableName
	 *            表名称
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 获得表名称
	 * 
	 * @return 表名称
	 */
	public String getTableName() {
		return this.tableName;
	}
	
	public String getTableNameNoPrefix() {
	    return removePrefix(this.tableName);
	}

	/**
	 * 获得表名称(转换为CamelStyle类型)
	 * 
	 * @return 表名称(转换为CamelStyle类型)
	 */
	public String getTableName2Camel() {
		 return StringUtil.convertUpperCaseToCamelStyle(removePrefix(this.tableName));
	}

	/**
	 * 获得表名称(转换为PascalStyle类型)
	 * 
	 * @return 表名称(转换为PascalStyle类型)
	 */
	public String getTableName2Pascal() {
		 return StringUtil.convertUpperCaseToPascalStyle(removePrefix(this.tableName));
	}

	
	public String getShortTableName2Pascal(){
		int firstUnderLinePos = this.tableName.indexOf("_", 1);
		return StringUtil.convertUpperCaseToPascalStyle(this.tableName.substring(firstUnderLinePos+1));
	}
	

	public String getDomainInstanceName(){
		String domainName = getShortTableName2Pascal();
		return domainName.substring(0,1).toLowerCase()+domainName.substring(1);
	}
	
	
	public String getCurrentDate(){
		return DateUtil.convertDateToString(new Date());
	}
	
	public String getCurrentTime(){
		return DateUtil.getTimeString(new Date());
	}
	// -----------------表中文名称---------------------//
	/**
	 * 表中文名称
	 */
	private String tableChineseName = null;

	/**
	 * 设置表中文名称
	 * 
	 * @param tableChineseName
	 *            表中文名称
	 */
	public void setTableChineseName(String tableChineseName) {
		this.tableChineseName = tableChineseName;
	}

	/**
	 * 获得表中文名称
	 * 
	 * @return 表中文名称
	 */
	public String getTableChineseName() {
		return this.tableChineseName;
	}

	// -----------------列属性列表---------------------//
	/**
	 * 列属性列表
	 */
	private List columnList = new ArrayList();

	/**
	 * 设置列属性列表
	 * 
	 * @param columnList
	 *            列属性列表
	 */
	public void setColumnList(List columnList) {
		this.columnList = columnList;
	}

	/**
	 * 获得列属性列表
	 * 
	 * @return 列属性列表
	 */
	public List getColumnList() {
		return this.columnList;
	}

	// -----------------创建人---------------------//
	/**
	 * 创建人
	 */
	private String createUserName = null;

	/**
	 * 设置创建人
	 * 
	 * @param createUserName
	 *            创建人
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	/**
	 * 获得创建人
	 * 
	 * @return 创建人
	 */
	public String getCreateUserName() {
		return this.createUserName;
	}

	/**
	 * @return Returns the moduleName.
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName The moduleName to set.
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public static void main(String[] args){
		TableModel model = new TableModel();
		model.setTableName("OM_BASE_STATION");
		
		System.out.println(model.getShortTableName2Pascal());
	}

	public TemplateInfo getTemplateInfo() {
		return templateInfo;
	}

	public void setTemplateInfo(TemplateInfo templateInfo) {
		this.templateInfo = templateInfo;
	}

	public String getTableSpaceName() {
		return tableSpaceName;
	}

	public void setTableSpaceName(String tableSpaceName) {
		this.tableSpaceName = tableSpaceName;
	}

	/***add by zhujl**************************************************/
	public String getDomainName() {
        return StringUtil.getCamelCase(removePrefix(this.tableName),"_");
    }
    
	public String getDomainNameWithFirstCaseLower() {
	    return lowerFirestChar(getDomainName());
	}
	
	
	
	public String getSqlMapNamespace() {
	    return getDomainName().toUpperCase();
	}
	
	public String getDomainAlias() {
	    return getDomainName().toLowerCase();
	}
	
	 /**
     * 将表名转换成类名
     * 
     * @param tableName
     * @return
     */
    private String getClassName(String tableName) {
        return removePrefix(tableName).replaceAll("_", "");
    }
    
    public String upperFirestChar(String src) {
        return src.substring(0, 1).toUpperCase().concat(src.substring(1));
    }
    public String lowerFirestChar(String src) {
        return src.substring(0, 1).toLowerCase().concat(src.substring(1));
    }
    
    public String getTableName2PascalWithoutPrefix() {
         return StringUtil.convertUpperCaseToPascalStyle(removePrefix(this.tableName));
    }
    
    private String removePrefix(String tableName){
        if(tableNamePrefix!=null && !tableNamePrefix.isEmpty()){
            return tableName.replace(tableNamePrefix, "");
        }
        return tableName;
    }

    public String getTableNamePrefix() {
        return tableNamePrefix;
    }

    public void setTableNamePrefix(String tableNamePrefix) {
        this.tableNamePrefix = tableNamePrefix;
    }
}
