package com.qixiu.schoolfix.model.check_mechine;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.schoolfix.model.IdIntef;

import java.util.List;

public class CheckMainSchoolBean extends BaseBean<CheckMainSchoolBean.ResultBean> {



    public static class ResultBean {
        /**
         * dataList : [{"id":"8a5ddc9b-783e-40f1-9be1-7aec453070c9","checkPointGUID":"8d82f10e-5f05-4cd9-6859-08d69af30dd4","userGUID":"e9761c30-52d0-4f44-8ad5-1a74f977bc6b","checkRecordBeginTime":"2019-02-26 08:30:00","checkRecordFinishTime":null,"tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2019-02-26 13:50:26","checkRecordEndTime":"2019-02-26 17:30:00","checkRecordSignTime":null,"checkRecordMaxLateTime":"2019-02-26 09:00:00","checkLineGUID":"b4542c69-0c21-4166-e50f-08d69af32bb8","checkLinePeriod":"每天","checkLineName":"测试路线","checkPointName":"001","userName":"维修员01","schoolUnitMapX":"116.671618","schoolUnitMapY":"39.252128"}]
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

        public static class DataListBean implements Parcelable,IdIntef {
            /**
             * id : 8a5ddc9b-783e-40f1-9be1-7aec453070c9
             * checkPointGUID : 8d82f10e-5f05-4cd9-6859-08d69af30dd4
             * userGUID : e9761c30-52d0-4f44-8ad5-1a74f977bc6b
             * checkRecordBeginTime : 2019-02-26 08:30:00
             * checkRecordFinishTime : null
             * tenantId : 9936f0b1-6953-4037-802a-297f728a97a4
             * isDeleted : 0
             * createTime : 2019-02-26 13:50:26
             * checkRecordEndTime : 2019-02-26 17:30:00
             * checkRecordSignTime : null
             * checkRecordMaxLateTime : 2019-02-26 09:00:00
             * checkLineGUID : b4542c69-0c21-4166-e50f-08d69af32bb8
             * checkLinePeriod : 每天
             * checkLineName : 测试路线
             * checkPointName : 001
             * userName : 维修员01
             * schoolUnitMapX : 116.671618
             * schoolUnitMapY : 39.252128
             */

            private String id;
            private String checkPointGUID;
            private String userGUID;
            private String checkRecordBeginTime;
            private String checkRecordFinishTime;
            private String tenantId;
            private int isDeleted;
            private String createTime;
            private String checkRecordEndTime;
            private String checkRecordSignTime;
            private String checkRecordMaxLateTime;
            private String checkLineGUID;
            private String checkLinePeriod;
            private String checkLineName;
            private String checkPointName;
            private String userName;
            private String schoolUnitMapX;
            private String schoolUnitMapY;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCheckPointGUID() {
                return checkPointGUID;
            }

            public void setCheckPointGUID(String checkPointGUID) {
                this.checkPointGUID = checkPointGUID;
            }

            public String getUserGUID() {
                return userGUID;
            }

            public void setUserGUID(String userGUID) {
                this.userGUID = userGUID;
            }

            public String getCheckRecordBeginTime() {
                return checkRecordBeginTime;
            }

            public void setCheckRecordBeginTime(String checkRecordBeginTime) {
                this.checkRecordBeginTime = checkRecordBeginTime;
            }

            public Object getCheckRecordFinishTime() {
                return checkRecordFinishTime;
            }

            public void setCheckRecordFinishTime(String checkRecordFinishTime) {
                this.checkRecordFinishTime = checkRecordFinishTime;
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

            public String getCheckRecordEndTime() {
                return checkRecordEndTime;
            }

            public void setCheckRecordEndTime(String checkRecordEndTime) {
                this.checkRecordEndTime = checkRecordEndTime;
            }

            public Object getCheckRecordSignTime() {
                return checkRecordSignTime;
            }

            public void setCheckRecordSignTime(String checkRecordSignTime) {
                this.checkRecordSignTime = checkRecordSignTime;
            }

            public String getCheckRecordMaxLateTime() {
                return checkRecordMaxLateTime;
            }

            public void setCheckRecordMaxLateTime(String checkRecordMaxLateTime) {
                this.checkRecordMaxLateTime = checkRecordMaxLateTime;
            }

            public String getCheckLineGUID() {
                return checkLineGUID;
            }

            public void setCheckLineGUID(String checkLineGUID) {
                this.checkLineGUID = checkLineGUID;
            }

            public String getCheckLinePeriod() {
                return checkLinePeriod;
            }

            public void setCheckLinePeriod(String checkLinePeriod) {
                this.checkLinePeriod = checkLinePeriod;
            }

            public String getCheckLineName() {
                return checkLineName;
            }

            public void setCheckLineName(String checkLineName) {
                this.checkLineName = checkLineName;
            }

            public String getCheckPointName() {
                return checkPointName;
            }

            public void setCheckPointName(String checkPointName) {
                this.checkPointName = checkPointName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getSchoolUnitMapX() {
                return schoolUnitMapX;
            }

            public void setSchoolUnitMapX(String schoolUnitMapX) {
                this.schoolUnitMapX = schoolUnitMapX;
            }

            public String getSchoolUnitMapY() {
                return schoolUnitMapY;
            }

            public void setSchoolUnitMapY(String schoolUnitMapY) {
                this.schoolUnitMapY = schoolUnitMapY;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.checkPointGUID);
                dest.writeString(this.userGUID);
                dest.writeString(this.checkRecordBeginTime);
                dest.writeString(this.checkRecordFinishTime);
                dest.writeString(this.tenantId);
                dest.writeInt(this.isDeleted);
                dest.writeString(this.createTime);
                dest.writeString(this.checkRecordEndTime);
                dest.writeString(this.checkRecordSignTime);
                dest.writeString(this.checkRecordMaxLateTime);
                dest.writeString(this.checkLineGUID);
                dest.writeString(this.checkLinePeriod);
                dest.writeString(this.checkLineName);
                dest.writeString(this.checkPointName);
                dest.writeString(this.userName);
                dest.writeString(this.schoolUnitMapX);
                dest.writeString(this.schoolUnitMapY);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.checkPointGUID = in.readString();
                this.userGUID = in.readString();
                this.checkRecordBeginTime = in.readString();
                this.checkRecordFinishTime = in.readString();
                this.tenantId = in.readString();
                this.isDeleted = in.readInt();
                this.createTime = in.readString();
                this.checkRecordEndTime = in.readString();
                this.checkRecordSignTime = in.readString();
                this.checkRecordMaxLateTime = in.readString();
                this.checkLineGUID = in.readString();
                this.checkLinePeriod = in.readString();
                this.checkLineName = in.readString();
                this.checkPointName = in.readString();
                this.userName = in.readString();
                this.schoolUnitMapX = in.readString();
                this.schoolUnitMapY = in.readString();
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
