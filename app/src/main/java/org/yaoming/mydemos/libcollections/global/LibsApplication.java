package org.yaoming.mydemos.libcollections.global;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.yaoming.mydemos.libcollections.crash_Log.CrashHandler;

/**
 * Created by user on 2016/3/1.
 */
public class LibsApplication extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        Fresco.initialize(getApplicationContext());
        refWatcher = LeakCanary.install(this);

    }


    public static RefWatcher getRefWatcher(Context context) {
        LibsApplication application = (LibsApplication) context.getApplicationContext();
        return application.refWatcher;
    }

}
