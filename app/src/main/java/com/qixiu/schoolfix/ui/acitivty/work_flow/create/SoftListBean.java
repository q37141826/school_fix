package com.qixiu.schoolfix.ui.acitivty.work_flow.create;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/12/10.
 */

public class SoftListBean extends BaseBean<SoftListBean.ResultBean>{


    /**
     * dataList : [{"deviceSoftFrameworkStr":"CS","deviceSoftTypeStr":"多媒体","deviceSoftPlatformStr":"Liunx","deviceSoftLanguageStr":"英文","id":"560bd462-3bfd-4283-b568-08d659c84e19","schoolUnitGUID":"efb1dd4f-4851-4fb5-b69a-007d261deeeb","repairBusinessGUID":"bcdfdd35-f4a9-4fb1-cdc7-08d654d2ba9e","productGUID":"","deviceBuyDate":"","deviceNotUseYears":"","deviceMachineCode":"","deviceIpAddress":"","deviceAddress":"","deviceMapX":"","deviceMapY":"","deviceRepairBeginDate":"2018-12-17 00:00:00","deviceRepairEndDate":"2018-12-20 00:00:00","deviceType":1,"deviceSoftName":"12312","deviceSoftBrand":"123","deviceSoftFramework":2,"deviceSoftType":1,"deviceSoftPlatform":2,"deviceSoftLanguage":2,"qrCodeGUID":"","deviceRejectReason":"","deviceRecordCode":"2018120400007","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-04 17:10:15","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"已审批","approveGUID":"","approveTime":"","deviceCode":"20181204RJ00011","deviceIsScrap":0,"schoolUnitName":"上海市青浦区豫才中学","productName":"","qrCodeImgUrl":"","repairBusinessName":"qwer","repairBusinessTel":"23412341234","repairBusinessAddress":"qwer","warningOneMonthTime":"","warningTime":""},{"deviceSoftFrameworkStr":"BS","deviceSoftTypeStr":"多媒体","deviceSoftPlatformStr":"Windows","deviceSoftLanguageStr":"中文","id":"3277df85-4fb2-4370-8dee-08d659c04b80","schoolUnitGUID":"efb1dd4f-4851-4fb5-b69a-007d261deeeb","repairBusinessGUID":"3b792d38-32c3-466a-d032-08d657615ee1","productGUID":"","deviceBuyDate":"","deviceNotUseYears":"","deviceMachineCode":"","deviceIpAddress":"","deviceAddress":"","deviceMapX":"","deviceMapY":"","deviceRepairBeginDate":"2018-12-10 00:00:00","deviceRepairEndDate":"2018-12-28 00:00:00","deviceType":1,"deviceSoftName":"123","deviceSoftBrand":"12343","deviceSoftFramework":1,"deviceSoftType":1,"deviceSoftPlatform":1,"deviceSoftLanguage":1,"qrCodeGUID":"","deviceRejectReason":"123","deviceRecordCode":"2018120400005","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-04 16:12:55","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"已审批","approveGUID":"","approveTime":"","deviceCode":"20181204RJ00008","deviceIsScrap":0,"schoolUnitName":"上海市青浦区豫才中学","productName":"","qrCodeImgUrl":"","repairBusinessName":"djfklajslkdfj","repairBusinessTel":"12341","repairBusinessAddress":"413234","warningOneMonthTime":"","warningTime":""},{"deviceSoftFrameworkStr":"CS","deviceSoftTypeStr":"多媒体","deviceSoftPlatformStr":"Windows","deviceSoftLanguageStr":"中文","id":"a7fc3dee-b9d6-4300-8b5f-08d659b64dbb","schoolUnitGUID":"27cb5cb5-e5f1-4c99-a38c-00e14aab76ed","repairBusinessGUID":"ce009b2c-c3c5-4ad1-caab-08d65752eea3","productGUID":"","deviceBuyDate":"","deviceNotUseYears":"","deviceMachineCode":"","deviceIpAddress":"","deviceAddress":"","deviceMapX":"","deviceMapY":"","deviceRepairBeginDate":"2018-12-02 00:00:00","deviceRepairEndDate":"2018-12-21 00:00:00","deviceType":1,"deviceSoftName":"1","deviceSoftBrand":"2","deviceSoftFramework":2,"deviceSoftType":1,"deviceSoftPlatform":1,"deviceSoftLanguage":1,"qrCodeGUID":"","deviceRejectReason":"","deviceRecordCode":"","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-04 15:01:24","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"待审批","approveGUID":"","approveTime":"","deviceCode":"20181204RJ00007","deviceIsScrap":0,"schoolUnitName":"上海市青浦区朱家角幼儿园","productName":"","qrCodeImgUrl":"","repairBusinessName":"齐科售后","repairBusinessTel":"13428046523","repairBusinessAddress":"","warningOneMonthTime":"","warningTime":""},{"deviceSoftFrameworkStr":"CS","deviceSoftTypeStr":"多媒体","deviceSoftPlatformStr":"Windows","deviceSoftLanguageStr":"中文","id":"106bb7b9-e949-4985-480b-08d659b1629b","schoolUnitGUID":"b6acb676-171c-459a-8b3d-01dc3a528fab","repairBusinessGUID":"bcdfdd35-f4a9-4fb1-cdc7-08d654d2ba9e","productGUID":"","deviceBuyDate":"","deviceNotUseYears":"","deviceMachineCode":"","deviceIpAddress":"","deviceAddress":"","deviceMapX":"","deviceMapY":"","deviceRepairBeginDate":"2018-12-17 00:00:00","deviceRepairEndDate":"2018-12-28 00:00:00","deviceType":1,"deviceSoftName":"aa","deviceSoftBrand":"索芙特","deviceSoftFramework":2,"deviceSoftType":1,"deviceSoftPlatform":1,"deviceSoftLanguage":1,"qrCodeGUID":"","deviceRejectReason":"","deviceRecordCode":"2018120400004","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-04 14:26:11","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"已审批","approveGUID":"","approveTime":"","deviceCode":"20181204RJ00006","deviceIsScrap":0,"schoolUnitName":"上海市青浦区金泽幼儿园","productName":"","qrCodeImgUrl":"","repairBusinessName":"qwer","repairBusinessTel":"23412341234","repairBusinessAddress":"qwer","warningOneMonthTime":"","warningTime":""}]
     * pageIndex : 1
     * pageCount : 1
     * pageSize : 1000
     * rowCount : 4
     */

    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * deviceSoftFrameworkStr : CS
         * deviceSoftTypeStr : 多媒体
         * deviceSoftPlatformStr : Liunx
         * deviceSoftLanguageStr : 英文
         * id : 560bd462-3bfd-4283-b568-08d659c84e19
         * schoolUnitGUID : efb1dd4f-4851-4fb5-b69a-007d261deeeb
         * repairBusinessGUID : bcdfdd35-f4a9-4fb1-cdc7-08d654d2ba9e
         * productGUID :
         * deviceBuyDate :
         * deviceNotUseYears :
         * deviceMachineCode :
         * deviceIpAddress :
         * deviceAddress :
         * deviceMapX :
         * deviceMapY :
         * deviceRepairBeginDate : 2018-12-17 00:00:00
         * deviceRepairEndDate : 2018-12-20 00:00:00
         * deviceType : 1
         * deviceSoftName : 12312
         * deviceSoftBrand : 123
         * deviceSoftFramework : 2
         * deviceSoftType : 1
         * deviceSoftPlatform : 2
         * deviceSoftLanguage : 2
         * qrCodeGUID :
         * deviceRejectReason :
         * deviceRecordCode : 2018120400007
         * tenantId : 9936f0b1-6953-4037-802a-297f728a97a4
         * isDeleted : 0
         * createTime : 2018-12-04 17:10:15
         * createGUID : 552b20d2-73e3-4052-8d73-08d647b3429b
         * createdName : yudm
         * modifiedTime :
         * modifiedGUID : 552b20d2-73e3-4052-8d73-08d647b3429b
         * modifiedName : yudm
         * approveState : 已审批
         * approveGUID :
         * approveTime :
         * deviceCode : 20181204RJ00011
         * deviceIsScrap : 0
         * schoolUnitName : 上海市青浦区豫才中学
         * productName :
         * qrCodeImgUrl :
         * repairBusinessName : qwer
         * repairBusinessTel : 23412341234
         * repairBusinessAddress : qwer
         * warningOneMonthTime :
         * warningTime :
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


            private String deviceSoftFrameworkStr;
            private String deviceSoftTypeStr;
            private String deviceSoftPlatformStr;
            private String deviceSoftLanguageStr;
            private String id;
            private String schoolUnitGUID;
            private String repairBusinessGUID;
            private String productGUID;
            private String deviceBuyDate;
            private String deviceNotUseYears;
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
            private int deviceSoftFramework;
            private int deviceSoftType;
            private int deviceSoftPlatform;
            private int deviceSoftLanguage;
            private String qrCodeGUID;
            private String deviceRejectReason;
            private String deviceRecordCode;
            private String tenantId;
            private int isDeleted;
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
            private int deviceIsScrap;
            private String schoolUnitName;
            private String productName;
            private String qrCodeImgUrl;
            private String repairBusinessName;
            private String repairBusinessTel;
            private String repairBusinessAddress;
            private String warningOneMonthTime;
            private String warningTime;

            public String getDeviceSoftFrameworkStr() {
                return deviceSoftFrameworkStr;
            }

            public void setDeviceSoftFrameworkStr(String deviceSoftFrameworkStr) {
                this.deviceSoftFrameworkStr = deviceSoftFrameworkStr;
            }

            public String getDeviceSoftTypeStr() {
                return deviceSoftTypeStr;
            }

            public void setDeviceSoftTypeStr(String deviceSoftTypeStr) {
                this.deviceSoftTypeStr = deviceSoftTypeStr;
            }

            public String getDeviceSoftPlatformStr() {
                return deviceSoftPlatformStr;
            }

            public void setDeviceSoftPlatformStr(String deviceSoftPlatformStr) {
                this.deviceSoftPlatformStr = deviceSoftPlatformStr;
            }

            public String getDeviceSoftLanguageStr() {
                return deviceSoftLanguageStr;
            }

            public void setDeviceSoftLanguageStr(String deviceSoftLanguageStr) {
                this.deviceSoftLanguageStr = deviceSoftLanguageStr;
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

            public String getDeviceNotUseYears() {
                return deviceNotUseYears;
            }

            public void setDeviceNotUseYears(String deviceNotUseYears) {
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

            public int getDeviceSoftFramework() {
                return deviceSoftFramework;
            }

            public void setDeviceSoftFramework(int deviceSoftFramework) {
                this.deviceSoftFramework = deviceSoftFramework;
            }

            public int getDeviceSoftType() {
                return deviceSoftType;
            }

            public void setDeviceSoftType(int deviceSoftType) {
                this.deviceSoftType = deviceSoftType;
            }

            public int getDeviceSoftPlatform() {
                return deviceSoftPlatform;
            }

            public void setDeviceSoftPlatform(int deviceSoftPlatform) {
                this.deviceSoftPlatform = deviceSoftPlatform;
            }

            public int getDeviceSoftLanguage() {
                return deviceSoftLanguage;
            }

            public void setDeviceSoftLanguage(int deviceSoftLanguage) {
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

            public int getIsDeleted() {
                return isDeleted;
            }

            public void setIsDeleted(int isDeleted) {
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

            public int getDeviceIsScrap() {
                return deviceIsScrap;
            }

            public void setDeviceIsScrap(int deviceIsScrap) {
                this.deviceIsScrap = deviceIsScrap;
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

            public String getRepairBusinessName() {
                return repairBusinessName;
            }

            public void setRepairBusinessName(String repairBusinessName) {
                this.repairBusinessName = repairBusinessName;
            }

            public String getRepairBusinessTel() {
                return repairBusinessTel;
            }

            public void setRepairBusinessTel(String repairBusinessTel) {
                this.repairBusinessTel = repairBusinessTel;
            }

            public String getRepairBusinessAddress() {
                return repairBusinessAddress;
            }

            public void setRepairBusinessAddress(String repairBusinessAddress) {
                this.repairBusinessAddress = repairBusinessAddress;
            }

            public String getWarningOneMonthTime() {
                return warningOneMonthTime;
            }

            public void setWarningOneMonthTime(String warningOneMonthTime) {
                this.warningOneMonthTime = warningOneMonthTime;
            }

            public String getWarningTime() {
                return warningTime;
            }

            public void setWarningTime(String warningTime) {
                this.warningTime = warningTime;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.deviceSoftFrameworkStr);
                dest.writeString(this.deviceSoftTypeStr);
                dest.writeString(this.deviceSoftPlatformStr);
                dest.writeString(this.deviceSoftLanguageStr);
                dest.writeString(this.id);
                dest.writeString(this.schoolUnitGUID);
                dest.writeString(this.repairBusinessGUID);
                dest.writeString(this.productGUID);
                dest.writeString(this.deviceBuyDate);
                dest.writeString(this.deviceNotUseYears);
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
                dest.writeInt(this.deviceSoftFramework);
                dest.writeInt(this.deviceSoftType);
                dest.writeInt(this.deviceSoftPlatform);
                dest.writeInt(this.deviceSoftLanguage);
                dest.writeString(this.qrCodeGUID);
                dest.writeString(this.deviceRejectReason);
                dest.writeString(this.deviceRecordCode);
                dest.writeString(this.tenantId);
                dest.writeInt(this.isDeleted);
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
                dest.writeInt(this.deviceIsScrap);
                dest.writeString(this.schoolUnitName);
                dest.writeString(this.productName);
                dest.writeString(this.qrCodeImgUrl);
                dest.writeString(this.repairBusinessName);
                dest.writeString(this.repairBusinessTel);
                dest.writeString(this.repairBusinessAddress);
                dest.writeString(this.warningOneMonthTime);
                dest.writeString(this.warningTime);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.deviceSoftFrameworkStr = in.readString();
                this.deviceSoftTypeStr = in.readString();
                this.deviceSoftPlatformStr = in.readString();
                this.deviceSoftLanguageStr = in.readString();
                this.id = in.readString();
                this.schoolUnitGUID = in.readString();
                this.repairBusinessGUID = in.readString();
                this.productGUID = in.readString();
                this.deviceBuyDate = in.readString();
                this.deviceNotUseYears = in.readString();
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
                this.deviceSoftFramework = in.readInt();
                this.deviceSoftType = in.readInt();
                this.deviceSoftPlatform = in.readInt();
                this.deviceSoftLanguage = in.readInt();
                this.qrCodeGUID = in.readString();
                this.deviceRejectReason = in.readString();
                this.deviceRecordCode = in.readString();
                this.tenantId = in.readString();
                this.isDeleted = in.readInt();
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
                this.deviceIsScrap = in.readInt();
                this.schoolUnitName = in.readString();
                this.productName = in.readString();
                this.qrCodeImgUrl = in.readString();
                this.repairBusinessName = in.readString();
                this.repairBusinessTel = in.readString();
                this.repairBusinessAddress = in.readString();
                this.warningOneMonthTime = in.readString();
                this.warningTime = in.readString();
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
