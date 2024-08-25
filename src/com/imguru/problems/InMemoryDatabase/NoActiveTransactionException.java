package com.imguru.problems.InMemoryDatabase;

class NoActiveTransactionException extends Exception {

    NoActiveTransactionException() {
        super("No Active Transaction");
    }

}
