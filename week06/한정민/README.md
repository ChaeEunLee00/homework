# 문제 풀이

### 프로그래머스 입국심사

- 시간 범위 설정
    - 최소 시간(left) : 가장 빠른 심사관이 1명을 심사하는 시간 -> `min(times)`
    - 최대 시간(right) : 가장 느린 심사관이 모두(n명) 심사하는 시간 -> `max(times) * n`
- total = mid 시간 동안 심사한 총 인원
    - total >= n : 시간 충분 -> `right = mid - 1`
    - total < n : 시간 부족 -> `left = mid + 1`