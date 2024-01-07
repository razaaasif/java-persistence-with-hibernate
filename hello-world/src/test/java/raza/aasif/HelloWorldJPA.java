package raza.aasif;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;

import raza.aasif.model.Message;
import raza.aasif.utils.JpaUtils;

public class HelloWorldJPA {
	@Test
	public void insertMessage() {
		Message msg = new Message();
		msg.setText("Hello!");
		EntityManager em = JpaUtils.getEntityManager();
		JpaUtils.beginTransaction();
		em.persist(msg);
		JpaUtils.commitTransaction();
	}

	@Test
	public void checkMessage() {

		Message msgList = JpaUtils.getEntityManager().find(Message.class, Long.valueOf(1));
		assertEquals(msgList.getId(), Long.valueOf(1));
		assertEquals(msgList.getText(), "Hello!");
	}
}