package com.qixiu.schoolfix.utils;

import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.schoolfix.ui.fragment.home.HomeDataBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataUtils {


    public static List<HomeDataBean.ResultBean.MonthFinshDetailsBean> getFictionChartData() {
        List<HomeDataBean.ResultBean.MonthFinshDetailsBean> datas = new ArrayList<>();

        HomeDataBean.ResultBean.MonthFinshDetailsBean
                bean = new HomeDataBean.ResultBean.MonthFinshDetailsBean();
        bean.setFinishCOunt(3);
        bean.setFinishDate("2019-03-12");
        datas.add(bean);
        bean = new HomeDataBean.ResultBean.MonthFinshDetailsBean();
        bean.setFinishCOunt(5);
        bean.setFinishDate("2019-03-13");
        datas.add(bean);
        bean = new HomeDataBean.ResultBean.MonthFinshDetailsBean();
        bean.setFinishCOunt(10);
        bean.setFinishDate("2019-03-14");
        datas.add(bean);

        return datas;
    }

    public static List<HomeDataBean.ResultBean.MonthFinshDetailsBean> getChartData(List<HomeDataBean.ResultBean.MonthFinshDetailsBean> originDatas) {
        List<HomeDataBean.ResultBean.MonthFinshDetailsBean> datas = new ArrayList<>();

        if (originDatas.size() == 1) {
            Date date = TimeDataUtil.strToDate(originDatas.get(0).getFinishDate(),TimeDataUtil.DEFULT_DATE_FORMAT);
            HomeDataBean.ResultBean.MonthFinshDetailsBean
                    bean = new HomeDataBean.ResultBean.MonthFinshDetailsBean();
            bean.setFinishCOunt(0);
            bean.setFinishDate(TimeDataUtil.getTimeStamp(date.getTime()-24*60*1000));
            datas.add(bean);
        }
        datas.addAll(originDatas);
        return datas;
    }


}
