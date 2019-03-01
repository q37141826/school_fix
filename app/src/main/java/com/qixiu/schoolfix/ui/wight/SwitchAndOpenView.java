package com.qixiu.schoolfix.ui.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qixiu.schoolfix.R;

public class SwitchAndOpenView extends RelativeLayout implements View.OnClickListener {
    Context context;
    private Button switchButton;

    boolean isOpened = true;//开关是否开着
    boolean isAlwaysClosed = false;//永远隐藏和显示
    boolean changeShow = true;//有的时候翻转到另外一边才显示

    private TextView textViewTilte;
    private TextView textViewResovleTitle;
    private LinearLayout linearLayout;
    private EditText editTextResolve;

    public void setSwitchListener(SwitchListener switchListener) {
        this.switchListener = switchListener;
    }

    SwitchListener switchListener;


    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;

    }

    public SwitchAndOpenView(Context context) {
        super(context);
        this.context = context;
    }

    public SwitchAndOpenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = View.inflate(context, R.layout.switch_and_open_view, this);
        initView(view);
        initListenner();
        //增加xml里面的可编辑属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SwitchAndOpen);
        String textTitle = array.getString(R.styleable.SwitchAndOpen_textTitle);
        setTitle(textTitle);
        String textResolve = array.getString(R.styleable.SwitchAndOpen_textResovleTitle);
        setResolveText(textResolve);
        String textHint = array.getString(R.styleable.SwitchAndOpen_edittext_hint);
        setResolveHint(textHint);
        changeShow=array.getBoolean(R.styleable.SwitchAndOpen_changeShow,true);
        isShow(changeShow ? !isOpened : isOpened);
        array.recycle();
    }

    private void setResolveHint(String textHint) {
        editTextResolve.setHint(textHint);
    }

    public void setResolveText(String textResolve) {
        textViewResovleTitle.setText(textResolve);
    }

    public void setTitle(String textTitle) {
        textViewTilte.setText(textTitle);
    }

    private void initListenner() {
        switchButton.setOnClickListener(this);
    }

    private void initView(View view) {
        switchButton = view.findViewById(R.id.switchButton);
        textViewTilte = view.findViewById(R.id.textViewTilte);
        textViewResovleTitle = view.findViewById(R.id.textViewResovleTitle);
        linearLayout = view.findViewById(R.id.linearLayout);
        editTextResolve = view.findViewById(R.id.edttextResolve);
        switchButton.setBackgroundResource(R.drawable.switch_yes);
    }


    @Override
    public void onClick(View v) {
        isOpened = !isOpened;
        switchButton.setBackgroundResource(isOpened ? R.drawable.switch_yes : R.drawable.switch_no);
        if (switchListener != null) {
            switchListener.isOpen(isOpened);
        }
        isShow(changeShow ? !isOpened : isOpened);
    }

    public void isShow(boolean isShow) {
        linearLayout.setVisibility(isShow && !isAlwaysClosed ? View.VISIBLE : View.GONE);
    }

    public void setOpenVisble(int visibility) {
        linearLayout.setVisibility(visibility);
    }


    public interface SwitchListener {
        void isOpen(boolean isOpen);
    }

    public CharSequence getTitile(){
        return textViewTilte.getText();
    }
    public CharSequence getTitileResolve(){
        return textViewResovleTitle.getText();
    }
    public CharSequence getInput(){
        return editTextResolve.getText();
    }

    public TextView getTitleView(){
        return  textViewTilte;
    }
    public TextView getTitleResovleView(){
        return  textViewResovleTitle;
    }
    public EditText getInputEdittext(){
        return  editTextResolve;
    }
}
