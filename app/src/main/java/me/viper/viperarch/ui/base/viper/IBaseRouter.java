package me.viper.viperarch.ui.base.viper;

import android.app.Activity;

public interface IBaseRouter{

    public <T> void navigate(Activity currActivity, Class<T> classOfT);
}
