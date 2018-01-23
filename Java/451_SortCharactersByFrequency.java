Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++){
            hash[s.charAt(i)]++;
        }
        TreeMap<Integer, List<Character>> map = new TreeMap<Integer, List<Character>>();
        for (int i = 0 ; i < hash.length; i++){
            if (hash[i] > 0){
                if (!map.containsKey(hash[i])){
                    map.put(hash[i], new ArrayList<Character>());
                }
                map.get(hash[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (map.size() > 0){
            Map.Entry<Integer, List<Character>> entry = map.pollLastEntry();
            for (Character c : entry.getValue()){
                for (int i = 0; i < entry.getKey(); i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}