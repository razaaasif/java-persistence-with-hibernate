package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.util.HibernateUtils;

public class Main {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
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
