package raza.aasif;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import raza.aasif.model.Message;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Message msg = new Message();
		msg.setText("Hello!");
		System.out.println(msg.getText());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		em.persist(msg);
		tx.commit();
		// INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')
		em.close();
	}
}
