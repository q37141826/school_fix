package com.qixiu.alimaplib.location;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.qixiu.alimaplib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2018/12/5.
 */

public class MarkerUtils {

    protected static View getMyView(MarkInterf markInterf, Activity activity) {
        View view = activity.getLayoutInflater().inflate(R.layout.marker_bg, null);
        ImageView tv_val = (ImageView) view.findViewById(R.id.marker_item_icon);
        TextView textView = view.findViewById(R.id.textViewMapMark);
        textView.setText(markInterf.getText());
        tv_val.setImageResource(markInterf.getImageRes());
        return view;
    }

    public static void mark(List<? extends MarkInterf> beans, AMap aMap, Activity activity) {
        for (int i = 0; i < beans.size(); i++) {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(beans.get(i).getLatitude(),
                    beans.get(i).getLongtitude()));
            markerOption.draggable(false);//设置Marker可拖动
            markerOption.title(String.valueOf(i));
            markerOption.icon(BitmapDescriptorFactory.fromView(getMyView(beans.get(i), activity)));
            aMap.addMarker(markerOption);
        }
    }


    public static List<MarkBean>  getTestData(){
        //测试数据
        List<MarkBean> points = new ArrayList<>();
        MarkBean markBean=new MarkBean();
        markBean.setImageRes(R.mipmap.ic_launcher);
        markBean.setLatitude(30.474);
        markBean.setLongtitude(114.387);
        markBean.setText("这个是测试地点");
        points.add(markBean);
        return points;
    }

}
