package com.geek.hition.recycleviewdemo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.geek.hition.recycleviewdemo.R;
import com.geek.hition.recycleviewdemo.domain.UserBean;


/**
 * Created by hession on 2016/10/12.
 */
public class UserInfoAdapter extends XMBaseAdapter<UserBean>{

    public UserInfoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserInfoRecycleHolder(parent, R.layout.item_recycleview);
    }

    class UserInfoRecycleHolder extends BaseViewHolder<UserBean>{

        private ImageView avatar;
        private TextView nickName;
        private TextView realName;
        private TextView address;

        public UserInfoRecycleHolder(ViewGroup parent, @LayoutRes int res) {
            super(parent, res);
            avatar = $(R.id.avatar);
            nickName = $(R.id.nickName);
            realName = $(R.id.realName);
            address = $(R.id.address);
        }

        @Override
        public void setData(UserBean data) {
            avatar.setBackgroundResource(data.getAvatarResId());
            nickName.setText(data.getNickname());
            realName.setText(data.getName());
            address.setText(data.getAddress());
        }
    }

}
