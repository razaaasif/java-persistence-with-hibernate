package com.raza.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raza.entity.Guide;
import com.raza.entity.Student;
import com.raza.util.HibernateUtils;

public class MainOneToMany {
    public static void main(String[] args) {
        final Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();

//            Student student1 = new Student(null, "CS-17-01", "Aamir Raza");
//            Student student2 = new Student(null, "CS-17-02", "Aasif Raza");
//
////            // guide object
//            Guide guide = new Guide(null, "Ramesh The Guide", "Guide-01", 100000);
//
//            guide.addStudent(student1);
//            guide.addStudent(student2);
            
            Student toDelete = session.get(Student.class,3L);
            session.delete(toDelete);
//            session.persist(guide);
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
