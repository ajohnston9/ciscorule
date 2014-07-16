/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.johnstonconsulting.ciscoruletool.utils;

/**
 *
 * @author andrew
 */
public class Rule {
    
    private String mOption;
    private String mValue;
    
    public Rule(String param, String arg) {
        mOption = param;
        mValue  = arg;
    }

    public String getParam() {
        return mOption;
    }

    public void setParam(String mOption) {
        this.mOption = mOption;
    }

    public String getArg() {
        return mValue;
    }

    public void setArg(String mValue) {
        this.mValue = mValue;
    }
    
    
}
