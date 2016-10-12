package com.geek.hition.recycleviewdemo;

import android.view.View;

import com.geek.hition.recycleviewdemo.adapter.XMBaseAdapter;

/**
 * Created by hession on 2016/10/12.
 */
public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

    void setMore(View view, XMBaseAdapter.OnLoadMoreListener listener);
    void setNoMore(View view);
    void setErrorMore(View view);
}
