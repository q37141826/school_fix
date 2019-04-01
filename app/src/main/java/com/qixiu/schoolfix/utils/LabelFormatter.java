package com.qixiu.schoolfix.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class LabelFormatter implements IAxisValueFormatter {
    private final String[] mLabels;
    public LabelFormatter(String[] labels) {
        mLabels = labels;
    }
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        try {
            return mLabels[(int) value];
        } catch (Exception e) {
            e.printStackTrace();
            return mLabels[0];
        }
    }
}
