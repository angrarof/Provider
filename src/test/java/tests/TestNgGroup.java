package tests;

import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.IOException;

public class TestNgGroup {

    @Test(groups = {"regression"}, enabled = true, priority = 1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(enabled = false)
    public void test2() throws IOException {
        System.out.println("Test 2");
    }

    @Test(groups = {"smoke"}, enabled = false)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(enabled = false)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(groups = {"uat"}, enabled = false)
    public void test5(){
        System.out.println("Test 5");
    }
}
