package nowCoder.recursion;

/**
 * Created by billlin on 2019/2/9
 */
public class JumpFloorII {

//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

// 非递归处理方法：每个台阶可以看作一块木板,让青蛙跳上去,n个台阶就有n块木板,最后一块木板是青蛙到达的位子,必须存在,
// 其他n-1块木板可以任意选择是否存在,则每个木板有存在和不存在两种选择,n-1块木板就有
// 2^(n-1)种,可以直接得到结果

    public int JumpFloor(int target){
        return (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        System.out.println(jumpFloorII.JumpFloor(4));
    }

}
