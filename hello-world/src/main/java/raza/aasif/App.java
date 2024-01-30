package raza.aasif;

import org.hibernate.Session;
import org.hibernate.Transaction;

import raza.aasif.model.Message;
import raza.aasif.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.getTransaction();

//		Message message = new Message();
//		message.setText("Haha");
//		session.save(message);
//		session.getTransaction().commit();
//		System.out.println(message);

		try {
			tx.begin();
			Message m = session.get(Message.class, 2L);
			System.out.println(m);
			session.delete(m);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
}
