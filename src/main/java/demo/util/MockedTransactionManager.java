package demo.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jim
 */
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class MockedTransactionManager extends AbstractPlatformTransactionManager {

    Logger logger = Logger.getLogger(MockedTransactionManager.class.getName());
    @Override
    protected Object doGetTransaction() throws TransactionException {
        return UUID.randomUUID().toString();
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
        logger.info("beginning " + (String)transaction );
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
        logger.info("committing " + status.getTransaction());
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
         logger.info("rollback " + status.getTransaction());
    }
    
   
}
