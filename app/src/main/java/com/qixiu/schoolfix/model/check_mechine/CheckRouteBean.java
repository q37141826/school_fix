package com.qixiu.schoolfix.model.check_mechine;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

public class CheckRouteBean extends BaseBean<CheckRouteBean.ResultBean> {


    public static class ResultBean {
        /**
         * dataList : [{"id":"4fe90436-ff2f-4e93-bcce-08d69af32bd0","checkLineGUID":"f2af10e2-ff22-4d52-e50e-08d69af32bb8","userGUID":"e9761c30-52d0-4f44-8ad5-1a74f977bc6b","checkLineUserAssginState":1,"tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2019-02-25 15:30:52","createGUID":"e9761c30-52d0-4f44-8ad5-1a74f977bc6b","createdName":"维修员01","modifiedTime":null,"modifiedGUID":null,"modifiedName":null,"approveState":null,"approveGUID":null,"approveTime":null,"checkLineName":"走一圈","userName":"维修员01","jobNumber":null,"position":null,"mobilePhone":"13211111111","email":"www.1111111111@qq.com","buName":"A组","isHas":"已分配"}]
         * pageIndex : 1
         * pageCount : 1
         * pageSize : 1000
         * rowCount : 1
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

        public static class DataListBean {
            /**
             * id : 4fe90436-ff2f-4e93-bcce-08d69af32bd0
             * checkLineGUID : f2af10e2-ff22-4d52-e50e-08d69af32bb8
             * userGUID : e9761c30-52d0-4f44-8ad5-1a74f977bc6b
             * checkLineUserAssginState : 1
             * tenantId : 9936f0b1-6953-4037-802a-297f728a97a4
             * isDeleted : 0
             * createTime : 2019-02-25 15:30:52
             * createGUID : e9761c30-52d0-4f44-8ad5-1a74f977bc6b
             * createdName : 维修员01
             * modifiedTime : null
             * modifiedGUID : null
             * modifiedName : null
             * approveState : null
             * approveGUID : null
             * approveTime : null
             * checkLineName : 走一圈
             * userName : 维修员01
             * jobNumber : null
             * position : null
             * mobilePhone : 13211111111
             * email : www.1111111111@qq.com
             * buName : A组
             * isHas : 已分配
             */

            private String id;
            private String checkLineGUID;
            private String userGUID;
            private int checkLineUserAssginState;
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
            private String checkLineName;
            private String userName;
            private String jobNumber;
            private String position;
            private String mobilePhone;
            private String email;
            private String buName;
            private String isHas;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCheckLineGUID() {
                return checkLineGUID;
            }

            public void setCheckLineGUID(String checkLineGUID) {
                this.checkLineGUID = checkLineGUID;
            }

            public String getUserGUID() {
                return userGUID;
            }

            public void setUserGUID(String userGUID) {
                this.userGUID = userGUID;
            }

            public int getCheckLineUserAssginState() {
                return checkLineUserAssginState;
            }

            public void setCheckLineUserAssginState(int checkLineUserAssginState) {
                this.checkLineUserAssginState = checkLineUserAssginState;
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

            public Object getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(String modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public Object getModifiedGUID() {
                return modifiedGUID;
            }

            public void setModifiedGUID(String modifiedGUID) {
                this.modifiedGUID = modifiedGUID;
            }

            public Object getModifiedName() {
                return modifiedName;
            }

            public void setModifiedName(String modifiedName) {
                this.modifiedName = modifiedName;
            }

            public Object getApproveState() {
                return approveState;
            }

            public void setApproveState(String approveState) {
                this.approveState = approveState;
            }

            public Object getApproveGUID() {
                return approveGUID;
            }

            public void setApproveGUID(String approveGUID) {
                this.approveGUID = approveGUID;
            }

            public Object getApproveTime() {
                return approveTime;
            }

            public void setApproveTime(String approveTime) {
                this.approveTime = approveTime;
            }

            public String getCheckLineName() {
                return checkLineName;
            }

            public void setCheckLineName(String checkLineName) {
                this.checkLineName = checkLineName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public Object getJobNumber() {
                return jobNumber;
            }

            public void setJobNumber(String jobNumber) {
                this.jobNumber = jobNumber;
            }

            public Object getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getBuName() {
                return buName;
            }

            public void setBuName(String buName) {
                this.buName = buName;
            }

            public String getIsHas() {
                return isHas;
            }

            public void setIsHas(String isHas) {
                this.isHas = isHas;
            }
        }
    }
}
