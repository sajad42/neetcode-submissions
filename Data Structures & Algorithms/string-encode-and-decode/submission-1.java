class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        if (strs == null || strs.isEmpty()) return result.toString();
        for (String str : strs) {
            int length = str.length();
            result.append(length).append("#").append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;

        int i=0;
        while (i < str.length()) {
            int endOfNum = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, endOfNum));
            
            result.add(str.substring(endOfNum +1, endOfNum+1 + length));

            i = endOfNum+1 + length;
        }
        return result;
    }
}
