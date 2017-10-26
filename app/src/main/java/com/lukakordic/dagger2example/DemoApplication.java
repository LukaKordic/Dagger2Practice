package com.lukakordic.dagger2example;

import android.app.Application;
import android.content.Context;

import com.lukakordic.dagger2example.data.DataManager;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    public static Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        Realm.init(this);
        RealmConfiguration defaultConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(defaultConfiguration);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
