package me.viper.viperarch.data;

import javax.inject.Inject;

import me.viper.viperarch.data.db.DbService;
import me.viper.viperarch.data.model.User;
import me.viper.viperarch.data.prefs.PreferencesService;
import me.viper.viperarch.data.remote.ApiService;

public class AppDataManager implements DataManager {

    @Inject
    ApiService apiService;
    @Inject
    DbService dbService;
    @Inject
    PreferencesService preferencesService;

    public AppDataManager() {

    }

    @Override
    public User getData() {
        return new User("Shehab Osama","01555164961");
    }

    @Override
    public User getData2() {
        return new User("Shehab Osama fathi","01555164961");
    }
}
