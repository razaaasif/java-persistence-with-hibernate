package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.common.Constants.EmployeeType;
import com.raza.entity.Address;
import com.raza.entity.Employee;
import com.raza.entity.Person;
import com.raza.util.HibernateUtils;

public class Enum {
	public static void main(String[] args) {
		final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			Employee employee = new Employee("Aasif Raza" , EmployeeType.FULL_TIME);
			session.persist(employee);
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
