package middle;

/**
 * Created by billlin on 2018/12/23
 */
public class LongestPalindromicSubstring3 {
    // DP的关键是通过状态的合并减少计算量
    public String longestPalindrome(String s){
        String result = "";
        if(s == null || s.length() == 0){
            return result;
        }

        // 子序列s(i...j)的头尾是否相同
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 0;

        for(int j = 0; j < s.length(); j++){
            for(int i = 0; i <= j; i++){
                // s[i]与s[j]相同，同时j==i或者j与i只隔一位或者s[i+1]与[sj-1]相同时，当前子序列为回文子序列
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i+1][j-1]);
                if(dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";
        LongestPalindromicSubstring3 longestPalindromicSubstring3 = new LongestPalindromicSubstring3();
        System.out.println(longestPalindromicSubstring3.longestPalindrome(s));
    }
}
