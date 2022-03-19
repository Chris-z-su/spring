package com.shubao.test;

import cn.hutool.Hutool;
import org.junit.Test;

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

}
