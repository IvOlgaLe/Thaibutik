package com.myapp.DAO;

import com.myapp.utils.DbPopulator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

@ContextConfiguration({
        "classpath:spring-app.xml",
        "classpath:spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTestClass {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private DbPopulator dbPopulator;

    private static boolean dataLoaded = false;

    @Before
    public void setUp() throws Exception {
        if(!dataLoaded) {
            dbPopulator.execute();
            dataLoaded = true;
        }
    }

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testCRUD(){
        //-----save------

        //-----getById-------

        //-----update-----

        //-----getAll-----

        //-----delete-----
    }
}
