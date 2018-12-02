package com.qixiu.schoolfix.ui.acitivty.home.create_mechine;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.qixiu.alimaplib.MapContainer;
import com.qixiu.alimaplib.location.LoactionUtils;
import com.qixiu.alimaplib.result.AmapClickResultBean;
import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.ui.acitivty.baseactivity.RequstActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAddressActivity extends RequstActivity implements AMap.OnMapLongClickListener, GeocodeSearch.OnGeocodeSearchListener, AMap.OnMapClickListener {
    @BindView(R.id.textViewSelectedAddress)
    TextView textViewSelectedAddress;
    @BindView(R.id.edittextInputAddress)
    EditText edittextInputAddress;
    @BindView(R.id.mapView)
    TextureMapView mapView;
    @BindView(R.id.map_container)
    MapContainer mapContainer;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    private AMap aMap;
    private GeocodeSearch geocodeSearch;
    private String simpleAddress;
    private LatLng clicklatLng;
    AmapClickResultBean amapClickResultBean;

    @Override
    protected void onInitData() {
        mTitleView.setTitle("选择地址");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_select_address;
    }

    @Override
    protected void onInitViewNew() {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        mapContainer.setScrollView(scrollView);
        //加载地图
        mapView.onCreate(savedInstanceState);
        aMap = mapView.getMap();
        LoactionUtils.location(aMap);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();

        aMap.setOnMapLongClickListener(this);
        aMap.setOnMapClickListener(this);
        //地理搜索类
        geocodeSearch = new GeocodeSearch(this);
        geocodeSearch.setOnGeocodeSearchListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        aMap.clear();
        double latitude = latLng.latitude;
        double longitude = latLng.longitude;
        amapClickResultBean=new AmapClickResultBean();
        amapClickResultBean.setLatLng(latLng);
        MarkerOptions otMarkerOptions = new MarkerOptions();
        otMarkerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.red_point));
        otMarkerOptions.position(latLng);
        getAddressByLatlng(latLng);
        aMap.addMarker(otMarkerOptions);
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));

    }
    @Override
    public void onMapClick(LatLng latLng) {
        aMap.clear();
        clicklatLng = latLng;
        double latitude = latLng.latitude;
        double longitude = latLng.longitude;
        amapClickResultBean=new AmapClickResultBean();
        amapClickResultBean.setLatLng(latLng);
        MarkerOptions otMarkerOptions = new MarkerOptions();
        otMarkerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.red_point));
        otMarkerOptions.position(latLng);
        getAddressByLatlng(latLng);//查询这个坐标的地名
        aMap.addMarker(otMarkerOptions);
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
    }

    private void getAddressByLatlng(LatLng latLng) {
        //逆地理编码查询条件：逆地理编码查询的地理坐标点、查询范围、坐标类型。
        LatLonPoint latLonPoint = new LatLonPoint(latLng.latitude, latLng.longitude);
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 500f, GeocodeSearch.AMAP);
        //异步查询
        geocodeSearch.getFromLocationAsyn(query);
    }


    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
        String formatAddress = regeocodeAddress.getFormatAddress();
        amapClickResultBean.setAddress(formatAddress);
        EventBus.getDefault().post(amapClickResultBean);
        finish();
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

//    //根据地名获取
//    private void getLatlon(String cityName){
//        GeocodeSearch geocodeSearch=new GeocodeSearch(getContext());
//        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
//            @Override
//            public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
//
//            }
//
//            @Override
//            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
//
//                if (i==1000){
//                    if (geocodeResult!=null && geocodeResult.getGeocodeAddressList()!=null &&
//                            geocodeResult.getGeocodeAddressList().size()>0){
//
//                        GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
//                        double latitude = geocodeAddress.getLatLonPoint().getLatitude();//纬度
//                        double longititude = geocodeAddress.getLatLonPoint().getLongitude();//经度
//                        String adcode= geocodeAddress.getAdcode();//区域编码
//
//                        Log.e("地理编码", geocodeAddress.getAdcode()+"");
//                        Log.e("纬度latitude",latitude+"");
//                        Log.e("经度longititude",longititude+"");
//
//                    }else {
//                        ToastUtil.toast("地址名出错");
//                    }
//                }
//            }
//        });
//        GeocodeQuery geocodeQuery=new GeocodeQuery(cityName.trim(),"29");
//        geocodeSearch.getFromLocationNameAsyn(geocodeQuery);
//    }



}
