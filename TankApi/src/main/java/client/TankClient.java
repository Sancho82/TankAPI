package client;

import entity.Tank;

import javax.persistence.*;
import java.util.List;

public class TankClient {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TankApi");

    public Tank addTank(String name, String owner, String type) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        Tank tank = null;
        Long lastId;

        try {
            et = em.getTransaction();
            et.begin();

            lastId = (Long) (em.createQuery("select max(tankId) from Tank").getResultList().get(0));

            tank = new Tank()
                    .setTankId(++lastId)
                    .setName(name)
                    .setOwner(owner)
                    .setType(type);

            em.persist(tank);
            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return tank;
    }

    public void deleteTank(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;

        try {
            et = em.getTransaction();
            et.begin();

            TypedQuery<Tank> query = em.createQuery("select t from Tank t where t.name=:name", Tank.class);
            query.setParameter("name", name);

            List<Tank> resultList = query.getResultList();

            if (resultList.size() > 0) {
                for(Tank tank : resultList) {
                    if (tank.getName().equals(name)) em.remove(tank);
                }
            } else System.out.println("Tank with given name doesn't exists.");

            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
