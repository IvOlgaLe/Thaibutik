package com.myapp.DAO;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CartServiceTest.class,
        OrderServiceTest.class,
        ProductServiceTest.class,
        UserServiceTest.class,
})
public class TestRunner {
    public static void main(String[] args) {

    }
}
