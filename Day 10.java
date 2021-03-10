/*
*/
class Solution {
     final static int cons[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
      final static String val[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
     public String intToRoman(int num) {
       StringBuilder ans = new StringBuilder();
         for(int i = 0; num > 0; i++){
             while(num >= cons[i]){
                 ans.append(val[i]);
                 num -= cons[i];
                 }
         }
        return ans.toString();
    }
}