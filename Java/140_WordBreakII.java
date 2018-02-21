Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces 
in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary
does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Method 1: dfs
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0){
            return result;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        if (wordDict.contains(s)){
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++){
            String sub = s.substring(i);
            if (wordDict.contains(sub)){
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() != 0){
                    for (String str : temp){
                        result.add(str +" " + sub);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
}