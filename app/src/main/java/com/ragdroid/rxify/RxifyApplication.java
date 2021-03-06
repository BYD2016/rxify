package com.ragdroid.rxify;

import android.app.Application;

import com.ragdroid.rxify.logic.data.remote.ApiModule;
import com.ragdroid.rxify.dagger.AppComponent;
import com.ragdroid.rxify.logic.AppModule;
import com.ragdroid.rxify.dagger.DaggerAppComponent;

/**
 * Created by garimajain on 30/08/16.
 */
public final class RxifyApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
    }

    private void initComponent() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://baseurl.com"))
                .build();
    }
}
