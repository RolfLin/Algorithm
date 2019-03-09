package company.huawei.sortAndFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {


    /**
     *
     * 题目描述：明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
     * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
     * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
     *
     *
     * 思路：此类给定数据范围的题目，都可以尝试用桶排序的方法解决，即将当前元素的值存到对应下标中
     * @param arg
     */


    /**
     * 桶排序
     * @param arg
     */
    public static void main2(String arg[]){
        int N, n;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            N = scanner.nextInt();
            int[] arr = new int[N + 1];
            while(N-- > 0){
                n = scanner.nextInt();
                arr[n] = 1;
            }
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 1){
                    System.out.println(i);
                }
            }
        }
    }




    public static void sort(int[] list){
        Arrays.sort(list);
        List<Integer> res = new ArrayList<>();
        res.add((Integer) list[0]);
        for(int i = 1; i < list.length; i++){
            if(res.get(res.size() - 1) != list[i]){
                res.add((Integer) list[i]);
            }
        }
        for(int i : res){
            System.out.println(i);
        }
    }

    /**
     * 常规方法
     * @param args
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int i = 0;
            while(i < n){
                arr[i] = sc.nextInt();
                i++;
            }
            sort(arr);
        }
    }
}
