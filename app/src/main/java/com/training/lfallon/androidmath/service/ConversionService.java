package com.training.lfallon.androidmath.service;

import android.widget.EditText;

import com.training.lfallon.androidmath.exception.InputException;

public class ConversionService {

    private static ConversionService instance;

    private ConversionService(){}

    public static ConversionService getInstance(){
        if(instance == null){
            instance = new ConversionService();
        }
        return instance;
    }

    public Double numberFromEditText(EditText editText) throws InputException {
        try{
            return Double.parseDouble(editText.getText().toString());
        } catch(NumberFormatException e) {
            throw new InputException("Please enter two valid numbers");
        }
    }

}
