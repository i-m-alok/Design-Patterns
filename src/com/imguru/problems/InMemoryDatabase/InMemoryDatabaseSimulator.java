package com.imguru.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NoActiveTransactionException extends Exception {

    NoActiveTransactionException(){
        super("No Active Transaction");
    }

}
public class InMemoryDatabaseSimulator {

    private Map<String, String> permanentStorage;
    private Stack<Map<String, String>> temporaryStorage;

    InMemoryDatabaseSimulator(){
        permanentStorage = new HashMap<>();
        temporaryStorage = new Stack<>();
    }

    public void begin(){
        temporaryStorage.push(new HashMap<>());
    }

    /**
     * Set or Save the value corresponding to key in DB if there is anu active transaction
     *
     * @param key the input string from which value(string) needs to save
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void set(String key, String value) throws NoActiveTransactionException{

        if(temporaryStorage.isEmpty()){
            throw new NoActiveTransactionException();
        }

        Map<String, String> currentTransaction = temporaryStorage.peek();
        currentTransaction.put(key, value);

    }

    /**
     * Fetches the value of input "key"
     *
     * @param key the input string to fetch the value of it from DB
     * @return value of the key or null
     */
    public String get(String key){

        for(int x = temporaryStorage.size()-1; x>=0; x--){
            Map<String, String> currentTransaction = temporaryStorage.get(x);
            if(currentTransaction.containsKey(key)){
                return currentTransaction.get(key);
            }
        }

        return permanentStorage.get(key);
    }

    /**
     * Commit all active transaction and save the changes to permanentStore
     *
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void commit() throws NoActiveTransactionException{
        if(temporaryStorage.isEmpty()){
            throw new NoActiveTransactionException();
        }

        for(int i=0; i<temporaryStorage.size(); i++){
            Map<String, String> currentTransaction = temporaryStorage.get(i);
            permanentStorage.putAll(currentTransaction);
        }
        temporaryStorage  = new Stack<>();
    }

    /**
     * Count all the keys which are permanently store in DB
     * This method can be called outside transaction
     *
     * @return count(integer) of all the keys that are permanently stored in DB
     */
    public Integer count(){
        return permanentStorage.size();
    }

    /**
     * Rollback the transaction if any exception occurs
     *
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void rollback() throws NoActiveTransactionException{
        if(temporaryStorage.isEmpty()){
            throw new NoActiveTransactionException();
        }
    }
}
