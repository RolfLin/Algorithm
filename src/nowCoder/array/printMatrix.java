package nowCoder.array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-15 17:35
 **/
public class printMatrix {
    /**
     * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     * 思路：每打印完一轮环，下个环整体范围减1，即行和列的起始下标+1，结束下标-1；
     * 每轮环打印看做四步过程，左上到右上倒数第二个点，右上到右下倒数第二个点，...，
     * 左下到左上倒数第二个点，，清晰地将环打印过程拆分，下一轮打印只是范围缩小，过程不变，
     * 直到环的行或列的两个下标交叉，打印完成
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int tC = 0, dC = matrix[0].length - 1;
        int tR = 0, dR = matrix.length - 1;
        ArrayList<Integer> res = new ArrayList();
        while(tC <= dC && tR <= dR){
            printEdge(matrix, tC++, dC--, tR++, dR--, res);
        }
        return res;
    }

    public static void printEdge(int[][] m, int tC, int dC, int tR, int dR, ArrayList<Integer> res){
        if(tC == dC){
            for(int i = tR; i <= dR; i++){
                res.add(m[i][tC]);
            }
        }
        else if(tR == dR){
            for(int i = tC; i <= dC; i++){
                res.add(m[tR][i]);
            }
        }
        else{
            int curL = tC;
            int curW = tR;
            while(curL != dC){
                res.add(m[tR][curL]);
                curL++;
            }
            while(curW != dR){
                res.add(m[curW][dC]);
                curW++;
            }
            while(curL != tC){
                res.add(m[dR][curL]);
                curL--;
            }
            while(curW != tR){
                res.add(m[curW][tC]);
                curW--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
//        int[][] matrix = { { 1 } };
        printMatrix(matrix);

        Stack<Integer> stack = new Stack();
//        stack.push(1);
        if(stack.isEmpty()){
            System.out.println("Null");
        }
        System.out.println(stack.peek());
    }
}
