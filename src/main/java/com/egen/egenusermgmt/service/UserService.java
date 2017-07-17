package com.egen.egenusermgmt.service;

import com.egen.egenusermgmt.entity.User;
import com.egen.egenusermgmt.repos.UserRespository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.UUID;

/**
 * Created by lakinep on 7/16/17.
 */
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRespository userRespository;

    public List<User> getAllUsers() {
        return userRespository.findAll();
    }

    public void createUser(User user) {
      if (!userRespository.exists(user.getId())) {
          log.info(">>>>>>User Not Exists in the repository, Hence saving", user.toString());
          userRespository.save(user);
      }
    }

    public void updateUser(User user, UUID id) {
        if (userRespository.exists(id)) {
            log.info(user.toString());
            userRespository.save(user);
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "User Not Found!");
        }
    }

    private User getUser(UUID id) {
        User user = userRespository.getOne(id);
        if (user!=null) {
            user.toString();
        }
        return user;
    }
}
