package com.qixiu.schoolfix.ui.acitivty.inspection.check_route;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

/**
 * Created by my on 2018/12/4.
 */

public class CheckRouteAdapter extends RecyclerBaseAdapter {
    private ViewDataBinding bind;
    int varableId;

    public void setVarableId(int varableId) {
        this.varableId = varableId;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_check_route;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new CheckRouteHolder(itemView, context, this);
    }

    public class CheckRouteHolder extends RecyclerBaseHolder {

        public CheckRouteHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            bind = DataBindingUtil.bind(itemView);
        }

        @Override
        public void bindHolder(int position) {
            bind.setVariable(varableId,mData);
        }
    }
}
