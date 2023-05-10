package com.imguru.templatemethod;

import java.util.Date;

public class AuditTrail {


    public void log(){
        System.out.println("Audit executed :: " + new Date().getTime());
    }
}
