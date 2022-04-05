package com.shubao.test;

import java.util.Arrays;
import java.util.Date;

public class TestCoPilot {
    //获取数组中的最大值
    public int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //获取数组中的最小值
    public int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    //获取数组中的最大值与最小值之差
    public int getMaxMin(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return max - min;
    }

    //获取数组中的平均值
    public double getAvg(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)sum / arr.length;
    }

    //获取数组中的中位数
    public double getMedian(int[] arr){
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        quickSort(temp, 0, temp.length - 1);
        if (temp.length % 2 == 0){
            return (double)(temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        }else {
            return temp[temp.length / 2];
        }
    }

    private void quickSort(int[] temp, int i, int i1) {
        if (i < i1){
            int j = partition(temp, i, i1);
            quickSort(temp, i, j - 1);
            quickSort(temp, j + 1, i1);
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

    //获取数组中的最大值与最小值之差的百分比
    public double getMaxMinPercent(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return (double)(max - min) / (max + min);
    }

    //获取数组中的平均值与最大值之差的百分比
    public double getAvgMaxPercent(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)(sum / arr.length) / (max(arr) + min(arr));
    }

    private double min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    private double max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //获取数组中的平均值与最小值之差的百分比
    public double getAvgMinPercent(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)(sum / arr.length) / (max(arr) + min(arr));
    }

    //获取数组中的最大值与最小值之差的百分比
    public double getMaxMinPercent2(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){  //比较最大值
                max = arr[i];
            }
            if (arr[i] < min){  //比较最小值
                min = arr[i];
            }
        }   //循环结束
        return (double)(max - min) / (max + min);
    }

    //获取数组中的方差
    public double getVar(int[] arr){
        double avg = getAvg(arr);
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.pow(arr[i] - avg, 2);
        }
        return sum / arr.length;
    }

    //获取数组中的标准差
    public double getStd(int[] arr){
        return Math.sqrt(getVar(arr));
    }

    //计算两个日期之间的天数
    public int getDays(Date start, Date end){
        long time = end.getTime() - start.getTime();
        return (int)(time / (1000 * 60 * 60 * 24));
    }

    //获取两个日期之间的年数
    public int getYears(Date start, Date end){
        int days = getDays(start, end);
        return days / 365;
    }

    //获取两个日期之间的月数
    public int getMonths(Date start, Date end){
        int days = getDays(start, end);
        return days / 30;
    }

    //获取两个日期之间的周数   周一到周日
    public int getWeeks(Date start, Date end){
        int days = getDays(start, end);
        return days / 7;
    }

    //获取两个日期之间的工作日数  周一到周五  周六周日不计算
    public int getWorkDays(Date start, Date end){
        int days = getDays(start, end);
        int count = 0;
        for (int i = 0; i < days; i++) {
            if (start.getDay() != 0 && start.getDay() != 6){
                count++;
            }
            start.setDate(start.getDate() + 1);
        }
        return count;
    }

    //获取两个日期之间的自然日数  周一到周日  周六周日计算  周日不计算   周一到周五计算 周六周日不计算
    public int getNaturalDays(Date start, Date end){
        int days = getDays(start, end);
        int count = 0;
        for (int i = 0; i < days; i++) {
            if (start.getDay() != 6 && start.getDay() != 0){
                count++;
            }
            start.setDate(start.getDate() + 1);
        }
        return count;
    }

    //比较三个数
    public int compareThree(int a, int b, int c){
        if (a > b && a > c){
            return a;
        }else if (b > a && b > c){
            return b;
        }else {
            return c;
        }
    }

    //比较三个数
    public int compareThree(double a, double b, double c){
        if (a > b && a > c){
            return (int)a;
        }else if (b > a && b > c){
            return (int)b;
        }else {
            return (int)c;
        }
    }

    //比较三个数
    public int compareThree(String a, String b, String c){
        if (a.compareTo(b) > 0 && a.compareTo(c) > 0){
            return a.compareTo(b);
        }else if (b.compareTo(a) > 0 && b.compareTo(c) > 0){
            return b.compareTo(a);
        }else {
            return c.compareTo(a);
        }
    }

    //比较三个数
    public int compareThree(Date a, Date b, Date c){
        if (a.getTime() > b.getTime() && a.getTime() > c.getTime()){
            return 1;
        }else if (b.getTime() > a.getTime() && b.getTime() > c.getTime()){
            return 2;
        }else {
            return 3;
        }
    }

    //比较三个数
    public int compareThree(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr){
        String max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        return max.compareTo(arr[0]);
    }

    //比较三个数
    public int compareThree(Date[] arr){
        Date max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        return compareThree(max, arr[0], arr[1]);
    }

    //比较三个数
    public int compareThree(int[] arr, int start, int end){
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr, int start, int end){
        double max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr, int start, int end){
        String max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        return max.compareTo(arr[start]);
    }

    //比较三个数
    public int compareThree(Date[] arr, int start, int end){
        Date max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        return compareThree(max, arr[start], arr[end]);
    }

    //比较三个数
    public int compareThree(int[] arr, int start, int end, int[] arr2){
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start; i <= end; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr, int start, int end, double[] arr2){
        double max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start; i <= end; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr, int start, int end, String[] arr2){
        String max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        for (int i = start; i <= end; i++) {
            if (arr2[i].compareTo(max) > 0){
                max = arr2[i];
            }
        }
        return max.compareTo(arr[start]);
    }

    //比较三个数
    public int compareThree(Date[] arr, int start, int end, Date[] arr2){
        Date max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        for (int i = start; i <= end; i++) {
            if (arr2[i].getTime() > max.getTime()){
                max = arr2[i];
            }
        }
        return compareThree(max, arr[start], arr[end]);
    }

    //比较三个数
    public int compareThree(int[] arr, int start, int end, int[] arr2, int start2, int end2){
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr, int start, int end, double[] arr2, int start2, int end2){
        double max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr, int start, int end, String[] arr2, int start2, int end2){
        String max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].compareTo(max) > 0){
                max = arr2[i];
            }
        }
        return max.compareTo(arr[start]);
    }

    //比较三个数
    public int compareThree(Date[] arr, int start, int end, Date[] arr2, int start2, int end2){
        Date max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].getTime() > max.getTime()){
                max = arr2[i];
            }
        }
        return compareThree(max, arr[start], arr[end]);
    }

    //比较三个数
    public int compareThree(int[] arr, int start, int end, int[] arr2, int start2, int end2, int[] arr3, int start3, int end3){
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i] > max){
                max = arr3[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr, int start, int end, double[] arr2, int start2, int end2, double[] arr3, int start3, int end3){
        double max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i] > max){
                max = arr3[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr, int start, int end, String[] arr2, int start2, int end2, String[] arr3, int start3, int end3){
        String max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].compareTo(max) > 0){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i].compareTo(max) > 0){
                max = arr3[i];
            }
        }
        return max.compareTo(arr[start]);
    }

    //比较三个数
    public int compareThree(Date[] arr, int start, int end, Date[] arr2, int start2, int end2, Date[] arr3, int start3, int end3){
        Date max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].getTime() > max.getTime()){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i].getTime() > max.getTime()){
                max = arr3[i];
            }
        }
        return compareThree(max, arr[start], arr[end]);
    }

    //比较三个数
    public int compareThree(int[] arr, int start, int end, int[] arr2, int start2, int end2, int[] arr3, int start3, int end3, int[] arr4, int start4, int end4){
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i] > max){
                max = arr3[i];
            }
        }
        for (int i = start4; i <= end4; i++) {
            if (arr4[i] > max){
                max = arr4[i];
            }
        }
        return max;
    }

    //比较三个数
    public int compareThree(double[] arr, int start, int end, double[] arr2, int start2, int end2, double[] arr3, int start3, int end3, double[] arr4, int start4, int end4){
        double max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i] > max){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i] > max){
                max = arr3[i];
            }
        }
        for (int i = start4; i <= end4; i++) {
            if (arr4[i] > max){
                max = arr4[i];
            }
        }
        return (int)max;    //取整
    }

    //比较三个数
    public int compareThree(String[] arr, int start, int end, String[] arr2, int start2, int end2, String[] arr3, int start3, int end3, String[] arr4, int start4, int end4){
        String max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].compareTo(max) > 0){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].compareTo(max) > 0){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i].compareTo(max) > 0){
                max = arr3[i];
            }
        }
        for (int i = start4; i <= end4; i++) {
            if (arr4[i].compareTo(max) > 0){
                max = arr4[i];
            }
        }
        return max.compareTo(arr[start]);
    }

    //比较三个数
    public int compareThree(Date[] arr, int start, int end, Date[] arr2, int start2, int end2, Date[] arr3, int start3, int end3, Date[] arr4, int start4, int end4){
        Date max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i].getTime() > max.getTime()){
                max = arr[i];
            }
        }
        for (int i = start2; i <= end2; i++) {
            if (arr2[i].getTime() > max.getTime()){
                max = arr2[i];
            }
        }
        for (int i = start3; i <= end3; i++) {
            if (arr3[i].getTime() > max.getTime()){
                max = arr3[i];
            }
        }
        for (int i = start4; i <= end4; i++) {
            if (arr4[i].getTime() > max.getTime()){
                max = arr4[i];
            }
        }
        return compareThree(max, arr[start], arr[end]);
    }

//    //获取用户表信息
//    public void getUserInfo(String userId, String userName, String userPwd, String userType, String userPhone, String userEmail, String userAddress, String userBirthday, String userSex){
//        this.userId = userId;
//        this.userName = userName;
//        this.userPwd = userPwd;
//        this.userType = userType;
//        this.userPhone = userPhone;
//        this.userEmail = userEmail;
//        this.userAddress = userAddress;
//        this.userBirthday = userBirthday;
//        this.userSex = userSex;
//    }
//
//    //获取用户表信息
//    public void getUserInfo(String userId, String userName, String userPwd, String userType, String userPhone, String userEmail, String userAddress, String userBirthday, String userSex, String userPhoto){
//        this.userId = userId;
//        this.userName = userName;
//        this.userPwd = userPwd;
//        this.userType = userType;
//        this.userPhone = userPhone;
//        this.userEmail = userEmail;
//        this.userAddress = userAddress;
//        this.userBirthday = userBirthday;
//        this.userSex = userSex;
//        this.userPhoto = userPhoto;
//    }
//
//    //获取用户表信息
//    public void getUserInfo(String userId, String userName, String userPwd, String userType, String userPhone, String userEmail, String userAddress, String userBirthday, String userSex, String userPhoto, String userSignature){
//        this.userId = userId;
//        this.userName = userName;
//        this.userPwd = userPwd;
//        this.userType = userType;
//        this.userPhone = userPhone;
//        this.userEmail = userEmail;
//        this.userAddress = userAddress;
//        this.userBirthday = userBirthday;
//        this.userSex = userSex;
//        this.userPhoto = userPhoto;
//        this.userSignature = userSignature;
//    }
//
//    //获取用户表信息
//    public void getUserInfo(String userId, String userName, String userPwd, String userType, String userPhone, String userEmail, String userAddress, String userBirthday, String userSex, String userPhoto, String userSignature, String userGrade){
//        this.userId = userId;
//        this.userName = userName;
//        this.userPwd = userPwd;
//        this.userType = userType;
//        this.userPhone = userPhone;
//        this.userEmail = userEmail;
//        this.userAddress = userAddress;
//        this.userBirthday = userBirthday;
//        this.userSex = userSex;
//        this.userPhoto = userPhoto;
//        this.userSignature = userSignature;
//        this.userGrade = userGrade;
//    }

    //二叉树查找
    public int binarySearch(Date[] arr, int start, int end, Date key){
        if (start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid].getTime() == key.getTime()){
            return mid;
        }
        if (arr[mid].getTime() > key.getTime()){
            return binarySearch(arr, start, mid - 1, key);
        }
        return binarySearch(arr, mid + 1, end, key);
    }

    //二叉树查找
    public int binarySearch(Date[] arr, int start, int end, Date key, int start2, int end2){
        if (start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid].getTime() == key.getTime()){
            return mid;
        }
        if (arr[mid].getTime() > key.getTime()){
            return binarySearch(arr, start, mid - 1, key, start2, end2);
        }
        return binarySearch(arr, mid + 1, end, key, start2, end2);
    }

    //红黑树查找
    public int redBlackSearch(Date[] arr, int start, int end, Date key){
        if (start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid].getTime() == key.getTime()){
            return mid;
        }
        if (arr[mid].getTime() > key.getTime()){
            return redBlackSearch(arr, start, mid - 1, key);
        }
        return redBlackSearch(arr, mid + 1, end, key);
    }

    //图查找
    public int graphSearch(String[] arr, int start, int end, String key){
        if (start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid].equals(key)){
            return mid;
        }
        if (arr[mid].compareTo(key) > 0){
            return graphSearch(arr, start, mid - 1, key);
        }
        return graphSearch(arr, mid + 1, end, key);
    }

    //查找    时间复杂度O(log(n))
    public int search(Date[] arr, Date key){
        return binarySearch(arr, 0, arr.length - 1, key);
    }

    //查找    时间复杂度O(log(n))
    public int search(Date[] arr, Date key, int start2, int end2){
        return binarySearch(arr, 0, arr.length - 1, key, start2, end2);
    }

    //数组+链表查找    时间复杂度O(n)
    public int search(String[] arr, String key){
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    //红黑树查找    时间复杂度O(log(n))
    public int redBlackSearch(Date[] arr, Date key){
        return redBlackSearch(arr, 0, arr.length - 1, key);
    }

    //图查找    时间复杂度O(n)
    public int graphSearch(String[] arr, String key){
        return graphSearch(arr, 0, arr.length - 1, key);
    }

    //插入    时间复杂度O(log(n))
    public void insert(Date[] arr, Date key){
        int index = search(arr, key);
        if (index == -1){
            arr[arr.length] = key;
            Arrays.sort(arr);
        }
    }

    //插入    时间复杂度O(log(n))
    public void insert(Date[] arr, Date key, int start2, int end2){
        int index = search(arr, key, start2, end2);
        if (index == -1){
            arr[arr.length] = key;
            Arrays.sort(arr);
        }
    }

    //红黑树插入    时间复杂度O(log(n))
    public void redBlackInsert(Date[] arr, Date key){
        int index = redBlackSearch(arr, key);
        if (index == -1){
            arr[arr.length] = key;
            Arrays.sort(arr);
        }
    }

    //图插入    时间复杂度O(n)
    public void graphInsert(String[] arr, String key){
        int index = graphSearch(arr, key);
        if (index == -1){
            arr[arr.length] = key;
            Arrays.sort(arr);
        }
    }

    //删除    时间复杂度O(log(n))
    public void delete(Date[] arr, Date key){
        int index = search(arr, key);
        if (index != -1){   //找到    删除  时间复杂度O(log(n))  时间复杂度O(n)   时间复杂度O(n)   时间复杂度O(n)
            arr[index] = arr[arr.length - 1];
            arr[arr.length - 1] = null;
            Arrays.sort(arr);
        }
    }

    //删除    时间复杂度O(log(n))
    public void delete(Date[] arr, Date key, int start2, int end2){
        int index = search(arr, key, start2, end2);
        if (index != -1){   //找到    删除  时间复杂度O(log(n))  时间复杂度O(n)   时间复杂度O(n)   时间复杂度O(n)
            arr[index] = arr[arr.length - 1];
            arr[arr.length - 1] = null;
            Arrays.sort(arr);
        }
    }


    //堆排序    时间复杂度O(n)
    public void heapSort(Date[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--){
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    private void swap(Date[] arr, int i, int i1) {
        Date temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    private void heapAdjust(Date[] arr, int i, int length) {
        int temp = i;   //记录当前节点
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < length && arr[left].compareTo(arr[temp]) > 0){
            temp = left;
        }
        if (right < length && arr[right].compareTo(arr[temp]) > 0){
            temp = right;
        }
        if (temp != i){
            swap(arr, i, temp);
            heapAdjust(arr, temp, length);
        }
    }

    //乘积运算

    //平方根倒数速算法

}
