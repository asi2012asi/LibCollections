package org.yaoming.mydemos.libcollections.democode.presenter;

import org.yaoming.mydemos.libcollections.democode.model.DemoCodeDataProvider;
import org.yaoming.mydemos.libcollections.democode.view.DemoCodeFragment;
import org.yaoming.mydemos.libcollections.democode.view.IDemoCodeView;

/**
 * Created by user on 2016/3/2.
 */
public class DemoCodePresentImpl implements DemoCodePresenter {

    private IDemoCodeView iDemoCodeView;

    public DemoCodePresentImpl(IDemoCodeView iDemoCodeView) {
        this.iDemoCodeView = iDemoCodeView;
    }

    @Override
    public void addDataByType(int type) {
        switch (type) {
            case DemoCodeFragment.DEMOCODE_TABTITLE_UI:
                //iDemoCodeView是view层 ，DemoCodeDataProvider.getUIList()是model层 ，使用Presenter作为中间者，把两者的关系串联在一起了
                iDemoCodeView.addUIData(DemoCodeDataProvider.getUIList());
                break;
            case DemoCodeFragment.DEMOCODE_TABTITLE_FUNCTION:
                iDemoCodeView.addFuncitonData(DemoCodeDataProvider.getFunctionList());
                break;
            case DemoCodeFragment.DEMOCODE_TABTITLE_DATABASE:
                iDemoCodeView.addWebSiteData(DemoCodeDataProvider.getDataBaseList());
                break;
            default:
                break;
        }
    }
}
