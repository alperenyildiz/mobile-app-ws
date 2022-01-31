package com.aula.app.ws.ui.controller;


import com.aula.app.ws.exceptions.UserServiceException;
import com.aula.app.ws.ui.model.request.UpdateUserDetailRequestModel;
import com.aula.app.ws.ui.model.request.UserDetailsRequestModel;
import com.aula.app.ws.ui.model.response.UserRest;
import com.aula.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    Map<String, UserRest> users;

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit") int limit) {
        return "get user was called with page: " + page + " limit : " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if (true) throw new UserServiceException("UserServiceException is thrown");

        if (users.containsKey(userId))
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {

        UserRest returnValue = userService.createUser(userDetailsRequestModel);
        if (users == null) users = new HashMap<>();
        users.put(returnValue.getUserId(), returnValue);

        return new ResponseEntity(returnValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailRequestModel updateUserDetailRequestModel) {

        UserRest storedUser = users.get(userId);

        storedUser.setFirstName(updateUserDetailRequestModel.getFirstName());
        storedUser.setLastName(updateUserDetailRequestModel.getLastName());

        users.put(userId, storedUser);

        return storedUser;

    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

        if (users.remove(userId) != null)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.noContent().build();


    }
}
