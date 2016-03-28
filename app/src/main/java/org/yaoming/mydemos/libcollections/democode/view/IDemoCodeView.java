package org.yaoming.mydemos.libcollections.democode.view;

import org.yaoming.mydemos.libcollections.democode.model.DemoCodeListitemBean;

import java.util.List;

/**
 * Created by user on 2016/3/2.
 */
public interface IDemoCodeView {

    void addUIData(List<DemoCodeListitemBean> data);
    void addFuncitonData(List<DemoCodeListitemBean> data);
    void addWebSiteData(List<DemoCodeListitemBean> data);

}
