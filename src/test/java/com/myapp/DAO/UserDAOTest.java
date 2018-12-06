package com.myapp.DAO;

import com.myapp.util.DbPopulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({
        "classpath:spring-app.xml",
        "classpath:spring-db.xml"
})
//@RunWith(Arquillian.class)
public class UserDAOTest {
/*    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

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
