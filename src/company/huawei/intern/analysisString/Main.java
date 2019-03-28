package company.huawei.intern.analysisString;

import java.util.Scanner;

public class Main {
    public static void getResult(int n, String s) {
        char[] chars = new char[9];
        String[] strs = new String[n];

        int start = 0, end = 9;
        int index = 0;
        while(index < n) {
            strs[index] = s.substring(start, end);
            start += 9;
            end += 9;
            index++;
        }

//----------------------------更改
        char[] res = new char[n * 9];
        int resIndex = 0;
        int flag = 0;
        for (String curS : strs) {
            chars = curS.toCharArray();
            if(chars[0] == '1') {
                for(int i = 1;i < chars.length;i++) {
                    res[resIndex++] = chars[i];
                }
            }else {
                for(int i = chars.length - 1;i >= 1;i--) {
                    res[resIndex++] = chars[i];
                }
            }
            if(flag != strs.length - 1) {
                res[resIndex++] = ' ';
            }
            flag++;
        }
        System.out.println(res);

//----------------------------更改

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            getResult(n, str);
        }
    }
}
