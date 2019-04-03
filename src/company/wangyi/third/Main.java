package company.wangyi.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int sum = 0;
    static List<Integer> res = new ArrayList<Integer>();
    public static int time(ArrayList<Integer> data, int max) {
        ArrayList<Integer> cur = (ArrayList<Integer>) data.clone();
        int num = 0;
        while(data.size() != 0)  {
            sum = data.get(0);
            data.remove(0);
            if(data.size() != 0 && (data.get(0) + sum <= max)) {
                data.remove(0);
            }
            num += 1;
        }
        return num;
    }


    public static void swap(ArrayList<Integer> data, int i ,int j) {
        int tem = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tem);
    }

    public static void f(ArrayList<Integer> data, int start, int n, int max) {
        if(start == n) {
            res.add(time(data, max));
        }else {
            int i = start;
            while(i < data.size()) {
                swap(data, start, i);
                f(data, start + 1, n, max);
                swap(data, start, i);
                i += 1;
            }
        }
    }

    public static void getResult() {

    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int index = 0;
        while (index < n) {
            data.add(in.nextInt());
            index++;
        }

        f(data, 0, n, w);
//        Arrays.sort(res.toArray());
        System.out.println(res);
    }
}
