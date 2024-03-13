package org.app.data_base;

import jakarta.persistence.*;

import java.util.Objects;

@NamedQuery(
        name = "Clients.findByLogin",
        query = "select c from Clients c where  c.login=:login"
)
@NamedQuery(
        name = "Clients.deleteByLogin",
        query = "delete from Clients c where c.login=:login"
)
@NamedQuery(
        name = "Clients.findMaxId",
        query = "select max(c.id) from Clients c"
)
@NamedQuery(
        name = "Clients.findAllClients",
        query = "select c from Clients c"
)
@Entity
public class Clients {
    @Basic
    @Column(name = "role", nullable = false, length = 20)
    private String role;
    @Basic
    @Id
    @Column(name = "login", nullable = false, length = 200)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 254)
    private String password;

    public Clients(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }
    public Clients() {}
    public Clients(String role, String login, String password, String token) {
        this.role = role;
        this.login = login;
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(role, clients.role) && Objects.equals(login, clients.login) && Objects.equals(password, clients.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, login, password);
    }

    @Override
    public String toString() {return "Clients [role: " + this.role + ", login: " + this.login +
            ", password: " + this.password + "]";}
}
