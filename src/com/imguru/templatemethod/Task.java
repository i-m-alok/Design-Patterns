package com.imguru.templatemethod;

public abstract class Task {

    private AuditTrail auditTrail;

    public Task() {
        this.auditTrail = new AuditTrail();
    }

    public void execute(){
        auditTrail.log();
        doExecute();
    }
    protected abstract void doExecute();
}
