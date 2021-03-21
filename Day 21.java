/*
Reordered Power of 2
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
 

Note:

1 <= N <= 10^9
*/
class Solution {
    public boolean reorderedPowerOf2(int N) {
        char ch[] = String.valueOf(N).toCharArray();
        Arrays.sort(ch);
        for(int i = 0; i < 30; i++){
            char ch1[] = String.valueOf(1 << i).toCharArray();
            Arrays.sort(ch1);
            if(ch1.length > ch.length) return false;
            if(Arrays.equals(ch,ch1)) return true;
        }
        return false;
        
    }
}