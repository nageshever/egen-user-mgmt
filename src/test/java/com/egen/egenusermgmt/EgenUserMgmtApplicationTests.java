package com.egen.egenusermgmt;

import com.egen.egenusermgmt.entity.User;
import com.egen.egenusermgmt.service.UserService;

import static org.mockito.BDDMockito.given;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.juli.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = UserController.class, secure = false)
@SpringBootTest
public class EgenUserMgmtApplicationTests {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

 /*  @TestConfiguration
    public static class UserServiceTestConfig {
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }*/

  /*  @Autowired
    private MockMvc mockMvc;*/

    @Autowired
    UserService userService;

    @Before
    public void setup() {

    }

    @Test
    public void testCreateUsers() throws Exception {
        //Test to see mandatory fields are given and JPA saves those users
        User user1 = new User("Nagesh", "Lakinepally", (short) 37, "M", "9196388454");
        User user2 = new User("Sudheera", "Lakinepally", (short) 32, "F", "9192750155");
        userService.createUser(user1);
        userService.createUser(user2);
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }
    @Test
    public void testNullUserFirstName() throws Exception {
        //Now Given null firstname, should not create, still the number of records remain same
        User user3 = new User(null,"Lakinepally",(short)32, "F", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testNonAlphaFirstName() throws Exception {
        //Now Given null lastName, should not create, still the number of records remain same
        User user3 = new User("123","Lakinepally",(short)32, "F", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testNullUserLastName() throws Exception {
        //Now Given null firstname, should not create, still the number of records remain same
        User user3 = new User("Sudheera",null,(short)32, "F", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testNonAlphaLastName() throws Exception {
        //Now Given null lastName, should not create, still the number of records remain same
        User user3 = new User("Sudheera","123",(short)32, "F", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testNegativeAge() throws Exception {
        //Now Given -ve age, should not create, still the number of records remain same
        User user3 = new User("Subbarao","Chicago",(short)-1, "M", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testOtherGender() throws Exception {
        //Now Given non M/F gender, should not create, still the number of records remain same
        User user3 = new User("Subbarao","Chicago",(short)32, "X", "9192750155");
        List<User> userList;
        userList = userService.getAllUsers();
        //Check whether 2 users created are saved to database
        assertEquals(userList.size(), 2);
    }

    @Test
    public void testGetAllUsers() throws Exception{
        //Then retreive those users to see the count.
        List<User> userList;
        userList = userService.getAllUsers();
        assertEquals(userList.size(), 2);
    }

}
