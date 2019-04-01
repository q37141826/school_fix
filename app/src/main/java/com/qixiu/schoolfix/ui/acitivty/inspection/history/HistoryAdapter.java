package com.qixiu.schoolfix.ui.acitivty.inspection.history;

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

public class HistoryAdapter extends RecyclerBaseAdapter {
    int varibleId;

    @Override
    public int getLayoutId() {
//        return R.layout.item_history;
        return R.layout.item_inspection;
    }

    public void setVaribleId(int varibleId) {
        this.varibleId = varibleId;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new HistotyHolder(itemView, context, this);
    }

    public class HistotyHolder extends RecyclerBaseHolder {

        private final ViewDataBinding bind;

        public HistotyHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            bind = DataBindingUtil.bind(itemView);
        }

        @Override
        public void bindHolder(int position) {
            bind.setVariable(varibleId,mData);
        }
    }
}
