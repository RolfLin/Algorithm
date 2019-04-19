package middle.dp;

import java.util.HashMap;
import java.util.Map;


/**
 * 描述
 中文
 English
 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的最短子串。

 如果在source中没有这样的子串，返回""。
 如果有多个这样的子串，保证在source中始终只有一个唯一的最短子串。
 目标字符串可能包含重复字符，最小窗口应覆盖所有字符，包括目标中的重复字符

 说明
 在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？

 ——不需要。

 样例
 例1:

 输入:
 ""
 ""
 输出:
 ""
 例2:

 输入:
 "ADOBECODEBANC"
 "ABC"
 输出:
 "BANC"

 思路：首先建一个map（我并没有使用C++里面的map，而是用的vector，道理是一样的），大小分配128（所有大写字母的ASCII码不超过128），初始化为0。
 遍历target，是map相应的位置上加1。之后设置两个指针，begin和end，用于计算长度。
 当target的字母在source中出现时，counter减1，当counter减为0时，target中的全部字母已包含在source的子串中，接着我们比较子串的长度选出最小的即可。

 */
public class MinWindow {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    static String minWindow(String source, String target) {
        // write your code here
//        Map<Integer, Integer> map = new HashMap<>();
        int[] map = new int[256];
        for (char c : target.toCharArray()) map[c]++;
        int counter = target.length(),begin = 0,end = 0,d = Integer.MAX_VALUE,head = 0;
        while (end < source.length()) {
            if (map[source.charAt(end++)]-- > 0) counter--;
            while (counter == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                if (map[source.charAt(begin++)]++ == 0) counter++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : source.substring(head,d);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
