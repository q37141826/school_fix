package com.qixiu.schoolfix.ui.acitivty.work_flow.sign;

public class TimeAddressBean {

    int minutus;
    String time;
    String address;
    private boolean btnVisble = false;
    String btnText;
    String titleText;

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public boolean isBtnVisble() {
        return btnVisble;
    }

    public void setBtnVisble(boolean btnVisble) {
        this.btnVisble = btnVisble;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public int getMinutus() {
        return minutus;
    }

    public void setMinutus(int minutus) {
        this.minutus = minutus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}