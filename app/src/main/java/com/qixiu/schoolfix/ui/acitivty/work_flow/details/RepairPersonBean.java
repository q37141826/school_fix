package com.qixiu.schoolfix.ui.acitivty.work_flow.details;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/11/29.
 */

public class RepairPersonBean extends BaseBean<RepairPersonBean.ResultBean>{


    /**
     * dataList : [{"id":"552b20d2-73e3-4052-8d73-08d647b3429b","userCode":"yudm","userName":"yudm","buguid":"","email":"yudm@163.com","password":"4QrcOUm6Wau+VuBX8g+IPg==","officePhone":"23121","mobilePhone":"","homePhone":"","adAccount":"","isDisabeld":0,"disabledReason":"","isAdmin":"","jobNumber":"","defaultStation":"","pswModifyTime":"","isUserChangePWD":"","isLocked":"","lockTime":"","position":"","isFormalEstablishment":"","lastIpAdress":"","imageGUID":"","srcImageGUID":"","loginErrorCount":"","lastLoginErrorTime":"","passwordModifyTime":"","loginTime":"","userType":"","repairBusinessGUID":"9936f0b1-6953-4037-802a-297f728a97a4","tenantId":"","isDeleted":"","createTime":"2018-11-11 16:54:16","createGUID":"","createdName":"","modifiedTime":"2018-11-27 17:26:11","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":"","isMainAccountUser":0,"userQualification":"","repairBusinessName":"深圳NIZ供应商","repairBusinessTel":"13222222222","repairBusinessAddress":"深圳市宝安区","buName":""},{"id":"e9761c30-52d0-4f44-8ad5-1a74f977bc6b","userCode":"wxy","userName":"维修员01","buguid":"9936f0b1-6953-4037-802a-297f728a97a4","email":"www.1111111111@qq.com","password":"4QrcOUm6Wau+VuBX8g+IPg==","officePhone":"13211111111","mobilePhone":"13211111111","homePhone":"13211111111","adAccount":"","isDisabeld":0,"disabledReason":"","isAdmin":"","jobNumber":"","defaultStation":"","pswModifyTime":"","isUserChangePWD":"","isLocked":"","lockTime":"","position":"","isFormalEstablishment":"","lastIpAdress":"","imageGUID":"","srcImageGUID":"","loginErrorCount":"","lastLoginErrorTime":"","passwordModifyTime":"","loginTime":"","userType":2,"repairBusinessGUID":"9936f0b1-6953-4037-802a-297f728a97a4","tenantId":"","isDeleted":0,"createTime":"2018-11-20 15:11:20","createGUID":"","createdName":"","modifiedTime":"2018-11-28 10:18:09","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":"2018-11-20 15:11:20","isMainAccountUser":0,"userQualification":"","repairBusinessName":"深圳NIZ供应商","repairBusinessTel":"13222222222","repairBusinessAddress":"深圳市宝安区","buName":""}]
     * pageIndex : 1
     * pageCount : 1
     * pageSize : 1000
     * rowCount : 2
     */



    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : 552b20d2-73e3-4052-8d73-08d647b3429b
         * userCode : yudm
         * userName : yudm
         * buguid :
         * email : yudm@163.com
         * password : 4QrcOUm6Wau+VuBX8g+IPg==
         * officePhone : 23121
         * mobilePhone :
         * homePhone :
         * adAccount :
         * isDisabeld : 0
         * disabledReason :
         * isAdmin :
         * jobNumber :
         * defaultStation :
         * pswModifyTime :
         * isUserChangePWD :
         * isLocked :
         * lockTime :
         * position :
         * isFormalEstablishment :
         * lastIpAdress :
         * imageGUID :
         * srcImageGUID :
         * loginErrorCount :
         * lastLoginErrorTime :
         * passwordModifyTime :
         * loginTime :
         * userType :
         * repairBusinessGUID : 9936f0b1-6953-4037-802a-297f728a97a4
         * tenantId :
         * isDeleted :
         * createTime : 2018-11-11 16:54:16
         * createGUID :
         * createdName :
         * modifiedTime : 2018-11-27 17:26:11
         * modifiedGUID :
         * modifiedName :
         * approveState :
         * approveGUID :
         * approveTime :
         * isMainAccountUser : 0
         * userQualification :
         * repairBusinessName : 深圳NIZ供应商
         * repairBusinessTel : 13222222222
         * repairBusinessAddress : 深圳市宝安区
         * buName :
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
            private String userCode;
            private String userName;
            private String buguid;
            private String email;
            private String password;
            private String officePhone;
            private String mobilePhone;
            private String homePhone;
            private String adAccount;
            private int isDisabeld;
            private String disabledReason;
            private String isAdmin;
            private String jobNumber;
            private String defaultStation;
            private String pswModifyTime;
            private String isUserChangePWD;
            private String isLocked;
            private String lockTime;
            private String position;
            private String isFormalEstablishment;
            private String lastIpAdress;
            private String imageGUID;
            private String srcImageGUID;
            private String loginErrorCount;
            private String lastLoginErrorTime;
            private String passwordModifyTime;
            private String loginTime;
            private String userType;
            private String repairBusinessGUID;
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
            private int isMainAccountUser;
            private String userQualification;
            private String repairBusinessName;
            private String repairBusinessTel;
            private String repairBusinessAddress;
            private String buName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getBuguid() {
                return buguid;
            }

            public void setBuguid(String buguid) {
                this.buguid = buguid;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getOfficePhone() {
                return officePhone;
            }

            public void setOfficePhone(String officePhone) {
                this.officePhone = officePhone;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getHomePhone() {
                return homePhone;
            }

            public void setHomePhone(String homePhone) {
                this.homePhone = homePhone;
            }

            public String getAdAccount() {
                return adAccount;
            }

            public void setAdAccount(String adAccount) {
                this.adAccount = adAccount;
            }

            public int getIsDisabeld() {
                return isDisabeld;
            }

            public void setIsDisabeld(int isDisabeld) {
                this.isDisabeld = isDisabeld;
            }

            public String getDisabledReason() {
                return disabledReason;
            }

            public void setDisabledReason(String disabledReason) {
                this.disabledReason = disabledReason;
            }

            public String getIsAdmin() {
                return isAdmin;
            }

            public void setIsAdmin(String isAdmin) {
                this.isAdmin = isAdmin;
            }

            public String getJobNumber() {
                return jobNumber;
            }

            public void setJobNumber(String jobNumber) {
                this.jobNumber = jobNumber;
            }

            public String getDefaultStation() {
                return defaultStation;
            }

            public void setDefaultStation(String defaultStation) {
                this.defaultStation = defaultStation;
            }

            public String getPswModifyTime() {
                return pswModifyTime;
            }

            public void setPswModifyTime(String pswModifyTime) {
                this.pswModifyTime = pswModifyTime;
            }

            public String getIsUserChangePWD() {
                return isUserChangePWD;
            }

            public void setIsUserChangePWD(String isUserChangePWD) {
                this.isUserChangePWD = isUserChangePWD;
            }

            public String getIsLocked() {
                return isLocked;
            }

            public void setIsLocked(String isLocked) {
                this.isLocked = isLocked;
            }

            public String getLockTime() {
                return lockTime;
            }

            public void setLockTime(String lockTime) {
                this.lockTime = lockTime;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getIsFormalEstablishment() {
                return isFormalEstablishment;
            }

            public void setIsFormalEstablishment(String isFormalEstablishment) {
                this.isFormalEstablishment = isFormalEstablishment;
            }

            public String getLastIpAdress() {
                return lastIpAdress;
            }

            public void setLastIpAdress(String lastIpAdress) {
                this.lastIpAdress = lastIpAdress;
            }

            public String getImageGUID() {
                return imageGUID;
            }

            public void setImageGUID(String imageGUID) {
                this.imageGUID = imageGUID;
            }

            public String getSrcImageGUID() {
                return srcImageGUID;
            }

            public void setSrcImageGUID(String srcImageGUID) {
                this.srcImageGUID = srcImageGUID;
            }

            public String getLoginErrorCount() {
                return loginErrorCount;
            }

            public void setLoginErrorCount(String loginErrorCount) {
                this.loginErrorCount = loginErrorCount;
            }

            public String getLastLoginErrorTime() {
                return lastLoginErrorTime;
            }

            public void setLastLoginErrorTime(String lastLoginErrorTime) {
                this.lastLoginErrorTime = lastLoginErrorTime;
            }

            public String getPasswordModifyTime() {
                return passwordModifyTime;
            }

            public void setPasswordModifyTime(String passwordModifyTime) {
                this.passwordModifyTime = passwordModifyTime;
            }

            public String getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(String loginTime) {
                this.loginTime = loginTime;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getRepairBusinessGUID() {
                return repairBusinessGUID;
            }

            public void setRepairBusinessGUID(String repairBusinessGUID) {
                this.repairBusinessGUID = repairBusinessGUID;
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

            public int getIsMainAccountUser() {
                return isMainAccountUser;
            }

            public void setIsMainAccountUser(int isMainAccountUser) {
                this.isMainAccountUser = isMainAccountUser;
            }

            public String getUserQualification() {
                return userQualification;
            }

            public void setUserQualification(String userQualification) {
                this.userQualification = userQualification;
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

            public String getBuName() {
                return buName;
            }

            public void setBuName(String buName) {
                this.buName = buName;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.userCode);
                dest.writeString(this.userName);
                dest.writeString(this.buguid);
                dest.writeString(this.email);
                dest.writeString(this.password);
                dest.writeString(this.officePhone);
                dest.writeString(this.mobilePhone);
                dest.writeString(this.homePhone);
                dest.writeString(this.adAccount);
                dest.writeInt(this.isDisabeld);
                dest.writeString(this.disabledReason);
                dest.writeString(this.isAdmin);
                dest.writeString(this.jobNumber);
                dest.writeString(this.defaultStation);
                dest.writeString(this.pswModifyTime);
                dest.writeString(this.isUserChangePWD);
                dest.writeString(this.isLocked);
                dest.writeString(this.lockTime);
                dest.writeString(this.position);
                dest.writeString(this.isFormalEstablishment);
                dest.writeString(this.lastIpAdress);
                dest.writeString(this.imageGUID);
                dest.writeString(this.srcImageGUID);
                dest.writeString(this.loginErrorCount);
                dest.writeString(this.lastLoginErrorTime);
                dest.writeString(this.passwordModifyTime);
                dest.writeString(this.loginTime);
                dest.writeString(this.userType);
                dest.writeString(this.repairBusinessGUID);
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
                dest.writeInt(this.isMainAccountUser);
                dest.writeString(this.userQualification);
                dest.writeString(this.repairBusinessName);
                dest.writeString(this.repairBusinessTel);
                dest.writeString(this.repairBusinessAddress);
                dest.writeString(this.buName);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.userCode = in.readString();
                this.userName = in.readString();
                this.buguid = in.readString();
                this.email = in.readString();
                this.password = in.readString();
                this.officePhone = in.readString();
                this.mobilePhone = in.readString();
                this.homePhone = in.readString();
                this.adAccount = in.readString();
                this.isDisabeld = in.readInt();
                this.disabledReason = in.readString();
                this.isAdmin = in.readString();
                this.jobNumber = in.readString();
                this.defaultStation = in.readString();
                this.pswModifyTime = in.readString();
                this.isUserChangePWD = in.readString();
                this.isLocked = in.readString();
                this.lockTime = in.readString();
                this.position = in.readString();
                this.isFormalEstablishment = in.readString();
                this.lastIpAdress = in.readString();
                this.imageGUID = in.readString();
                this.srcImageGUID = in.readString();
                this.loginErrorCount = in.readString();
                this.lastLoginErrorTime = in.readString();
                this.passwordModifyTime = in.readString();
                this.loginTime = in.readString();
                this.userType = in.readString();
                this.repairBusinessGUID = in.readString();
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
                this.isMainAccountUser = in.readInt();
                this.userQualification = in.readString();
                this.repairBusinessName = in.readString();
                this.repairBusinessTel = in.readString();
                this.repairBusinessAddress = in.readString();
                this.buName = in.readString();
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
