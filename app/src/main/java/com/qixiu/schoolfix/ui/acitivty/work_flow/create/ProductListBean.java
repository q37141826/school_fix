package com.qixiu.schoolfix.ui.acitivty.work_flow.create;

import android.os.Parcel;
import android.os.Parcelable;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/12/7.
 */

public class ProductListBean extends BaseBean<ProductListBean.ResultBean> {


    /**
     * dataList : [{"id":"4c9fea17-6ec0-44c5-7b22-08d6576c7d44","productCode":"001","productModel":"45+6","productName":"北极雄","productImgUrl":"/upload/shproduct/2018120124450_004164653.jpg","productBrand":"25","productTypeGUID":"f1a5a808-726d-4901-26f7-08d6574ca4ad","productRemark":"25","productIsEnable":0,"tenantId":"9936f0b1-6953-4037-802a-297f728a97a4","isDeleted":0,"createTime":"2018-12-01 17:07:59","createGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","createdName":"yudm","modifiedTime":"","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"373054b1-260b-4439-a199-08d64e8ac2d8","productCode":"Rz01-01620100","productModel":"Rz01-102","productName":"雷蛇TAIPAN3500","productImgUrl":"/upload/shproduct/2018120135883_004164653.jpg","productBrand":"雷蛇","productTypeGUID":"ce3ca6b5-8cc2-4a48-c953-08d64e888975","productRemark":"有线三色炫彩游戏鼠标","productIsEnable":1,"tenantId":"","isDeleted":0,"createTime":"2018-11-20 09:57:22","createGUID":"","createdName":"","modifiedTime":"2018-11-27 17:08:18","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"4f1368c5-3d74-4163-a198-08d64e8ac2d8","productCode":"G304","productModel":"G304","productName":"罗技G304无线鼠标","productImgUrl":"","productBrand":"罗技","productTypeGUID":"14a37622-dd8e-4421-c952-08d64e888975","productRemark":"蓝牙稳定游戏鼠标","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-20 09:55:03","createGUID":"","createdName":"","modifiedTime":"2018-11-21 14:57:04","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"0c757e77-71cf-4f41-a197-08d64e8ac2d8","productCode":"20181120","productModel":"G502","productName":"罗技G502","productImgUrl":"","productBrand":"罗技","productTypeGUID":"14a37622-dd8e-4421-c952-08d64e888975","productRemark":"游戏/办公鼠标","productIsEnable":1,"tenantId":"","isDeleted":0,"createTime":"2018-11-20 09:52:00","createGUID":"","createdName":"","modifiedTime":"2018-11-27 13:43:43","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"fec27584-05af-4f72-8bea-08d64c5ba3ec","productCode":"20160606","productModel":"gs87","productName":"高斯87键机械键盘","productImgUrl":"/upload/shproduct/2018111759046_004164653.jpg","productBrand":"Ganss","productTypeGUID":"31b1ed26-c3f4-41e1-c94c-08d64e888975","productRemark":"87键","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-17 15:23:20","createGUID":"","createdName":"","modifiedTime":"2018-11-24 18:00:26","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"5efbc4d7-f5ca-4439-8be8-08d64c5ba3ec","productCode":"20181116","productModel":"fll108","productName":"高斯法拉利红108","productImgUrl":"","productBrand":"Ganss","productTypeGUID":"31b1ed26-c3f4-41e1-c94c-08d64e888975","productRemark":"法拉利漆+华丽外观","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-17 15:11:55","createGUID":"","createdName":"","modifiedTime":"2018-11-27 13:43:44","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"50bb2acd-7694-436f-8be7-08d64c5ba3ec","productCode":"20181117","productModel":"Micro84XRGB","productName":"NIZ84双模静电容RGB","productImgUrl":"","productBrand":"NIZ","productTypeGUID":"0b04e9b5-97ea-48b3-8030-08d649de8d11","productRemark":"蓝牙有线双模式","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-17 15:09:39","createGUID":"","createdName":"","modifiedTime":"2018-11-27 13:43:44","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"2db1a9be-70e9-e811-a168-d0e956dfa907","productCode":"20181115","productModel":"NIZ108","productName":"NIZ静电容108网吧防水版","productImgUrl":"/upload/shproduct/2018111721210_004164653.jpg","productBrand":"NIZ","productTypeGUID":"0b04e9b5-97ea-48b3-8030-08d649de8d11","productRemark":"防水性能特别好","productIsEnable":1,"tenantId":"","isDeleted":0,"createTime":"2018-11-17 00:00:00","createGUID":"","createdName":"","modifiedTime":"2018-11-27 13:43:45","modifiedGUID":"","modifiedName":"","approveState":"","approveGUID":"","approveTime":""},{"id":"47ff94da-70e9-e811-a168-d0e956dfa907","productCode":"20171111","productModel":"HHKB02","productName":"HHKB有线版","productImgUrl":"","productBrand":"HHKB","productTypeGUID":"67cb9c04-d9c6-4471-c950-08d64e888975","productRemark":"","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-17 00:00:00","createGUID":"","createdName":"","modifiedTime":"2018-11-20 09:50:35","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"a39293f1-a0e8-e811-a168-d0e956dfa907","productCode":"20181114","productModel":"NIZ108简版","productName":"NIZ静电容108","productImgUrl":"/upload/shproduct/2018120132268_004164653.jpg","productBrand":"NIZ4","productTypeGUID":"0b04e9b5-97ea-48b3-8030-08d649de8d11","productRemark":"sdfasdfasdfadfasd","productIsEnable":1,"tenantId":"","isDeleted":0,"createTime":"2018-11-14 11:09:11","createGUID":"","createdName":"","modifiedTime":"2018-11-27 13:43:45","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""},{"id":"7e3ec3e7-70e9-e811-a168-d0e956dfa907","productCode":"20171222","productModel":"HHKB01","productName":"HHKB无线版","productImgUrl":"","productBrand":"HHKB","productTypeGUID":"67cb9c04-d9c6-4471-c950-08d64e888975","productRemark":"","productIsEnable":0,"tenantId":"","isDeleted":0,"createTime":"2018-11-14 00:00:00","createGUID":"","createdName":"","modifiedTime":"2018-11-21 14:57:06","modifiedGUID":"552b20d2-73e3-4052-8d73-08d647b3429b","modifiedName":"yudm","approveState":"","approveGUID":"","approveTime":""}]
     * pageIndex : 1
     * pageCount : 1
     * pageSize : 9999
     * rowCount : 11
     */


    public static class ResultBean {
        private int pageIndex;
        private int pageCount;
        private int pageSize;
        private int rowCount;
        /**
         * id : 4c9fea17-6ec0-44c5-7b22-08d6576c7d44
         * productCode : 001
         * productModel : 45+6
         * productName : 北极雄
         * productImgUrl : /upload/shproduct/2018120124450_004164653.jpg
         * productBrand : 25
         * productTypeGUID : f1a5a808-726d-4901-26f7-08d6574ca4ad
         * productRemark : 25
         * productIsEnable : 0
         * tenantId : 9936f0b1-6953-4037-802a-297f728a97a4
         * isDeleted : 0
         * createTime : 2018-12-01 17:07:59
         * createGUID : 552b20d2-73e3-4052-8d73-08d647b3429b
         * createdName : yudm
         * modifiedTime :
         * modifiedGUID : 552b20d2-73e3-4052-8d73-08d647b3429b
         * modifiedName : yudm
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


            /**
             * id : d9c18144-cfff-4fe9-bf05-d534ee105c87
             * schoolUnitGUID : efb1dd4f-4851-4fb5-b69a-007d261deeeb
             * productGUID : 373054b1-260b-4439-a199-08d64e8ac2d8
             * productName : 雷蛇TAIPAN3500
             * productTypeGUID : ce3ca6b5-8cc2-4a48-c953-08d64e888975
             * productModel : Rz01-102
             * productBrand : 雷蛇
             * productTypeName : 雷蛇
             * schoolUnitName : 上海市青浦区豫才中学
             * schoolUnitTel :
             * schoolUnitMaster :
             */

            private String id;
            private String schoolUnitGUID;
            private String productGUID;
            private String productName;
            private String productTypeGUID;
            private String productModel;
            private String productBrand;
            private String productTypeName;
            private String schoolUnitName;
            private String schoolUnitTel;
            private String schoolUnitMaster;

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

            public String getProductTypeGUID() {
                return productTypeGUID;
            }

            public void setProductTypeGUID(String productTypeGUID) {
                this.productTypeGUID = productTypeGUID;
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

            public String getProductTypeName() {
                return productTypeName;
            }

            public void setProductTypeName(String productTypeName) {
                this.productTypeName = productTypeName;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.schoolUnitGUID);
                dest.writeString(this.productGUID);
                dest.writeString(this.productName);
                dest.writeString(this.productTypeGUID);
                dest.writeString(this.productModel);
                dest.writeString(this.productBrand);
                dest.writeString(this.productTypeName);
                dest.writeString(this.schoolUnitName);
                dest.writeString(this.schoolUnitTel);
                dest.writeString(this.schoolUnitMaster);
            }

            public DataListBean() {
            }

            protected DataListBean(Parcel in) {
                this.id = in.readString();
                this.schoolUnitGUID = in.readString();
                this.productGUID = in.readString();
                this.productName = in.readString();
                this.productTypeGUID = in.readString();
                this.productModel = in.readString();
                this.productBrand = in.readString();
                this.productTypeName = in.readString();
                this.schoolUnitName = in.readString();
                this.schoolUnitTel = in.readString();
                this.schoolUnitMaster = in.readString();
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
