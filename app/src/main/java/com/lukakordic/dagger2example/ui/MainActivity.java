package com.lukakordic.dagger2example.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lukakordic.dagger2example.DemoApplication;
import com.lukakordic.dagger2example.R;
import com.lukakordic.dagger2example.data.DataManager;
import com.lukakordic.dagger2example.data.models.User;
import com.lukakordic.dagger2example.di.component.ActivityComponent;
import com.lukakordic.dagger2example.di.component.DaggerActivityComponent;
import com.lukakordic.dagger2example.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView userInfo;
    private TextView accessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        userInfo = findViewById(R.id.user_info);
        accessToken = findViewById(R.id.access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = dataManager.getAccessToken();
        if (token != null) {
            accessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = dataManager.getUser(1L);
            userInfo.setText(user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
