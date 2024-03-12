package org.app.ApiClients;

import org.app.data_base.Clients;
import org.app.data_base.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserActivityController {
    @Autowired
    private DataBase dataBase;

    private final static List<User> users = new ArrayList<>();

    @PostMapping("")
    public User addUser(@RequestBody User login) {
        dataBase.addUser(login.getLogin(), login.getPassword(), login.getToken());
        users.add(login);
        return login;
    }

    @GetMapping("")
    public List<Clients> getUsers() {
        return dataBase.getAllUserData();
    }

    @GetMapping("/{login}")
    public User getUserByUsername(@PathVariable("login") String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

//    @PutMapping("/{username}")
//    public Post update(@PathVariable("username") String username, @RequestBody Post post) {
//        users.stream().filter(user -> user.getUsername().equals(username)).findAny().ifPresent(user -> user.getPosts().add(post));
//        return post;
//    }

    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        users.stream().filter(user -> user.getLogin().equals(username)).findAny().ifPresent(users::remove);
        return "User with username: " + username + " has been deleted";
    }

}
