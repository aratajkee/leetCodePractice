import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> uniq = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniq.contains(nums[i])){
                return true;
            }
            uniq.add(nums[i]);
        }
        return false;
    }
    public boolean isAnagram(String s1, String s2){

        if (s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> s1Hash = new HashMap<>();
        HashMap<Character, Integer> s2Hash = new HashMap<>();

        for (int i = 0;i < s1.length();i++){

            int current = s1Hash.getOrDefault(s1.charAt(i), 0);
            s1Hash.put(s1.charAt(i), current + 1);

        }
        for (int i = 0;i < s2.length();i++){

            int current = s2Hash.getOrDefault(s2.charAt(i), 0);
            s2Hash.put(s2.charAt(i), current + 1);

        }

       if (!s1Hash.equals(s2Hash)){
           return false;
       }
       return true;
    }

}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}