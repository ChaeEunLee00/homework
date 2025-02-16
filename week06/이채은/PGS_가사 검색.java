import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> originWords = new HashMap<>();
        Map<Integer, List<String>> reverseWords = new HashMap<>();

        for(String word : words){
            int length = word.length();

            originWords.computeIfAbsent(length, i -> new ArrayList<>()).add(word);
            reverseWords.computeIfAbsent(length, i -> new ArrayList<>()).add(reverse(word));
        }


        for(int key : originWords.keySet()){
            List<String> list;

            list = originWords.get(key);
            Collections.sort(list);
            list = reverseWords.get(key);
            Collections.sort(list);
        }

        int qLength = queries.length;
        int[] answer = new int[qLength];
        for(int i = 0; i < qLength; i++){
            String query = queries[i];

            // 길이에 맞는 word list 꺼내기
            List<String> list;
            if(query.charAt(0) == '?'){
                list = reverseWords.get(query.length());
                query = reverse(query);
            } else{
                list = originWords.get(query.length());
            }

            // 구간 찾기
            if(list == null) answer[i] = 0;
            else{
                int low = binarySearch(list, query.replace('?',Character.MIN_VALUE));
                int high = binarySearch(list, query.replace('?',Character.MAX_VALUE));
                answer[i] = high - low;
            }
        }

        return answer;
    }

    int binarySearch(List<String> list, String target){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(list.get(mid).compareTo(target) < 0) left = mid+1;
            else right = mid-1;
        }
        return left;

    }

    String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}