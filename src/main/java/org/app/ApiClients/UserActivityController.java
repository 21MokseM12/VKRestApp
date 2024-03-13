package org.app.ApiClients;

import org.app.data_base.Clients;
import org.app.data_base.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserActivityController {
    @Autowired
    private DataBase dataBase;

    @PostMapping("/registration")
    public User addUser(@RequestBody User login) {
        dataBase.addUser(login.getLogin(), login.getToken());
        return login;
    }

    @GetMapping("")
    public List<Clients> getUsers() {
        return dataBase.getAllUserData();
    }

    @GetMapping("/{login}")
    public String getUserByUsername(@PathVariable("login") String login) {
        return dataBase.getUserData(login);
    }

//    @PutMapping("/{username}")
//    public Post update(@PathVariable("username") String username, @RequestBody Post post) {
//        users.stream().filter(user -> user.getUsername().equals(username)).findAny().ifPresent(user -> user.getPosts().add(post));
//        return post;
//    }

    @DeleteMapping("/{login}")
    public String deleteUser(@PathVariable("login") String login) {
        dataBase.deleteUser(login);
        return "User with username: " + login + " has been deleted";
    }

}
