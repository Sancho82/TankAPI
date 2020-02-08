package client;

import entity.Tank;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class TankClient {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TankApi");

    public Tank findTankByName() {
        return null;
    }

    public String addTank(String name, String owner, String type) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        String createMessage = "";
        Tank tank;
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
            createMessage = "Tank successfully created.";
            et.commit();

        } catch (RollbackException e) {
            createMessage = "Tank with given name already exists.";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return createMessage;
    }

    public String deleteTank(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        String deleteMessage = "";

        try {
            et = em.getTransaction();
            et.begin();

            TypedQuery<Tank> query = em.createQuery("select t from Tank t where t.name=:name", Tank.class);
            query.setParameter("name", name);

            Optional<Tank> result = Optional.ofNullable(query.getSingleResult());

            if (result.isPresent()) {
                deleteMessage = "Tank with given name successfully deleted.";
                em.remove(result.get());
            }

            et.commit();

        } catch (NoResultException nre) {
            deleteMessage = "Tank with given name doesn't exist.";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return deleteMessage;
    }
}
