package test.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGExample {

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.out.println("Before method");
    }

    @Test(groups = { "include-test-one" })
    public void testMethodOne() {
        System.out.println("Test method one");
    }

    @Test(groups = { "include-test-two" })
    public void testMethodTwo() {
        System.out.println("Test method two");
    }

    @Test(groups = { "test-one-exclude" })
    public void testMethodThree() {
        System.out.println("Test method three");
    }

    @Test(groups = { "test-two-exclude" })
    public void testMethodFour() {
        System.out.println("Test method Four");
    }
}
