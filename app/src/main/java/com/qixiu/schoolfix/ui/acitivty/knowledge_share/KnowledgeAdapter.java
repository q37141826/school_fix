package com.qixiu.schoolfix.ui.acitivty.knowledge_share;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

/**
 * Created by my on 2018/12/5.
 */

public class KnowledgeAdapter extends RecyclerBaseAdapter {

    @Override
    public int getLayoutId() {
        return R.layout.item_knowledge;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new KnowledgeHolder(itemView, context, this);
    }

    public class KnowledgeHolder extends RecyclerBaseHolder {

        public KnowledgeHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
        }

        @Override
        public void bindHolder(int position) {

        }
    }
}
