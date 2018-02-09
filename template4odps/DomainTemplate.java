/*
 * ${tableModel.tableName2Pascal}.java 
 * Copyright(c) 2018 91jkys.com
 * ALL Rights Reserved.
 */
package com.jkys.bi.common.odps.beans;

import java.io.Serializable;
import java.sql.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 类${tableModel.domainName}的实现描述：${tableModel.tableName}
 * 
 * @author ${author} 2018-01-26 17:40:00
 */
public class ${tableModel.domainName} implements Serializable{
    <#list tableModel.columnList as columnModel>
    
    private ${columnModel.columnType} ${columnModel.columnName};     // ${columnModel.columnChineseName}
    
    </#list>
    <#list tableModel.columnList as columnModel>
    public void set${columnModel.columnNameFirstUpper}(${columnModel.columnType} ${columnModel.columnName}) {
        this.${columnModel.columnName} = ${columnModel.columnName};
    }
    
    public ${columnModel.columnType} get${columnModel.columnNameFirstUpper}() {
        return this.${columnModel.columnName};
    }
    </#list>
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}