package com.test;

import java.util.*;

/**
 * 生成数独
 */
public class SudukuGenerator {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            try {
                start();
                flag = false;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * 生成数独
     */
    private static void start() {
        //9*9的数独
        int[][] suduku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //
                int[] row = Arrays.copyOf(suduku[i], j);
                int[] column = new int[i];
                for (int k = 0; k < i; k++) {
                    //把当前位置的值 第k行第j列的值
                    column[k] = suduku[k][j];
                }
                List<Integer> placeList = new ArrayList<>();
                //取所在的九宫格位置
                int placeRow = i / 3;
                int placeColumn = j / 3;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        //构建九宫格的数独
                        placeList.add(suduku[placeRow * 3 + m][placeColumn * 3 + n]);
                    }
                }
                //给数独填充数字
                suduku[i][j] = getNumber(row, column, placeList.stream().mapToInt(Integer::intValue).toArray());
            }
        }
        for (int i = 0; i < suduku.length; i++) {
            System.out.println(Arrays.toString(suduku[i]));
        }
    }

    /**
     * 填充数字 选择从既没有在此行 也没有在此列的数值
     * @param row
     * @param column
     * @param toArray
     * @return
     */
    private static int getNumber(int[] row, int[] column, int[] toArray) {
        //使用到Set容器 其中不能存重复的值 合并数组
        Set<Integer> mergeSet = new HashSet<>();
        //将行 列的数字都存入set
        for (int item : row) {
            mergeSet.add(item);
        }
        for (int value : column) {
            mergeSet.add(value);
        }

        for (int i : toArray) {
            mergeSet.add(i);
        }

        Set<Integer> source  = new HashSet<>();
        for (int m=1; m<10; m++){
            source.add(m);
        }
        //取差集
        source.removeAll(mergeSet);
        int[] merge = source.stream().mapToInt(Integer::intValue).toArray();
        //随机返回一个下标
        return merge[getRandomCursor(merge.length)];
    }

    /**
     * 取随机数
     * @param length
     * @return
     */
    private static int getRandomCursor(int length) {
        return Math.abs(new Random().nextInt())%length;
    }
}
