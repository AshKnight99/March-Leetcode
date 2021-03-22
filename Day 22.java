/*
Vowel Spellchecker
Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
In addition, the spell checker operates under the following precedence rules:

When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
When the query matches a word up to capitlization, you should return the first such match in the wordlist.
When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
If the query has no matches in the wordlist, you should return the empty string.
Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

 

Example 1:

Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 

Note:

1 <= wordlist.length <= 5000
1 <= queries.length <= 5000
1 <= wordlist[i].length <= 7
1 <= queries[i].length <= 7
All strings in wordlist and queries consist only of english letters.
*/
class Solution {
    public String[] spellchecker(String[] W, String[] Q) {
        Set<String> orig = new HashSet<>(Arrays.asList(W));
        Map<String, String> lower = new HashMap<>(), mask = new HashMap<>();
        for (int i = W.length - 1; i >= 0; i--) {
            String word = W[i], wlow = word.toLowerCase();
            lower.put(wlow, word);
            mask.put(vmask(wlow), word);
        }
        for (int i = 0; i < Q.length; i++) {
            String query = Q[i], qlow = query.toLowerCase(),
                qmask = vmask(qlow);
            if (orig.contains(query)) continue;
            else if (lower.containsKey(qlow)) Q[i] = lower.get(qlow);
            else if (mask.containsKey(qmask)) Q[i] = mask.get(qmask);
            else Q[i] = "";
        }
        return Q;
    }
     public String vmask(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') c = '*';
            sb.append(c);
        }
        return sb.toString();
    }
}