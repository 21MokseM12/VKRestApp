package org.app.data_base;
import jakarta.persistence.*;
import org.app.data_base.entities.Clients;
import org.app.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBase {
    @Autowired
    private ClientsRepository repository;
    @Autowired
    @Qualifier("tokenGenerator")
    private PasswordEncoder encoder;
    public void addUser(Clients client) {
        client.setPassword(encoder.encode(client.getLogin() + ":" + client.getPassword()));
        repository.save(client);
    }
    public void deleteUser(String login) {
        repository.delete(repository.findByLogin(login).orElseThrow());
    }
//    public void addUser(String login, String password) {
//        if (!isUserExist(login)) {
//            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
//                EntityManager manager = factory.createEntityManager();
//                manager.getTransaction().begin();
//                Clients client = new Clients("user", login, password);
//                client = manager.merge(client);
//                manager.getTransaction().commit();
//            }
//        }
//    }
//    public void deleteUser(String login) {
//        if (isUserExist(login)) {
//            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
//                EntityManager manager = factory.createEntityManager();
//                manager.getTransaction().begin();
//                manager.createNamedQuery("Clients.deleteByLogin")
//                        .setParameter("login", login)
//                        .executeUpdate();
//                manager.getTransaction().commit();
//            }
//        }
////        else System.out.println("NO");
//    }
//    public String getUserData(String login) {
//        StringBuilder data = new StringBuilder();
//        if (isUserExist(login)) {
//            try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
//                EntityManager manager = factory.createEntityManager();
//                Clients client = manager.createNamedQuery("Clients.findByLogin", Clients.class).setParameter("login", login)
//                        .getSingleResult();
//                data.append(client.toString());
//            }
//        }
//        return data.toString();
//    }
//    public boolean isUserExist(String login) {
//        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")){
//            EntityManager manager = factory.createEntityManager();
//            try {
//                Clients client = manager.createNamedQuery("Clients.findByLogin", Clients.class).setParameter("login", login).getSingleResult();
//                return true;
//            } catch (NoResultException e) {
//                return false;
//            }
//        }
//    }
//    public List<Clients> getAllUserData() {
//        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("DataBaseUnit")) {
//            EntityManager manager = factory.createEntityManager();
//            return manager.createNamedQuery("Clients.findAllClients", Clients.class).getResultList();
//        }
//    }
}
