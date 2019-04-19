package middle.dp;

/**
 * 题目描述：给定数组arr，返回arr的最长递增子序列。【例子】：
 * arr=[10,22,9,33,21,50,41,60,80],返回的最长递增子序列为[10,22,33,41,60,80]长度为6。
 *
 * 思路：遍历一遍，记录以当前元素为递增子序列时的最长长度，再找出最长的一个即可。
 * 需要建立两个数组。
 * 数组dp，存放arr对应位置元素作为子序列结尾时的最长递增长度。
 * 数组ends，存放某个arr元素，该元素所在ends数组的位置下标，即代表了以该元素作为最小结尾时的递增子序列的序列长度。
 * 所以ends需要不断更新某个位置下标对应的元素值，因为是有序的，可以直接二分查找位置。
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
