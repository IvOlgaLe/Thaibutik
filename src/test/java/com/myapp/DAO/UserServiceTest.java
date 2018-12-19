package com.myapp.DAO;

import com.myapp.model.Role;
import com.myapp.model.User;
import com.myapp.service.UserService;
import com.myapp.util.DbPopulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({
        "classpath:resources/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveUser() {
        User userExp = new User("Emma Save", "emma@gmail.com", "110", new Role(1, "ROLE_USER"), "65 Central St, Brooklyn, NY, 11256", "212-159-2516", null);
        User userAct = userService.saveUser(userExp);
        assert (userAct.equals(userExp));
    }

    @Test
    public void testUpdateUser() {
    }

    @Test
    public void testDeleteUserById() {
    }

    @Test
    public void testGetUserById() {
    }

    @Test
    public void testGetUserByEmail() {
    }

    @Test
    public void testGetUsersByParam() {
    }

    @Test
    public void testGetAllUsers() {
    }
}
