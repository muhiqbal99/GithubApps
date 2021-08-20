package com.example.submission2bfaa.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/submission2bfaa/ui/activity/DetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/submission2bfaa/databinding/ActivityDetailUserBinding;", "isFavorite", "", "user", "Lcom/example/submission2bfaa/model/User;", "viewModel", "Lcom/example/submission2bfaa/viewmodel/DetailViewModel;", "addOrRemoveFavorite", "", "changeFavorite", "condition", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setActionBarTitle", "username", "", "showUser", "detailUser", "Companion", "app_debug"})
public final class DetailActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.submission2bfaa.ui.activity.DetailActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_USERNAME = "extra_username";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DATA = "extra_data";
    private com.example.submission2bfaa.databinding.ActivityDetailUserBinding binding;
    private com.example.submission2bfaa.viewmodel.DetailViewModel viewModel;
    private com.example.submission2bfaa.model.User user;
    private boolean isFavorite = false;
    
    public DetailActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showUser(com.example.submission2bfaa.model.User detailUser) {
    }
    
    private final void addOrRemoveFavorite() {
    }
    
    private final void changeFavorite(boolean condition) {
    }
    
    private final void setActionBarTitle(java.lang.String username) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/submission2bfaa/ui/activity/DetailActivity$Companion;", "", "()V", "EXTRA_DATA", "", "EXTRA_USERNAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}