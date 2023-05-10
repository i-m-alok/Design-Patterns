package com.imguru.templatemethod;

public class Main {

    public static void main(String[] args) {

        Task generateReport = new GenerateReportTask();
        TransferMoneyTask transferMoney = new TransferMoneyTask();

        transferMoney.execute();
    }
}
