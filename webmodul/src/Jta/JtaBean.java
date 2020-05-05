package Jta;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JtaBean {
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    SessionContext sessionContext;
    public void saveStudent(){
        entityManager.persist(new Student("Max"));
        sessionContext.setRollbackOnly();
    }
}
