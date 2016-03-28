package org.yaoming.mydemos.libcollections.democode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/2.
 */
public class DemoCodeDataProvider {

    public static List<DemoCodeListitemBean> getUIList(){
        List<DemoCodeListitemBean> codeListitemBeanList = new ArrayList<>();
        codeListitemBeanList.add(new DemoCodeListitemBean("UI","使用material design"));
        codeListitemBeanList.add(new DemoCodeListitemBean("UI","使用fresco加载图片"));

        return codeListitemBeanList;
    }

    public static List<DemoCodeListitemBean> getFunctionList(){
        List<DemoCodeListitemBean> codeListitemBeanList = new ArrayList<>();
        codeListitemBeanList.add(new DemoCodeListitemBean("功能","使用RxJava"));
        codeListitemBeanList.add(new DemoCodeListitemBean("功能","使用mvp模式设计程序"));

        return codeListitemBeanList;
    }

    public static List<DemoCodeListitemBean> getDataBaseList(){
        List<DemoCodeListitemBean> codeListitemBeanList = new ArrayList<>();
        codeListitemBeanList.add(new DemoCodeListitemBean("数据库","使用LiteOrm"));
        codeListitemBeanList.add(new DemoCodeListitemBean("数据库","使用Android SQLite Database"));

        return codeListitemBeanList;
    }

}
