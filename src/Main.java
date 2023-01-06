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
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;

    }
    public List<List<String>> groupAnagrams(String[] strs){

        List<List<String>> resultList = new ArrayList<>();
        if (strs.length == 0){return resultList;}
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s: strs) {

            char[] hash = new char[26];
            for (char c: s.toCharArray()){
                hash[c - 'a']++;
            }
            String key = new String(hash);
            hashMap.computeIfAbsent(key, k -> new ArrayList<>());
            hashMap.get(key).add(s);
        }
        resultList.addAll(hashMap.values());
        return resultList;
    }

}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strs = new String[]{"cat","act","zxc","czx","xzc"};
        List<List<String>> tmp = solution.groupAnagrams(strs);
        System.out.println(tmp);
    }
}