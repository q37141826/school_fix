package com.qixiu.schoolfix.ui.acitivty.home.binding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.home.create_mechine.CreateMechineActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/11/27.
 */

public class MechineCodeAdapter extends RecyclerBaseAdapter {


    @Override
    public int getLayoutId() {
        return R.layout.item_layout_select_mechine_code;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new MechineCodeHolder(itemView, context, this);
    }

    public class MechineCodeHolder extends RecyclerBaseHolder {
        TextView textViewMechineCode;
        ImageView imageViewSelected;

        public MechineCodeHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            textViewMechineCode = itemView.findViewById(R.id.textViewMechineCode);
            imageViewSelected = itemView.findViewById(R.id.imageViewSelected);
        }

        @Override
        public void bindHolder(int position) {
            if (mData instanceof MechineCodeListBean.ResultBean.DataListBean) {
                MechineCodeListBean.ResultBean.DataListBean dataListBean = (MechineCodeListBean.ResultBean.DataListBean) mData;
                textViewMechineCode.setText(dataListBean.getDeviceMachineCode());

                imageViewSelected.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataListBean.setModify(true);
                        CreateMechineActivity.start(mContext,CreateMechineActivity.class,dataListBean);
                    }
                });
            }

        }
    }
}
