package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import com.qixiu.qixiu.request.bean.BaseBean;
import com.qixiu.schoolfix.model.IdIntef;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class ResoveListBean extends BaseBean<ResoveListBean.ResultBean> {



    public static class ResultBean {
        /**
         * id : 11766b6b-e4eb-e811-97c0-d8d9fea957a0
         * productProblemGUID : 10BB2ACD-7694-436F-8BE7-08D64C5BA3EC
         * productProblemRemark : 重启
         * productProblemPriority : 1
         * productProblemPriorityStr : 高
         */

        private List<GetProductProblemSolutionDtosBean> getProductProblemSolutionDtos;

        public List<GetProductProblemSolutionDtosBean> getGetProductProblemSolutionDtos() {
            return getProductProblemSolutionDtos;
        }

        public void setGetProductProblemSolutionDtos(List<GetProductProblemSolutionDtosBean> getProductProblemSolutionDtos) {
            this.getProductProblemSolutionDtos = getProductProblemSolutionDtos;
        }

        public static class GetProductProblemSolutionDtosBean implements IdIntef {
            private String id;
            private String productProblemGUID;
            private String productProblemRemark;
            private int productProblemPriority;
            private String productProblemPriorityStr;
            private boolean isLast=false;
            private boolean isSelected=false;

            public boolean isLast() {
                return isLast;
            }

            public void setLast(boolean last) {
                isLast = last;
            }

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }
            @Override
            public String getId() {
                return id;
            }
            @Override
            public void setId(String id) {
                this.id = id;
            }

            public String getProductProblemGUID() {
                return productProblemGUID;
            }

            public void setProductProblemGUID(String productProblemGUID) {
                this.productProblemGUID = productProblemGUID;
            }

            public String getProductProblemRemark() {
                return productProblemRemark;
            }

            public void setProductProblemRemark(String productProblemRemark) {
                this.productProblemRemark = productProblemRemark;
            }

            public int getProductProblemPriority() {
                return productProblemPriority;
            }

            public void setProductProblemPriority(int productProblemPriority) {
                this.productProblemPriority = productProblemPriority;
            }

            public String getProductProblemPriorityStr() {
                return productProblemPriorityStr;
            }

            public void setProductProblemPriorityStr(String productProblemPriorityStr) {
                this.productProblemPriorityStr = productProblemPriorityStr;
            }
        }
    }
}
