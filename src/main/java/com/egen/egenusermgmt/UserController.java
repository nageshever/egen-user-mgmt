package com.egen.egenusermgmt;

import com.egen.egenusermgmt.entity.User;
import com.egen.egenusermgmt.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.awt.*;
import java.util.List;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by lakinep on 7/16/17.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping (value = "/api/user/",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {
        log.debug(user.toString());
        userService.createUser(user);
    }

    @RequestMapping (value = "/api/user/get/",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping (value="/api/user/update/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user, @PathVariable UUID id) {
        userService.updateUser(user, id);
    }
}
