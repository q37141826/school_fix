package com.qixiu.schoolfix.ui.acitivty.inspection;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.qixiu.alimaplib.MapContainer;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.alimaplib.location.MarkerUtils;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.wigit.show_dialog.ArshowContextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RouteMapActivity extends RequestActivity {


    @BindView(R.id.mapView)
    TextureMapView mapView;
    @BindView(R.id.map_container)
    MapContainer mapContainer;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    private AMap aMap;

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("巡检地图");
    }

    @Override
    public void onSuccess(BaseBean data) {

    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onFailure(C_CodeBean c_codeBean, String m) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onInitData() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_route_map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //加载地图
        mapContainer.setScrollView(scrollView);
        mapView.onCreate(savedInstanceState);
        RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) mapView.getLayoutParams();
        layoutparams.height = windowHeight - ArshowContextUtil.dp2px(100);
        aMap = mapView.getMap();
        LoactionUtils.location(aMap);

        //测试下数据
        MarkerUtils.mark(MarkerUtils.getTestData(),aMap,this);
//        aMap.setPointToCenter((int)MarkerUtils.getTestData().get(0).getLatitude(),(int)MarkerUtils.getTestData().get(0).getLongtitude());
    }
}
