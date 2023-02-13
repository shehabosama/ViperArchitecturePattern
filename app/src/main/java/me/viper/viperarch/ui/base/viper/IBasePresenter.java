package me.viper.viperarch.ui.base.viper;

import android.app.Activity;

import me.viper.viperarch.ui.main.router.MainRouter;
import me.viper.viperarch.ui.main.view.MainViewModel;

public interface IBasePresenter{
     void setData();
     <T> void navigate(Activity currActivity, Class<T> secondActivity);
     void getData();
     MainViewModel getViewModel();
     BasePresenter getBasePresenter();

}
