package com.qixiu.schoolfix.utils.reuestutil;

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
        return getRequest(map, "CreateTime desc");
    }


    public static RequestBean getRequest(Map<String, String> map, String order) {
        String setDatatype = "uniqueidentifier";
        String operator = "eq";
        return getRequest(map, order, setDatatype, operator);
    }


    public static RequestBean getRequest(Map<String, String> map, String order, String setDatatype, String operatoer) {
        RequestBean requestIntef = new RequestBean();
        requestIntef.setPageIndex(1);
        requestIntef.setPageSize(1000);
        RequestBean.FilterBean filterBean = new RequestBean.FilterBean();
        List<RequestBean.FilterBean.ConditionsBean> conditionsBeanss = new ArrayList<>();

        Set<String> keys = map.keySet();
        for (String key : keys) {
            RequestBean.FilterBean.ConditionsBean conditionsBean = new RequestBean.FilterBean.ConditionsBean();
            conditionsBean.setAttribute(key);
            conditionsBean.setDatatype(setDatatype);
            conditionsBean.setOperatoer(operatoer);
            conditionsBean.setValue(map.get(key));
            conditionsBeanss.add(conditionsBean);
        }

        filterBean.setConditions(conditionsBeanss);
        filterBean.setType("and");
        requestIntef.setFilter(filterBean);
        requestIntef.setOrder(order);
        return requestIntef;
    }


    public static RequestBean getRequests(Map<String, String[]> map, String order, String type) {
        RequestBean requestIntef = new RequestBean();
        requestIntef.setPageIndex(1);
        requestIntef.setPageSize(1000);
        RequestBean.FilterBean filterBean = new RequestBean.FilterBean();
        List<RequestBean.FilterBean.ConditionsBean> conditionsBeanss = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            RequestBean.FilterBean.ConditionsBean conditionsBean = new RequestBean.FilterBean.ConditionsBean();
            conditionsBean.setAttribute(key);
            conditionsBean.setDatatype(map.get(key)[1]);
            conditionsBean.setOperatoer(map.get(key)[2]);
            conditionsBean.setValue(map.get(key)[3]);
            conditionsBeanss.add(conditionsBean);
        }
        filterBean.setConditions(conditionsBeanss);
        filterBean.setType(type);
        requestIntef.setFilter(filterBean);
        requestIntef.setOrder(order);
        return requestIntef;
    }


    public static RequestBean getRequests(List<String[]> datas, String order, String type) {
        RequestBean requestIntef = new RequestBean();
        requestIntef.setPageIndex(1);
        requestIntef.setPageSize(1000);
        RequestBean.FilterBean filterBean = new RequestBean.FilterBean();
        List<RequestBean.FilterBean.ConditionsBean> conditionsBeanss = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            RequestBean.FilterBean. ConditionsBean  conditionsBean=new RequestBean.FilterBean.ConditionsBean();
            conditionsBean.setAttribute(datas.get(i)[0]);
            conditionsBean.setDatatype(datas.get(i)[1]);
            conditionsBean.setOperatoer(datas.get(i)[2]);
            conditionsBean.setValue(datas.get(i)[3]);
            conditionsBeanss.add(conditionsBean);
        }
        filterBean.setConditions(conditionsBeanss);
        filterBean.setType(type);
        requestIntef.setFilter(filterBean);
        requestIntef.setOrder(order);
        return requestIntef;
    }
}
