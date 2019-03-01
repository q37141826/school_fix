package com.qixiu.qixiu.recyclerview_lib;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class RecyclerDataBindingHolder extends RecyclerBaseHolder {
    private final ViewDataBinding bind;
    public RecyclerDataBindingHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
        super(itemView, context, adapter);
        bind = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bindHolder(int position) {
        bind.setVariable(getVaribleId(),mData);
        setClick();
    }

    public void setClick(){

    }

    public abstract int getVaribleId();
}
