package com.chenyang.livestudy.activity;

import android.os.Bundle;

import com.chenyang.livestudy.R;
import com.chenyang.livestudy.activity.base.BaseNetActivity;
import com.chenyang.livestudy.network.RetrofitManager;
import com.chenyang.livestudy.network.api.TestApi;
import com.chenyang.livestudy.utils.LogUtils;

import retrofit2.Call;

/**
 * 测试activity
 * Created by xiaoyuan on 16/11/6.
 */

public class TestActivity extends BaseNetActivity<Object> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goneLoading();
//        setContentView(R.layout.activity_main);
//        TestModel.test();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {
        TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> testCall = testApi.test();
        testCall.enqueue(this);
    }

    @Override
    protected void processData(Object o) {
        LogUtils.w(o.toString());
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }
}
