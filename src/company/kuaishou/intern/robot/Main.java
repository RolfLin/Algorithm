package company.kuaishou.intern.robot;

import java.util.Scanner;

public class Main {

    public static int movingCount(int rows, int cols,int t) {
        boolean[][] v = new boolean[rows][cols];
        return countingSteps(t,rows,cols,0,0,v);
    }
    public static int countingSteps(int li,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > li)  return 0;
        visited[r][c] = true;
        return countingSteps(li,rows,cols,r - 1,c,visited)
                + countingSteps(li,rows,cols,r,c - 1,visited)
                + countingSteps(li,rows,cols,r + 1,c,visited)
                + countingSteps(li,rows,cols,r,c + 1,visited)
                + 1;
    }
    public static int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println(movingCount(a, b, c));
    }
}
