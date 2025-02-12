class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for(int i = 0; i < times.length; i++){
            if(max < times[i]) max = times[i];
        }

        long left = 1;
        long right = max * n;

        while(left <= right){
            long mid = (left + right) / 2;

            // mid 시간 동안 심사할 수 있는 사람 수 구하기
            long num = 0;
            for(int i = 0; i < times.length; i++){
                num += mid / times[i];
            }

            // num이 n보다 작다면 left = mid+1
            // num이 n보다 크거나 작면 right = mid-1
            if(num < n) left = mid+1;
            else right = mid-1;
        }

        return right+1;
    }
}