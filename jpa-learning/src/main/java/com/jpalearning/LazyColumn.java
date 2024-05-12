package com.jpalearning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpalearning.entity.Post;

public class LazyColumn {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {

			transaction.begin();
			Post post = entityManager.find(Post.class, 2l);
			System.out.println(post.getTitle());
			//fetching lazy data
			System.out.println(post.getPostedOn());
			transaction.commit();
			emf.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
	}

}
