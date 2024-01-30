package main;

import javax.management.Query;
import javax.persistence.EntityManager;

import com.raza.entity.Item;
import com.raza.entity.advanced.ItemBidSummary;
import com.raza.persistence.utils.JpaDao;

public class Main {
	public static void main(String[] args) {
		EntityManager em = JpaDao.getEntityManager();
		Item it = new Item();
		it.setName("Test");
		em.persist(it);
		em.flush();
		Item item = em.find(Item.class, Long.valueOf(1));
		item.setName("New name");
		// ItemBidSummary itemBidSummary = em.find(ItemBidSummary.class, ITEM_ID);
		javax.persistence.Query query = em.createQuery("SELECT ibs FROM ItemBidSummary ibs WHERE ibs.itemId = :id");
		ItemBidSummary itemBidSummary = (ItemBidSummary) query.setParameter("id", "itemId").getSingleResult();

	}
}
