package com.qixiu.schoolfix.ui.fragment.home;

import com.qixiu.qixiu.request.bean.BaseBean;

import java.util.List;

/**
 * Created by my on 2018/11/22.
 */

public class HomeDataBean extends BaseBean<HomeDataBean.ResultBean>{


    public static class ResultBean {
        private int finishWorkOrderCount;
        private int pointGoodCount;
        private int waitDealOrderCount;
        private int waitReceiveOrderCount;
        /**
         * finishDate : 2018-11-20
         * finishCOunt : 1
         */

        private List<MonthFinshDetailsBean> monthFinshDetails;

        public int getFinishWorkOrderCount() {
            return finishWorkOrderCount;
        }

        public void setFinishWorkOrderCount(int finishWorkOrderCount) {
            this.finishWorkOrderCount = finishWorkOrderCount;
        }

        public int getPointGoodCount() {
            return pointGoodCount;
        }

        public void setPointGoodCount(int pointGoodCount) {
            this.pointGoodCount = pointGoodCount;
        }

        public int getWaitDealOrderCount() {
            return waitDealOrderCount;
        }

        public void setWaitDealOrderCount(int waitDealOrderCount) {
            this.waitDealOrderCount = waitDealOrderCount;
        }

        public int getWaitReceiveOrderCount() {
            return waitReceiveOrderCount;
        }

        public void setWaitReceiveOrderCount(int waitReceiveOrderCount) {
            this.waitReceiveOrderCount = waitReceiveOrderCount;
        }

        public List<MonthFinshDetailsBean> getMonthFinshDetails() {
            return monthFinshDetails;
        }

        public void setMonthFinshDetails(List<MonthFinshDetailsBean> monthFinshDetails) {
            this.monthFinshDetails = monthFinshDetails;
        }

        public static class MonthFinshDetailsBean {
            private String finishDate;
            private int finishCOunt;

            public String getFinishDate() {
                return finishDate;
            }

            public void setFinishDate(String finishDate) {
                this.finishDate = finishDate;
            }

            public int getFinishCOunt() {
                return finishCOunt;
            }

            public void setFinishCOunt(int finishCOunt) {
                this.finishCOunt = finishCOunt;
            }
        }
    }
}
