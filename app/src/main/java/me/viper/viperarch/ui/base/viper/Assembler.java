package me.viper.viperarch.ui.base.viper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import me.viper.viperarch.data.DataManager;

/**
 * Viper Assembly helper class
 */
public class Assembler {
    private BaseViewModel view;
    private BaseRouter router;
    private BaseInteractor interactor;
    private BasePresenter presenter;
    private DataManager dataManager;


    private Assembler(Builder builder) {
        this.view = builder.view;
        this.interactor = builder.interactor;
        this.router = builder.router;
        this.presenter = builder.presenter;
        this.dataManager = builder.dataManager;
    }


    //Binding according to the Viper design pattern
    public void bind() {
        interactor.attachDataManager(dataManager);
        interactor.attachPresenter(presenter);
        view.attachPresenter(presenter);
        presenter.attachInteractor(interactor);
        presenter.attachRouter(router);
        presenter.attachView(view);
    }

    public void unbind(){
        interactor.detachPresenter();
        interactor.detachDataManager();
        view.detachPresenter();
        presenter.detachInteractor();
        presenter.detachRouter();
        presenter.detachView();
    }


    public static class Builder{
        private BaseViewModel view;
        private BaseRouter router;
        private BaseInteractor interactor;
        private BasePresenter presenter;
        private DataManager dataManager;

        public Builder() {
        }

        public Builder view(@NonNull BaseViewModel view) {
            this.view = view;
            return this;
        }

        public Builder router(@NonNull BaseRouter router) {
            this.router = router;
            return this;
        }

        public Builder interactor(@NonNull BaseInteractor interactor) {
            this.interactor = interactor;
            return this;
        }

        public Builder presenter(@NonNull BasePresenter presenter) {
            this.presenter = presenter;
            return this;
        }

        public Builder dataManager(@NonNull DataManager dataManager) {
            this.dataManager = dataManager;
            return this;
        }

        public Assembler build() {
            return new Assembler(this);
        }
    }
}
