package com.qixiu.schoolfix.ui.fragment.worklist;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/11/26.
 */

public class WorkListBean extends BaseBean<WorkListBean.ResultBean>{


    public static class ResultBean {
        private Object id;
        /**
         * productName : 高斯法拉利红108
         * productImgUrl :
         * workOrderTypeStr : 完成
         * workOrderCreatime : 2018-11-19 10:22:36
         * workOrderCstProblemRemark : 键盘进水啦
         * id : ef1a467a-136e-4e67-8e80-3d363acf06d2
         */

        private List<MyWorkOdersBean> myWorkOders;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public List<MyWorkOdersBean> getMyWorkOders() {
            return myWorkOders;
        }

        public void setMyWorkOders(List<MyWorkOdersBean> myWorkOders) {
            this.myWorkOders = myWorkOders;
        }

        public static class MyWorkOdersBean {

            /**
             * productName : 雷蛇TAIPAN3500
             * productImgUrl : /upload/shproduct/2018120135883_004164653.jpg
             * workOrderTypeStr : 待接单
             * workOrderCreatime : 2018-11-30 10:01:28
             * workOrderCstProblemRemark :
             * deviceTypeStr : 硬件
             * schoolUnitName : 上海市青浦区金泽幼儿园
             * schoolUnitArea : 中国上海上海市青浦区
             * id : dac12fda-13be-41d1-e73a-08d65667be08
             */

            private String productName;
            private String productImgUrl;
            private String workOrderTypeStr;
            private String workOrderCreatime;
            private String workOrderCstProblemRemark;
            private String deviceTypeStr;
            private String schoolUnitName;
            private String schoolUnitArea;
            private String id;

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductImgUrl() {
                return productImgUrl;
            }

            public void setProductImgUrl(String productImgUrl) {
                this.productImgUrl = productImgUrl;
            }

            public String getWorkOrderTypeStr() {
                return workOrderTypeStr;
            }

            public void setWorkOrderTypeStr(String workOrderTypeStr) {
                this.workOrderTypeStr = workOrderTypeStr;
            }

            public String getWorkOrderCreatime() {
                return workOrderCreatime;
            }

            public void setWorkOrderCreatime(String workOrderCreatime) {
                this.workOrderCreatime = workOrderCreatime;
            }

            public String getWorkOrderCstProblemRemark() {
                return workOrderCstProblemRemark;
            }

            public void setWorkOrderCstProblemRemark(String workOrderCstProblemRemark) {
                this.workOrderCstProblemRemark = workOrderCstProblemRemark;
            }

            public String getDeviceTypeStr() {
                return deviceTypeStr;
            }

            public void setDeviceTypeStr(String deviceTypeStr) {
                this.deviceTypeStr = deviceTypeStr;
            }

            public String getSchoolUnitName() {
                return schoolUnitName;
            }

            public void setSchoolUnitName(String schoolUnitName) {
                this.schoolUnitName = schoolUnitName;
            }

            public String getSchoolUnitArea() {
                return schoolUnitArea;
            }

            public void setSchoolUnitArea(String schoolUnitArea) {
                this.schoolUnitArea = schoolUnitArea;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
