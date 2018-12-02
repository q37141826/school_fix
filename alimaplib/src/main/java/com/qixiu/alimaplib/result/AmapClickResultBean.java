package com.qixiu.alimaplib.result;

import com.amap.api.maps.model.LatLng;

/**
 * Created by my on 2018/11/26.
 */

public class AmapClickResultBean {
    LatLng latLng;
    String address;

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
