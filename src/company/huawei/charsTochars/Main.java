package company.huawei.charsTochars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 题目描述：写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 *
 * 思路：利用幂函数pow方法，进行pow(底数，指数) * 当前位的常数项即可，注意常数项要判断下A与F字符的特殊情况，
 * 大写字母、小写字母、0到9的ascii码是不相连的
 */

public class Main {


    public static String transfer(String str) {
        char[] chars = str.toCharArray();
        int sum = 0;
        int index = 0;
        for(int i = chars.length - 1; i >= 2; i--) {
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                sum += (Math.pow(16, index)) * (chars[i] - 'A' + 10);
            }else {
                sum += (Math.pow(16, index)) * (chars[i] - '0');
            }
            index++;
        }
//        System.out.println(sum);
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strs = new ArrayList<>();
        while(sc.hasNext()){
            strs.add(sc.next());
        }
        for(String str : strs){
            String res = transfer(str);
            System.out.println(res);
        }
    }
}
