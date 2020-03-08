package client;

import entity.Tank;

import javax.persistence.*;
import java.util.Optional;

public class TankClient {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TankApi");

    public Optional<Tank> findTankByName(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        Optional<Tank> result = Optional.empty();

        try {
            et = em.getTransaction();
            et.begin();

            TypedQuery<Tank> query = em.createQuery("select t from Tank t where t.name=:name", Tank.class);
            query.setParameter("name", name);

            result = Optional.ofNullable(query.getSingleResult());

            et.commit();

        } catch (Exception e) {
            System.out.println("Find query unsuccessful.");
        } finally {
            em.close();
        }
        return result;
    }

    public String addTank(String name, String owner, String type) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        String createMessage = null;
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
            System.out.println("Create query unsuccessful.");
        } finally {
            em.close();
        }
        return createMessage;
    }

    public Tank updateTank(Tank tank) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;

        try {
            et = em.getTransaction();
            et.begin();

            em.merge(tank);

            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update query unsuccessful.");
        } finally {
            em.close();
        }

        return findTankByName(tank.getName()).get();
    }

    public String deleteTank(String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et;
        String deleteMessage = null;

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
            System.out.println("Delete query unsuccessful.");
        } finally {
            em.close();
        }
        return deleteMessage;
    }
}
