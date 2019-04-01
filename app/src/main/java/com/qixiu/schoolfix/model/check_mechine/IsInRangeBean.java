package com.qixiu.schoolfix.model.check_mechine;

import com.qixiu.qixiu.request.bean.BaseBean;

public class IsInRangeBean  extends BaseBean<IsInRangeBean.ResultBean> {




    public static class ResultBean {
        /**
         * isInRange : 1
         */

        private int isInRange;

        public int getIsInRange() {
            return isInRange;
        }

        public void setIsInRange(int isInRange) {
            this.isInRange = isInRange;
        }
    }
}
