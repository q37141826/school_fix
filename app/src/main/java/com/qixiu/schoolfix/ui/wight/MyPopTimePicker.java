package com.qixiu.schoolfix.ui.wight;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qixiu.qixiu.utils.NumUtils;
import com.qixiu.qixiu.utils.TimeDataUtil;
import com.qixiu.schoolfix.R;
import com.qixiu.wigit.picker.PickerView;
import com.qixiu.wigit.picker.SelectedDataBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HuiHeZe on 2017/8/25.
 */

public class MyPopTimePicker implements View.OnClickListener {
    private static final int FIRST_TIME=1000;
    private Pop_itemSelectListener call, leftCall;
    private Context context;
    private View contentView;
    private PopupWindow popupWindow;
    private RelativeLayout relativeLayout_back_for_dismiss;
    private TextView textView_left_pop_picker, textView_right_pop_picker;
    private PickerView pickview_time_left, pickview_time_right;
    SelectedDataBean leftSelect, rightSelected;

    public MyPopTimePicker(Context context){
        this.context=context;
    }

    public void setViewAndData( List<SelectedDataBean> listLeft, List<SelectedDataBean> listRight, Pop_itemSelectListener leftcall, Pop_itemSelectListener call){
        this.call = call;
        this.leftCall = leftcall;
        setAllView();
        setClick();
        pickview_time_left.setData(listLeft);
        pickview_time_right.setData(listRight);
        pickview_time_left.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(SelectedDataBean data) {
                leftSelect = data;
                MyPopTimePicker.this.leftCall.getRightSelectData(data);
            }
        });
        pickview_time_right.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(SelectedDataBean text) {
                rightSelected = text;
            }
        });
        leftSelect = listLeft.get(listLeft.size() / 2);
        rightSelected = listRight.get(listRight.size() / 2);

    }




    public MyPopTimePicker(Context context, List<SelectedDataBean> listLeft, List<SelectedDataBean> listRight, Pop_itemSelectListener leftcall, Pop_itemSelectListener call) {
        this.call = call;
        this.leftCall = leftcall;
        this.context = context;
        setAllView();
        setClick();
        pickview_time_left.setData(listLeft);
        pickview_time_right.setData(listRight);
        pickview_time_left.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(SelectedDataBean data) {
                leftSelect = data;
                MyPopTimePicker.this.leftCall.getRightSelectData(data);
            }
        });
        pickview_time_right.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(SelectedDataBean text) {
                rightSelected = text;
            }
        });
        leftSelect = listLeft.get(listLeft.size() / 2);
        rightSelected = listRight.get(listRight.size() / 2);
    }

    public void setLeftData(List<SelectedDataBean> list) {
        pickview_time_left.setData(list);
    }


    public void setRightData(List<SelectedDataBean> list) {
        pickview_time_right.setData(list);
        rightSelected = list.get(list.size() / 2);
    }

    private void setClick() {
        textView_right_pop_picker.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_right_pop_picker:
                SelectedDataBean selectedDataBean = new SelectedDataBean("1", leftSelect.getText() + "    " + rightSelected.getText());
                call.getRightSelectData(selectedDataBean);
                dismiss();
                break;
        }
    }


    public interface Pop_itemSelectListener {
        void getRightSelectData(SelectedDataBean selectedDataBean);
    }

    private void setAllView() {
        contentView = View.inflate(context, R.layout.pop_picker, null);
        relativeLayout_back_for_dismiss = (RelativeLayout) contentView.findViewById(R.id.relativeLayout_back_for_dismiss);
        textView_left_pop_picker = (TextView) contentView.findViewById(R.id.textView_left_pop_picker);
        textView_right_pop_picker = (TextView) contentView.findViewById(R.id.textView_right_pop_picker);
        pickview_time_left = (PickerView) contentView.findViewById(R.id.pickview_time_left);
        pickview_time_right = (PickerView) contentView.findViewById(R.id.pickview_time_right);
        setPop();
        showAtLocation(Gravity.CENTER, 0, 0);
        //设置一个空的监听事件，抢夺左侧的界面焦点

    }

    private void setPop() {
        //根据字数计算每个条目的长度
        popupWindow = new PopupWindow(contentView);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);

        relativeLayout_back_for_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }


    public void show() {
        showAtLocation(Gravity.CENTER, 0, 0);
    }

    public void dismiss() {
        popupWindow.dismiss();
    }

    public void showAtLocation(int gravity, int x, int y) {
        if (!popupWindow.isShowing()) {
            popupWindow.showAtLocation(contentView, gravity, x, y);
        }
    }


    public static MyPopTimePicker getDefultTimePicker(Context context, int leftLength,Pop_itemSelectListener pop_itemSelectListener) {

        List<SelectedDataBean> leftSelectedDatas = new ArrayList<>();

        for (int i = 0; i < leftLength; i++) {
            String date = TimeDataUtil.getTimeStamp(new Date().getTime() + i * 24 * 60 * 60 * 1000, "yyyy-MM-dd");
            SelectedDataBean selectedDataBean = new SelectedDataBean("" + i, date);
            if(i==0){
                selectedDataBean.setState(FIRST_TIME);
            }
            leftSelectedDatas.add(selectedDataBean);
        }
        List<SelectedDataBean> rightSelectedDatas = refreshRightDatas(true);

        MyPopTimePicker popTimePicker = new MyPopTimePicker(context);
        popTimePicker.setViewAndData(leftSelectedDatas, rightSelectedDatas, new MyPopTimePicker.Pop_itemSelectListener() {
            @Override
            public void getRightSelectData(SelectedDataBean selectedDataBean) {
                popTimePicker.rightSelected=selectedDataBean;
                if (selectedDataBean.getState()==FIRST_TIME) {
                    popTimePicker.setRightData(refreshRightDatas(true));
                } else {
                    popTimePicker.setRightData(refreshRightDatas(false));
                }
            }
        }, new Pop_itemSelectListener() {
            @Override
            public void getRightSelectData(SelectedDataBean selectedDataBean) {
                selectedDataBean.setText( popTimePicker.rightSelected.getText());
                pop_itemSelectListener.getRightSelectData(selectedDataBean);
            }
        });
        return popTimePicker;
    }
    public static SelectedDataBean getCurrentLeftSelect(MyPopTimePicker myPopTimePicker){
        return myPopTimePicker.leftSelect;
    }

    private static List<SelectedDataBean> refreshRightDatas(boolean isFirst) {
        String hour = TimeDataUtil.getTimeStamp(new Date().getTime(), "HH");
        List<SelectedDataBean> rightSelectedDatas = new ArrayList<>();
        String times[] = {"00:00-01:59", "02:00-03:59", "04:00-05:59", "06:00-07:59", "08:00-09:59", "10:00-11:59",
                "12:00-13:59", "14:00-15:59", "16:00-17:59", "18:00-19:59", "20:00-21:59", "22:00-23:59",};
        int position = 0;
        if (isFirst) {
            position = NumUtils.getInterger(hour) / 2;
        }
        for (int i = position; i < times.length; i++) {
            SelectedDataBean selectedDataBean = new SelectedDataBean("" + i, times[i]);
            rightSelectedDatas.add(selectedDataBean);
        }
        return rightSelectedDatas;
    }


}
