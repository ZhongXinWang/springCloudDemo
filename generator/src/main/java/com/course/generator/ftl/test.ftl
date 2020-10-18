package com.course.generator.test;
/**
* 测试类
* @author Winston.Wang
* @date 2020/10/18
* @version 1.0
* <#list 1..30 as n>${n?lower_abc} </#list>
<#if name == 1>
    name is 1
<#else>
    name is not 1
</#if>
**/
public class ${className} {

    private String id;
    private String name;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }
}
