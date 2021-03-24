package lc1013PartitionArrayIntoThreePartsWithEqualSum;

/*
1013. 将数组分成和相等的三个部分
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。



示例 1：

输入：[0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
示例 2：

输入：[0,2,1,-6,6,7,9,-1,2,0,1]
输出：false
示例 3：

输入：[3,3,6,5,-2,2,5,1,-9,4]
输出：true
解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4


提示：

3 <= A.length <= 50000
-10^4 <= A[i] <= 10^4
*/

public class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }
        int partSum = sum / 3;
        if (partSum * 3 != sum) {
            return false;
        }
        int i = 0;
        int part1Sum = 0;
        boolean flag1 = false;
        while ((part1Sum != partSum && i < arr.length) || !flag1) {
            part1Sum += arr[i++];
            flag1 = true;
        }
        if (i == arr.length) {
            return false;
        }
        int part2Sum = 0;
        boolean flag2 = false;
        while ((part2Sum != partSum && i < arr.length) || !flag2) {
            part2Sum += arr[i++];
            flag2 = true;
        }
        if (i == arr.length) {
            return false;
        }
        int part3Sum = 0;
        boolean flag3 = false;
        while ( i < arr.length) {
            part3Sum += arr[i++];
            flag3= true;
        }
        return part3Sum == partSum && flag3;
    }
}
