package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.BR;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.model.check_mechine.CheckMechineBean;

/**
 * Created by my on 2018/12/4.
 */

public class SchoolCheckAdapter extends RecyclerBaseAdapter {

    boolean isCheckBle = true;

    public void setCheckBle(boolean checkBle) {
        isCheckBle = checkBle;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_school_check;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new SchoolCheckHoldr(itemView, context, this);
    }

    public class SchoolCheckHoldr extends RecyclerBaseHolder {
        TextView textViewNum, textViewCheckState
//                textViewAddress, textViewMechineCode,
//                textViewMechineName, textViewCheckItems;
                ;
        ImageView imageViewGotoDetails;
        private final ViewDataBinding bind;

        public SchoolCheckHoldr(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
//            textViewCheckItems = itemView.findViewById(R.id.textViewCheckItems);
//            textViewNum = itemView.findViewById(R.id.textViewNum);
            textViewCheckState = itemView.findViewById(R.id.textViewCheckState);
//            textViewAddress = itemView.findViewById(R.id.textViewAddress);
//            textViewMechineCode = itemView.findViewById(R.id.textViewMechineCode);
//            textViewMechineName = itemView.findViewById(R.id.textViewMechineName);
            imageViewGotoDetails = itemView.findViewById(R.id.imageViewGotoDetails);
            bind = DataBindingUtil.bind(itemView);
        }

        @Override
        public void bindHolder(int position) {
//            textViewCheckItems.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    getClickListenner().click(itemView,mData);
//                }
//            });
            imageViewGotoDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getClickListenner2().itemChildclick(imageViewGotoDetails, mData, 1, itemView);
                }
            });
            bind.setVariable(BR.data, mData);
            if (mData instanceof CheckMechineBean.ResultBean.DataListBean) {
                CheckMechineBean.ResultBean.DataListBean listBean = (CheckMechineBean.ResultBean.DataListBean) mData;
                textViewCheckState.setText(listBean.getIsChecked() == 0 ? "未检测" : "已检测");
                textViewCheckState.setVisibility(isCheckBle ? View.VISIBLE : View.GONE);
                textViewCheckState.setTextColor(listBean.getIsChecked() == 0 ?
                        mContext.getResources().getColor(R.color.theme_color) : mContext.getResources().getColor(R.color.txt_fe9e46));
            }

        }
    }
}
