package com.qixiu.schoolfix.ui.acitivty.inspection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

/**
 * Created by my on 2018/12/3.
 */

public class InspectionAdapter extends RecyclerBaseAdapter {


    @Override
    public int getLayoutId() {
        return R.layout.item_inspection;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new InspectHolder(itemView,context,this);
    }

    public class InspectHolder extends RecyclerBaseHolder {

        public InspectHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
        }

        @Override
        public void bindHolder(int position) {

        }
    }
}
