package com.lukakordic.dagger2example.di.component;

import android.app.Application;
import android.content.Context;

import com.lukakordic.dagger2example.DemoApplication;
import com.lukakordic.dagger2example.data.DataManager;
import com.lukakordic.dagger2example.data.SharedPrefsHelper;
import com.lukakordic.dagger2example.di.ApplicationContext;
import com.lukakordic.dagger2example.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getSharedPreferenceHelper();
}
