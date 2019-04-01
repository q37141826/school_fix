package com.qixiu.schoolfix.model.check_mechine;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

public class CheckMechineBean extends BaseBean<CheckMechineBean.ResultBean> {


    public static class ResultBean {
        /**
         * dataList : [{"id":"11109c69-8a39-e911-9738-a58da28d0b52","checkRecordGUID":"8a5ddc9b-783e-40f1-9be1-7aec453070c9","userGUID":null,"createTime":"2019-02-26 13:50:26","checkDeviceRecordTime":null,"deviceGUID":"69667064-ed92-4d49-ccc0-08d64f98bdd5","deviceAddress":"武汉市江夏区武大园路","deviceMachineCode":"123","productName":"高斯法拉利红108","isChecked":0},{"id":"12109c69-8a39-e911-9738-a58da28d0b52","checkRecordGUID":"8a5ddc9b-783e-40f1-9be1-7aec453070c9","userGUID":null,"createTime":"2019-02-26 13:50:26","checkDeviceRecordTime":null,"deviceGUID":"7c88ff2c-00c6-412e-76cd-08d69ac9d8b8","deviceAddress":"123132123","deviceMachineCode":"0010101","productName":"雷蛇TAIPAN3500","isChecked":0}]
         * pageIndex : 1
         * pageCount : 1
         * pageSize : 1000
         * rowCount : 2
         */

        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        private List<DataListBean> dataList;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean implements Parcelable {
            /**
             * id : 11109c69-8a39-e911-9738-a58da28d0b52
             * checkRecordGUID : 8a5ddc9b-783e-40f1-9be1-7aec453070c9
             * userGUID : null
             * createTime : 2019-02-26 13:50:26
             * checkDeviceRecordTime : null
             * deviceGUID : 69667064-ed92-4d49-ccc0-08d64f98bdd5
             * deviceAddress : 武汉市江夏区武大园路
             * deviceMachineCode : 123
             * productName : 高斯法拉利红108
             * isChecked : 0
             */

            private String id;
            private String qrCodeGUID;
            private String checkRecordGUID;
            private String userGUID;
            private String createTime;
            private String checkDeviceRecordTime;
            private String deviceGUID;
            private String deviceAddress;
            private String deviceMachineCode;
            private String productName;
            private int isChecked;

            public String getQrCodeGUID() {
                return qrCodeGUID;
            }

            public void setQrCodeGUID(String qrCodeGUID) {
                this.qrCodeGUID = qrCodeGUID;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCheckRecordGUID() {
                return checkRecordGUID;
            }

            public void setCheckRecordGUID(String checkRecordGUID) {
                this.checkRecordGUID = checkRecordGUID;
            }

            public Object getUserGUID() {
                return userGUID;
            }

            public void setUserGUID(String userGUID) {
                this.userGUID = userGUID;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getCheckDeviceRecordTime() {
                return checkDeviceRecordTime;
            }

            public void setCheckDeviceRecordTime(String checkDeviceRecordTime) {
                this.checkDeviceRecordTime = checkDeviceRecordTime;
            }

            public String getDeviceGUID() {
                return deviceGUID;
            }

            public void setDeviceGUID(String deviceGUID) {
                this.deviceGUID = deviceGUID;
            }

            public String getDeviceAddress() {
                return deviceAddress;
            }

            public void setDeviceAddress(String deviceAddress) {
                this.deviceAddress = deviceAddress;
            }

            public String getDeviceMachineCode() {
                return deviceMachineCode;
            }

            public void setDeviceMachineCode(String deviceMachineCode) {
                this.deviceMachineCode = deviceMachineCode;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public int getIsChecked() {
                return isChecked;
            }

            public void setIsChecked(int isChecked) {
                this.isChecked = isChecked;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.qrCodeGUID);
                dest.writeString(this.checkRecordGUID);
                dest.writeString(this.userGUID);
                dest.writeString(this.createTime);
                dest.writeString(this.checkDeviceRecordTime);
                dest.writeString(this.deviceGUID);
                dest.writeString(this.deviceAddress);
                dest.writeString(this.deviceMachineCode);
                dest.writeString(this.productName);
                dest.writeInt(this.isChecked);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.qrCodeGUID = in.readString();
                this.checkRecordGUID = in.readString();
                this.userGUID = in.readString();
                this.createTime = in.readString();
                this.checkDeviceRecordTime = in.readString();
                this.deviceGUID = in.readString();
                this.deviceAddress = in.readString();
                this.deviceMachineCode = in.readString();
                this.productName = in.readString();
                this.isChecked = in.readInt();
            }

            public static final Parcelable.Creator<DataListBean> CREATOR = new Parcelable.Creator<DataListBean>() {
                @Override
                public DataListBean createFromParcel(Parcel source) {
                    return new DataListBean(source);
                }

                @Override
                public DataListBean[] newArray(int size) {
                    return new DataListBean[size];
                }
            };
        }
    }
}
