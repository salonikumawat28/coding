/**
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * 
 * Input: haystack = "", needle = ""
 * Output: 0
 *  
 * 
 * Constraints:
 * 
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        ImplementStrStr solution = new ImplementStrStr();
        System.out.println(solution.strStr(haystack, needle));
    }

    /**
     * Return the index where needle matches haystack.
     * 
     * steps:
     * 1. if haystack length < needele length , return -1
     * 2. if needle length == 0 , return 0
     * 3. find  31^needle length, so that it can be used by rolling hash
     * 4. find hashcode of needle.
     * 5. find hashcode of haystack from 0 to needle length - 1
     * 6. start a loop from 0 to (haystack length - needle length)
     * 7. for i != 0, find hashcode of haystack from i to i + m -1, where m is needle length, using rolling approach
     * 8. check if needle hashcode and haystack hashcode matches
     * 9. if matches, check each character of both string, if matches return i
     * 10. at the end of loop return -1
     * @param haystack is input string
     * @param needle is input string
     * @return index where needle matches haystack
     */
    public int strStrRolling(String haystack, String needle) { // O(n+m), O(1) where n is length of haystack and m is lrngth of needle. This is assuming collision are less but if collision are more then TC = O(nm).
        int hayLength = haystack.length(); // O(1), O(1)
        int needleLength = needle.length(); // O(1), O(1)
        if(hayLength < needleLength) return -1; // O(1), O(1)
        if(needleLength == 0) return 0; // O(1), O(1)
        int power = power(needleLength); // O(m), O(1)
        int needleHashcode = findHashcode(needle, 0, needleLength - 1); // O(m), O(1)
        int haystackHashcode = findHashcode(haystack, 0, needleLength - 1); // O(m), O(1)

        for(int i = 0; i <= hayLength - needleLength; i++) { // O(n+m), O(1). Assuming collision are less because of good hash, matches() will be called around once.
            if(i != 0) haystackHashcode = rollingHashcode(haystackHashcode, haystack, i, needleLength, power); // O(1), O(1)
            if(haystackHashcode == needleHashcode && matches(needle, haystack, i)) return i; // O(m), O(1)
        }
        return -1; // O(1), O(1)
    }

    /**
     * Find hashcode of given input string.
     * 
     * steps:
     * 1. start a for loop i from start to end 
     * 2. for each i, hashcode = hashcode * 31 + str[i]
     * 3. return hashcode
     * @param str is input string
     * @param start is starting index
     * @param end id ending index
     * @return hashcode of input string
     */
    private int findHashcode(String str, int start, int end) { // O(m), O(1) where m is length of needle
        int hashcode = 0; // O(1), O(1)
        for(int i = start; i <= end; i ++) { // O(m), O(1)
            hashcode = hashcode * 31 + str.charAt(i); // O(1), O(1)
        }
        return hashcode; // O(1), O(1)
    }
    
    /**
     * Find rolling hashcode of input string.
     * 
     * steps:
     * 1. return oldhashcode*31 - str[start-1]*31^length + str[start+length-1]
     * @param hashcode is given hashcode
     * @param str is input string
     * @param start is staring index
     * @param length is length of string
     * @return new rolling hashcode
     */
    private int rollingHashcode(int oldHashcode, String str, int start, int length, int power) { // O(1), O(1) 
        return (oldHashcode - str.charAt(start - 1) * power) * 31 
                + str.charAt(start - length - 1) ; // O(m), O(1)
    }

    /**
     * Matches str1 with str2
     * 
     * steps:
     * 1. start a loop from 0 to length of str1
     * 2. for each i, check str1[i] equals to str2[start2 + i]
     * 3. if not matches, return false
     * 4. at the end of loop return true
     * @param str1 is input string
     * @param str2 is input string
     * @param start2 is starting index of str2 input string
     * @return if both string maches or not
     */
    private boolean matches(String str1, String str2, int start2) { // O(m), O(1) where m is length of needle
        for(int i = 0; i < str1.length(); i++) { // O(m), O(1)
            if(str1.charAt(i) != str2.charAt(start2 + i)) return false; // O(1), O(1)
        }
        return true; // O(1), O(1)
    }

    /**
     * Find power
     * 
     * steps:
     * 1. initilise power = 1. Make it long so that it does not overflow.
     * 2. start a for loop i from 0 to length
     * 3. for each i, do power = power * 31
     * 4. at the end of loop return power. make it int with risk of data loss.
     * 
     * @param length is length of input string
     * @return power
     */
    private int power(int length) { // O(m), O(1) where m is length of needle
        long power = 1; // O(1), O(1)
        for(int i = 0; i < length; i++) { // O(m), O(1)
            power = power * 31; // O(1), O(1)
        }
        return (int)power; // O(1), O(1)
    }

    /**
     * Return first occurance of needle input string in haystack input string.
     * 
     * step 1: start a loop from 0 to n, length of haystring
     * step 2: check each ithcharcter of haystack with starting character of needle string.
     * step 3: if matches, update counter with ith index and check next charcters of needle string with next characters of haystack in countinous way.
     * step 5: if string is empty return 0
     * step 6: at the end return i
     * 
     * step 1: start a loop from 0 to n, length of haystack
     * step 2: for each ith index check if haystack matches with needle string
     * step 3: if matches return i
     * step 4: at the end loop return -1 because nothing matches 
     * 
     * @param haystack
     * @param needle
     * @return
     */                                                 
    public int strStr(String haystack, String needle) { // O(mn), O(1) where n is haystack length and m is needle length
        int counter = 0; //
        int j = 0; // 
        int hayLength = haystack.length(); // O(1), O(1)
        int needleLength = needle.length(); // O(1), O(1)
        if((hayLength == 0 && needleLength == 0) || needleLength == 0 ) return 0; // O(1), O(1)
        if(hayLength < needleLength) return -1; // O(1)
        for(int i = 0; i < hayLength; i++) { // O(mn), O(1) 
            if(haystack.charAt(i) == needle.charAt(0)) { // O(m), O(1)
                counter  = i; // O(1), O(1)
                j = 1; // O(1), O(1)
                while(j < needleLength && counter < hayLength - 1){  // O(m), O(1) where m is length of needle
                    if(haystack.charAt(++counter) != needle.charAt(j)) break;  // O(1), O(1)
                    j++; // O(1), O(1)
                }
                if(j == needleLength) return i;
            }

        }
        return -1;
    }
    
}
