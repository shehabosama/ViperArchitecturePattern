package me.viper.viperarch.ui.main.router;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import me.viper.viperarch.ui.base.viper.BaseRouter;
import me.viper.viperarch.ui.main.SecondActivity;

public class MainRouter extends BaseRouter {
    //some code about router, such as:
    @Override
    public <T> void navigate(Activity currActivity,Class<T> classOfT){
        currActivity.startActivity(new Intent(currActivity, classOfT));
    }
}