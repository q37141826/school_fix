package com.qixiu.schoolfix.ui.acitivty.work_flow;

import com.qixiu.schoolfix.ui.acitivty.work_flow.problem.RequestBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by my on 2018/11/26.
 */

public class RequestMaker {


    public static RequestBean getMechineRequest(String productGUID) {
        RequestBean requestIntef = new RequestBean();

        requestIntef.setPageIndex(1);
        requestIntef.setPageSize(1000);
        RequestBean.FilterBean filterBean = new RequestBean.FilterBean();
        List<RequestBean.FilterBean.ConditionsBean> conditionsBeanss = new ArrayList<>();
        RequestBean.FilterBean.ConditionsBean conditionsBean = new RequestBean.FilterBean.ConditionsBean();
        conditionsBean.setAttribute("ProductGUID");
        conditionsBean.setDatatype("uniqueidentifier");
        conditionsBean.setOperatoer("eq");
        conditionsBean.setValue(productGUID);//测试ID
        conditionsBeanss.add(conditionsBean);
        filterBean.setConditions(conditionsBeanss);
        filterBean.setType("and");
        requestIntef.setFilter(filterBean);
        return requestIntef;
    }


    public static RequestBean getRequest(Map<String, String> map) {
        RequestBean requestIntef = new RequestBean();

        requestIntef.setPageIndex(1);
        requestIntef.setPageSize(1000);
        RequestBean.FilterBean filterBean = new RequestBean.FilterBean();
        List<RequestBean.FilterBean.ConditionsBean> conditionsBeanss = new ArrayList<>();

        Set<String> keys = map.keySet();
        for (String key : keys) {
            RequestBean.FilterBean.ConditionsBean conditionsBean = new RequestBean.FilterBean.ConditionsBean();

            conditionsBean.setAttribute(key);
            conditionsBean.setDatatype("uniqueidentifier");
            conditionsBean.setOperatoer("eq");
            conditionsBean.setValue(map.get(key));
            conditionsBeanss.add(conditionsBean);
        }

        filterBean.setConditions(conditionsBeanss);
        filterBean.setType("and");
        requestIntef.setFilter(filterBean);
        return requestIntef;
    }
}
