package company.wangyi.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[] returnIndex(ArrayList<Integer> data) {
        if(data.size() == 1) {
            return new int[]{0, data.get(0)};
        }
        if(data.size() == 2) {
            int num = data.get(0) * data.get(1);
            if(data.get(0) > data.get(1)) {
                return new int[]{1, num};
            }else {
                return new int[]{0, num};
            }
        }
        int i = 2;
        int min = data.get(1);
        int min_index = 1;
        while(i < data.size() - 1) {
            if(data.get(i) < min) {
                min_index = i;
            }
            i += 1;
        }
        return new int[]{min_index, data.get(min_index - 1) * data.get(min_index) * data.get(min_index + 1)};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        int index = 0;
        while (in.hasNext()) {
            data.add(in.nextInt());
        }
        int sum = 0;
        while(data.size() != 0) {
            int[] tem = returnIndex((ArrayList<Integer>) data);
            int max_index = tem[0], max = tem[1];
            sum += max;
            data.remove(max_index);
        }
        System.out.println(sum);
    }
}
