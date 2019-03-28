package company.huawei.intern.snakePrint;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：将字符串转为一道基础计算式，如"1+22+13-51-99+65"
 * 1. 只有加减
 * 2. 公式完整，不存在++，--，或者+-字符在头尾的情况
 * 3. 数字范围0-99
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        String str = in.nextLine();
        char[] chars = str.toCharArray();

        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), 0);
            map.put((char) (i + 'A'), 0);
        }

        for (char c : chars) {
//            char c = in.next().charAt(0);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
//                System.out.print(c);
                map.put(c, map.get(c) + 1);
            }
        }


        boolean flag = false;

        for (int i = 0; i < 26; i++) {
            if (map.get((char) (i + 'a')) > 0 && map.get((char) (i + 'A')) > 0) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            System.out.println("Not Found");
            return;
        }


        for (int z = 0; z < 26; z++) {
            while (true) {
                int index = -1;
                int length = 0;
                for (int j = z; j < 26; j++) {
                    if (map.get((char) (j + 'a')) == 0 || map.get((char) (j + 'A')) == 0) {
                        break;
                    }
                    length++;
                }

                if (length == 0) {
                    break;
                }

                for (int i = z; i < z + length; i++) {
                    map.put((char) ('A' + i), map.get((char) ('A' + i)) - 1);
                    map.put((char) ('a' + i), map.get((char) ('a' + i)) - 1);
                    System.out.print((char) ('A' + i));
                    System.out.print((char) ('a' + i));
                }
                System.out.println();
            }
        }

//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
    }
}