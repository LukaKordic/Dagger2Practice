package com.lukakordic.dagger2example.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.lukakordic.dagger2example.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application app) {
        application = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
