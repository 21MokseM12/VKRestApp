package org.app.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.app.data_base.entities.Clients;
import org.app.data_base.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserActivityController {

    @Autowired
    private DataBase dataBase;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/registration")
    public User addUser(@RequestBody User login) {
        dataBase.addUser(new Clients("ROLE_POSTS", login.getLogin(), login.getPassword()));
        return login;
    }

//    @GetMapping("/allClients")
//    public List<Clients> getUsers() {
//        return dataBase.getAllUserData();
//    }
//
//    @GetMapping("/client/{login}")
//    public String getUserByUsername(@PathVariable("login") String login) {
//        return dataBase.getUserData(login);
//    }
//

    @GetMapping("/")
    public ResponseEntity<String> proxyRequest1(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @GetMapping("/posts/{url}**")
    @PreAuthorize("hasAuthority('ROLE_POSTS')")
    public ResponseEntity<String> proxyRequest2(@PathVariable String url) {
        try {
            String targetUrl = "https://jsonplaceholder.typicode.com/posts/" + url;
            System.out.println(targetUrl);
            ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @GetMapping("/example/**")
//    public String handleRequest(HttpServletRequest request) {
//        String remainingPath = (String) request.getAttribute(
//                RequestDispatcher.FORWARD_REQUEST_URI);
//        // обработка remainingPath
//        return "Remaining part of the URL: " + remainingPath;
//    }

    @GetMapping("/albums/{url}")
    public ResponseEntity<String> proxyRequest3(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/albums/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
    }

    @GetMapping("/users/{url}")
    public ResponseEntity<String> proxyRequest4(@PathVariable("url") String url) {
        String targetUrl = "https://jsonplaceholder.typicode.com/users/" + url;
        ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
        return response;
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
