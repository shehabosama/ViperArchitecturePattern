package me.viper.viperarch.ui.main.presenter;

import android.app.Activity;

import me.viper.viperarch.data.model.User;
import me.viper.viperarch.ui.base.viper.BasePresenter;
import me.viper.viperarch.ui.main.interactor.MainInteractor;
import me.viper.viperarch.ui.main.router.MainRouter;
import me.viper.viperarch.ui.main.view.MainViewModel;

public class MainPresenter extends BasePresenter<MainViewModel, MainRouter, MainInteractor> {
    //this presenter's methods should be call in activity, and it should react with viewModel, router and interactor.

    @Override
    public void setData(){
        getView().getUser().setValue(new User("shehab","osama"));
    }
    @Override
    public MainViewModel getViewModel(){
        return getView();
    }
    @Override
    public BasePresenter getBasePresenter() {
        return this;
    }

    @Override
    public <T> void navigate(Activity currActivity, Class<T> secondActivity){
        getRouter().navigate(currActivity,secondActivity);
    }
    @Override
    public void getData(){
        getView().getUser().setValue(getInteractor().getData());
    }
}