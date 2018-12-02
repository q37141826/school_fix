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
            private String productName;
            private String productImgUrl;
            private String workOrderTypeStr;
            private String workOrderCreatime;
            private String workOrderCstProblemRemark;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
