package cn.penghaonan.problems;

import cn.penghaonan.ITest;
import cn.penghaonan.Logger;

public class LongestSubstringWithoutRepeatingCharacters implements ITest {
    @Override
    public void test() {
        String testStr = "a";
        Logger.log(lengthOfLongestSubstring(testStr) + "");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            boolean hasSame = false;
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    start = j + 1;
                    hasSame = true;
                    break;
                }
            }
            if (!hasSame) {
                int length = i - start + 1;
                maxLength = length > maxLength ? length : maxLength;
            }
        }
        return maxLength;
    }
}
