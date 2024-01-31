package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Address;
import com.raza.entity.Person;
import com.raza.util.HibernateUtils;

public class Main {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Address shipping = new Address("Raza Muhallah", "Sitamarhi", "843330");
			Address billing = new Address("Dhauj", "Faridabad", "121004");

			Person person = new Person("Aasif", shipping, billing);
			// return the identifier
			session.save(person);

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
