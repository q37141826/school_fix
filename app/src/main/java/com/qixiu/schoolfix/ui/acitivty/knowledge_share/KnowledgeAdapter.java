package com.qixiu.schoolfix.ui.acitivty.knowledge_share;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.BuildConfig;
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
        ImageView imageView;
        TextView textView;

        public KnowledgeHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }

        @Override
        public void bindHolder(int position) {
            if (mData instanceof KnowledgeShareBean.ResultBean.DataListBean) {
                KnowledgeShareBean.ResultBean.DataListBean bean = (KnowledgeShareBean.ResultBean.DataListBean) mData;
                textView.setText(bean.getArticleTypeName());
                Glide.with(mContext).load(BuildConfig.BASE_URL + bean.getArticleTypeUrl()).into(imageView);
            }
        }
    }
}
