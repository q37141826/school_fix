package com.qixiu.schoolfix.ui.fragment.home;

/**
 * Created by my on 2018/11/14.
 */

public class HomeGotoBean {
    private String unDo="";
    private String name;
    private int image;
    private Class gotoActivity;
    private int action;
    private boolean num_visble=false;


    public boolean isNum_visble() {
        return num_visble;
    }

    public void setNum_visble(boolean num_visble) {
        this.num_visble = num_visble;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getUnDo() {
        return unDo;
    }

    public void setUnDo(String unDo) {
        this.unDo = unDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Class getGotoActivity() {
        return gotoActivity;
    }

    public void setGotoActivity(Class gotoActivity) {
        this.gotoActivity = gotoActivity;
    }
}
