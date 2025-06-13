# 문제 풀이

### 백준 17141 연구소 2

- 바이러스의 좌표들 중에서 M개를 뽑는 조합(combinations 활용)을 만들고 각각에 대해 bfs 수행
- bfs 함수에서는 해당 조합에 대해 바이러스가 퍼지는 데 걸리는 시간을 계산

### 백준 17142 연구소 3

- 전체적인 과정은 '연구소 2' 문제와 유사
- 주의) 바이러스가 빈 칸(0)에 퍼지는 시간만 최댓값으로 계산 <br>
  : 비활성 바이러스가 활성화되는 경우에는 시간을 갱신하지 않음

### 백준 20057 마법사 상어와 토네이도

- 토네이도의 이동 규칙
  -  `왼쪽1 - 아래쪽1 - 오른쪽2 - 위쪽2 - 왼쪽3 - 아래쪽3 - 오른쪽4 - 위쪽4 - ...` <br>
  - 왼쪽, 아래쪽에 대해서는 홀수번 / 오른쪽, 위쪽에 대해서는 짝수번 이동
- tornado 함수 : 토네이도가 한 칸 이동할 때마다 모래 확산을 처리
  - 격자 안에 있으면 `board[nx][ny]`에 모래를 더하고, 격자 밖이면 answer에 추가

### 프로그래머스 상담원 인원

1. `combinations_with_replacement`를 통해 멘토를 배치할 수 있는 모든 조합을 구함
2. 최소힙을 이용해 해당 배치로 했을 때 최소 대기 시간이 나오는지 확인

### 백준 13335 트럭

- 현재 bridge 위에 있는 트럭의 무게 합 + 기다리고 있는 첫번째 트럭의 무게가
  - 다리의 최대하중(L)보다 작거나 같으면 bridge에 트럭을 추가
  - 다리의 최대하중(L)보다 크면 bridge에 빈 칸(0)을 추가