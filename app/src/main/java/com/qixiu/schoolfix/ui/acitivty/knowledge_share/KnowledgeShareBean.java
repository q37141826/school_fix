package com.qixiu.schoolfix.ui.acitivty.knowledge_share;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/12/10.
 */

public class KnowledgeShareBean extends BaseBean<KnowledgeShareBean.ResultBean>{


    /**
     * dataList : [{"id":"5a8ed69f-1c6b-4a8e-91b2-08d65beddc0c","articleTypeName":"搞笑","articleTypeUrl":"/images/A171C6FA-601D-49e8-8DE3-5A402213EBFD.png","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-07 10:44:37","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"7c4738b7-fb8b-4e8b-91b1-08d65beddc0c","articleTypeName":"21","articleTypeUrl":"123","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-07 10:44:07","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"95901f92-1c08-45ce-a7b1-01e6819b0165","articleTypeName":"八卦","articleTypeUrl":"/images/A171C6FA-601D-49e8-8DE3-5A402213EBFD.png","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"","createGUID":"","createdName":"","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"95901f92-1c08-45ce-a7b1-01e6819b0325","articleTypeName":"新闻","articleTypeUrl":"/images/A171C6FA-601D-49e8-8DE3-5A402213EBFD.png","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"","createGUID":"","createdName":"","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"95901f92-1c08-45ce-a7b1-01e6819b0365","articleTypeName":"娱乐","articleTypeUrl":"/images/A171C6FA-601D-49e8-8DE3-5A402213EBFD.png","tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"","createGUID":"","createdName":"","modifiedTime":"","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""}]
     * pageIndex : 1
     * pageCount : 1
     * pageSize : 1000
     * rowCount : 5
     */



    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : 5a8ed69f-1c6b-4a8e-91b2-08d65beddc0c
         * articleTypeName : 搞笑
         * articleTypeUrl : /images/A171C6FA-601D-49e8-8DE3-5A402213EBFD.png
         * tenantId : 9936f0b1-6953-4037-802a-297f728a97a4
         * isDeleted : 0
         * createTime : 2018-12-07 10:44:37
         * createGUID : 552b20d2-73e3-4052-8d73-08d647b3429b
         * createdName : yudm
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

        public static class DataListBean implements Parcelable {


            private String id;
            private String articleTypeName;
            private String articleTypeUrl;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getArticleTypeName() {
                return articleTypeName;
            }

            public void setArticleTypeName(String articleTypeName) {
                this.articleTypeName = articleTypeName;
            }

            public String getArticleTypeUrl() {
                return articleTypeUrl;
            }

            public void setArticleTypeUrl(String articleTypeUrl) {
                this.articleTypeUrl = articleTypeUrl;
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
                dest.writeString(this.articleTypeName);
                dest.writeString(this.articleTypeUrl);
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
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.articleTypeName = in.readString();
                this.articleTypeUrl = in.readString();
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
