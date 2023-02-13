package me.viper.viperarch.ui.main;

import android.arch.lifecycle.ViewModelProviders;

import javax.inject.Named;
import javax.inject.Singleton;

import me.viper.viperarch.di.scope.ActivityScope;
import me.viper.viperarch.ui.base.viper.BasePresenter;
import me.viper.viperarch.ui.base.viper.IBasePresenter;
import me.viper.viperarch.ui.main.interactor.MainInteractor;
import me.viper.viperarch.ui.main.presenter.MainPresenter;
import me.viper.viperarch.ui.main.router.MainRouter;
import me.viper.viperarch.ui.main.view.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @ActivityScope
    @Provides
    MainViewModel provideViewModel(MainActivity activity) {
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }

    @ActivityScope
    @Provides
    MainInteractor provideInteractor() {
        return new MainInteractor();
    }

    @ActivityScope
    @Provides
    MainRouter provideRouter() {
        return new MainRouter();
    }

    @ActivityScope
    @Provides
    MainPresenter providePresenter() {
        return new MainPresenter();
    }
    @ActivityScope
    @Provides
    @Named("firstPresenter")
    IBasePresenter providePresenter2() {
        return new MainPresenter();
    }
//    @ActivityScope
//    @Provides
//    @Named("secondPresenter")
//    IBasePresenter providePresenter3() {
//        return new SecondPresenter();
//    }
}
