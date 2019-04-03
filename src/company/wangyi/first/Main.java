package company.wangyi.first;


import java.util.Scanner;

public class Main {


    public static String getResult(String str) {
        if(str.trim().equals("")) {
            return str;
        }
        char[] order = str.toCharArray();
        char[] reverse = new char[order.length];
        int reverseIndex = 0;
        for(int i = order.length - 1; i >= 0; i--){
            reverse[reverseIndex] = order[i];
            reverseIndex++;
        }
        String reverseStr = new String(reverse);
        String[] arr = reverseStr.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int strIndex = arr.length - 1;
        for(String curStr : arr) {
            char[] chars = curStr.toCharArray();
            int index = 0;
            char[] curC = new char[chars.length];
            for(int i = 0; i < chars.length; i++) {
                if((chars[i] >= 'a'&& chars[i] <= 'z') || (chars[i] >= 'A'&& chars[i] <= 'Z') ||
                        (chars[i] >= '0' && chars[i] <= '9')) {
                    curC[index] = chars[i];
                    index++;
                }else {
                    char[] tmp = new char[curC.length];
                    int tmpIndex = curC.length - 1;
                    for(char c : curC) {
                        tmp[tmpIndex--] = c;
                    }
                    stringBuffer.append(new String(tmp));
                    stringBuffer.append(chars[i]);
                    if(i < chars.length) {
                        curC = new char[curC.length];
                        index = 0;
                    }
                }
            }
            if(index != 0) {
                char[] tmp = new char[curC.length];
                int tmpIndex = curC.length - 1;
                for(char c : curC) {
                    tmp[tmpIndex--] = c;
                }
                stringBuffer.append(new String(tmp));
            }

            if(strIndex > 0) {
                stringBuffer.append(" ");
            }
            strIndex--;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(getResult(str));

    }
}
