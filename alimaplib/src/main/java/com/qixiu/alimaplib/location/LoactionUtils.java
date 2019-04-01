package com.qixiu.alimaplib.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by my on 2018/11/26.
 */

public class LoactionUtils {
    public static String loactionPermissions[] = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private static double logtitude;
    private static double latitude;

    public static MyLocationStyle location(AMap aMap) {
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);//定位一次，且将视角移动到地图中心点。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style

        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.getUiSettings().setRotateGesturesEnabled(false);//不准旋转
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.getUiSettings().setZoomControlsEnabled(false);//隐藏放大缩小按钮

        return myLocationStyle;
    }


    public static void searchAddress(double lati, double longti, Context context, LocationResultStrIntf listenner) {
        GeocodeSearch geocodeSearch;
        //逆地理编码查询条件：逆地理编码查询的地理坐标点、查询范围、坐标类型。
        LatLonPoint latLonPoint = new LatLonPoint(lati, longti);
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 500f, GeocodeSearch.AMAP);
        //异步查询
        geocodeSearch = new GeocodeSearch(context);

        geocodeSearch.getFromLocationAsyn(query);

        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            @Override
            public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
                RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
                String formatAddress = regeocodeAddress.getFormatAddress();
                if (listenner != null) {
                    listenner.locationResult(formatAddress);
                }
            }

            @Override
            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

            }
        });


    }

    public static void adjustPoints(AMap aMap, List<MarkerOptions> markers) {
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();//存放所有点的经纬度
        for (int i = 0; i < markers.size(); i++) {
            boundsBuilder.include(markers.get(i).getPosition());//把所有点都include进去（LatLng类型）
        }
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 50));//第二个参数为四周留空宽度
    }


    public static void getLoacation(Context context, LocationResultListenner listenner) {
        logtitude = 0;
        latitude = 0;
        LocationManager locationManager;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);//低精度，如果设置为高精度，依然获取不了location。
        criteria.setAltitudeRequired(false);//不要求海拔
        criteria.setBearingRequired(false);//不要求方位
        criteria.setCostAllowed(true);//允许有花费
        criteria.setPowerRequirement(Criteria.POWER_LOW);//低功耗
        String locationProvider = locationManager.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "onCreate: 没有权限 ");
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationProvider);
        Log.d(TAG, "onCreate: " + (location == null) + "..");
        if (location != null) {
            Log.d(TAG, "onCreate: location");
            //不为空,显示地理位置经纬度
        }

        //监视地理位置变化
        locationManager.requestLocationUpdates(locationProvider, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (logtitude != location.getLongitude() || latitude != location.getLatitude()) {
                    logtitude = location.getLongitude();
                    latitude = location.getLatitude();
                    listenner.getResult(location);
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
    }


    public static void getOneceLoction(Context context, LocationResultListenner locationResultListenner) {
        //声明AMapLocationClient类对象
        AMapLocationClient mLocationClient = null;
//声明定位回调监听器
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                locationResultListenner.getResult(aMapLocation);
            }
        };
//初始化定位
        mLocationClient = new AMapLocationClient(context);
//设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(option);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
//设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        option.setOnceLocationLatest(true);
        mLocationClient.startLocation();
    }


    public interface LocationResultListenner {
        void getResult(Location location);
    }


}
