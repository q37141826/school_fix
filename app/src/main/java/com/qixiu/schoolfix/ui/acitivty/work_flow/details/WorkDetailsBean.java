package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2018/11/26.
 */

public class WorkDetailsBean extends BaseBean<WorkDetailsBean.ResultBean> {


    public static class ResultBean implements Parcelable {

        private String eduAappWorkOrderType;
        private String workOrderTypeStr;
        private String id;
        private String deviceGUID;
        private String repairUserGUID;
        private String serviceUserGUID;
        private String workOrderSubmitName;
        private String workOrderSubmitUnit;
        private String workOrderSubmitTel;
        private int workOrderType;
        private String workOrderServiceNo;
        private String workOrderExpectTime;
        private String workOrderCstProblemRemark;
        private String workOrderProblemMP3Url;
        private String workOrderMP3;
        private String workOrderCstProblemImgUrl;
        private String workOrderGoTime;
        private String workOrderGoAddress;
        private String workOrderSignInTime;
        private String workOrderSignInAddress;
        private String workOrderSignOutTime;
        private String workOrderSignOutAddress;
        private String workOrderErrorImgUrls;
        private String workOrderUserSignImgUrl;
        private String qrCodeGUID;
        private String workOrderCreatime;
        private String workOrderReceiveTime;
        private String workOrderAssignTime;
        private String destroyUserGUID;
        private String workOrderCancleReason;
        private String workOrderDestroyTime;
        private String cstProductProblemGUIDs;
        private String repairProductProblemGUIDs;
        private String productProblemSolutionGUID;
        private String workOrderRepairSolutionRemark;
        private String workOrderRepairProblemRemark;
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
        private String workOrderSubmitId;
        private String workOrderFinishTime;
        private String workOrderSubmitAddress;
        private int workOrderRepairIsConfirmFinish;
        private String workOrderExpectEndTime;
        private String repairUseTime;
        private String productTypeName;
        private String productGUID;
        private String productName;
        private String productModel;
        private String productBrand;
        private String productImgUrl;
        private String deviceMachineCode;
        private String deviceRecordCode;
        private String deviceAddress;
        private int deviceType;
        private String deviceCode;
        private String deviceSoftName;
        private String deviceSoftBrand;
        private String repairBusinessGUID;
        private String repairBusinessName;
        private String repairBusinessTel;
        private String repairBusinessContacts;
        private String repairBusinessAddress;
        private String schoolUnitMaster;
        private String schoolUnitAddress;
        private String schoolUnitName;
        private String schoolUnitGUID;
        private String schoolUnitArea;
        private String schoolUnitServiceName;
        private String schoolUnitTypeName;
        private String repairUserName;
        private String workOrderComentType;
        private String orderDateDiff;
        private String qrCodeImgUrl;
        /**
         * productProblemRemark : 重启
         * productProblemPriorityStr : 高
         */

        private List<RepairSolutionsBean> repairSolutions;

        public String getEduAappWorkOrderType() {
            return eduAappWorkOrderType;
        }

        public void setEduAappWorkOrderType(String eduAappWorkOrderType) {
            this.eduAappWorkOrderType = eduAappWorkOrderType;
        }

        public String getWorkOrderTypeStr() {
            return workOrderTypeStr;
        }

        public void setWorkOrderTypeStr(String workOrderTypeStr) {
            this.workOrderTypeStr = workOrderTypeStr;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDeviceGUID() {
            return deviceGUID;
        }

        public void setDeviceGUID(String deviceGUID) {
            this.deviceGUID = deviceGUID;
        }

        public String getRepairUserGUID() {
            return repairUserGUID;
        }

        public void setRepairUserGUID(String repairUserGUID) {
            this.repairUserGUID = repairUserGUID;
        }

        public String getServiceUserGUID() {
            return serviceUserGUID;
        }

        public void setServiceUserGUID(String serviceUserGUID) {
            this.serviceUserGUID = serviceUserGUID;
        }

        public String getWorkOrderSubmitName() {
            return workOrderSubmitName;
        }

        public void setWorkOrderSubmitName(String workOrderSubmitName) {
            this.workOrderSubmitName = workOrderSubmitName;
        }

        public String getWorkOrderSubmitUnit() {
            return workOrderSubmitUnit;
        }

        public void setWorkOrderSubmitUnit(String workOrderSubmitUnit) {
            this.workOrderSubmitUnit = workOrderSubmitUnit;
        }

        public String getWorkOrderSubmitTel() {
            return workOrderSubmitTel;
        }

        public void setWorkOrderSubmitTel(String workOrderSubmitTel) {
            this.workOrderSubmitTel = workOrderSubmitTel;
        }

        public int getWorkOrderType() {
            return workOrderType;
        }

        public void setWorkOrderType(int workOrderType) {
            this.workOrderType = workOrderType;
        }

        public String getWorkOrderServiceNo() {
            return workOrderServiceNo;
        }

        public void setWorkOrderServiceNo(String workOrderServiceNo) {
            this.workOrderServiceNo = workOrderServiceNo;
        }

        public String getWorkOrderExpectTime() {
            return workOrderExpectTime;
        }

        public void setWorkOrderExpectTime(String workOrderExpectTime) {
            this.workOrderExpectTime = workOrderExpectTime;
        }

        public String getWorkOrderCstProblemRemark() {
            return workOrderCstProblemRemark;
        }

        public void setWorkOrderCstProblemRemark(String workOrderCstProblemRemark) {
            this.workOrderCstProblemRemark = workOrderCstProblemRemark;
        }

        public String getWorkOrderProblemMP3Url() {
            return workOrderProblemMP3Url;
        }

        public void setWorkOrderProblemMP3Url(String workOrderProblemMP3Url) {
            this.workOrderProblemMP3Url = workOrderProblemMP3Url;
        }

        public String getWorkOrderMP3() {
            return workOrderMP3;
        }

        public void setWorkOrderMP3(String workOrderMP3) {
            this.workOrderMP3 = workOrderMP3;
        }

        public String getWorkOrderCstProblemImgUrl() {
            return workOrderCstProblemImgUrl;
        }

        public void setWorkOrderCstProblemImgUrl(String workOrderCstProblemImgUrl) {
            this.workOrderCstProblemImgUrl = workOrderCstProblemImgUrl;
        }

        public String getWorkOrderGoTime() {
            return workOrderGoTime;
        }

        public void setWorkOrderGoTime(String workOrderGoTime) {
            this.workOrderGoTime = workOrderGoTime;
        }

        public String getWorkOrderGoAddress() {
            return workOrderGoAddress;
        }

        public void setWorkOrderGoAddress(String workOrderGoAddress) {
            this.workOrderGoAddress = workOrderGoAddress;
        }

        public String getWorkOrderSignInTime() {
            return workOrderSignInTime;
        }

        public void setWorkOrderSignInTime(String workOrderSignInTime) {
            this.workOrderSignInTime = workOrderSignInTime;
        }

        public String getWorkOrderSignInAddress() {
            return workOrderSignInAddress;
        }

        public void setWorkOrderSignInAddress(String workOrderSignInAddress) {
            this.workOrderSignInAddress = workOrderSignInAddress;
        }

        public String getWorkOrderSignOutTime() {
            return workOrderSignOutTime;
        }

        public void setWorkOrderSignOutTime(String workOrderSignOutTime) {
            this.workOrderSignOutTime = workOrderSignOutTime;
        }

        public String getWorkOrderSignOutAddress() {
            return workOrderSignOutAddress;
        }

        public void setWorkOrderSignOutAddress(String workOrderSignOutAddress) {
            this.workOrderSignOutAddress = workOrderSignOutAddress;
        }

        public String getWorkOrderErrorImgUrls() {
            return workOrderErrorImgUrls;
        }

        public void setWorkOrderErrorImgUrls(String workOrderErrorImgUrls) {
            this.workOrderErrorImgUrls = workOrderErrorImgUrls;
        }

        public String getWorkOrderUserSignImgUrl() {
            return workOrderUserSignImgUrl;
        }

        public void setWorkOrderUserSignImgUrl(String workOrderUserSignImgUrl) {
            this.workOrderUserSignImgUrl = workOrderUserSignImgUrl;
        }

        public String getQrCodeGUID() {
            return qrCodeGUID;
        }

        public void setQrCodeGUID(String qrCodeGUID) {
            this.qrCodeGUID = qrCodeGUID;
        }

        public String getWorkOrderCreatime() {
            return workOrderCreatime;
        }

        public void setWorkOrderCreatime(String workOrderCreatime) {
            this.workOrderCreatime = workOrderCreatime;
        }

        public String getWorkOrderReceiveTime() {
            return workOrderReceiveTime;
        }

        public void setWorkOrderReceiveTime(String workOrderReceiveTime) {
            this.workOrderReceiveTime = workOrderReceiveTime;
        }

        public String getWorkOrderAssignTime() {
            return workOrderAssignTime;
        }

        public void setWorkOrderAssignTime(String workOrderAssignTime) {
            this.workOrderAssignTime = workOrderAssignTime;
        }

        public String getDestroyUserGUID() {
            return destroyUserGUID;
        }

        public void setDestroyUserGUID(String destroyUserGUID) {
            this.destroyUserGUID = destroyUserGUID;
        }

        public String getWorkOrderCancleReason() {
            return workOrderCancleReason;
        }

        public void setWorkOrderCancleReason(String workOrderCancleReason) {
            this.workOrderCancleReason = workOrderCancleReason;
        }

        public String getWorkOrderDestroyTime() {
            return workOrderDestroyTime;
        }

        public void setWorkOrderDestroyTime(String workOrderDestroyTime) {
            this.workOrderDestroyTime = workOrderDestroyTime;
        }

        public String getCstProductProblemGUIDs() {
            return cstProductProblemGUIDs;
        }

        public void setCstProductProblemGUIDs(String cstProductProblemGUIDs) {
            this.cstProductProblemGUIDs = cstProductProblemGUIDs;
        }

        public String getRepairProductProblemGUIDs() {
            return repairProductProblemGUIDs;
        }

        public void setRepairProductProblemGUIDs(String repairProductProblemGUIDs) {
            this.repairProductProblemGUIDs = repairProductProblemGUIDs;
        }

        public String getProductProblemSolutionGUID() {
            return productProblemSolutionGUID;
        }

        public void setProductProblemSolutionGUID(String productProblemSolutionGUID) {
            this.productProblemSolutionGUID = productProblemSolutionGUID;
        }

        public String getWorkOrderRepairSolutionRemark() {
            return workOrderRepairSolutionRemark;
        }

        public void setWorkOrderRepairSolutionRemark(String workOrderRepairSolutionRemark) {
            this.workOrderRepairSolutionRemark = workOrderRepairSolutionRemark;
        }

        public String getWorkOrderRepairProblemRemark() {
            return workOrderRepairProblemRemark;
        }

        public void setWorkOrderRepairProblemRemark(String workOrderRepairProblemRemark) {
            this.workOrderRepairProblemRemark = workOrderRepairProblemRemark;
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

        public String getWorkOrderSubmitId() {
            return workOrderSubmitId;
        }

        public void setWorkOrderSubmitId(String workOrderSubmitId) {
            this.workOrderSubmitId = workOrderSubmitId;
        }

        public String getWorkOrderFinishTime() {
            return workOrderFinishTime;
        }

        public void setWorkOrderFinishTime(String workOrderFinishTime) {
            this.workOrderFinishTime = workOrderFinishTime;
        }

        public String getWorkOrderSubmitAddress() {
            return workOrderSubmitAddress;
        }

        public void setWorkOrderSubmitAddress(String workOrderSubmitAddress) {
            this.workOrderSubmitAddress = workOrderSubmitAddress;
        }

        public int getWorkOrderRepairIsConfirmFinish() {
            return workOrderRepairIsConfirmFinish;
        }

        public void setWorkOrderRepairIsConfirmFinish(int workOrderRepairIsConfirmFinish) {
            this.workOrderRepairIsConfirmFinish = workOrderRepairIsConfirmFinish;
        }

        public String getWorkOrderExpectEndTime() {
            return workOrderExpectEndTime;
        }

        public void setWorkOrderExpectEndTime(String workOrderExpectEndTime) {
            this.workOrderExpectEndTime = workOrderExpectEndTime;
        }

        public String getRepairUseTime() {
            return repairUseTime;
        }

        public void setRepairUseTime(String repairUseTime) {
            this.repairUseTime = repairUseTime;
        }

        public String getProductTypeName() {
            return productTypeName;
        }

        public void setProductTypeName(String productTypeName) {
            this.productTypeName = productTypeName;
        }

        public String getProductGUID() {
            return productGUID;
        }

        public void setProductGUID(String productGUID) {
            this.productGUID = productGUID;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductModel() {
            return productModel;
        }

        public void setProductModel(String productModel) {
            this.productModel = productModel;
        }

        public String getProductBrand() {
            return productBrand;
        }

        public void setProductBrand(String productBrand) {
            this.productBrand = productBrand;
        }

        public String getProductImgUrl() {
            return productImgUrl;
        }

        public void setProductImgUrl(String productImgUrl) {
            this.productImgUrl = productImgUrl;
        }

        public String getDeviceMachineCode() {
            return deviceMachineCode;
        }

        public void setDeviceMachineCode(String deviceMachineCode) {
            this.deviceMachineCode = deviceMachineCode;
        }

        public String getDeviceRecordCode() {
            return deviceRecordCode;
        }

        public void setDeviceRecordCode(String deviceRecordCode) {
            this.deviceRecordCode = deviceRecordCode;
        }

        public String getDeviceAddress() {
            return deviceAddress;
        }

        public void setDeviceAddress(String deviceAddress) {
            this.deviceAddress = deviceAddress;
        }

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceCode() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode = deviceCode;
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

        public String getRepairBusinessGUID() {
            return repairBusinessGUID;
        }

        public void setRepairBusinessGUID(String repairBusinessGUID) {
            this.repairBusinessGUID = repairBusinessGUID;
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

        public String getRepairBusinessContacts() {
            return repairBusinessContacts;
        }

        public void setRepairBusinessContacts(String repairBusinessContacts) {
            this.repairBusinessContacts = repairBusinessContacts;
        }

        public String getRepairBusinessAddress() {
            return repairBusinessAddress;
        }

        public void setRepairBusinessAddress(String repairBusinessAddress) {
            this.repairBusinessAddress = repairBusinessAddress;
        }

        public String getSchoolUnitMaster() {
            return schoolUnitMaster;
        }

        public void setSchoolUnitMaster(String schoolUnitMaster) {
            this.schoolUnitMaster = schoolUnitMaster;
        }

        public String getSchoolUnitAddress() {
            return schoolUnitAddress;
        }

        public void setSchoolUnitAddress(String schoolUnitAddress) {
            this.schoolUnitAddress = schoolUnitAddress;
        }

        public String getSchoolUnitName() {
            return schoolUnitName;
        }

        public void setSchoolUnitName(String schoolUnitName) {
            this.schoolUnitName = schoolUnitName;
        }

        public String getSchoolUnitGUID() {
            return schoolUnitGUID;
        }

        public void setSchoolUnitGUID(String schoolUnitGUID) {
            this.schoolUnitGUID = schoolUnitGUID;
        }

        public String getSchoolUnitArea() {
            return schoolUnitArea;
        }

        public void setSchoolUnitArea(String schoolUnitArea) {
            this.schoolUnitArea = schoolUnitArea;
        }

        public String getSchoolUnitServiceName() {
            return schoolUnitServiceName;
        }

        public void setSchoolUnitServiceName(String schoolUnitServiceName) {
            this.schoolUnitServiceName = schoolUnitServiceName;
        }

        public String getSchoolUnitTypeName() {
            return schoolUnitTypeName;
        }

        public void setSchoolUnitTypeName(String schoolUnitTypeName) {
            this.schoolUnitTypeName = schoolUnitTypeName;
        }

        public String getRepairUserName() {
            return repairUserName;
        }

        public void setRepairUserName(String repairUserName) {
            this.repairUserName = repairUserName;
        }

        public String getWorkOrderComentType() {
            return workOrderComentType;
        }

        public void setWorkOrderComentType(String workOrderComentType) {
            this.workOrderComentType = workOrderComentType;
        }

        public String getOrderDateDiff() {
            return orderDateDiff;
        }

        public void setOrderDateDiff(String orderDateDiff) {
            this.orderDateDiff = orderDateDiff;
        }

        public String getQrCodeImgUrl() {
            return qrCodeImgUrl;
        }

        public void setQrCodeImgUrl(String qrCodeImgUrl) {
            this.qrCodeImgUrl = qrCodeImgUrl;
        }

        public List<RepairSolutionsBean> getRepairSolutions() {
            return repairSolutions;
        }

        public void setRepairSolutions(List<RepairSolutionsBean> repairSolutions) {
            this.repairSolutions = repairSolutions;
        }

        public static class RepairSolutionsBean implements Parcelable {


            private String productProblemRemark;
            private String productProblemPriorityStr;

            public String getProductProblemRemark() {
                return productProblemRemark;
            }

            public void setProductProblemRemark(String productProblemRemark) {
                this.productProblemRemark = productProblemRemark;
            }

            public String getProductProblemPriorityStr() {
                return productProblemPriorityStr;
            }

            public void setProductProblemPriorityStr(String productProblemPriorityStr) {
                this.productProblemPriorityStr = productProblemPriorityStr;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.productProblemRemark);
                dest.writeString(this.productProblemPriorityStr);
            }

            public RepairSolutionsBean() {
            }

            protected RepairSolutionsBean(Parcel in) {
                this.productProblemRemark = in.readString();
                this.productProblemPriorityStr = in.readString();
            }

            public static final Creator<RepairSolutionsBean> CREATOR = new Creator<RepairSolutionsBean>() {
                @Override
                public RepairSolutionsBean createFromParcel(Parcel source) {
                    return new RepairSolutionsBean(source);
                }

                @Override
                public RepairSolutionsBean[] newArray(int size) {
                    return new RepairSolutionsBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.eduAappWorkOrderType);
            dest.writeString(this.workOrderTypeStr);
            dest.writeString(this.id);
            dest.writeString(this.deviceGUID);
            dest.writeString(this.repairUserGUID);
            dest.writeString(this.serviceUserGUID);
            dest.writeString(this.workOrderSubmitName);
            dest.writeString(this.workOrderSubmitUnit);
            dest.writeString(this.workOrderSubmitTel);
            dest.writeInt(this.workOrderType);
            dest.writeString(this.workOrderServiceNo);
            dest.writeString(this.workOrderExpectTime);
            dest.writeString(this.workOrderCstProblemRemark);
            dest.writeString(this.workOrderProblemMP3Url);
            dest.writeString(this.workOrderMP3);
            dest.writeString(this.workOrderCstProblemImgUrl);
            dest.writeString(this.workOrderGoTime);
            dest.writeString(this.workOrderGoAddress);
            dest.writeString(this.workOrderSignInTime);
            dest.writeString(this.workOrderSignInAddress);
            dest.writeString(this.workOrderSignOutTime);
            dest.writeString(this.workOrderSignOutAddress);
            dest.writeString(this.workOrderErrorImgUrls);
            dest.writeString(this.workOrderUserSignImgUrl);
            dest.writeString(this.qrCodeGUID);
            dest.writeString(this.workOrderCreatime);
            dest.writeString(this.workOrderReceiveTime);
            dest.writeString(this.workOrderAssignTime);
            dest.writeString(this.destroyUserGUID);
            dest.writeString(this.workOrderCancleReason);
            dest.writeString(this.workOrderDestroyTime);
            dest.writeString(this.cstProductProblemGUIDs);
            dest.writeString(this.repairProductProblemGUIDs);
            dest.writeString(this.productProblemSolutionGUID);
            dest.writeString(this.workOrderRepairSolutionRemark);
            dest.writeString(this.workOrderRepairProblemRemark);
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
            dest.writeString(this.workOrderSubmitId);
            dest.writeString(this.workOrderFinishTime);
            dest.writeString(this.workOrderSubmitAddress);
            dest.writeInt(this.workOrderRepairIsConfirmFinish);
            dest.writeString(this.workOrderExpectEndTime);
            dest.writeString(this.repairUseTime);
            dest.writeString(this.productTypeName);
            dest.writeString(this.productGUID);
            dest.writeString(this.productName);
            dest.writeString(this.productModel);
            dest.writeString(this.productBrand);
            dest.writeString(this.productImgUrl);
            dest.writeString(this.deviceMachineCode);
            dest.writeString(this.deviceRecordCode);
            dest.writeString(this.deviceAddress);
            dest.writeInt(this.deviceType);
            dest.writeString(this.deviceCode);
            dest.writeString(this.deviceSoftName);
            dest.writeString(this.deviceSoftBrand);
            dest.writeString(this.repairBusinessGUID);
            dest.writeString(this.repairBusinessName);
            dest.writeString(this.repairBusinessTel);
            dest.writeString(this.repairBusinessContacts);
            dest.writeString(this.repairBusinessAddress);
            dest.writeString(this.schoolUnitMaster);
            dest.writeString(this.schoolUnitAddress);
            dest.writeString(this.schoolUnitName);
            dest.writeString(this.schoolUnitGUID);
            dest.writeString(this.schoolUnitArea);
            dest.writeString(this.schoolUnitServiceName);
            dest.writeString(this.schoolUnitTypeName);
            dest.writeString(this.repairUserName);
            dest.writeString(this.workOrderComentType);
            dest.writeString(this.orderDateDiff);
            dest.writeString(this.qrCodeImgUrl);
            dest.writeList(this.repairSolutions);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.eduAappWorkOrderType = in.readString();
            this.workOrderTypeStr = in.readString();
            this.id = in.readString();
            this.deviceGUID = in.readString();
            this.repairUserGUID = in.readString();
            this.serviceUserGUID = in.readString();
            this.workOrderSubmitName = in.readString();
            this.workOrderSubmitUnit = in.readString();
            this.workOrderSubmitTel = in.readString();
            this.workOrderType = in.readInt();
            this.workOrderServiceNo = in.readString();
            this.workOrderExpectTime = in.readString();
            this.workOrderCstProblemRemark = in.readString();
            this.workOrderProblemMP3Url = in.readString();
            this.workOrderMP3 = in.readString();
            this.workOrderCstProblemImgUrl = in.readString();
            this.workOrderGoTime = in.readString();
            this.workOrderGoAddress = in.readString();
            this.workOrderSignInTime = in.readString();
            this.workOrderSignInAddress = in.readString();
            this.workOrderSignOutTime = in.readString();
            this.workOrderSignOutAddress = in.readString();
            this.workOrderErrorImgUrls = in.readString();
            this.workOrderUserSignImgUrl = in.readString();
            this.qrCodeGUID = in.readString();
            this.workOrderCreatime = in.readString();
            this.workOrderReceiveTime = in.readString();
            this.workOrderAssignTime = in.readString();
            this.destroyUserGUID = in.readString();
            this.workOrderCancleReason = in.readString();
            this.workOrderDestroyTime = in.readString();
            this.cstProductProblemGUIDs = in.readString();
            this.repairProductProblemGUIDs = in.readString();
            this.productProblemSolutionGUID = in.readString();
            this.workOrderRepairSolutionRemark = in.readString();
            this.workOrderRepairProblemRemark = in.readString();
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
            this.workOrderSubmitId = in.readString();
            this.workOrderFinishTime = in.readString();
            this.workOrderSubmitAddress = in.readString();
            this.workOrderRepairIsConfirmFinish = in.readInt();
            this.workOrderExpectEndTime = in.readString();
            this.repairUseTime = in.readString();
            this.productTypeName = in.readString();
            this.productGUID = in.readString();
            this.productName = in.readString();
            this.productModel = in.readString();
            this.productBrand = in.readString();
            this.productImgUrl = in.readString();
            this.deviceMachineCode = in.readString();
            this.deviceRecordCode = in.readString();
            this.deviceAddress = in.readString();
            this.deviceType = in.readInt();
            this.deviceCode = in.readString();
            this.deviceSoftName = in.readString();
            this.deviceSoftBrand = in.readString();
            this.repairBusinessGUID = in.readString();
            this.repairBusinessName = in.readString();
            this.repairBusinessTel = in.readString();
            this.repairBusinessContacts = in.readString();
            this.repairBusinessAddress = in.readString();
            this.schoolUnitMaster = in.readString();
            this.schoolUnitAddress = in.readString();
            this.schoolUnitName = in.readString();
            this.schoolUnitGUID = in.readString();
            this.schoolUnitArea = in.readString();
            this.schoolUnitServiceName = in.readString();
            this.schoolUnitTypeName = in.readString();
            this.repairUserName = in.readString();
            this.workOrderComentType = in.readString();
            this.orderDateDiff = in.readString();
            this.qrCodeImgUrl = in.readString();
            this.repairSolutions = new ArrayList<RepairSolutionsBean>();
            in.readList(this.repairSolutions, RepairSolutionsBean.class.getClassLoader());
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
