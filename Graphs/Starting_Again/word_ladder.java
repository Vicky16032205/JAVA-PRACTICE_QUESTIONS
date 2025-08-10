package Graphs.Starting_Again;

import java.util.*;

public class word_ladder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        set.remove(beginWord);
        int count = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                String curr = queue.poll();

                if(curr.equals(endWord)) return count;
                
                StringBuilder sb = new StringBuilder(curr);

                for(int i=0;i<sb.length();i++){
                    char c = sb.charAt(i);
                    for(char ch = 'a'; ch<='z';ch++){
                        if(ch == c) continue;

                        sb.setCharAt(i, ch);
                        String word = sb.toString();
                        if(set.contains(word)){
                            set.remove(word);
                            queue.add(word);
                        }
                    }
                    sb.setCharAt(i, c);
                }
            }
            count++;
        }
        return 0;
    }
}