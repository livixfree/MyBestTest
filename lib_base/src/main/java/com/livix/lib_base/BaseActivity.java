package com.livix.lib_base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * 基础 Activity类
 *
 * @author LIVIX
 * @date: 2021/10/13
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();

    /**
     * 绑定当前布局ID
     *
     * @return layoutId
     */
    protected abstract int onBindLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createContentView());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            initIntentData(bundle);
        }
    }

    /**
     * 初始化布局文件
     *
     * @return view
     */
    public abstract View createContentView();


    /**
     * 获取Intent传递的数据
     *
     * @param bundle Intent 传递的Bundle数据
     */
    protected void initIntentData(Bundle bundle) {

    }

    /**
     * 事件处理
     */
    protected void initEvent() {

    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
