package com.lukakordic.dagger2example.data;

import android.content.Context;

import com.lukakordic.dagger2example.data.models.User;
import com.lukakordic.dagger2example.di.ApplicationContext;
import com.lukakordic.dagger2example.utils.realm.RealmUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private Context context;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, SharedPrefsHelper sharedPrefsHelper) {
        this.context = context;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public void createUser(User user) {
        RealmUtils.insertUser(user);
    }

    public User getUser(long userId) {
        return RealmUtils.getUser(userId);
    }
}
