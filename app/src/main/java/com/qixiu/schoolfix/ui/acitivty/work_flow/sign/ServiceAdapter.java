package com.qixiu.schoolfix.ui.acitivty.work_flow.sign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

/**
 * Created by my on 2018/11/29.
 */

public class ServiceAdapter extends RecyclerBaseAdapter {

    @Override
    public int getLayoutId() {
        return R.layout.item_sign;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new ServiceHolder(itemView,context,this);
    }

    public class ServiceHolder extends RecyclerBaseHolder{
        TextView textViewTime, textViewStep,
                textViewDateTime, textViewAddress;
        Button btnSign;
        public ServiceHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewStep = itemView.findViewById(R.id.textViewStep);
            textViewDateTime = itemView.findViewById(R.id.textViewDateTime);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            btnSign = itemView.findViewById(R.id.btnSign);
        }

        @Override
        public void bindHolder(int position) {
            if (mData instanceof TimeAddressBean) {
                TimeAddressBean bean = (TimeAddressBean) mData;
                textViewAddress.setText(bean.getAddress());
                textViewDateTime.setText(bean.getTime());
                textViewTime.setText(bean.minutus/1000/60 + "分钟");
                textViewTime.setVisibility(View.GONE);
                textViewStep.setText(bean.getTitleText());
                btnSign.setText(bean.getBtnText());
                btnSign.setVisibility(bean.isBtnVisble()? View.VISIBLE:View.GONE);
                btnSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       getClickListenner().click(v,mData);
                    }
                });
            }
        }
    }
}
