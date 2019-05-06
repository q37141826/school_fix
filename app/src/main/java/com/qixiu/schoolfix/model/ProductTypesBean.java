package com.qixiu.schoolfix.model;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

public class ProductTypesBean  extends BaseBean<ProductTypesBean.ResultBean> {


    public static class ResultBean {
        private List<DtosBean> dtos;

        public List<DtosBean> getDtos() {
            return dtos;
        }

        public void setDtos(List<DtosBean> dtos) {
            this.dtos = dtos;
        }

        public static class DtosBean {
            /**
             * productTypeGUID : 183e438c-4140-4d97-4f05-08d6c3e958da
             * productTypeName : 路由器
             */

            private String productTypeGUID;
            private String productTypeName;

            public String getProductTypeGUID() {
                return productTypeGUID;
            }

            public void setProductTypeGUID(String productTypeGUID) {
                this.productTypeGUID = productTypeGUID;
            }

            public String getProductTypeName() {
                return productTypeName;
            }

            public void setProductTypeName(String productTypeName) {
                this.productTypeName = productTypeName;
            }
        }
    }
}
