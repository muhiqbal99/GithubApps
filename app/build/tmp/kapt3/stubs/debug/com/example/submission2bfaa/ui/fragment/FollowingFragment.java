package com.example.submission2bfaa.ui.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/submission2bfaa/ui/fragment/FollowingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/submission2bfaa/databinding/FragmentFollowBinding;", "adapter", "Lcom/example/submission2bfaa/ui/adapter/UserAdapter;", "binding", "getBinding", "()Lcom/example/submission2bfaa/databinding/FragmentFollowBinding;", "username", "", "viewModel", "Lcom/example/submission2bfaa/viewmodel/FollowingViewModel;", "onDestroyView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "state", "", "app_debug"})
public final class FollowingFragment extends androidx.fragment.app.Fragment {
    private com.example.submission2bfaa.databinding.FragmentFollowBinding _binding;
    private com.example.submission2bfaa.viewmodel.FollowingViewModel viewModel;
    private com.example.submission2bfaa.ui.adapter.UserAdapter adapter;
    private java.lang.String username;
    
    public FollowingFragment() {
        super();
    }
    
    private final com.example.submission2bfaa.databinding.FragmentFollowBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showLoading(boolean state) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}