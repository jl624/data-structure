package sort;

import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 插入排序
 * @Date: 2022/3/19
 * @Time: 15:02
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {104,34,119,1};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr){

        //插入排序时间复杂度O(n) 80000条数据 用时4-5s  选择 2-3s  冒泡 20s左右
        //使用for循环简化代码
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;//即arr[1]前面的下标
            //给insertVal找到插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex] 后移
                insertIndex--;
            }
            //退出while 插入的位置找到 insertIndex+1
            arr[insertIndex + 1] = insertVal;
            System.out.println("第"+ i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }

        //使用逐步推导
        //第1轮
        //定义待插入的数
        /*
        int insertVal = arr[1];
        int insertIndex = 0;//即arr[1]前面的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex] 后移
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));

        //第2轮
        //定义待插入的数
        insertVal = arr[2];
        insertIndex = 2 - 1;//即arr[1]前面的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex] 后移
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));

        //第3轮
        //定义待插入的数
        insertVal = arr[3];
        insertIndex = 3 -1;//即arr[1]前面的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex] 后移
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));

         */
    }
}
