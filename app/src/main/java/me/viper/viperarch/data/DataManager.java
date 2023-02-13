package me.viper.viperarch.data;


import me.viper.viperarch.data.db.DbHelper;
import me.viper.viperarch.data.model.User;
import me.viper.viperarch.data.prefs.PreferencesHelper;
import me.viper.viperarch.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    public User getData();
    public User getData2();
}
