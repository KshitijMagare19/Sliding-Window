import java.util.Arrays;
import java.util.HashMap;

public class Count_Occurrences_Of_Anagrams {

    static int solve(String s1, String s2) {

        // * Bruth Force O(n!)
        // find all posible anagrams of given string s2
        // this will take O(n!) time.
        // then compare each window with all possible anagrams of given string s2
        // this takes too much time

        // * Optimized Sliding Window O(n)
        // step 1 : create map of s2
        // store size of map in count
        // step 2:
        int ans = 0;
        int k = s2.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int count = map.size();
        int i = 0, j = 0, n = s1.length();
        while (j < n) {
            char c = s1.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    ans++;
                }
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    // * Another approach O(n log n)
    static boolean isAnagram(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
    static int solve2(String s1, String s2){
        int ans = 0;
        int len = s2.length();
        for(int i = 0; i <= s1.length()-len; i++){
            if(isAnagram(s1.substring(i, i+len),s2)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "forxxorfxdofr";
        String s2 = "for";
        System.out.println("Count_Occurrences_Of_Anagrams : " + solve2(s1, s2));

    }

}
