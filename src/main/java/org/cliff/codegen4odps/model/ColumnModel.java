/*
 * ColumnModel.java Created on 2005-6-13 Copyright(c) 2002-2005 by Iswind ALL Rights Reserved.
 */
package org.cliff.codegen4odps.model;

import org.cliff.codegen4odps.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 字段模型
 * 
 * @time: 0:14:38
 * @author lift
 */
public class ColumnModel {

    protected final Log log               = LogFactory.getLog(getClass());
    /**
     * 列名
     */
    private String      columnName        = null;

    /**
     * 中文名
     */
    private String      columnChineseName = null;

    /**
     * 字段类型
     */
    private String      columnType        = null;

    /**
     * odps库列类型
     */
    private String      sourceColumnType        = null;

    /**
     * 去除长度的coulmnType
     */
    private String      coulmnTypeNoSize  = null;

    /**
     * 字段的长度,例如number(2,3)->2,3
     */
    private String      coulmnSize        = null;

    /**
     * 字段长度
     */
    private int         columnLength      = 0;

    /**
     * 备注
     */
    private String      remark            = null;

    /**
     * 是否是主键
     */
    private boolean     isPK              = false;

    /**
     * 是否非空
     */
    private boolean     isNotNull         = false;

    // -----add by zhujl start----------------
    /**
     * 获得列名
     * 
     * @return 列名
     */
    public String getColumnNameFirstUpper() {
        return this.columnName.substring(0, 1).toUpperCase() + this.columnName.substring(1);
    }

    // -----add by zhujl end----------------

    /**
     * 设置列名
     * 
     * @param columnName 列名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获得列名
     * 
     * @return 列名
     */
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * 获得列名(转换为CamelStyle类型)
     * 
     * @return 列名(转换为CamelStyle类型)
     */
    public String getColumnName2Camel() {
        System.out.println(this.columnName);
        return StringUtil.convertUpperCaseToCamelStyle(this.columnName);
    }

    /**
     * 获得列名(转换为PascalStyle类型)
     * 
     * @return 列名(转换为PascalStyle类型)
     */
    public String getColumnName2Pascal() {
        return StringUtil.convertUpperCaseToPascalStyle(this.columnName);
    }

    /**
     * 设置中文名
     * 
     * @param columnChineseName 中文名
     */
    public void setColumnChineseName(String columnChineseName) {
        this.columnChineseName = columnChineseName;
    }

    /**
     * 获得中文名
     * 
     * @return 中文名
     */
    public String getColumnChineseName() {
        return this.columnChineseName;
    }

    /**
     * 设置字段类型
     * 
     * @param columnType 字段类型
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
        log.debug("setColumnType(String columnType),columnType:" + columnType);
        String coulmnTypeAfterClean = cleanUpString(columnType);

        // 获得去除长度的coulmnType和coulmnSize
        coulmnTypeNoSize = "";
        coulmnSize = "";
        if (coulmnTypeAfterClean.indexOf("(") > 0) {
            coulmnSize = coulmnTypeAfterClean.substring(coulmnTypeAfterClean.indexOf("(") + 1, coulmnTypeAfterClean.indexOf(")")).trim();
            coulmnTypeNoSize = coulmnTypeAfterClean.substring(0, coulmnTypeAfterClean.indexOf("("));
        } else {
            coulmnSize = "0";
            coulmnTypeNoSize = coulmnTypeAfterClean;
        }
    }
    
    private  static String cleanUpString(String str) {
        if (str == null) {
            return "";
        }
        if (StringUtils.isEmpty(str.trim())) {
            return "";
        }
        return str.trim().toLowerCase();
    }

    /**
     * 获得字段类型
     * 
     * @return 字段类型
     */
    public String getColumnType() {
        return this.columnType;
    }

    /**
     * 设置去除长度的coulmnType
     * 
     * @param coulmnTypeNoSize 去除长度的coulmnType
     */
    public void setCoulmnTypeNoSize(String coulmnTypeNoSize) {
        this.coulmnTypeNoSize = coulmnTypeNoSize;
    }

    /**
     * 获得去除长度的coulmnType
     * 
     * @return 去除长度的coulmnType
     */
    public String getCoulmnTypeNoSize() {
        return this.coulmnTypeNoSize;
    }

    /**
     * 设置字段的长度,例如number(2,3)->2,3
     * 
     * @param coulmnSize 字段的长度,例如number(2,3)->2,3
     */
    public void setCoulmnSize(String coulmnSize) {
        this.coulmnSize = coulmnSize;
    }

    /**
     * 获得字段的长度,例如number(2,3)->2,3
     * 
     * @return 字段的长度,例如number(2,3)->2,3
     */
    public String getCoulmnSize() {
        return this.coulmnSize;
    }

    /**
     * 根据字段类型返回对应的java类型
     * 
     * @return java类型
     * @throws Exception
     */
//    public String getColumnTypeMapClassType() throws Exception {
//        return DatabaseUtil.getClassTypeByColumnType(this.columnType);
//    }

    /**
     * 设置字段长度
     * 
     * @param columnLength 字段长度
     */
    public void setColumnLength(int columnLength) {
        this.columnLength = columnLength;
    }

    /**
     * 获得字段长度
     * 
     * @return 字段长度
     */
    public int getColumnLength() {
        return this.columnLength;
    }

    /**
     * 设置是否是主键
     * 
     * @param isPK 是否是主键
     */
    public void setIsPK(boolean isPK) {
        this.isPK = isPK;
    }

    /**
     * 获得是否是主键
     * 
     * @return 是否是主键
     */
    public boolean getIsPK() {
        return this.isPK;
    }

    /**
     * 设置是否非空
     * 
     * @param isNotNull 是否非空
     */
    public void setIsNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    /**
     * 获得是否非空
     * 
     * @return 是否非空
     */
    public boolean getIsNotNull() {
        return this.isNotNull;
    }

    /**
     * 设置备注
     * 
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获得备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return this.remark;
    }

    public String getSourceColumnType() {
        return sourceColumnType;
    }

    public void setSourceColumnType(String sourceColumnType) {
        this.sourceColumnType = sourceColumnType;
    }
}
