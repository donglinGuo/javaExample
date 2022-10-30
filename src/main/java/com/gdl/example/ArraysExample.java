package com.gdl.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysExample {
    public static void main(String[] args){
        testAsList();
        testCopyOf();
        testCopyOfRange();
        testEquals();
        testDeepEquals();
        testHashCode();
        testDeepHashCode();
        testDeepToString();
        testFill();
        testPrallelPrefix();
        testPrallelSetAll();
        testSetAll();
        testParallelSort();



    }

    /**
     * test asList()
     */
    public static void testAsList(){
        // 创建一个List
        System.out.println("test Arrays.asList() method ====");
        List<String> str1 = Arrays.asList("a","b");
        System.out.println("input is 'a','b'" + " output is " + str1.toString());

        // 转化一个数组
        String[] str2 = new String[]{"c","d"};
        List<String> list2 = Arrays.asList(str2);
        System.out.printf("intput is arr: %s %s  output is %s%n",str2, Arrays.toString(str2), list2);

        // 基本类型数组为参数时
        int[] arr1 = new int[]{0,1,2,3};
        List arrList = Arrays.asList(arr1);
        System.out.printf("intput is %s size is %s output is %s size is %s the elements type is %s%n", arr1,arr1.length, arrList, arrList.size(), arrList.get(0).getClass().getSimpleName());

        // 对返回结果的操作会反应在原始数组上
        String[] arr3 = new String[]{"a","b"};
        List<String> list3 = Arrays.asList(arr3);
        System.out.printf("before set: array is %s %s, list is %s%n",arr3,Arrays.toString(arr3),list3);
        list3.set(1,"c");
        System.out.printf("after set: array is %s %s,  list is %s%n", arr3, Arrays.toString(arr3),list3);
    }

    /**
     * test copyOf()
     */
    public static void testCopyOf(){
        System.out.println("test Arrays.copyOf() ===");
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr1 = Arrays.copyOf(arr, 4);
        int[] arr2 = Arrays.copyOf(arr, 10);
        System.out.printf("intput arr is %s %s , copy range 0-3 is %s, copy range 0-10 is %s%n", arr,Arrays.toString(arr), Arrays.toString(arr1), Arrays.toString(arr2));
    }

    /**
     * test copyOfRange()
     */
    public static void testCopyOfRange(){
        System.out.println("test Arrays.copyOfRange() ===");
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr1 = Arrays.copyOfRange(arr, 0, 4);
        System.out.printf("intput arr is %s %s , copy range 0-3 is %s%n", arr,Arrays.toString(arr), Arrays.toString(arr1));
    }

    public static void testEquals(){
        System.out.println("test Arrays.equals() ===");
        String[] a = new String[]{"a","c"};
        String[] b = new String[]{"a","c"};
        System.out.printf("obj arr %s %s is %s equals to obj arr %s %s%n", a, Arrays.toString(a), Arrays.deepEquals(a,b), b, Arrays.toString(b));}

    /**
     * test deepEquals()
     */
    public static void testDeepEquals(){
        System.out.println("test Arrays.deepEquals() ===");
        Object[] a = new Object[]{"a","c"};
        Object[] b = new Object[]{"b","c"};
        System.out.printf("obj arr %s %s is %s equals to obj arr %s %s%n", a, Arrays.toString(a), Arrays.deepEquals(a,b), b, Arrays.toString(b));

        Integer[] a1 = null;
        Integer[] b1 = null;
        System.out.printf("obj arr %s %s is %s equals to obj arr %s %s%n", a1, Arrays.toString(a1), Arrays.deepEquals(a1,b1), b1, Arrays.toString(b1));

        Integer[] a2 = new Integer[]{1,2,3};
        Integer[] b2 = new Integer[]{1,2,3};
        System.out.printf("obj arr %s %s is %s equals to obj arr %s %s%n", a2, Arrays.toString(a2), Arrays.deepEquals(a2,b2), b2, Arrays.toString(b2));
    }

    /**
     * test deepHashCode
     */
    public static void testDeepHashCode() {
        System.out.println("test Arrays.deepHashCode() ===");
        Integer[] a = new Integer[]{1, 2, 3};
        System.out.printf("input arr is %s %s, hash code is %s%n", a, Arrays.toString(a), Arrays.deepHashCode(a));
        Integer[] b = new Integer[]{1, 2, 3};
        System.out.printf("intput arr1 is %s, arr2 is %s, arr1's deepHashCode is equals to arr2's deepHashCode %s, and arr1 deepEquals to arr2 %s%n", Arrays.toString(a), Arrays.toString(b), a.hashCode()==b.hashCode(), Arrays.deepEquals(a,b));
    }

    /**
     * test deepToString
     */
    public static void testDeepToString(){
        System.out.println("test Arrays.deepToString() ===");
        int[][] a = new int[][]{new int[]{1,2,3},new int[]{4,5,6}};
        System.out.printf("arr is %s, toString res is %s, deepToString res is %s%n", a, Arrays.toString(a), Arrays.deepToString(a));
    }


    /**
     * test fill
     */
    public static void testFill(){
        System.out.println("test Arrays.fill() ===");
        int[] a = new int[]{1,2,3,4,5};
        System.out.printf("arr is %s %s%n", a, Arrays.toString(a));
        Arrays.fill(a, 10);
        System.out.printf("after fill(a,10), arr is %s %s%n", a, Arrays.toString(a));
        Arrays.fill(a,2,4,0);
        System.out.printf("after fill(a, 2, 4, 0), arr is %s %s%n", a, Arrays.toString(a));
    }

    /**
     * test hash code
     */
    public static void testHashCode(){
        System.out.println("test Arrays.hashCode() ===");
        int[] a = new int[]{1,2,3};
        System.out.printf("arr is %s %s, hashcode is %s%n", a, Arrays.toString(a), Arrays.hashCode(a));
    }
    /**
     * test parallelPrefix
     */
    public static void testPrallelPrefix(){
        System.out.println("test Arrays.parallelPrefix() ===");
        int[] a = new int[]{1,2,3,4,5};
        Arrays.parallelPrefix(a, Integer::sum);
        System.out.printf("input arr is {1,2,3,4,5}, opration is sum, res is %s%n", Arrays.toString(a));
    }

    public static void testPrallelSetAll(){
        System.out.println("test Arrays.paralleSetAll() ===");
        int[] a = new int[]{1,2,3,4,5};
        // 注意传入的是数组索引
        Arrays.parallelSetAll(a, value->a[value]*2);
        System.out.printf("input arr is {1,2,3,4,5}, opration is a*2, res is %s%n", Arrays.toString(a));
    }
    public static void testSetAll(){
        System.out.println("test Arrays.setAll() ===");
        int[] a = new int[]{1,2,3,4,5};
        // 注意传入的是数组索引
        Arrays.setAll(a, value->a[value]*2);
        System.out.printf("input arr is {1,2,3,4,5}, opration is a*2, res is %s%n", Arrays.toString(a));
    }

    public static void testParallelSort(){
        System.out.println("test Arrays.parallelSort() ===");
        int[] a = new int[]{1,8,3,6,5};
        // 注意传入的是数组索引
        Arrays.parallelSort(a);
        System.out.printf("input arr is {1,8,3,6,5}, parallelSort res is %s%n", Arrays.toString(a));
    }
    public static void sort(){
        System.out.println("test Arrays.sort() ===");
        int[] a = new int[]{1,8,3,6,5};
        // 注意传入的是数组索引
        Arrays.sort(a);
        System.out.printf("input arr is {1,8,3,6,5}, parallelSort res is %s%n", Arrays.toString(a));
    }

}

