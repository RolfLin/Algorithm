package company.huawei.intern.gatherHoney;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：蜜蜂采蜜问题（路径规划）。蜜蜂从坐标原点的蜂巢离开去采蜜，连续采5片花丛后归巢。请规划下到访花丛的顺序，使飞行总距离最短
 *
 * 思路：直接用枚举方式，取最小值。 枚举的过程，同样是可以用回溯法来处理；
 * 两个花丛的距离就用两点间的距离公式来计算即可
 *
 */

public class Main {

    public static void getResult(List<Integer> res, int[] arr, List<Integer> tmp, int[] location) {

        if(tmp.size() == location.length) {
            int sum = 0;
            int x = 0, y = 0;
            for(int l : tmp) {
                sum += distance(x, y, arr[l * 2], arr[l * 2 + 1]);
                x = arr[l * 2];
                y = arr[l * 2 + 1];
            }
            sum += distance(x, y, 0, 0);
            res.add(sum);
        } else {
            for(int i = 0 ; i < location.length; i++) {
                if(tmp.contains(location[i])) {
                    continue;
                }
                tmp.add(location[i]);
                getResult(res, arr, tmp, location);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static int distance(int x_s, int y_s, int x_e, int y_e) {
        return (int) Math.sqrt(Math.pow((x_e - x_s), 2) + Math.pow((y_e - y_s), 2));
    }

    public static void main(String[] args) {
        String str = "200 0 200 10 200 50 200 30 200 25";
//        String str = "200 0 200 200 0 200";
        int[] arr = new int[str.length()];
        String[] strs = str.split(" ");
        int arrIndex = 0;
        for(String s : strs) {
            arr[arrIndex] = Integer.parseInt(s);
            arrIndex++;
        }

        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] location = new int[]{0,1,2,3,4};
        getResult(res, arr, tmp, location);
        int resMin = res.get(0);
        for(int i : res) {
            if(i < resMin) {
                resMin = i;
            }
        }
        System.out.println(resMin);
    }
}
