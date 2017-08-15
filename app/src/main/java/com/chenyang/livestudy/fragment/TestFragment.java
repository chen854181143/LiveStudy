package com.chenyang.livestudy.fragment;

import android.os.Bundle;
import android.view.View;

import com.chenyang.livestudy.R;
import com.chenyang.livestudy.fragment.base.BaseNetFragment;
import com.chenyang.livestudy.network.RetrofitManager;
import com.chenyang.livestudy.network.api.TestApi;

import retrofit2.Call;

/**
 * Created by xiaoyuan on 16/11/6.
 */

public class TestFragment extends BaseNetFragment<Object> {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goneLoading();
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

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }
}
