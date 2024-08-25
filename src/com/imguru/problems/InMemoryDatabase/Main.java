package com.imguru.problems.InMemoryDatabase;

public class Main {
    public static void main(String[] args) throws NoActiveTransactionException {
        InMemoryDatabaseSimulator db = new InMemoryDatabaseSimulator();

        db.begin();
        System.out.println(db.get("a"));
        System.out.println(db.count());
        db.set("a", "Hello A");
        db.begin();
        db.set("a", "Hello World");
        db.set("b", "Hello B");
        db.rollback();
        System.out.println(db.get("a"));
        System.out.println(db.get("b"));
        db.commit();
        System.out.println(db.count());
    }
}
