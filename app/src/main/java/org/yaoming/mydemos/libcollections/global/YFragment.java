package org.yaoming.mydemos.libcollections.global;
import android.support.v4.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by user on 2016/3/1.
 */
public class YFragment extends Fragment {


    public YFragment(){}

    @Override
    public void onDestroy() {
        super.onDestroy();
        //当fragment关闭时 检测没有释放的应用 尝试调用gc 还没有被释放将会dialog通知最短强引用路径
        // 找到应该销毁的引用为何还存在（被其他地方引用着）如果还不够 就把heap dump到hprof 用mat工具检查
        // 注意GBaseActivity无需watch ，在appConfig中install的时候已经自动加上
        RefWatcher refWatcher = LibsApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);

    }
}
