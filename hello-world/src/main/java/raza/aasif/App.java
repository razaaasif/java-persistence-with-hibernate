package raza.aasif;

import org.hibernate.Session;
import org.hibernate.Transaction;

import raza.aasif.model.Message;
import raza.aasif.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Message message = new Message();
		message.setText("Haha");
		Transaction tr = session.getTransaction();
		tr.begin();
		session.persist(message);
		tr.commit();
		session.close();
		System.out.println(message);
	}
}
