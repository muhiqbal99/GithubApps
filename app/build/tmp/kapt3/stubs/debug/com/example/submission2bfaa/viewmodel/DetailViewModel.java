package com.example.submission2bfaa.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/submission2bfaa/viewmodel/DetailViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "detail", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/submission2bfaa/model/User;", "favoriteDao", "Lcom/example/submission2bfaa/data/local/FavoriteDao;", "favoriteRepositories", "Lcom/example/submission2bfaa/repository/FavoriteRepositories;", "getUserDetail", "Landroidx/lifecycle/LiveData;", "setFavorite", "Lkotlinx/coroutines/Job;", "user", "newStatus", "", "setUserDetail", "", "username", "", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.example.submission2bfaa.data.local.FavoriteDao favoriteDao = null;
    private final com.example.submission2bfaa.repository.FavoriteRepositories favoriteRepositories = null;
    private final androidx.lifecycle.MutableLiveData<com.example.submission2bfaa.model.User> detail = null;
    
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public final void setUserDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.submission2bfaa.model.User> getUserDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setFavorite(@org.jetbrains.annotations.NotNull()
    com.example.submission2bfaa.model.User user, boolean newStatus) {
        return null;
    }
}