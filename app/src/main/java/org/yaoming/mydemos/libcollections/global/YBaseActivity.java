package org.yaoming.mydemos.libcollections.global;

import android.os.Bundle;
import android.view.ViewGroup;

import org.yaoming.mydemos.libcollections.global.AbUtil.AbViewUtil;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by user on 2016/3/1.
 * 基类 原则上所有的Activity都要继承于他
 */
public abstract class YBaseActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private boolean isNeed2Scaled = false;
    public void setContentView_1280x720(int layoutResID){
        super.setContentView(layoutResID);
        isNeed2Scaled =true;
    }


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isNeed2Scaled) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
            AbViewUtil.scaleContentView(viewGroup);
        }
    }
}
