package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.schoolfix.model.IdIntef;

import java.util.List;

/**
 * Created by my on 2018/11/24.
 */

/*
*

* */

public class ProblemDataBean extends BaseBean<ProblemDataBean.ResultBean> {



    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : 10bb2acd-7694-436f-8be7-08d64c5ba3ec
         * productGUID : 50bb2acd-7694-436f-8be7-08d64c5ba3ec
         * productProblemRemark : 设备过热
         * tenantId :
         * isDeleted : 0
         * createTime :
         * createGUID :
         * createdName :
         * modifiedTime :
         * modifiedGUID :
         * modifiedName :
         * approveState :
         * approveGUID :
         * approveTime :
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

        public static class DataListBean implements Parcelable,IdIntef{
            private String id;
            private String productGUID;
            private String productProblemRemark;
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




            public boolean isLast() {
                return last;
            }

            public void setLast(boolean last) {
                this.last = last;
            }

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }

            private boolean last=false;
            private  boolean isSelected=false;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getProductGUID() {
                return productGUID;
            }

            public void setProductGUID(String productGUID) {
                this.productGUID = productGUID;
            }

            public String getProductProblemRemark() {
                return productProblemRemark;
            }

            public void setProductProblemRemark(String productProblemRemark) {
                this.productProblemRemark = productProblemRemark;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.productGUID);
                dest.writeString(this.productProblemRemark);
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
                dest.writeByte(this.last ? (byte) 1 : (byte) 0);
                dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.productGUID = in.readString();
                this.productProblemRemark = in.readString();
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
                this.last = in.readByte() != 0;
                this.isSelected = in.readByte() != 0;
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
