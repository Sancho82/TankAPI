package client;

import entity.Tank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TankClient {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TankApi");

    public Tank addTank() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        Tank tank = null;
        Long lastId;

        try {
            et = em.getTransaction();
            et.begin();

            lastId = (Long) (em.createQuery("SELECT MAX(Id) FROM Tank").getResultList().get(0));

            tank = new Tank()
                    .setId(++lastId)
                    .setName("Piranha")
                    .setOwner("Szani")
                    .setType("M48 Patton");

            if (em.find(Tank.class, tank.getId()) == null) em.persist(tank);
            else System.out.println("Tank with given Id already exists.");

            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tank;
    }
}
