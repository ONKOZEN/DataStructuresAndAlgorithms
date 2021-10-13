package com.leetCode;

import java.util.Objects;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int res = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        if (Objects.equals(s, "")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int record = 0;
        int flag;
        for (int i = 0; i < s.length(); i+=flag) {
            flag = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (j == s.length() - 1) {
                    flag = j - i + 1;
                    //i += flag;
                    if (flag > record) {
                        record = flag;
                        break;
                    }
                }
                if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    flag = j - i;
                    //i +=flag;
                    if (flag > record) {
                        record = flag;
                        break;
                    }
                }

            }
        }
        return record;
    }
}
