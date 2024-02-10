package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Address;
import com.raza.entity.Child;
import com.raza.entity.Parent;
import com.raza.entity.ParentPrimaryKey;
import com.raza.entity.Person;
import com.raza.util.HibernateUtils;

public class ParentChild {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			ParentPrimaryKey pk = new ParentPrimaryKey("Aasif", "Raza");
			Parent p = new Parent(pk);
			p.addChild(new Child("Aasif"));
			p.addChild(new Child("Sifan"));
			session.persist(p);
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
