package middle.dp;


/**
 * 题目：647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 思路：分奇数回文子串和偶数回文子串。两种都是以当前位置元素为中心，往两侧遍历，两侧当前元素相同则count++;
 * 奇数时，注意自身也为回文子串；
 * 偶数回文子串时，让right为i+1,则不会重复遍历
 *
 */
public class CountSubString {
    int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(i, i, s);
            extendPalindrome(i, i + 1, s);
        }
        return count;
    }

    public void extendPalindrome(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}