class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long number = numbers[i];

            // 이진수로 표현
            StringBuilder sb = new StringBuilder();
            while(number > 0){
                if(number%2 == 0) sb.insert(0,'0');
                else sb.insert(0,'1');
                number /= 2;
            }

            // 완전이진트리를 위한 길이 맞추기
            int n = 2;
            int length = sb.length();
            while(n-1 < length){
                n *= 2;
            }

            int cnt = n-1-length;
            for(int j = 0; j < cnt; j++){
                sb.insert(0,'0');
            }

            // 완전이진트리인지 확인하기
            if(isComplete(sb) != -1) answer[i] = 1;
            else answer[i] = 0;
        }

        return answer;
    }

    int isComplete(StringBuilder sb){
        int len = sb.length();
        if(len == 1) return sb.charAt(0) - '0';

        StringBuilder sbLeft = new StringBuilder(sb.substring(0, len/2));
        StringBuilder sbRight = new StringBuilder(sb.substring(len/2+1));

        int root = sb.charAt(len/2) - '0';
        int left = isComplete(sbLeft);
        int right = isComplete(sbRight);

        if(left == -1 || right == -1) return -1;
        if(root == 0 && left + right > 0) return -1;
        return root;
    }
}