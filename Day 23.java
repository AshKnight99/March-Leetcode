/*
3Sum With Multiplicity
Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
 

Constraints:

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
*/
class Solution {
    public int threeSumMulti(int[] A, int T) {
        long[] nmap = new long[101];
        long ans = 0;
        for (int num : A) nmap[num]++;
        for (int k = 100; k >= 0; k--)
            for (int j = k; j >= 0; j--) {
                int i = T - k - j;
                if (i > j || i < 0) continue;
                long x = nmap[i], y = nmap[j], z = nmap[k], res = x * y * z;
                if (res == 0) continue;
                if (i == k) res = x * (x-1) * (x-2) / 6;
                else if (i == j) res = x * (x-1) / 2 * z;
                else if (j == k) res = x * y * (y-1) / 2;
                ans += res;
            }
        return (int)(ans % 1000000007);
    }
}
