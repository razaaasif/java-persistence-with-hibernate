package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Department;
import com.raza.entity.User;
import com.raza.entity.UserId;
import com.raza.util.HibernateUtils;

public class MapsIdMain {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();

			User user = session.get(User.class, new UserId("John Doe", 1L));
			System.out.println(user.getUserId().getUsername());
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
