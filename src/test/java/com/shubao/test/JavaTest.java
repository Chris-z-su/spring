package com.shubao.test;

import cn.hutool.Hutool;
import com.shubao.domain.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaTest {

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2(){
        List<String> list = null;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test3(){
        int[] nums = {1,2,3,1};
        int[] nums2 = new int[3];
        int[] nums3 = new int[]{1,2,3};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    System.out.println(true);
                }
            }
        }
        System.out.println(false);
    }

    @Test
    public void test4(){
        HashMap hashMap = new HashMap();
        System.out.println(hashMap);
    }

    @Test
    public void test5(){
        System.out.println("Hutool.getAllUtils() = " + Hutool.getAllUtils());
    }

    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.shubao.domain.User");
        Constructor<?> constructor = clazz.getConstructor();
        System.out.println("constructor = " + constructor);
        User user = (User) clazz.getConstructor().newInstance();
        System.out.println("user = " + user);
        Method[] methods = clazz.getMethods();
        System.out.println("methods = " + methods);
    }

}
