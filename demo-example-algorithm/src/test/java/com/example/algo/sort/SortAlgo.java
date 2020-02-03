package com.example.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/21 11:06
 * @blame 仓储开发组
 **/
public class SortAlgo {


    public static void main(String[] args) {

        int arr[] = {8, 5, 23, 324, 7, 2, 67, 3, 2, 4};
        maopaoSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        xierSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);

    }




    /**
     * 归并排序
     * @param arr
     * @param start
     * @param end
     */
    private static void mergeSort(int[] arr, int start, int end) {
        long start0 = System.currentTimeMillis();
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                arr[i] = result[i - start];
            }
        }

        System.out.println("归并排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start0) + "ms");
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
        long start = System.currentTimeMillis();
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, high);
        }
        System.out.println("快速排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start) + "ms");
    }


    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    /**
     * 希尔排序
     *
     * @param arr
     */
    private static void xierSort(int arr[]) {
        long start = System.currentTimeMillis();

        //希尔排序（插入排序变种版）
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //i层循环控制步长
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
                for (int k = j; k > 0 && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
            //j,k为插入排序，不过步长为i
        }
        System.out.println("希尔排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start) + "ms");
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int arr[]) {
        long start = System.currentTimeMillis();
        //插入排序
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
        System.out.println("插入排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start) + "ms");
    }


    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int arr[]) {
        long start = System.currentTimeMillis();
        //选择
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
        System.out.println("选择排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start) + "ms");
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void maopaoSort(int arr[]) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序：" + JSONObject.toJSON(arr) + ",使用时间：" + (System.currentTimeMillis() - start) + "ms");
    }


}
