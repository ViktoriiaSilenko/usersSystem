package com.spring.series.jdbc.controller;

import com.spring.series.jdbc.model.User;
import com.spring.series.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        List<User> users = userService.getAllUsers();

        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>() {}.getType();
        String json = gson.toJson(users, type);

        return json;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        Gson gson = new Gson();
        String json = gson.toJson(user);

        return json;
    }

    @RequestMapping(value= "/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        return userService.insertNewUser(user);

    }


}
