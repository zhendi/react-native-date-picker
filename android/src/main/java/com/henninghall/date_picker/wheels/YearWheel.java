package com.henninghall.date_picker.wheels;

import com.henninghall.date_picker.Mode;
import com.henninghall.date_picker.PickerView;

import java.util.Calendar;

public class YearWheel extends Wheel
{
    private int defaultStartYear;
    private int defaultEndYear;

    public YearWheel(final PickerView pickerView, final int id) {
        super(pickerView, id);
        this.defaultStartYear = 0;
        this.defaultEndYear = 2100;
    }

    @Override
    void init() {
        final int startYear = getStartYear();
        final int endYear = getEndYear() ;

        for (int i = startYear; i <= endYear; ++i) {
            values.add(String.valueOf(i));
            displayValues.add(String.valueOf(i));
        }

        picker.setDisplayedValues(displayValues.toArray(new String[0]));
        picker.setMinValue(startYear);
        picker.setMaxValue(endYear);
    }

    private int getEndYear() {
        if (this.pickerView.maxDate == null) {
            return this.defaultEndYear;
        }
        final Calendar cal = Calendar.getInstance();
        cal.setTime(this.pickerView.maxDate);
        return cal.get(Calendar.YEAR);
    }

    private int getStartYear() {
        if (this.pickerView.minDate != null) {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(this.pickerView.minDate);
            return cal.get(1);
        }
        return this.defaultStartYear;
    }

    @Override
    public boolean visible() {
        return this.pickerView.mode == Mode.date;
    }

    public String getFormatTemplate() {
        return "y";
    }
}

