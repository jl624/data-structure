package sort;

import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 选择排序
 * @Date: 2022/3/19
 * @Time: 11:47
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }
    //方法：选择排序
    public static void selectSort(int[] arr){

        //从推导中可以看出 利用for循环解决
        //选择排序复杂度O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){//说明假定的最小值不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            //将最小值放在arr[0] 即交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第"+(i+1)+"轮");
//            System.out.println(Arrays.toString(arr));
        }
        //使用逐步推导，
        //第一轮
        /*
        int minIndex = 0;
        int min = arr[0];
        for (int j = 1; j < arr.length; j++) {
            if (min > arr[j]){//说明假定的最小值不是最小
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //将最小值放在arr[0] 即交换
        if (minIndex != 0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        //第2轮
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        //第2轮
        minIndex = 1;
        min = arr[1];
        for (int j = 2; j < arr.length; j++) {
            if (min > arr[j]){//说明假定的最小值不是最小
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //将最小值放在arr[0] 即交换
        if (minIndex != 1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        //第2轮
        System.out.println("第2轮");
        System.out.println(Arrays.toString(arr));

        //第3轮
        minIndex = 2;
        min = arr[2];
        for (int j = 3; j < arr.length; j++) {
            if (min > arr[j]){//说明假定的最小值不是最小
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //将最小值放在arr[0] 即交换
        if (minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        //第3轮
        System.out.println("第3轮");
        System.out.println(Arrays.toString(arr));

         */
    }
}
