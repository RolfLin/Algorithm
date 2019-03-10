package nowCoder.recursion;

import java.lang.String;

/**
 * Created by billlin on 2019/2/8
 */
// 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）

// 思路：每次跳一阶，则剩下n-1台阶，跳法f(n-1)，跳两阶，则剩下n-2台阶，跳法f(n-2)，
// 则总跳法为f(n) = f(n-1) + f(n-2)
// 除了n=1和n=2时特殊
// 可以发现实际为一个斐波那契数列

public class JumpFloor {
        public int JumpFloor(int target) {
            // 每阶段最优状态与之前的某个阶段，以及阶段状态如何得到都有关，所以应该是贪心方法解决
            int result = judgeFloor(target);
            return result;
        }

        public int judgeFloor(int n){
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }
            return judgeFloor(n - 1) + judgeFloor(n - 2);
        }

        public int jumpFloorNonRecursion(int n){
//            非递归，保留上两个阶段的结果
            int a = 1, b = 2, c = 0;
            if(n <= 0){
                return 0;
            }
            if(n == 1){
                return 1;
            }
            else if(n == 2){
                return 2;
            }

            for(int i = 3;i <= n; i++){
                c = a + b;
                b = a;
                a = c;
            }

            return c;
        }


    public static void main(String[] args) {

    }
}
