package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class SelectedProblemResoveListBeans {

    private List<ProblemDataBean.ResultBean.DataListBean>  problemBeans;
    private List<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean>  ResoveBeans;

    public List<ProblemDataBean.ResultBean.DataListBean> getProblemBeans() {
        return problemBeans;
    }

    public void setProblemBeans(List<ProblemDataBean.ResultBean.DataListBean> problemBeans) {
        this.problemBeans = problemBeans;
    }

    public List<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean>  getResoveBeans() {
        return ResoveBeans;
    }

    public void setResoveBeans(List<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean>  resoveBeans) {
        ResoveBeans = resoveBeans;
    }
}
