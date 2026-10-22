package hot_100.base;


import java.util.HashSet;
import java.util.Set;

/**3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * 0 <= s.length <= 105
 * s 由英文字母、数字、符号和空格组成
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        int right = 0, left = 0, max_len = 0;
        Set<String> strSet = new HashSet<>();   // 用来存储区间字符串
        char[] strToList = s.toCharArray();     // 将字符串转字符数组
        while (right < strToList.length) {
            if (strSet.contains(String.valueOf(strToList[right]))) {
                // 如果当前索引对应的字符数组的值存在set区间字符串里面,则移除set里的,然后左指针移动
                strSet.remove(String.valueOf(strToList[left]));
                left += 1;
            }else {
                // 不存在则添加进set
                strSet.add(String.valueOf(strToList[right]));
                max_len = Math.max(max_len, strSet.size());
                right += 1;
            }
        }
        return max_len;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int right = 0, left = 0, max_len = 0;
        Set<Character> strSet = new HashSet<>();   // 用来存储区间字符串
        char[] strToList = s.toCharArray();     // 将字符串转字符数组
        while (right < strToList.length) {
            if (strSet.contains(strToList[right])) {
                // 如果当前索引对应的字符数组的值存在set区间字符串里面,则移除set里的,然后左指针移动
                strSet.remove(strToList[left]);
                left += 1;
            }else {
                // 不存在则添加进set
                strSet.add(strToList[right]);
                max_len = Math.max(max_len, strSet.size());
                right += 1;
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        int max_len = lengthOfLongestSubstring1(s);
        int max_len1 = lengthOfLongestSubstring1(s1);
        int max_len2 = lengthOfLongestSubstring1(s2);
        System.out.println(max_len);
        System.out.println(max_len1);
        System.out.println(max_len2);
    }
}
