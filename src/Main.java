import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> uniq = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniq.contains(nums[i])) {
                return true;
            }
            uniq.add(nums[i]);
        }
        return false;
    }

    public boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Hash = new HashMap<>();
        HashMap<Character, Integer> s2Hash = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            int current = s1Hash.getOrDefault(s1.charAt(i), 0);
            s1Hash.put(s1.charAt(i), current + 1);

        }
        for (int i = 0; i < s2.length(); i++) {

            int current = s2Hash.getOrDefault(s2.charAt(i), 0);
            s2Hash.put(s2.charAt(i), current + 1);

        }

        if (!s1Hash.equals(s2Hash)) {
            return false;
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> resultList = new ArrayList<>();
        if (strs.length == 0) {
            return resultList;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s : strs) {

            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            hashMap.computeIfAbsent(key, k -> new ArrayList<>());
            hashMap.get(key).add(s);
        }
        resultList.addAll(hashMap.values());
        return resultList;
    }

    public int[] topFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        LinkedHashMap<Integer, Integer> sortedHash = new LinkedHashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2).compareTo(o1);
            }
        });
        for (Integer i : list) {
            for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
                if (entry.getValue().equals(i)) {
                    sortedHash.put(entry.getKey(), i);
                }
            }
        }

        for (Integer i : sortedHash.keySet()) {
            if (k > 0) {
                res[k - 1] = i;
                k--;
            }
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    tmp *= nums[j];
                }
            }
            res[i] = tmp;
        }
        return res;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        int postfix = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];

        }
        for (int i = nums.length - 1; i > -1; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }


        return res;
    }

    public boolean isValidSudoku(char[][] board) {

        //check each rows
        for (char[] cArr : board) {
            HashMap<Character, Integer> rowMap = new HashMap<>();
            for (Character c : cArr) {
                if (!c.equals(',') && (!c.equals('.'))) {
                    rowMap.put(c, rowMap.getOrDefault(c, 0) + 1);
                }
            }
            for (Integer val : rowMap.values()) {

                if (val != 1) {
                    return false;
                }
            }


        }

        //check cols
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> colMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                Character c = board[j][i];
                if (!c.equals(',') && !c.equals('.')) {
                    colMap.put(c, colMap.getOrDefault(c, 0) + 1);
                }
            }
            for (Integer val : colMap.values()) {
                if (val != 1) {
                    return false;
                }
            }
        }
        //check 3x3 blocks
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if(!checkBlock(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkBlock(int I, int J, char[][] board){
        Set<Character> blockSet = new HashSet<>();
        int rows = I + 3;
        int cols = J + 3;

        for (int i = I; i < rows; i++) {
            for (int j = J; j < cols; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                if (blockSet.contains(board[i][j])){
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }
        return true;
    }


}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] board = new char[][]
                {{'1', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean b = solution.isValidSudoku(board);
        System.out.println(b);
//        for (char[] cArr : board) {
//            for (Character c : cArr) {
//                System.out.print(c + " ");
//            }
//            System.out.println("\n");
//        }
    }
}