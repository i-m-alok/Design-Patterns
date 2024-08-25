package com.imguru.problems.InMemoryDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InMemoryDatabaseSimulator {

    private final Map<String, String> permanentStore;
    private final Stack<Map<String, String>> transactionStack;

    InMemoryDatabaseSimulator(){
        permanentStore = new HashMap<>();
        transactionStack = new Stack<>();
    }

    public void begin(){
        transactionStack.push(new HashMap<>());
    }

    /**
     * Set or Save the value corresponding to key in DB if there is anu active transaction
     *
     * @param key the input string from which value(string) needs to save
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void set(String key, String value) throws NoActiveTransactionException{

        if(transactionStack.isEmpty()){
            throw new NoActiveTransactionException();
        }

        Map<String, String> currentTransaction = transactionStack.peek();
        currentTransaction.put(key, value);

    }

    /**
     * Fetches the value of input "key"
     *
     * @param key the input string to fetch the value of it from DB
     * @return value of the key or null
     */
    public String get(String key){

        for(int x = transactionStack.size()-1; x>=0; x--){
            Map<String, String> currentTransaction = transactionStack.get(x);
            if(currentTransaction.containsKey(key)){
                return currentTransaction.get(key);
            }
        }

        return permanentStore.get(key);
    }

    /**
     * Commit all active transaction and save the changes to permanentStore
     *
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void commit() throws NoActiveTransactionException{
        if(transactionStack.isEmpty()){
            throw new NoActiveTransactionException();
        }

        for(int i=0; i<transactionStack.size(); i++){
            Map<String, String> currentTransaction = transactionStack.get(i);
            permanentStore.putAll(currentTransaction);
        }
        transactionStack.clear();
    }

    /**
     * Count all the keys which are permanently store in DB
     * This method can be called outside transaction
     *
     * @return count(integer) of all the keys that are permanently stored in DB
     */
    public Integer count(){
        return permanentStore.size();
    }

    /**
     * Rollback the transaction if any exception occurs
     *
     * @throws NoActiveTransactionException if it is invoked when there is no currently active transaction
     */
    public void rollback() throws NoActiveTransactionException{
        if(transactionStack.isEmpty()){
            throw new NoActiveTransactionException();
        }
        transactionStack.pop();
    }
}
