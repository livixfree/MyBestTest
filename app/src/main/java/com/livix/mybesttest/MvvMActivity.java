package com.livix.mybesttest;

import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.livix.lib_base.BaseMvvMActivity;
import com.livix.lib_base.api.TokenBean;
import com.livix.mybesttest.databinding.ActivityMainBinding;

/**
 * @author LIVIX
 * @date: 2022/7/14
 */
public class MvvMActivity extends BaseMvvMActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected int onBindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> onBindViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        viewModel.getToken();
    }

    @Override
    protected void observeLivaData() {
        viewModel.getTokenLiveData().observe(this, new Observer<TokenBean>() {
            @Override
            public void onChanged(TokenBean tokenBean) {
                Toast.makeText(MvvMActivity.this, tokenBean.getAccessToken(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
