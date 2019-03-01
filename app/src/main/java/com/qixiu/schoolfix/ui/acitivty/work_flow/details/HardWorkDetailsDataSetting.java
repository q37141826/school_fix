package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.BuildConfig;
import com.qixiu.schoolfix.R;

import java.util.ArrayList;

import me.iwf.photopicker.PhotoPreview;

public class HardWorkDetailsDataSetting {
    public static void setProblemPic(RecyclerView recyclerView, String pics, Activity activity) {
        if (TextUtils.isEmpty(pics)) {
            recyclerView.setVisibility(View.GONE);
            return;
        } else {
            recyclerView.setVisibility(View.VISIBLE);
        }
        String[] split = pics.split(";");
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            datas.add(BuildConfig.BASE_URL + split[i]);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        ShowPicAdapter adapter = new ShowPicAdapter();
        recyclerView.setAdapter(adapter);
        adapter.refreshData(datas);
        adapter.setOnItemClickListener(new OnRecyclerItemListener() {
            @Override
            public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
                PhotoPreview.builder().setPhotos(datas).setShowDeleteButton(false).setCurrentItem(recyclerView.getChildLayoutPosition(v)).start(
                        activity);
            }
        });
    }


    public static class ShowPicAdapter extends RecyclerBaseAdapter {
        @Override
        public int getLayoutId() {
            return R.layout.item_upload_pictrue;
        }

        @Override
        public Object createViewHolder(View itemView, Context context, int viewType) {
            return new ShowHolder(itemView, context, this);
        }

        public class ShowHolder extends RecyclerBaseHolder {
            ImageView iv_picture;

            public ShowHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
                super(itemView, context, adapter);
                iv_picture = itemView.findViewById(R.id.iv_picture);
            }

            @Override
            public void bindHolder(int position) {
                Glide.with(mContext).load(mData.toString()).into(iv_picture);
            }
        }
    }
}
