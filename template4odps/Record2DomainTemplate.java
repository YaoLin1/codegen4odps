/*
 * ${tableModel.domainName}Record2DomainConveter .java
 * Copyright(c) 2018 91jkys
 * ALL Rights Reserved.
 */
package com.jkys.bi.common.odps;

import com.jkys.bi.common.odps.beans.${tableModel.domainName};
import com.jkys.bi.common.utils.Converter;
import com.aliyun.odps.data.Record;

/**
 * Created by zhujl on 2018/1/26.
 */
public class ${tableModel.domainName}Record2DomainConveter implements Converter<Record,${tableModel.domainName}> {
    @Override
    public void convert(Record source,${tableModel.domainName} target) {
        <#list tableModel.columnList as columnModel>
            target.set${columnModel.columnNameFirstUpper}(source.get${columnModel.sourceColumnType}("${columnModel.columnName}"));
        </#list>
    }
}