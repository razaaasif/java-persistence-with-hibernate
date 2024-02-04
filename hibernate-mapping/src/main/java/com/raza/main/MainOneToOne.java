package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Customer;
import com.raza.entity.Passport;
import com.raza.util.HibernateUtils;

public class MainOneToOne {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Passport passport = new Passport();
			Customer customer = new Customer("Aamir Raza 3", passport);
			session.persist(customer);

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
