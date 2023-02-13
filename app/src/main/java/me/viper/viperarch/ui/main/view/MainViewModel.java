package me.viper.viperarch.ui.main.view;

import android.arch.lifecycle.MutableLiveData;

import me.viper.viperarch.data.model.User;
import me.viper.viperarch.ui.base.viper.BaseViewModel;
import me.viper.viperarch.ui.main.presenter.MainPresenter;

public class MainViewModel extends BaseViewModel<MainPresenter> {
    //some code use LiveData notify ui change, such as:
    // Create a LiveData with a String
    private MutableLiveData<User> currentUser;

    public MutableLiveData<User> getUser() {
        if (currentUser == null) {
            currentUser = new MutableLiveData<User>();
        }
        return currentUser;
    }
}