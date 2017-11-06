package com.lukakordic.dagger2example.di.component;

import com.lukakordic.dagger2example.di.PerActivity;
import com.lukakordic.dagger2example.di.module.ActivityModule;
import com.lukakordic.dagger2example.ui.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
