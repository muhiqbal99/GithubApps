package com.example.submission2bfaa.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/example/submission2bfaa/viewmodel/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "favoriteRepositories", "Lcom/example/submission2bfaa/repository/FavoriteRepositories;", "(Lcom/example/submission2bfaa/repository/FavoriteRepositories;)V", "detail", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/submission2bfaa/model/User;", "getDetail", "()Landroidx/lifecycle/MutableLiveData;", "isFavorite", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "addFavorite", "Lkotlinx/coroutines/Job;", "user", "getUserDetail", "removeFavorite", "setUserDetail", "", "username", "", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.submission2bfaa.repository.FavoriteRepositories favoriteRepositories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.submission2bfaa.model.User> detail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite = null;
    
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    com.example.submission2bfaa.repository.FavoriteRepositories favoriteRepositories) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.submission2bfaa.model.User> getDetail() {
        return null;
    }
    
    public final void setUserDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.submission2bfaa.model.User> getUserDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addFavorite(@org.jetbrains.annotations.NotNull()
    com.example.submission2bfaa.model.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job removeFavorite(@org.jetbrains.annotations.NotNull()
    com.example.submission2bfaa.model.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFavorite() {
        return null;
    }
}