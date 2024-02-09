package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Address;
import com.raza.entity.Friend;
import com.raza.entity.Person;
import com.raza.util.HibernateUtils;

public class CollectionMapping {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Friend f = new Friend("Aasif Raza", "aasifraza9123@gmail.com");
			f.getNickNames().add("Arjun");
			f.getNickNames().add("Gaurav");
			f.getNickNames().add("Sonu");
			session.persist(f);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
