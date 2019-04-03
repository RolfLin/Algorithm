package company.wangyi.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<int[]> list = new ArrayList<>();
    public static int  Gcd(int a, int b, int c) {
        int res = 1;
        int num = 1;
        while(num <= Math.min(a, Math.min(b, c))) {
            if( a % num ==0 && b % num ==0 && c % num ==0 && num != 1) {
                res *= num;
                a /= num;
                b /= num;
                c /= num;
            }else {
                num += 1;
            }
        }
        return  res;
    }


    public static void generate(int[] data) {
        int a = 0, b = 1, c = 2;
        while(a < b && b < c && a < data.length && b < data.length && c < data.length) {
            int[] temp = new int[]{data[a], data[b], data[c]};
            list.add(temp);
            if(c == data.length - 1) {
                if(b == c - 1) {
                    a += 1;
                    b = a + 1;
                    c = b + 1;
                }else {
                    b += 1;
                    c = b + 1;
                }
            }else {
                c += 1;
            }
        }
    }

    public static void getResult() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int index = 0;
        int[] data = new int[n];
        while (index < n) {
            data[index] = in.nextInt();
            index++;
        }

        generate(data);
        int num = 0;
        for(int[] arr : list) {
            if(Gcd(arr[0], arr[1], arr[2]) == 1) {
                num += 1;
            }
        }
        System.out.println(num);
    }
}
