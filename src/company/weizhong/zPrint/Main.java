package company.weizhong.zPrint;

import java.util.Scanner;

public class Main {

    public static int[] getResult(int n){
        int i = 2;
        int sum = 1;
        while(sum < n) {
            sum += i;
            i++;
        }

        // n在第i-1层
        i--;
        int j = sum - n + 1;// 差距

        int x = 0, y = 0;
        if(i % 2 == 0) { // 从上往下
            y = i - 1;
            while(j < i) {
                x++;
                y--;
                j++;
            }
        }else { // 从下往上
            x = i - 1;
            while(j < i) {
                x--;
                y++;
                j++;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1,2,6,7},{3,5,8,14},{4,9,13}, {10,12}};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] res = getResult(n);
        System.out.println((res[0]+1) + "/" + (res[1]+1));
    }
}

//
//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    static String GetResult(int N) {
//
//
//    }
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String res;
//
//        int _N;
//        _N = Integer.parseInt(in.nextLine().trim());
//
//        res = GetResult(_N);
//        System.out.println(res);
//    }
//}

