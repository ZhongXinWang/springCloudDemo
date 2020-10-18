package com.course.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
* 测试类
* @author Winston.Wang
* @date 2020/10/18
* @version 1.0
**/
public class Main {
    public static void main(String[] args) throws IOException, TemplateException {

        String originPath = "G:\\ideaworkspace\\springCloudDemo\\generator\\src\\main\\java\\com\\course\\generator\\ftl";
        String targetPath = "G:\\ideaworkspace\\springCloudDemo\\generator\\src\\main\\java\\com\\course\\generator\\test\\Test.java";
        String targetPath2 = "G:\\ideaworkspace\\springCloudDemo\\generator\\src\\main\\java\\com\\course\\generator\\test\\Test1.java";
        // 创建对象
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        // 加载模板
        configuration.setDirectoryForTemplateLoading(new File(originPath));
        configuration.setDefaultEncoding("UTF-8");

        // 输出模板
        Template template = configuration.getTemplate("test.ftl");
        Writer out = new OutputStreamWriter(new FileOutputStream(new File(targetPath)));
        //  增加数据绑定
        Map<String,Object> dataModel = new HashMap<>(4);
        dataModel.put("name",1);
        dataModel.put("className","Test");
        template.process(dataModel,out);
        out.flush();
        out.close();


        Writer out1 = new OutputStreamWriter(new FileOutputStream(new File(targetPath2)));
        dataModel.put("className","Test1");
        template.process(dataModel,out1);
        out1.flush();
        out1.close();

    }
}
