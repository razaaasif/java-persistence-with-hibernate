package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Actor;
import com.raza.entity.Address;
import com.raza.entity.Movie;
import com.raza.entity.Person;
import com.raza.util.HibernateUtils;

public class ManyToMany {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Actor actor1 = new Actor("Sallu Bhai");
			Actor actor2 = new Actor("Shahrukh Bhai");

			Movie movie1 = new Movie("INDIAN");

			Movie movie2 = new Movie("TIGER ZINDA HAI");

			movie1.getActors().add(actor1);
			movie2.getActors().add(actor2);
			session.persist(movie1);
			session.persist(movie2);
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
