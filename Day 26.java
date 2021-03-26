/*
  Word Subsets
We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

 

Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 

Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
*/

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] Bfreq = new int[26], check = new int[26];
        int cmax = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < B.length; i++, Arrays.fill(check, 0)) {
            char[] word = B[i].toCharArray();
            for (int j = 0; j < word.length; j++)
                check[word[j] - 'a']++;
            for (int j = 0; j < 26; j++) {
                int diff = check[j] - Bfreq[j];
                if (diff > 0) {
                    cmax += diff;
                    Bfreq[j] += diff;
                }
                if (cmax > 10) return ans;
            }
        }
        for (int i = 0; i < A.length; i++, Arrays.fill(check, 0)) {
            char[] word = A[i].toCharArray();
            int j;
            if (word.length < cmax) continue;
            for (j = 0; j < word.length; j++)
                check[word[j] - 'a']++;
            for (j = 0; j < 26; j++)
                if (check[j] < Bfreq[j]) break;
            if (j == 26) ans.add(A[i]);
        }
        return ans;
    }
}