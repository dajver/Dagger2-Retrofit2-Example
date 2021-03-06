package com.project.dajver.dagger2testexample.components;

import com.project.dajver.dagger2testexample.App;
import com.project.dajver.dagger2testexample.MainActivity;
import com.project.dajver.dagger2testexample.SecondActivity;
import com.project.dajver.dagger2testexample.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by gleb on 8/16/17.
 */

@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent extends AndroidInjector<App> {

    void inject(MainActivity mainActivity);
    void inject(SecondActivity secondActivity);

    final class Initializer {
        private Initializer() { }

        public static AppComponent init(App app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}