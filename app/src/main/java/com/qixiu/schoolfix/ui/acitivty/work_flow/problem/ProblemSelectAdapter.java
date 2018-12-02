package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.schoolfix.R;
import com.qixiu.widget.LineControllerView;

public class ProblemSelectAdapter extends RecyclerBaseAdapter {


    @Override
    public int getLayoutId() {
        return R.layout.item_select_problem;
    }

    @Override
    public Object createViewHolder(View itemView, Context context, int viewType) {
        return new ProblemSelectHolder(itemView, context, this);
    }

    public class ProblemSelectHolder extends RecyclerBaseHolder {
        LineControllerView lineProblem;

        public ProblemSelectHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
            super(itemView, context, adapter);
            lineProblem = itemView.findViewById(R.id.lineProblem);
        }

        @Override
        public void bindHolder(int position) {
            if (mData instanceof ProblemDataBean.ResultBean.DataListBean) {
                final ProblemDataBean.ResultBean.DataListBean bean = (ProblemDataBean.ResultBean.DataListBean) mData;
                lineProblem.setPrimaryText(bean.getProductProblemRemark());
                if (bean.isLast()) {
                    lineProblem.setVisibility(View.GONE);
                } else {
                    lineProblem.setVisibility(View.VISIBLE);
                }
                if (bean.isSelected()) {
                    lineProblem.getRightImageView().setImageResource(R.drawable.yuan2);
                } else {
                    lineProblem.getRightImageView().setImageResource(R.drawable.yuan);
                }


            }
            if (mData instanceof ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean) {
                ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean bean = (ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean) mData;
                lineProblem.setPrimaryText(bean.getProductProblemRemark());
                if (bean.isLast()) {
                    lineProblem.setVisibility(View.GONE);
                } else {
                    lineProblem.setVisibility(View.VISIBLE);
                }
                if (bean.isSelected()) {
                    lineProblem.getRightImageView().setImageResource(R.drawable.yuan2);
                } else {
                    lineProblem.getRightImageView().setImageResource(R.drawable.yuan);
                }
            }
        }

    }

}