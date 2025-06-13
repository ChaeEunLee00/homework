# 문제 풀이

### 백준 2805 나무 자르기

- Python3으로 제출하면 시간 초과 발생 (Pypy3는 정답) <br>
    => 해결) 절단한 나무를 더하는 과정에서 이미 필요한 만큼의 길이(m)을 넘었다면 중단 (17~18줄)

### 백준 16401 과자 나눠주기

- 나무 자르기 문제와 유사
- left, right 범위 주의 (과자 길이가 1이상이므로, left 초기값은 1)

### 프로그래머스 표현 가능한 이진트리

1. 주어진 numbers의 십진수를 이진수로 변환
2. 이진수를 포화 이진트리 크기(2^n-1)가 되도록 앞에 0을 추가
3. 이진트리로 표현 가능한지 확인 <br>
    i) 루트 노드가 0이면, 해당 서브트리는 무조건 잘못된 트리로 판별 -> 0(False) 반환 <br>
    ii) 서브트리가 없거나(길이가 1) 모두 0인(ex. 0 0 0) 경우 -> 1(True) 반환

### 프로그래머스 입국심사

- 시간 범위 설정
    - 최소 시간(left) : 가장 빠른 심사관이 1명을 심사하는 시간 -> `min(times)`
    - 최대 시간(right) : 가장 느린 심사관이 모두(n명) 심사하는 시간 -> `max(times) * n`
- total = mid 시간 동안 심사한 총 인원
    - total >= n : 시간 충분 -> `right = mid - 1`
    - total < n : 시간 부족 -> `left = mid + 1`

### 백준 18869 멀티버스 Ⅱ

- `rank.append([sorted(universe[i]).index(j) for j in universe[i]])` 로 rank를 계산하면 시간 초과 발생 <br>
    => 해결) `dict` 를 사용하여 미리 순위를 계산

### 백준 2467 용액

- 값이 아닌 인덱스(left, right)를 증가, 감소시켜야 함

### 백준 2110 공유기 설치

- 가장 인접한 두 공유기 사이의 거리(mid)를 조절 -> 공유기를 C개 이상 설치할 수 있는지 확인
    - C개 이상 설치 가능한 경우 : start(범위의 시작) 증가 -> 거리(mid) 증가
    - C개 이상 설치할 수 없는 경우 : end(범위의 끝) 감소 -> 거리(mid) 감소

### 백준 12015 가장 긴 증가하는 부분 수열 2

- array를 돌며 num이 lis의 마지막 원소보다 크면 추가하고, 작거나 같으면 find_place(num) or bisect_left을 통해 얻은 인덱스를 num으로 대치
    - 주의) lis의 원소들이 '가장 긴 증가하는 부분 수열'을 만족하지는 않지만, 길이 값 자체는 '가장 긴 증가하는 부분 수열'을 만족함 <br>
    i) find_place(target) : lis의 왼쪽부터 탐색하여 target보다 크거나 같은 원소를 처음으로 만났을 때의 인덱스를 반환 <br>
    ii) bisect_left : find_place 대체 가능

### 백준 3020 개똥벌레

- binary_search(data, target) : data 리스트에 대해 target보다 큰 수의 개수를 찾는 함수
    - binary_search(data_bottom, h - 1) : h보다 높은 석순의 개수
    - binary_search(data_top, H - h) : h보다 낮은 종유석의 개수

### 프로그래머스 가사 검색

1. 각 단어를 길이에 따라 나눈 후 정렬
2. 각 쿼리에 대해 이진 탐색 수행 : 첫 단어와 마지막 단어의 위치를 찾아 차이를 계산
    - '?'를 a와 z로 대체하여 각각의 위치를 찾을 수 있음
    - '?'가 접두사인 경우, 단어를 뒤집어 저장한 리스트를 이용