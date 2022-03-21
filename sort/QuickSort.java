package sort;

import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 快速排序
 * @Date: 2022/3/20
 * @Time: 21:05
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println("arr = "+ Arrays.toString(arr));
    }

    //快速排序 80000数据用时1-2s
    public static void quickSort(int[] arr,int left, int right){
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让pivot值小放在左边
        while (l < r){
            //在pivot的左边一直找，找到大于等于pivot的值再退出
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot的值再退出
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果l>=r说明pivot的左右两边的值已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换后 如果arr[l] == pivot r-- 前移
            if (arr[l] == pivot){
                r -= 1;
            }
            //交换后 如果arr[r] == pivot l-- 后移
            if (arr[r] == pivot){
                l += 1;
            }
        }
        //如果l == r 必须l++ r-- 否则会出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l){
            quickSort(arr, l, right);
        }

    }
}
