You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word in 
words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0){
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int count = map.size();
        int len = words[0].length();
        int last = s.length() - len * words.length;
        int start = 0;
        while (start  <= last){
            Map<String, Integer> copy = new HashMap<>(map);
            for (int i = 0; i < words.length; i++){
                String str = s.substring(start+i*len, start+i*len+len);
                if (copy.containsKey(str)){
                    copy.put(str, copy.get(str) - 1);
                    if (copy.get(str) == 0){
                        copy.remove(str);
                    }
                    if (copy.isEmpty()){
                        result.add(start);
                        break;
                    }
                }else{
                    break;
                }
            }
            start++;
        }
        return result;
    }
}