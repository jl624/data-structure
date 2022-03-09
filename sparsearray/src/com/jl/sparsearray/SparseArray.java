package com.jl.sparsearray;

import java.io.*;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description: 二维数组转换为稀疏数组
 * @Date: 2022/3/8
 * @Time: 15:50
 **/
public class SparseArray {
    public static void main(String[] args) {

        //创建一个原始的二维数组 11 * 11
        //0：代表没有棋子， 1 代表黑子 2 代表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组:");
        for (int[] row : chessArr1) {
            for (int data: row ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组
        //1、先遍历二维数组 得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        //2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组将非零的值放入sparseArr中
        int count = 0;//用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        
        //输出稀疏数组
        System.out.println();
        System.out.println("===================得到的稀疏数组为========================");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组恢复为原始二维数组
        //1、先读取稀疏数组的第一行根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2、在读取稀疏数组后几行的数据(从第二行开始)，并赋给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //恢复后的二维数组
        System.out.println("===================恢复后的二维数组=========================");
        for (int[] row : chessArr2) {
            for (int data: row ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组保存到磁盘并命名为map.txt
        try {
            System.out.println("将稀疏数组保存到磁盘并命名为map.txt");
            File f = new File("E:\\map.txt");
            FileOutputStream fos = new FileOutputStream(f);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            System.out.println("写入中----------");
            for(int i = 0; i < sparseArr.length; i++) {
                osw.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
            }
            osw.close();//关闭输出流
            fos.close();//关闭输出流
            System.out.println("写入磁盘成功");

            //读取磁盘中map.txt文件
            System.out.println("读取中----");
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            StringBuffer sb = new StringBuffer();
            //读取到字符
            while (isr.ready()){
                sb.append((char)isr.read());
            }
            isr.close();
            fis.close();
            System.out.println("读取成功！！！！！！");

            //将读取的字符转换为字符串
            String s = sb.toString();
            String[] sb1 = sb.toString().split(",");
            System.out.printf("从磁盘读取的字符串为：\n%s\n", s);//格式化输出

            int sum1 = 0;
            int[][] sparseArr1 = new int[sb1.length/3][3];
            sparseArr1[0][0] = Integer.parseInt(sb1[0]);
            sparseArr1[0][1] = Integer.parseInt(sb1[1]);
            sparseArr1[0][2] = Integer.parseInt(sb1[2]);
            for(int i = 3; i < sb1.length; i += 3) {
                sum1++;
                sparseArr1[sum1][0] = Integer.parseInt(sb1[i]);
                sparseArr1[sum1][1] = Integer.parseInt(sb1[i+1]);
                sparseArr1[sum1][2] = Integer.parseInt(sb1[i+2]);
            }
            System.out.println("==============还原后的稀疏数组为=====================");
            for(int i = 0; i < sparseArr1.length; i++) {
                System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
            }
            //恢复原始二维数组
            int[][] chessArr3 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
            for(int i = 1; i < sparseArr1.length; i++) {
                chessArr3[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
            }
            System.out.println("============还原后的二维数组为=================");
            for(int[] a : chessArr3) {
                for(int b : a) {
                    System.out.printf("%d\t", b);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
