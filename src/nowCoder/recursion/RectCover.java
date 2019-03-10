package nowCoder.recursion;

/**
 * Created by billlin on 2019/2/10
 */

public class RectCover {
    /**
     *
     * 题目描述：
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 思路：与跳台阶非常类似，转化为一个选择走一步（横着放）还是走两步（竖着放）的问题。同样，可以非递归解决。
     */

    public int RectCover(int target) {
        int first = 1, second = 2, sum = 0;
        if(target == 1){
            return 1;
        }
        else if(target == 2){
            return 2;
        }
        for(int i = 3; i <= target; i++){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
