package org.app.data_base;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class DataBase {
    private static DataBase dataBase;
    public static synchronized DataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }

        return dataBase;
    }

    private DataBase() {}
    public void addUser(String login, String password, String token) {
        if (!isUserExist(login)) {
            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
                EntityManager manager = factory.createEntityManager();
                manager.getTransaction().begin();
                Clients client = new Clients("user", login, password, token);
                client = manager.merge(client);
                manager.getTransaction().commit();
            }
        }
    }
    public void deleteUser(String login) {
        if (isUserExist(login)) {
            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
                EntityManager manager = factory.createEntityManager();
                manager.getTransaction().begin();
                manager.createNamedQuery("Clients.deleteByLogin")
                        .setParameter("login", login)
                        .executeUpdate();
                manager.getTransaction().commit();
            }
        }
//        else System.out.println("NO");
    }
    public String getUserData(String login) {
        StringBuilder data = new StringBuilder();
        if (isUserExist(login)) {
            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
                EntityManager manager = factory.createEntityManager();
                Clients client = manager.createNamedQuery("Clients.findByLogin", Clients.class).setParameter("login", login)
                        .getSingleResult();
                data.append(client.toString());
            }
        }
        return data.toString();
    }
    private boolean isUserExist(String login) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")){
            EntityManager manager = factory.createEntityManager();
            try {
                Clients client = manager.createNamedQuery("Clients.findByLogin", Clients.class).setParameter("login", login).getSingleResult();
                return true;
            } catch (NoResultException e) {
                return false;
            }
        }
    }
}
