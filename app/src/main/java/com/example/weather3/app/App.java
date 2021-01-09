package com.example.weather3.app;

import android.app.Application;

import com.example.weather3.app.di.NetworkModule;
import com.example.weather3.app.di.RepoModule;

import toothpick.Scope;
import toothpick.Toothpick;


public class App extends Application {

    private static App instance;
    private Scope scope;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        scope = Toothpick.openScope(this);
        scope.installModules(new NetworkModule(), new RepoModule(this));
    }

    public static Scope getScope() {
        return instance.scope;
    }
}
