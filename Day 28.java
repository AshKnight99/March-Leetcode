/*
Reconstruct Original Digits from English
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
*/
class Solution {
    static final int[] DIGS = {0,2,4,6,8,5,7,3,9,1}, CHARS = {25,22,20,23,6,5,18,7,8,14};
    static final int[][] REMS = {{14},{14},{5,14},{18,8},{8,7},{8},{},{},{},{}};
    public String originalDigits(String S) {
        int[] fmap = new int[26], ans = new int[10];
        char[] SCA = S.toCharArray();
        for (char c : SCA) fmap[c - 97]++;
        for (int i = 0; i < 10; i++) {
            int count = fmap[CHARS[i]];
            for (int rem : REMS[i]) fmap[rem] -= count;
            ans[DIGS[i]] = count;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char c = (char)(i + 48);
            for (int j = 0; j < ans[i]; j++)
                sb.append(c);
        }
        return sb.toString();
    }
}