package com.imguru.templatemethod;

import java.util.Date;

public class TransferMoneyTask extends Task{

    @Override
    protected void doExecute(){
        System.out.println("Trasfer Money Executed :: "+ new Date().getTime());
    }
}
