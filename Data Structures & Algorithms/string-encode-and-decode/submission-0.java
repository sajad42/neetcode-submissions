class Solution {

    public String encode(List<String> strs) {
        // Handle empty list safely
        if (strs == null || strs.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            // Append length + delimiter + actual string
            result.append(str.length()).append("#").append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) return result;

        int i = 0;
        while (i < str.length()) {
            // 1. Find where the delimiter '#' is
            int delimiterIndex = str.indexOf('#', i);
            
            // 2. Extract the full length (works for 10, 100, etc.)
            int length = Integer.parseInt(str.substring(i, delimiterIndex));
            
            // 3. Move pointer past the '#' symbol
            int startOfWord = delimiterIndex + 1;
            int endOfWord = startOfWord + length;
            
            // 4. Extract the actual string
            String currStr = str.substring(startOfWord, endOfWord);
            result.add(currStr);
            
            // 5. Move the pointer 'i' to the start of the next encoded block
            i = endOfWord;
        }
        return result;
    }
}
