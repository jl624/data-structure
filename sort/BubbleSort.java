package sort;

import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 冒泡排序
 * @Date: 2022/3/19
 * @Time: 10:47
 **/
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3,9,-1,10,-2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试冒泡
        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));


        //为了好理解，演示冒泡排序的过程
        //冒泡 时间复杂度O(n^2)
        /*
        int temp = 0;
        boolean flag = false;//标识变量，表示是否进行交换
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //如果前面的数比后面的大 则交换
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if (!flag){//在一趟排序中，一次交换都没有发生
                break;
            }else {
                flag = false;//重置flag！！！ 进行下次交换
            }
        }
        */
        /*
        //第二趟 将第二大的数排在倒数第二位
        for (int i = 0; i < arr.length-1-1; i++) {
            //如果前面的数比后面的大 则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第三趟 将第三大的数排在倒数第三位
        for (int i = 0; i < arr.length-1-1-1; i++) {
            //如果前面的数比后面的大 则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第四趟 将第四大的数排在倒数第四位
        for (int i = 0; i < arr.length-1-3; i++) {
            //如果前面的数比后面的大 则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/
    }
    //将冒泡排序算法封装到一个方法
    public static void bubbleSort(int[] arr){
        //冒泡 时间复杂度O(n^2)
        int temp = 0;
        boolean flag = false;//标识变量，表示是否进行交换
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //如果前面的数比后面的大 则交换
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag){//在一趟排序中，一次交换都没有发生
                break;
            }else {
                flag = false;//重置flag！！！ 进行下次交换
            }
        }
    }
}
