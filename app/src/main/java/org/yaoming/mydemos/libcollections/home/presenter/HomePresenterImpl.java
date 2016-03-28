package org.yaoming.mydemos.libcollections.home.presenter;

import org.yaoming.mydemos.libcollections.R;
import org.yaoming.mydemos.libcollections.home.view.IHomeView;

/**
 * Created by user on 2016/3/1.
 */
public class HomePresenterImpl implements HomePresenter {

    private IHomeView mIHomeView;

    public HomePresenterImpl(IHomeView IHomeView) {
        this.mIHomeView = IHomeView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_demos:
                mIHomeView.switch2DemoCode();
                break;
            case R.id.navigation_item_website:
                mIHomeView.switch2Website();
                break;
            case R.id.navigation_item_about:
                mIHomeView.switch2AboutMe();
                break;

            default:
                break;
        }
    }
}
