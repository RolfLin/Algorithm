package middle.dp;

/**
 * 题目描述：给定数组arr，返回arr的最长递增子序列。【例子】：
 * arr=[10,22,9,33,21,50,41,60,80],返回的最长递增子序列为[10,22,33,41,60,80]长度为6。
 */

public class LongestSubString {
    public static int longestSubString1(int arr[])
    {
        if(arr==null||arr.length==0)
            return 0;
        int l=0,r=0,right=0;
        int len=0;
        int ends[]=new int[arr.length];
        int dp[]=new int[arr.length];
        dp[0]=1;
        ends[0]=arr[0];
        //ends[0]开始时存放arr[0],
        for(int i=1;i<arr.length;i++)
        {
            l=0;
            r=right;
            //如果arr[i]比 ends 数组中的所有元素都大则放到 ends 后面，
            //否则用arr[i]代替ends数组中第一个比arr[i]大的数，保持 ends 递增。
            while(l<=r)
            {
                int mid=(l+r)/2;
                if(arr[i]>ends[mid])
                {
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
            right=Math.max(l,right);
            ends[l]=arr[i];
            dp[i]=l+1;
            //arr[i]在数组 ends 中的位置，就是以arr[i]结尾的最长单调子序列的长度。
        }
        len=right+1;

        System.out.println("len : " + len);

        for (int i : dp) {
            System.out.println(i);
        }
        return len;
    }

    public static void main(String[] args) {
        longestSubString1(new int[]{2,1,5,3,6,4,8,9,7});
    }
}
