package com.training.lfallon.androidmath.model;

import com.training.lfallon.androidmath.exception.InputException;

public class PercentageInput {

    public static final String INPUT_EXCEPTION_MESSAGE = "Please enter a percentage between 0 and 100, and a positive number";

    private Double percentage;

    private Double number;

    public PercentageInput(){}

    public PercentageInput(Double percentage, Double number){
        this.percentage = percentage;
        this.number = number;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double calculatePercentage(){
        return number * percentage / 100;
    }

    public void validate() throws InputException {
        if(percentage < 0 || percentage > 100 || number < 0){
            throw new InputException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
