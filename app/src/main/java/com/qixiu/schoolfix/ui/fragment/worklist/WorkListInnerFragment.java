package com.qixiu.schoolfix.ui.fragment.worklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.XrecyclerViewUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkDetailsActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkReceiveActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.SoftWorkDetailsActivity;
import com.qixiu.schoolfix.ui.acitivty.work_flow.details.WorkDetailsBean;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.RequstFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

import static com.qixiu.schoolfix.ui.acitivty.work_flow.details.HardWorkDetailsActivity.ORDER_WATING;

/**
 * Created by my on 2018/11/15.
 */

public class WorkListInnerFragment extends RequstFragment implements XRecyclerView.LoadingListener, OnRecyclerItemListener {
    @BindView(R.id.recyclerViewWorlList)
    XRecyclerView recyclerViewWorlList;
    private WorlListAdapter adapter;
    private String type;
    private String selectedId;
    String types[] = {"待接单", "待处理", "历史工单"};


    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void onInitData() {
        mTitleView.getView().setVisibility(View.GONE);
        adapter = new WorlListAdapter();
        recyclerViewWorlList.setAdapter(adapter);
        XrecyclerViewUtil.setXrecyclerView(recyclerViewWorlList, this, getContext(), true, 1, null);

//        getData();
        adapter.setOnItemClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_inner_worklist;
    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onLoadMore() {
        XrecyclerViewUtil.stopXrecyclerRefreshLoading(recyclerViewWorlList);
    }

    @Override
    public void onSuccess(BaseBean data) {
        if (data instanceof WorkListBean) {
            WorkListBean bean = (WorkListBean) data;
            adapter.refreshData(bean.getO().getMyWorkOders());
        }
        if (data instanceof WorkDetailsBean) {
            WorkDetailsBean workDetailsBean = (WorkDetailsBean) data;
            if (workDetailsBean.getO().getDeviceType() == 2) {
                if (type.equals(types[0])) {
                    HardWorkReceiveActivity.start(getContext(), HardWorkReceiveActivity.class, selectedId);
                }
                if (type.equals(types[1])) {
                    if(workDetailsBean.getO().getWorkOrderTypeStr().equals(ORDER_WATING)){
                        HardWorkReceiveActivity.start(getContext(), HardWorkReceiveActivity.class, selectedId);
                    }else {
                        HardWorkDetailsActivity.start(getContext(), HardWorkDetailsActivity.class, selectedId);
                    }
                }
            } else {
                SoftWorkDetailsActivity.start(getContext(), SoftWorkDetailsActivity.class, selectedId);
            }
        }


        XrecyclerViewUtil.stopXrecyclerRefreshLoading(recyclerViewWorlList);
    }

    @Override
    public void onError(Exception e) {
        XrecyclerViewUtil.stopXrecyclerRefreshLoading(recyclerViewWorlList);

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {
        XrecyclerViewUtil.stopXrecyclerRefreshLoading(recyclerViewWorlList);

    }

    public void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("comAppUserId", Preference.get(ConstantString.USERID, ""));
        map.put("workOrderType", type);
        post(ConstantUrl.workListUrl, map, new WorkListBean());
    }

    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        if (data instanceof WorkListBean.ResultBean.MyWorkOdersBean) {
            WorkListBean.ResultBean.MyWorkOdersBean bean = (WorkListBean.ResultBean.MyWorkOdersBean) data;
            selectedId = bean.getId();
            post(ConstantUrl.workDetailsUrl + selectedId, new HashMap(), new WorkDetailsBean());
        }
    }


    public class WorlListAdapter extends RecyclerBaseAdapter {
        @Override
        public int getLayoutId() {
            return R.layout.item_work_list;
        }

        @Override
        public Object createViewHolder(View itemView, Context context, int viewType) {
            return new WorkListHolder(itemView, context, this);
        }

        public class WorkListHolder extends RecyclerBaseHolder {
            ImageView imageViewWorkListItem;
            TextView textViewObjectName, textViewAddress, textViewState, textViewCity,
                    textViewProblem, textViewType, textViewTime;

            public WorkListHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
                super(itemView, context, adapter);
                imageViewWorkListItem = itemView.findViewById(R.id.imageViewWorkListItem);
                textViewObjectName = itemView.findViewById(R.id.textViewObjectName);
                textViewAddress = itemView.findViewById(R.id.textViewAddress);
                textViewState = itemView.findViewById(R.id.textViewState);
                textViewCity = itemView.findViewById(R.id.textViewCity);
                textViewProblem = itemView.findViewById(R.id.textViewProblem);
                textViewType = itemView.findViewById(R.id.textViewType);
                textViewTime = itemView.findViewById(R.id.textViewTime);
            }

            @Override
            public void bindHolder(int position) {
                if (mData instanceof WorkListBean.ResultBean.MyWorkOdersBean) {
                    WorkListBean.ResultBean.MyWorkOdersBean bean = (WorkListBean.ResultBean.MyWorkOdersBean) mData;
                    Glide.with(mContext).load(bean.getProductImgUrl()).error(R.mipmap.shizi).into(imageViewWorkListItem);
                    textViewObjectName.setText(bean.getProductName());
                    textViewTime.setText(bean.getWorkOrderCreatime());
                    textViewProblem.setText(bean.getWorkOrderCstProblemRemark());
                    textViewState.setText(bean.getWorkOrderTypeStr());
                }

            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }
}
