# ▶숙제

### BOJ 3190 뱀
- 시뮬레이션
  - 덱 사용: 덱의 First를 뱀의 머리로, 덱의 Last를 뱀의 꼬리로 생각
  - 큐 사용: 방향 전환 정보 (시간, 회전 방향)
- 방향 전환이 필요한 시간이면 방향 전환
- 방향에 맞게 다음 위치로
- 다음 위치가 벽이거나 자기 몸이면, break
- 그게 아니면 다음 위치로 머리 이동
  - 사과가 있으면 사과 없애기
  - 사과가 없으면 꼬리 없애기

### BOJ 15683 감시
- 시뮬레이션
- cctv 방향 조합에 대한 모든 경우의 수 탐색 (dfs)

### BOJ 5052 전화번호 목록
- 전화번호 문자열 정렬 
- i-1번째 번호가 i번째 번호의 접두어인지 판별 (startsWith 사용)

### BOJ 14725 개미굴
- trie 자료구조를 사용하여 먹이 정보 저장
- 같은 층 먹이를 사전 순으로 출력하기 위해, child 노드를 treeMap에 저장

### BOJ 4485 녹색 옷 입은 애가 젤다지?
- 다익스트라 알고리즘
  - 한 노드에서 각 노드까지의 최소 비용을 구하는 알고리즘
  - 그리디 + 다이나믹 프로그래밍
- 그리디 : 현재 갈 수 있는 노드 중 최소 비용의 노드 방문 => 우선 순위 큐 사용
- 다이나믹 프로그래밍 : 방문한 노드에서 갈 수 있는 노드들의 비용이 기존 비용보다 작을 경우 업데이트 

### BOJ 13460 구슬 탈출 2
- bfs, 시뮬레이션
- 여기서 depth는 움직인 칸 갯수가 아닌, 기울이는 동작 횟수
  - 즉, 기울임 1번 (상하좌우) -> 기울임 2번 (상하좌우) -> ... 이렇게 너비우선탐색
- 빨강, 파랑 구슬 위치를 함께 추적한다.
  - 기울이는 동작 횟수가 10번 초과하거나 빨강 구슬이 구멍에 빠지지 않으면 -1
  - 파랑 구슬이 구멍에 빠지면 pass
  - 빨강 구슬이 구멍에 빠지면 횟수 리턴

### PGS 메뉴 리뉴얼
- orders 배열 원소 오름차순 정렬
- course 배열를 차례 대로 순회
  - 모든 order에 대해 course[i]개 단품요리 조합 생성
    - HashMap에 생성된 조합과 갯수 저장
    - 가장 많이 생성된 조합의 갯수 max 저장
  - 생성된 조합 중, 갯수가 2개 이상이고 max인 조합을 코스요리메뉴로 추가
- 코스요리메뉴 배열 오름차순 정렬

### PGS 보석 쇼핑
- 투포인터
- HashMap에 보석 종류 별 갯수 저장
- 모든 종류의 보석이 1개 이상일 때까지 end++
- start 보석이 1개 남을 때 까지 start++
- 최소구간 갱신 
