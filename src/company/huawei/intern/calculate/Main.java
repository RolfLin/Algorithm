package company.huawei.intern.calculate;

import java.util.Scanner;

/**
 * 题目描述：按行打印所给字符串的大小写字母蛇形字符串序列，如SsAa~&*sRSr，要求去
 * 1. 先打印长的蛇形子序列
 * 2. 子序列长度相等，则按字符大小顺序打印
 * 3. 先大写再小写
 * 4. 已打印过的那位字符串不能再次打印
 * 5. 蛇形字符串要字母相连才算，如sRSr,因为s是r的后一位，所以可以打印RrSs
 *
 *
 *
 * 举例：SsAa~&*sRSr 打印结果如下
 * RrSs
 * Aa
 * Ss
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int res = Integer.parseInt(String.valueOf(chars[0]));
        int i = 1;
        if(chars.length > 1 && chars[1] >= '0' && chars[1] <= '9') {
            res = res * 10 + Integer.parseInt(String.valueOf(chars[1]));
            i++;
        }
        for(; i < chars.length; i++){
            char c = chars[i++];
            int cur = Integer.parseInt(String.valueOf(chars[i++]));
            if(i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                cur = cur * 10 + Integer.parseInt(String.valueOf(chars[i]));
            }
            if(c == '+'){
                res += cur;
            }else {
                res -= cur;
            }
        }
        System.out.println(res);
    }
}