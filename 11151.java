class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) {
            return "";
        }
        int longest = 1;
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int[] temp = expandCenter(s, i, i);
            int[] temp2 = expandCenter(s, i, i + 1);
            if((temp[1] - temp[0]) + 1 > longest) {
                start = temp[0];
                end = temp[1];
                longest = temp[1] - temp[0] + 1;
            }
            if((temp2[1] - temp2[0]) + 1 > longest) {
                start = temp2[0];
                end = temp2[1];
                longest = temp2[1] - temp2[0] + 1;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int[] expandCenter(String s, int i, int j) {
        int[] ret = new int[2];
        if(i != j && s.charAt(i) != s.charAt(j)) {
            ret[0] = 0;
            ret[1] = 0;
            return ret;
        }
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        ret[0] = i + 1;
        ret[1] = j - 1;
        return ret;
    }
}
