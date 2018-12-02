package com.qixiu.schoolfix.ui.acitivty.work_flow.sign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

import butterknife.BindView;

import static com.qixiu.schoolfix.ui.acitivty.work_flow.sign.SignWorkActivity.SIGN_GO;
import static com.qixiu.schoolfix.ui.acitivty.work_flow.sign.SignWorkActivity.SIGN_IN;
import static com.qixiu.schoolfix.ui.acitivty.work_flow.sign.SignWorkActivity.SIGN_OUT;

/**
 * Created by my on 2018/11/27.
 */

public class SignAdapter extends RecyclerBaseAdapter {
    //    static final String SIGN_GO = "SIGN_GO";
//    static final String SIGN_IN = "SIGN_IN";
//    static final String SIGN_OUT = "SIGN_OUT";
//    static final String SIGN_FINISH = "SIGN_FINISH";
    ClickListenner listenner;

    public void setListenner(ClickListenner listenner) {
        this.listenner = listenner;
    }

    public interface ClickListenner {
        void click();
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_sign;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        SignHolder signHolder = new SignHolder(itemView, context, this);
        signHolder.setListenner(listenner);
        return signHolder;
    }

    public class SignHolder extends RecyclerBaseHolder {

        ClickListenner listenner;

        public void setListenner(ClickListenner listenner) {
            this.listenner = listenner;
        }

        TextView textViewTime, textViewStep,
                textViewDateTime, textViewAddress;
        Button btnSign;

        public SignHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
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
                textViewStep.setText(bean.getTitleText());
                btnSign.setText(bean.getBtnText());
                btnSign.setVisibility(bean.isBtnVisble()? View.VISIBLE:View.GONE);
                btnSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listenner.click();
                    }
                });
            }
        }
    }
}
