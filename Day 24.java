/*
Advantage Shuffle
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
*/
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Integer[] order = new Integer[B.length];
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) order[i] = i;
        Arrays.sort(order, (a,b) -> Integer.compare(B[b], B[a]));
        Arrays.sort(A);
        int i = 0, j = B.length - 1;
        for (int index : order)
            ans[index] = A[j] > B[index] ? A[j--] : A[i++];
        return ans;
    }
}