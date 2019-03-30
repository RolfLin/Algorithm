package company.kuaishou.intern.binary;

import java.util.Scanner;

public class Main {

    static int bitCount(int n)
    {
        int c; // 计数器
        for (c = 0; n > 0; n >>= 1)
            c += n &1;
        return c ;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(bitCount(n));
    }
}
