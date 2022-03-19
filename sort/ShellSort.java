package sort;

import java.sql.PreparedStatement;
import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 希尔排序
 * @Date: 2022/3/19
 * @Time: 15:48
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
    }


    //希尔排序 对有序序列再插入时采用交换法
    public static void shellSort(int[] arr){

        //根据推导，使用循环处理
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有元素共gap组  步长gap
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    //如果当前的元素大于步长的后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第"+(++count)+"轮 = "+Arrays.toString(arr));
        }


        //使用逐步推导的方式实现希尔排序
        //希尔排序
        //第1轮 将10个数据分为10/2=5组
        /*
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有元素（共5组 每组2个元素） 步长5
            for (int j = i - 5; j >= 0 ; j -= 5) {
                //如果当前的元素大于步长的后的那个元素，说明交换
                if (arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔第1轮");
        System.out.println(Arrays.toString(arr));

        //第2轮 将10个数据分为5/2 =2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有元素（共5组 每组2个元素） 步长5
            for (int j = i - 2; j >= 0 ; j -= 2) {
                //如果当前的元素大于步长的后的那个元素，说明交换
                if (arr[j] > arr[j + 2]){
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔第2轮");
        System.out.println(Arrays.toString(arr));

        //第3轮 将10个数据分为2/2 =1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有元素（共5组 每组2个元素） 步长5
            for (int j = i - 1; j >= 0 ; j -= 1) {
                //如果当前的元素大于步长的后的那个元素，说明交换
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔第3轮");
        System.out.println(Arrays.toString(arr));

         */
    }
}
