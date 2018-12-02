package com.qixiu.schoolfix.ui.acitivty.home.binding;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class MechineCodeListBean extends BaseBean<MechineCodeListBean.ResultBean> {


    /**
     * dataList : [{"id":"f8477e44-0d00-4d4a-ccc1-08d64f98bdd5","schoolUnitGUID":"efb1dd4f-4851-4fb5-b69a-007d261deeeb","repairBusinessGUID":"9936f0b1-6953-4037-802a-297f728a97a4","productGUID":"50bb2acd-7694-436f-8be7-08d64c5ba3ec","deviceBuyDate":"2018-11-02 00:00:00","deviceNotUseYears":3,"deviceMachineCode":"456","deviceIpAddress":"456","deviceAddress":"武汉市江夏区武大园路","deviceMapX":"456","deviceMapY":"45","deviceRepairBeginDate":"2018-11-02 00:00:00","deviceRepairEndDate":"2018-11-24 00:00:00","deviceType":2,"deviceSoftName":"","deviceSoftBrand":"","deviceSoftFramework":"","deviceSoftType":"","deviceSoftPlatform":"","deviceSoftLanguage":"","qrCodeGUID":"","deviceRejectReason":"","deviceRecordCode":"20181121YJ201811210000700005","tenantId":"","isDeleted":"","createTime":"2018-11-21 18:09:05","createGUID":"","createdName":"","modifiedTime":"2018-11-27 10:11:03","modifiedGUID":"","modifiedName":"","approveState":"审批中","approveGUID":"","approveTime":"","deviceCode":"2018112100007","schoolUnitName":"上海市青浦区豫才中学","productName":"NIZ84双模静电容RGB","qrCodeImgUrl":""}]
     * pageIndex : 1
     * pageCount : 1
     * pageSize : 1000
     * rowCount : 1
     */


    public static class ResultBean implements Parcelable {



        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : f8477e44-0d00-4d4a-ccc1-08d64f98bdd5
         * schoolUnitGUID : efb1dd4f-4851-4fb5-b69a-007d261deeeb
         * repairBusinessGUID : 9936f0b1-6953-4037-802a-297f728a97a4
         * productGUID : 50bb2acd-7694-436f-8be7-08d64c5ba3ec
         * deviceBuyDate : 2018-11-02 00:00:00
         * deviceNotUseYears : 3
         * deviceMachineCode : 456
         * deviceIpAddress : 456
         * deviceAddress : 武汉市江夏区武大园路
         * deviceMapX : 456
         * deviceMapY : 45
         * deviceRepairBeginDate : 2018-11-02 00:00:00
         * deviceRepairEndDate : 2018-11-24 00:00:00
         * deviceType : 2
         * deviceSoftName :
         * deviceSoftBrand :
         * deviceSoftFramework :
         * deviceSoftType :
         * deviceSoftPlatform :
         * deviceSoftLanguage :
         * qrCodeGUID :
         * deviceRejectReason :
         * deviceRecordCode : 20181121YJ201811210000700005
         * tenantId :
         * isDeleted :
         * createTime : 2018-11-21 18:09:05
         * createGUID :
         * createdName :
         * modifiedTime : 2018-11-27 10:11:03
         * modifiedGUID :
         * modifiedName :
         * approveState : 审批中
         * approveGUID :
         * approveTime :
         * deviceCode : 2018112100007
         * schoolUnitName : 上海市青浦区豫才中学
         * productName : NIZ84双模静电容RGB
         * qrCodeImgUrl :
         */

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



            private String id;
            private String schoolUnitGUID;
            private String repairBusinessGUID;
            private String productGUID;
            private String deviceBuyDate;
            private int deviceNotUseYears;
            private String deviceMachineCode;
            private String deviceIpAddress;
            private String deviceAddress;
            private String deviceMapX;
            private String deviceMapY;
            private String deviceRepairBeginDate;
            private String deviceRepairEndDate;
            private int deviceType;
            private String deviceSoftName;
            private String deviceSoftBrand;
            private String deviceSoftFramework;
            private String deviceSoftType;
            private String deviceSoftPlatform;
            private String deviceSoftLanguage;
            private String qrCodeGUID;
            private String deviceRejectReason;
            private String deviceRecordCode;
            private String tenantId;
            private String isDeleted;
            private String createTime;
            private String createGUID;
            private String createdName;
            private String modifiedTime;
            private String modifiedGUID;
            private String modifiedName;
            private String approveState;
            private String approveGUID;
            private String approveTime;
            private String deviceCode;
            private String schoolUnitName;
            private String productName;
            private String qrCodeImgUrl;
            private boolean first = false;
            private boolean isModify=false;

            public boolean isModify() {
                return isModify;
            }

            public void setModify(boolean modify) {
                isModify = modify;
            }

            public boolean isFirst() {
                return first;
            }

            public void setFirst(boolean first) {
                this.first = first;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSchoolUnitGUID() {
                return schoolUnitGUID;
            }

            public void setSchoolUnitGUID(String schoolUnitGUID) {
                this.schoolUnitGUID = schoolUnitGUID;
            }

            public String getRepairBusinessGUID() {
                return repairBusinessGUID;
            }

            public void setRepairBusinessGUID(String repairBusinessGUID) {
                this.repairBusinessGUID = repairBusinessGUID;
            }

            public String getProductGUID() {
                return productGUID;
            }

            public void setProductGUID(String productGUID) {
                this.productGUID = productGUID;
            }

            public String getDeviceBuyDate() {
                return deviceBuyDate;
            }

            public void setDeviceBuyDate(String deviceBuyDate) {
                this.deviceBuyDate = deviceBuyDate;
            }

            public int getDeviceNotUseYears() {
                return deviceNotUseYears;
            }

            public void setDeviceNotUseYears(int deviceNotUseYears) {
                this.deviceNotUseYears = deviceNotUseYears;
            }

            public String getDeviceMachineCode() {
                return deviceMachineCode;
            }

            public void setDeviceMachineCode(String deviceMachineCode) {
                this.deviceMachineCode = deviceMachineCode;
            }

            public String getDeviceIpAddress() {
                return deviceIpAddress;
            }

            public void setDeviceIpAddress(String deviceIpAddress) {
                this.deviceIpAddress = deviceIpAddress;
            }

            public String getDeviceAddress() {
                return deviceAddress;
            }

            public void setDeviceAddress(String deviceAddress) {
                this.deviceAddress = deviceAddress;
            }

            public String getDeviceMapX() {
                return deviceMapX;
            }

            public void setDeviceMapX(String deviceMapX) {
                this.deviceMapX = deviceMapX;
            }

            public String getDeviceMapY() {
                return deviceMapY;
            }

            public void setDeviceMapY(String deviceMapY) {
                this.deviceMapY = deviceMapY;
            }

            public String getDeviceRepairBeginDate() {
                return deviceRepairBeginDate;
            }

            public void setDeviceRepairBeginDate(String deviceRepairBeginDate) {
                this.deviceRepairBeginDate = deviceRepairBeginDate;
            }

            public String getDeviceRepairEndDate() {
                return deviceRepairEndDate;
            }

            public void setDeviceRepairEndDate(String deviceRepairEndDate) {
                this.deviceRepairEndDate = deviceRepairEndDate;
            }

            public int getDeviceType() {
                return deviceType;
            }

            public void setDeviceType(int deviceType) {
                this.deviceType = deviceType;
            }

            public String getDeviceSoftName() {
                return deviceSoftName;
            }

            public void setDeviceSoftName(String deviceSoftName) {
                this.deviceSoftName = deviceSoftName;
            }

            public String getDeviceSoftBrand() {
                return deviceSoftBrand;
            }

            public void setDeviceSoftBrand(String deviceSoftBrand) {
                this.deviceSoftBrand = deviceSoftBrand;
            }

            public String getDeviceSoftFramework() {
                return deviceSoftFramework;
            }

            public void setDeviceSoftFramework(String deviceSoftFramework) {
                this.deviceSoftFramework = deviceSoftFramework;
            }

            public String getDeviceSoftType() {
                return deviceSoftType;
            }

            public void setDeviceSoftType(String deviceSoftType) {
                this.deviceSoftType = deviceSoftType;
            }

            public String getDeviceSoftPlatform() {
                return deviceSoftPlatform;
            }

            public void setDeviceSoftPlatform(String deviceSoftPlatform) {
                this.deviceSoftPlatform = deviceSoftPlatform;
            }

            public String getDeviceSoftLanguage() {
                return deviceSoftLanguage;
            }

            public void setDeviceSoftLanguage(String deviceSoftLanguage) {
                this.deviceSoftLanguage = deviceSoftLanguage;
            }

            public String getQrCodeGUID() {
                return qrCodeGUID;
            }

            public void setQrCodeGUID(String qrCodeGUID) {
                this.qrCodeGUID = qrCodeGUID;
            }

            public String getDeviceRejectReason() {
                return deviceRejectReason;
            }

            public void setDeviceRejectReason(String deviceRejectReason) {
                this.deviceRejectReason = deviceRejectReason;
            }

            public String getDeviceRecordCode() {
                return deviceRecordCode;
            }

            public void setDeviceRecordCode(String deviceRecordCode) {
                this.deviceRecordCode = deviceRecordCode;
            }

            public String getTenantId() {
                return tenantId;
            }

            public void setTenantId(String tenantId) {
                this.tenantId = tenantId;
            }

            public String getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(String isDeleted) {
                this.isDeleted = isDeleted;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateGUID() {
                return createGUID;
            }

            public void setCreateGUID(String createGUID) {
                this.createGUID = createGUID;
            }

            public String getCreatedName() {
                return createdName;
            }

            public void setCreatedName(String createdName) {
                this.createdName = createdName;
            }

            public String getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(String modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public String getModifiedGUID() {
                return modifiedGUID;
            }

            public void setModifiedGUID(String modifiedGUID) {
                this.modifiedGUID = modifiedGUID;
            }

            public String getModifiedName() {
                return modifiedName;
            }

            public void setModifiedName(String modifiedName) {
                this.modifiedName = modifiedName;
            }

            public String getApproveState() {
                return approveState;
            }

            public void setApproveState(String approveState) {
                this.approveState = approveState;
            }

            public String getApproveGUID() {
                return approveGUID;
            }

            public void setApproveGUID(String approveGUID) {
                this.approveGUID = approveGUID;
            }

            public String getApproveTime() {
                return approveTime;
            }

            public void setApproveTime(String approveTime) {
                this.approveTime = approveTime;
            }

            public String getDeviceCode() {
                return deviceCode;
            }

            public void setDeviceCode(String deviceCode) {
                this.deviceCode = deviceCode;
            }

            public String getSchoolUnitName() {
                return schoolUnitName;
            }

            public void setSchoolUnitName(String schoolUnitName) {
                this.schoolUnitName = schoolUnitName;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getQrCodeImgUrl() {
                return qrCodeImgUrl;
            }

            public void setQrCodeImgUrl(String qrCodeImgUrl) {
                this.qrCodeImgUrl = qrCodeImgUrl;
            }

            public DataListBean() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.schoolUnitGUID);
                dest.writeString(this.repairBusinessGUID);
                dest.writeString(this.productGUID);
                dest.writeString(this.deviceBuyDate);
                dest.writeInt(this.deviceNotUseYears);
                dest.writeString(this.deviceMachineCode);
                dest.writeString(this.deviceIpAddress);
                dest.writeString(this.deviceAddress);
                dest.writeString(this.deviceMapX);
                dest.writeString(this.deviceMapY);
                dest.writeString(this.deviceRepairBeginDate);
                dest.writeString(this.deviceRepairEndDate);
                dest.writeInt(this.deviceType);
                dest.writeString(this.deviceSoftName);
                dest.writeString(this.deviceSoftBrand);
                dest.writeString(this.deviceSoftFramework);
                dest.writeString(this.deviceSoftType);
                dest.writeString(this.deviceSoftPlatform);
                dest.writeString(this.deviceSoftLanguage);
                dest.writeString(this.qrCodeGUID);
                dest.writeString(this.deviceRejectReason);
                dest.writeString(this.deviceRecordCode);
                dest.writeString(this.tenantId);
                dest.writeString(this.isDeleted);
                dest.writeString(this.createTime);
                dest.writeString(this.createGUID);
                dest.writeString(this.createdName);
                dest.writeString(this.modifiedTime);
                dest.writeString(this.modifiedGUID);
                dest.writeString(this.modifiedName);
                dest.writeString(this.approveState);
                dest.writeString(this.approveGUID);
                dest.writeString(this.approveTime);
                dest.writeString(this.deviceCode);
                dest.writeString(this.schoolUnitName);
                dest.writeString(this.productName);
                dest.writeString(this.qrCodeImgUrl);
                dest.writeByte(this.first ? (byte) 1 : (byte) 0);
                dest.writeByte(this.isModify ? (byte) 1 : (byte) 0);
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.schoolUnitGUID = in.readString();
                this.repairBusinessGUID = in.readString();
                this.productGUID = in.readString();
                this.deviceBuyDate = in.readString();
                this.deviceNotUseYears = in.readInt();
                this.deviceMachineCode = in.readString();
                this.deviceIpAddress = in.readString();
                this.deviceAddress = in.readString();
                this.deviceMapX = in.readString();
                this.deviceMapY = in.readString();
                this.deviceRepairBeginDate = in.readString();
                this.deviceRepairEndDate = in.readString();
                this.deviceType = in.readInt();
                this.deviceSoftName = in.readString();
                this.deviceSoftBrand = in.readString();
                this.deviceSoftFramework = in.readString();
                this.deviceSoftType = in.readString();
                this.deviceSoftPlatform = in.readString();
                this.deviceSoftLanguage = in.readString();
                this.qrCodeGUID = in.readString();
                this.deviceRejectReason = in.readString();
                this.deviceRecordCode = in.readString();
                this.tenantId = in.readString();
                this.isDeleted = in.readString();
                this.createTime = in.readString();
                this.createGUID = in.readString();
                this.createdName = in.readString();
                this.modifiedTime = in.readString();
                this.modifiedGUID = in.readString();
                this.modifiedName = in.readString();
                this.approveState = in.readString();
                this.approveGUID = in.readString();
                this.approveTime = in.readString();
                this.deviceCode = in.readString();
                this.schoolUnitName = in.readString();
                this.productName = in.readString();
                this.qrCodeImgUrl = in.readString();
                this.first = in.readByte() != 0;
                this.isModify = in.readByte() != 0;
            }

            public static final Creator<DataListBean> CREATOR = new Creator<DataListBean>() {
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.pageIndex);
            dest.writeInt(this.pageCount);
            dest.writeInt(this.pageSize);
            dest.writeInt(this.rowCount);
            dest.writeTypedList(this.dataList);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.pageIndex = in.readInt();
            this.pageCount = in.readInt();
            this.pageSize = in.readInt();
            this.rowCount = in.readInt();
            this.dataList = in.createTypedArrayList(DataListBean.CREATOR);
        }

        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel source) {
                return new ResultBean(source);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }
}
