package tests;

import org.testng.annotations.Test;

public class TestNgGroup {

    @Test(groups = {"regression"})
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(groups = {"smoke"})
    public void test3(){
        System.out.println("Test 3");
    }

    @Test
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(groups = {"uat"})
    public void test5(){
        System.out.println("Test 5");
    }
}
