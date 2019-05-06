package com.qixiu.schoolfix.ui.acitivty.work_flow.create;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/12/7.
 */

public class SchoolListBean extends BaseBean<SchoolListBean.ResultBean> {



    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : 4434ff0a-f19a-4e51-bb8f-9e17a5bd2358
         * schoolUnitGUID : efb1dd4f-4851-4fb5-b69a-007d261deeeb
         * repairBusinessGUID : 9936f0b1-6953-4037-802a-297f728a97a4
         * repairBusinessName : 深圳NIZ供应商
         * repairBusinessTel : 13222222222
         * repairBusinessAddress : 深圳市宝安区
         * schoolUnitName : 上海市青浦区豫才中学
         * schoolUnitTel :
         * schoolUnitMaster :
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
            private String repairBusinessName;
            private String repairBusinessTel;
            private String repairBusinessAddress;
            private String schoolUnitName;
            private String schoolUnitTel;
            private String schoolUnitMaster;
            private String schoolUnitAddress;

            public String getSchoolUnitAddress() {
                return schoolUnitAddress;
            }

            public void setSchoolUnitAddress(String schoolUnitAddress) {
                this.schoolUnitAddress = schoolUnitAddress;
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

            public String getSchoolUnitName() {
                return schoolUnitName;
            }

            public void setSchoolUnitName(String schoolUnitName) {
                this.schoolUnitName = schoolUnitName;
            }

            public String getSchoolUnitTel() {
                return schoolUnitTel;
            }

            public void setSchoolUnitTel(String schoolUnitTel) {
                this.schoolUnitTel = schoolUnitTel;
            }

            public String getSchoolUnitMaster() {
                return schoolUnitMaster;
            }

            public void setSchoolUnitMaster(String schoolUnitMaster) {
                this.schoolUnitMaster = schoolUnitMaster;
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
                dest.writeString(this.repairBusinessName);
                dest.writeString(this.repairBusinessTel);
                dest.writeString(this.repairBusinessAddress);
                dest.writeString(this.schoolUnitName);
                dest.writeString(this.schoolUnitTel);
                dest.writeString(this.schoolUnitMaster);
                dest.writeString(this.schoolUnitAddress);
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.schoolUnitGUID = in.readString();
                this.repairBusinessGUID = in.readString();
                this.repairBusinessName = in.readString();
                this.repairBusinessTel = in.readString();
                this.repairBusinessAddress = in.readString();
                this.schoolUnitName = in.readString();
                this.schoolUnitTel = in.readString();
                this.schoolUnitMaster = in.readString();
                this.schoolUnitAddress = in.readString();
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
    }
}
