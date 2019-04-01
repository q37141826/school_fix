package com.qixiu.schoolfix.ui.acitivty.inspection;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.MarkerOptions;
import com.qixiu.alimaplib.MapContainer;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.alimaplib.location.MarkBean;
import com.qixiu.alimaplib.location.MarkerUtils;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.IntentDataKeyConstant;
import com.qixiu.schoolfix.model.check_mechine.CheckMainSchoolBean;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequestActivity;
import com.qixiu.wigit.show_dialog.ArshowContextUtil;

import java.util.ArrayList;
import java.util.List;

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
    List<CheckMainSchoolBean.ResultBean.DataListBean> points;

    @Override
    protected void onInitViewNew() {
        mTitleView.setTitle("巡检地图");
        points = getIntent().getParcelableArrayListExtra(IntentDataKeyConstant.DATA);
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
//        MarkerUtils.mark(MarkerUtils.getTestData(), aMap, this);
//        aMap.setPointToCenter((int)MarkerUtils.getTestData().get(0).getLatitude(),(int)MarkerUtils.getTestData().get(0).getLongtitude());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (points != null) {
            List<MarkBean> markBeans = new ArrayList<>();
            for (int i = 0; i < points.size(); i++) {
                MarkBean markBean = new MarkBean();
                markBean.setLatitude(Double.parseDouble(points.get(i).getSchoolUnitMapY()));
                markBean.setLongtitude(Double.parseDouble(points.get(i).getSchoolUnitMapX()));
                markBean.setText(points.get(i).getCheckPointName());
                markBean.setImageRes(R.mipmap.map_mark2x);
                markBeans.add(markBean);
            }
            aMap.getUiSettings().setRotateGesturesEnabled(false);//禁止多点触控的时候旋转
            aMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
                @Override
                public void onMapLoaded() {
                    Location myLocation = aMap.getMyLocation();
                    MarkBean markBean = new MarkBean();//把当前位置也添加进去
                    markBean.setLatitude(myLocation.getLatitude());
                    markBean.setLongtitude(myLocation.getLongitude());
                    markBean.setText("");
                    markBeans.add(markBean);
                    List<MarkerOptions> mark = MarkerUtils.mark(markBeans, aMap, getActivity());
                    LoactionUtils.adjustPoints(aMap, mark);
                }
            });
        }
    }
}
