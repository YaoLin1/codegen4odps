/*
 * TemplateConfig.java Created on 2005-6-16
 * Copyright(c) 2002-2005 by Iswind
 * ALL Rights Reserved.
 */
package org.cliff.codegen4odps;

import com.thoughtworks.xstream.XStream;
import org.cliff.codegen4odps.model.TemplateInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 模版配置
 * @time: 18:22:20
 * @author lift
 */
public class TemplateConfig {
    /**
     * 读取配置文件，生成配置文件list
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static List<TemplateInfo> ReadConfigXml(String fileName) throws FileNotFoundException{
        XStream xstream = new XStream();
        xstream.alias("list", ArrayList.class);
        xstream.alias("templateInfo", TemplateInfo.class);
        FileInputStream fis = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(fis);
        List<TemplateInfo> list = (List<TemplateInfo>)xstream.fromXML(reader);
        return list;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            List list = TemplateConfig.ReadConfigXml("template.xml");
            for (int i=0;i<list.size();i++){
                TemplateInfo templateInfo =(TemplateInfo)list.get(i);
                System.out.println(templateInfo.getTemplateName());
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

}
