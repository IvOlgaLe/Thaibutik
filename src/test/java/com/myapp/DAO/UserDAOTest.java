package com.myapp.DAO;

import com.myapp.model.Role;
import com.myapp.model.User;
import com.myapp.service.UserService;
import com.myapp.util.DbPopulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@ContextConfiguration({
        "classpath:spring-app.xml",
        "classpath:spring-db.xml"
})

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
/*    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    @Autowired
    private UserService userService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
 //       dbPopulator.execute();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaveUser() {
        User userExp = new User("Emma Save", "emma@gmail.com", "110", 3, "65 Central St, Brooklyn, NY, 11256", "212-159-2516", null);
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
