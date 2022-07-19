package com.livix.lib_base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;


/**
 * @param <VM> ViewModel
 * @param <DB> DataBinding
 * @author LIVIX
 * @date: 2022/7/12
 */
public abstract class BaseMvvMActivity<VM extends BaseViewModel, DB extends ViewDataBinding> extends BaseActivity {

    public DB binding;

    public VM viewModel;

    /**
     * 绑定ViewModel类
     *
     * @return ViewModel.class
     */
    protected abstract Class<VM> onBindViewModel();

    /**
     * 初始化UI
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 观察LivaData的数据
     */
    protected abstract void observeLivaData();

    @Override
    public View createContentView() {
        binding = DataBindingUtil.setContentView(this, onBindLayoutId());
        return binding.getRoot();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        createViewModel();
        initData();
        observeLivaData();
        initEvent();
    }


    /**
     * 创建ViewModel类
     */
    private void createViewModel() {
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(onBindViewModel());
        viewModel.setLifecycleOwner(this);
    }

}
