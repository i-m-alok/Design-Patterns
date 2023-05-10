package com.imguru.templatemethod;

import java.util.Date;

public class GenerateReportTask extends Task{
    @Override
    protected void doExecute() {
        System.out.println("Generate Report Executed :: "+ new Date().getTime());
    }
}
