package com.lukakordic.dagger2example.utils.realm;

import com.lukakordic.dagger2example.DemoApplication;
import com.lukakordic.dagger2example.data.models.User;

import io.realm.Realm;

public class RealmUtils {

    public static User getUser(long userId) {
        Realm realm = DemoApplication.getRealm();
        return realm.copyFromRealm(realm.where(User.class).equalTo("id", userId).findFirst());
    }

    public static void insertUser(User user) {
        Realm realm = DemoApplication.getRealm();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    public static String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }
}
