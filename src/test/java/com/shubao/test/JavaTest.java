package com.shubao.test;

import cn.hutool.Hutool;
import com.shubao.domain.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

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

    @Test
    public void test7(){
        String[] array = new String[9];
        array[1]="Proposal";
        array[2] = "guProposalMain.getProposalNo()";
        array[3] = "riskCode";
        array[4] = "0000";
        array[5] = "";
        array[6] = "0";
        array[7] = "";
        array[8] = "";
        System.out.println("array = " + array);
    }

    @Test
    public void test8(){
//        long aLong = 1021824000000L;
//        Long aLong = 1021824000000L;
        Long aLong = null;
        if (aLong == null) {
            return;
        }
        Date date = new Date(aLong);
        System.out.println("date = " + date);
    }

    /**
     * GitHub Copilot:
     *  https://blog.csdn.net/j3T9Z7H/article/details/121133714
     */
    @Test
    public void test9(){
        // 冒泡排序 从小到大
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println("nums = " + nums);
    }

    @Test
    public void test10(){
        // 冒泡排序 从大到小
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println("nums = " + nums);
    }

    @Test
    public void test11(){
        // 选择排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    @Test
    public void test12(){
        // 插入排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < nums[j]){
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    @Test
    public void test13(){
        // 归并排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (int m = left; m <= right; m++) {
            nums[m] = temp[m];
        }
    }

    @Test
    public void test14(){
        // 快速排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right){
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    @Test
    public void test15(){
        // 堆排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    private void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        int child = 2 * i + 1;
        while (child < length){
            if (child + 1 < length && nums[child] < nums[child + 1]){
                child++;
            }
            if (temp >= nums[child]){
                break;
            }
            nums[i] = nums[child];
            i = child;
            child = 2 * i + 1;
        }
        nums[i] = temp;
    }

    //折半查找
    @Test
    public void test16(){
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        int target = 25;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test17(){
        // 基数排序
        int[] nums = {11,2,32,4,25,6,57,82,91,10};
        radixSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    private void radixSort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
            }
        }
        int exp = 1;
        while (max / exp > 0){
            countSort(nums, exp);
            exp *= 10;
        }
    }

    private void countSort(int[] nums, int exp) {
        int[] output = new int[nums.length];
        int[] count = new int[10];
        for (int i = 0; i < nums.length; i++) {
            count[(nums[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    @Test
    public void test18() {
        String str = "";
        System.out.println(str.equals(""));
        System.out.println(str == "");
        System.out.println(str != "");
    }

}
