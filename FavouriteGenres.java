// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        HashMap<String, List<String>> songGenres = new HashMap<>();
        userSongs.put("David", Arrays.asList("Song1", "Song4", "Song5", "Song8"));
        userSongs.put("Emma", Arrays.asList("Song2", "Song4", "Song3", "Song5"));
        userSongs.put("Malcom", Arrays.asList("Song7", "Song8", "Song5"));
        songGenres.put("Jazz", Arrays.asList("Song1", "Song2", "Song7"));
        songGenres.put("Pop", Arrays.asList("Song3", "Song4", "Song5"));
        songGenres.put("Rock", Arrays.asList("Song6", "Song8"));
        
        Map<String, List<String>> result = find(userSongs, songGenres);
        System.out.println(result);
    
        
    }
    
    public static Map<String, List<String>> find(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {
        
        HashMap<String, String> songToGenre = new HashMap<>();
        
        for (String genre: songGenres.keySet()) {
            for (String song: songGenres.get(genre)) {
                songToGenre.put(song, genre);
            }
        }
        
         HashMap<String, List<String>> result = new HashMap<>();
        
        for (String user : userSongs.keySet()) {
            List<String> songs = userSongs.get(user);
            Map<String, Integer> countMap = new HashMap<>(); 
            int max = 0;
            for (String song : songs) {
                String genre = songToGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                max = Math.max(max, countMap.get(genre));
            }
            
            List<String> genres = new ArrayList<>();
            for (String genre: countMap.keySet()) {
                if (countMap.get(genre) == max) {
                    genres.add(genre);
                }
            }
            
            result.put(user, genres);
        }
        
        return result;
   
    }
}