package nowCoder.array;

/**
 * @description:
 * @author: billlin
 * @create: 2019-02-26 09:49
 **/
public class Duplicate {

    /**
     * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     *
     * 思路：
     * 1. 先排序再遍历一次找，排序时间O(nlogn)
     * 2. 建立哈希表，查重。要求空间O(n)
     * 3. 遍历一遍，因为元素范围从0到n-1，对应数组长度，所以将数组的元素放到对应下标位置，
     * 就知道是否会有重复。
     * 所以每次判断当前下标是否与值相同，
     * 相同则跳过，
     * 不同则判断值与当前值对应下标位置的值是否相同，
     * 相同则代表重复，结束；
     * 不同则交换值，往下遍历。
     */

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int i = 0;
        while(i < length){
            if(numbers[i] == i){
                i++;
                continue;
            }else if(numbers[i] == numbers[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }else{
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
            i++;
        }
        return false;
    }

}
