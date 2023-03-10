package me.viper.viperarch.ui.base.viper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import me.viper.viperarch.ui.base.DiActivity;


public abstract class BasePresenter<V extends IBaseView, R extends IBaseRouter, I extends IBaseInteractor> implements IBasePresenter{

    private WeakReference<V> viewRef;

    private R router;
    private I interactor;

    //View
    public void attachView(@NonNull V view) {
        viewRef = new WeakReference<>(view);
    }

    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Nullable
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    //Router
    public void attachRouter(@NonNull R router) {
        this.router = router;
    }

    public void detachRouter() {
        this.router = null;
    }

    public R getRouter() {
        return router;
    }

    public boolean isRouterAttached() {
        return router != null;
    }

    //Interactor
    public void attachInteractor(@NonNull I iteractor) {
        this.interactor = iteractor;
    }

    public void detachInteractor() {
        this.interactor = null;
    }

    public I getInteractor() {
        return interactor;
    }

    public boolean isIteractorAttached() {
        return interactor != null;
    }


}
