package com.livix.lib_base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @param <DB> DataBinding类
 * @author LIVIX
 * @date: 2022/7/13
 */
public abstract class BaseNoModelActivity<DB extends ViewDataBinding> extends BaseActivity {

    /**
     * 统一DataBinding对象
     */
    public DB binding;

    /**
     * 初始化UI
     */
    protected abstract void initView();


    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    public View createContentView() {
        binding = DataBindingUtil.setContentView(this, onBindLayoutId());
        return binding.getRoot();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }
}
