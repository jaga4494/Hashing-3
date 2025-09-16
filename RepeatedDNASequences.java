class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>(); // can just use set instead of map
        HashSet<String> result = new HashSet<>();


        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        return map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        // or return new ArrayList<>(result);

    }
}