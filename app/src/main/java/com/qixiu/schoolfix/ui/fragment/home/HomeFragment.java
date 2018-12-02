package com.qixiu.schoolfix.ui.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.qixiu.qixiu.google.zxing.client.android.CaptureActivity;
import com.qixiu.qixiu.recyclerview_lib.OnRecyclerItemListener;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseAdapter;
import com.qixiu.qixiu.recyclerview_lib.RecyclerBaseHolder;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.Preference;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.action.IntentAction;
import com.qixiu.schoolfix.constant.ConstantString;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.ui.acitivty.work_flow.CreateSoftWorkActivity;
import com.qixiu.schoolfix.ui.acitivty.home.binding.BindingPhoneActivity;
import com.qixiu.schoolfix.ui.fragment.basefragment.base.RequstFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by my on 2018/11/14.
 */

public class HomeFragment extends RequstFragment implements OnRecyclerItemListener {
    int images[] = {R.drawable.sy_icon_djd, R.drawable.sy_icon_dcl, R.drawable.sy_icon_cjgd,
            R.drawable.sy_icon_zsfx, R.drawable.sy_icon_xjgl, R.drawable.homepage_btn_sweep,};
    String homeTitles[] = {"待接单", "待处理", "创建工单", "知识分享", "巡检管理", "扫码绑定",};
    int action[] = {IntentAction.GOTO_WAIT_HANDLER, IntentAction.GOTO_WAIT_HANDLE, IntentAction.GOTO_CREATE,
            IntentAction.GOTO_ACTIVITY, IntentAction.GOTO_ACTIVITY, IntentAction.GOTO_SCAN};
    @BindView(R.id.textViewFinished)
    TextView textViewFinished;
    @BindView(R.id.textViewPresed)
    TextView textViewPresed;
    @BindView(R.id.recyclerHome)
    RecyclerView recyclerHome;
    @BindView(R.id.lineChart)
    LineChart lineChart;
    private HomeAdapter adapter;

    //    Class gotoactivitys[]={MainActivity.class};
    @Override
    protected void onInitData() {
        mTitleView.getView().setVisibility(View.GONE);
        adapter = new HomeAdapter();
        recyclerHome.setAdapter(adapter);
        recyclerHome.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter.setOnItemClickListener(this);
    }

    private void setChartData(List<HomeDataBean.ResultBean.MonthFinshDetailsBean> monthFinshDetails) {
        //显示边界
        lineChart.setDrawBorders(true);
        //设置数据
        List<Entry> entries = new ArrayList<>();
        if (monthFinshDetails.size() <= 1) {
            entries.add(new Entry(0, 0));
        }
        for (int i = 0; i < monthFinshDetails.size(); i++) {
            try {
                float nums = monthFinshDetails.get(i).getFinishCOunt();
                if (entries.size() != 0) {
                    entries.add(new Entry(i + 1, nums));
                } else {
                    entries.add(new Entry(i, nums));
                }
            } catch (Exception e) {
            }
        }

        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, null);
        LineData data = new LineData(lineDataSet);
        lineChart.setData(data);
        lineChart.setScaleEnabled(false);//测试是否禁止滑动
        XAxis xAxis = lineChart.getXAxis();//获取X轴对象
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setAxisLineColor(Color.WHITE);
        YAxis leftYAxis = lineChart.getAxisLeft();//获取两个Y轴对象
        leftYAxis.setTextColor(Color.WHITE);
        leftYAxis.setAxisLineColor(Color.WHITE);
        YAxis rightYAxis = lineChart.getAxisRight();
        rightYAxis.setEnabled(false);//隐藏右侧Y轴
        rightYAxis.setAxisLineColor(Color.WHITE);//隐藏右侧Y轴
        leftYAxis.setDrawGridLines(false);//隐藏Y方向网格线
        lineDataSet.setValueFormatter(new IValueFormatter() {//设置线上为整数
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                int IValue = (int) value;
                return String.valueOf(IValue);
            }
        });
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setColor(Color.WHITE);
//        去掉纵向网格线和顶部边线：
        xAxis.setDrawGridLines(false);//隐藏x轴方向的网格线

        //隐藏描述
        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);
        //       ----
        lineChart.setDrawBorders(false); //隐藏边界线
//        --
        lineChart.setDrawGridBackground(false);//隐藏背景
        lineChart.setDrawingCacheBackgroundColor(Color.WHITE);

        //关闭交互
        lineChart.setTouchEnabled(false);//关闭触摸事件
        //隐藏图例
        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        lineChart.notifyDataSetChanged();
        lineChart.invalidate();//有的时候刷新不出来要加上这2句话
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void onItemClick(View v, RecyclerView.Adapter adapter, Object data) {
        if (data instanceof HomeGotoBean) {
            HomeGotoBean bean = (HomeGotoBean) data;
            if (bean.getAction() == IntentAction.GOTO_ACTIVITY || bean.getAction() == IntentAction.GOTO_CREATE) {
                if (bean.getGotoActivity() == null) {
                    ToastUtil.toast("敬请期待");
                    return;
                }
                Intent intent = new Intent(getContext(), bean.getGotoActivity());
                startActivity(intent);
            } else if (bean.getAction() == IntentAction.GOTO_SCAN) {
                Intent intent = new Intent(getContext(), CaptureActivity.class);
                startActivityForResult(intent, CaptureActivity.ZXING_INTENT);
            } else {
                EventBus.getDefault().post(bean);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String productCode = data.getStringExtra(CaptureActivity.ZXING_VALUE);
            BindingPhoneActivity.start(getContext(),BindingPhoneActivity.class,productCode);
        }
    }

    @Override
    public void onSuccess(BaseBean data) {
        List<HomeGotoBean> datas = new ArrayList<>();
        for (int i = 0; i < homeTitles.length; i++) {
            HomeGotoBean bean = new HomeGotoBean();
            bean.setImage(images[i]);
            bean.setName(homeTitles[i]);
            datas.add(bean);
            bean.setAction(action[i]);
        }
        if (data instanceof HomeDataBean) {
            HomeDataBean dataBean = (HomeDataBean) data;
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).getAction() == IntentAction.GOTO_WAIT_HANDLE) {
                    datas.get(i).setUnDo(dataBean.getO().getWaitDealOrderCount() + "");
                    datas.get(i).setNum_visble(true);
                }
                if (datas.get(i).getAction() == IntentAction.GOTO_WAIT_HANDLER) {
                    // TODO: 2018/11/22  等待后台添加待接单数量
                    datas.get(i).setNum_visble(true);
                    datas.get(i).setUnDo(dataBean.getO().getWaitReceiveOrderCount() + "");
                }
                if (datas.get(i).getAction() == IntentAction.GOTO_SCAN) {
                    datas.get(i).setGotoActivity(CaptureActivity.class);
                }
                if (datas.get(i).getAction() == IntentAction.GOTO_CREATE) {
                    datas.get(i).setGotoActivity(CreateSoftWorkActivity.class);
                }

            }
            adapter.refreshData(datas);
            textViewFinished.setText(dataBean.getO().getFinishWorkOrderCount() + "");
            textViewPresed.setText(dataBean.getO().getPointGoodCount() + "");
            setChartData(dataBean.getO().getMonthFinshDetails());

        }
    }


    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    public void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("comAppUserGUID", Preference.get(ConstantString.USERID, ""));
        post(ConstantUrl.homeUrl, map, new HomeDataBean());
    }

    public class HomeAdapter extends RecyclerBaseAdapter {
        @Override
        public int getLayoutId() {
            return R.layout.item_home;
        }

        @Override
        public Object createViewHolder(View itemView, Context context, int viewType) {
            return new HomeHolder(itemView, context, this);
        }

        public class HomeHolder extends RecyclerBaseHolder<HomeGotoBean> {
            ImageView imageViewHomeItem;
            TextView textViewUnDo, textViewTitle;

            public HomeHolder(View itemView, Context context, RecyclerView.Adapter adapter) {
                super(itemView, context, adapter);
                imageViewHomeItem = itemView.findViewById(R.id.imageViewHomeItem);
                textViewUnDo = itemView.findViewById(R.id.textViewUnDo);
                textViewTitle = itemView.findViewById(R.id.textViewTitle);
            }

            @Override
            public void bindHolder(int position) {
                Glide.with(mContext).load(mData.getImage()).into(imageViewHomeItem);
                textViewTitle.setText(mData.getName());
                textViewUnDo.setText(mData.getUnDo());
                if (mData.isNum_visble() && !TextUtils.isEmpty(mData.getUnDo()) && !"0".equals(mData.getUnDo())) {
                    textViewUnDo.setVisibility(View.VISIBLE);
                } else {
                    textViewUnDo.setVisibility(View.GONE);
                }
            }
        }
    }
}

