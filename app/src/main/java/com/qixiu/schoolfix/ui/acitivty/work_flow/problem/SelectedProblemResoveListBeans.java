package com.qixiu.schoolfix.ui.acitivty.work_flow.problem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class SelectedProblemResoveListBeans implements Parcelable {




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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.problemBeans);
        dest.writeList(this.ResoveBeans);
    }

    public SelectedProblemResoveListBeans() {
    }

    protected SelectedProblemResoveListBeans(Parcel in) {
        this.problemBeans = in.createTypedArrayList(ProblemDataBean.ResultBean.DataListBean.CREATOR);
        this.ResoveBeans = new ArrayList<ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean>();
        in.readList(this.ResoveBeans, ResoveListBean.ResultBean.GetProductProblemSolutionDtosBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<SelectedProblemResoveListBeans> CREATOR = new Parcelable.Creator<SelectedProblemResoveListBeans>() {
        @Override
        public SelectedProblemResoveListBeans createFromParcel(Parcel source) {
            return new SelectedProblemResoveListBeans(source);
        }

        @Override
        public SelectedProblemResoveListBeans[] newArray(int size) {
            return new SelectedProblemResoveListBeans[size];
        }
    };
}
