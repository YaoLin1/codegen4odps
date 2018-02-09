/*
 * ${tableModel.domainName}Domain2RecordConveter.java
 * Copyright(c) 2018 91jlts
 * ALL Rights Reserved.
 */
package com.jkys.bi.common.odps;

import com.jkys.bi.common.odps.beans.${tableModel.domainName};
import com.jkys.bi.common.utils.Converter;
import com.aliyun.odps.data.Record;


/**
 * Created by zhujl on 2018/1/26.
 */
public class ${tableModel.domainName}Domain2RecordConveter implements Converter<${tableModel.domainName},Record> {
    @Override
    public void convert(${tableModel.domainName} source,Record target) {
        <#list tableModel.columnList as columnModel>
            target.set${columnModel.sourceColumnType}("${columnModel.columnName}",source.get${columnModel.columnNameFirstUpper}());
        </#list>
    }
}