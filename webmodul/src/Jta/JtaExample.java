//package Jta;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class JtaExample {
//    public static void main(String[] args) throws InterruptedException{
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory();
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Student("Max"));
//        entityManager.persist(new Book("Max"));
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//        entityManagerFactory.close();
//    }
//}
