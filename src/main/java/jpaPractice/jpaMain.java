package jpaPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args) {
        // META-INF/persistence.xml -> <persistence-unit name="hello">
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager는 하나의 쓰레드에서 일회용으로만 사용해야 함
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = em.find(Member.class, 1000);
        member.setName("demian");
        tx.commit();

        em.close();
        emf.close();

    }
}
