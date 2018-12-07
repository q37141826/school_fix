package com.qixiu.schoolfix.ui.acitivty.inspection.school_check;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;

/**
 * Created by my on 2018/12/4.
 */

public class SchoolCheckAdapter extends RecyclerBaseAdapter {

    @Override
    public int getLayoutId() {
        return R.layout.item_school_check;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new SchoolCheckHoldr(itemView, context, this);
    }

    public class SchoolCheckHoldr extends RecyclerBaseHolder {
        TextView textViewNum, textViewCheckState,
                textViewAddress, textViewMechineCode,
                textViewMechineName, textViewCheckItems;
        ImageView imageViewGotoDetails;
        public SchoolCheckHoldr(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            textViewCheckItems = itemView.findViewById(R.id.textViewCheckItems);
            textViewNum = itemView.findViewById(R.id.textViewNum);
            textViewCheckState = itemView.findViewById(R.id.textViewCheckState);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewMechineCode = itemView.findViewById(R.id.textViewMechineCode);
            textViewMechineName = itemView.findViewById(R.id.textViewMechineName);
            imageViewGotoDetails = itemView.findViewById(R.id.imageViewGotoDetails);
        }

        @Override
        public void bindHolder(int position) {
            textViewCheckItems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getClickListenner().click(itemView,mData);
                }
            });
            imageViewGotoDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getClickListenner2().itemChildclick(imageViewGotoDetails,mData,1,itemView);
                }
            });
        }
    }
}
