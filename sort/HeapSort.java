package sort;
import java.util.Arrays;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 堆排序
 * @Date: 2022/3/25
 * @Time: 15:42
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }
    //方法：编写一个堆排序的方法
    public static void heapSort(int[] array){
        int temp = 0;
        System.out.println("堆排序");
        //分布完成
//        adjustHeap(array,1,array.length);
//        System.out.println("第一次" + Arrays.toString(array));
//
//        adjustHeap(array,0,array.length);
//        System.out.println("第2次" + Arrays.toString(array));
        //最终的代码
        //将无序的序列构建成一个堆，根据升序的降序需求选择大顶堆还是小顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array,i,array.length);
        }
        //将堆顶的元素与末尾元素交换，将最大元素放到数组的末端
        //重新调整结构，将其满足堆定义，然后继续交换堆顶元素和当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j = array.length - 1; j > 0 ; j--) {
            //交换
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array,0,j);
        }
        System.out.println("数组 = " + Arrays.toString(array));
    }

    /**
     * 将一个数组（二叉树）调整为一个大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //k = i * 2 + 1是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k+1 < length && arr[k] < arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp){//如果子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//！！！i指向k 继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值放在了最顶（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
