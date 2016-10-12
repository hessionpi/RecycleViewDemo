package com.geek.hition.recycleviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geek.hition.recycleviewdemo.adapter.UserInfoAdapter;
import com.geek.hition.recycleviewdemo.adapter.XMBaseAdapter;
import com.geek.hition.recycleviewdemo.domain.UserBean;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements XMBaseAdapter.OnLoadMoreListener {

    @Bind(R.id.recycle)
    RecyclerView mRecycle;

    private UserInfoAdapter adapter ;
    private List<UserBean> userDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        adapter = new UserInfoAdapter(this);
        adapter.setMore(R.layout.view_recyclerview_more, this);
        adapter.setNoMore(R.layout.view_recyclerview_nomore);
        adapter.setError(R.layout.view_recyclerview_error);

        //rRecyclerView相关配置
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycle.setLayoutManager(layoutManager);
        adapter.addHeader(new HeaderView());
        mRecycle.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        UserBean u1 = new UserBean();
        u1.setAvatarResId(R.mipmap.ic_launcher);
        u1.setNickname("天下无贼");
        u1.setName("傻根");
        u1.setAddress("甘肃天水");
        userDatas.add(u1);
        UserBean u2 = new UserBean();
        u2.setAvatarResId(R.mipmap.ic_launcher);
        u2.setNickname("功夫足球");
        u2.setName("馒头妹");
        u2.setAddress("广州花都影视城一楼");
        userDatas.add(u2);
        UserBean u3 = new UserBean();
        u3.setAvatarResId(R.mipmap.ic_launcher);
        u3.setNickname("火云邪神");
        u3.setName("连小龙");
        u3.setAddress("中国香港港仔码头2号铺");
        userDatas.add(u3);
        UserBean u4 = new UserBean();
        u4.setAvatarResId(R.mipmap.ic_launcher);
        u4.setNickname("牛逼哄哄");
        u4.setName("奶茶妹");
        u4.setAddress("北京市海淀区京东大厦一楼京东商城");
        userDatas.add(u4);
        adapter.addAll(userDatas);
    }


    @Override
    public void onLoadMore() {
        // to do load more page datas

    }

    class HeaderView implements XMBaseAdapter.ItemView{

        @Override
        public View onCreateView(ViewGroup parent) {
            TextView mHeader = new TextView(MainActivity.this);
            mHeader.setGravity(Gravity.CENTER);
            mHeader.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            mHeader.setText("这是为recycle 添加的头");
            mHeader.setTextColor(getResources().getColor(R.color.colorPrimary));
            return mHeader;
        }

        @Override
        public void onBindView(View headerView) {

        }
    }
}
