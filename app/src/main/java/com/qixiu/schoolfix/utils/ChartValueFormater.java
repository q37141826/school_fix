package com.qixiu.schoolfix.utils;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ChartValueFormater implements IValueFormatter {
    private final String[] mLabels;

    public ChartValueFormater(String[] mLabels) {
        this.mLabels = mLabels;
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        try {
            String IValue = ((int) value)+"";
            return (IValue + "");
        } catch (Exception e) {
            return mLabels[0];
        }
    }
}
