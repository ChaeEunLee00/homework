# SFT 133875 나무 섭지
- 유령이 해당 칸에 도착하는 최소 거리를 먼저 계산하고 남우는 그 거리 이상이 지나서 해당 칸에 도착할 수 없다.

# SFT 356860 스마트 물류
- 항상 가장 왼쪽에 위치한 부품부터 챙긴다

# BOJ 2170 선 긋기
- 끝점 -> 시작점 순으로 내림차순 정렬을 해서 중복되는 길이가 없도록 한다.
- 처음에 시간초과가 계속 발생했었는데 그 이유는 깜빡하고 아래 코드를 작성하지 않았기 때문,,
```c++
cout.tie(0);
cin.tie(0);
ios::sync_with_stdio(0);
```

# BOJ 1946 신입사원 
- 서류심사 순위를 기준으로 오름차순 정렬을 한 다음 면접 성적이 현재까지의 Min 값보다 작으면 선발되고, 크다면 선발되지 않는다.

# BOJ 2141 우체국
- 사람이 기준이므로 사람의 총 명수를 구해서 mid값이 어디에 위치하고 있는지를 구하면 된다.

# BOJ 2812 크게 만들기 
- 스택을 이용해서 최대한 큰 수가 앞에 오도록 만든다.

# BOJ 2879 코딩은 예쁘게
- 연속된 줄만 그룹으로 선택할 수 있으므로 앞에 줄이 몇번 탭을 추가 또는 삭제했는지 기억한다. 
- 1~n까지 탐색하면서 기억하고 있는 개수보다 많은 경우 answer에 차이를 더해주고 적은 경우에는 넘어간다.


# BOJ 1461 도서관
- 음수와 양수인 좌표를 따로 vector에 담는다.
- 내림차순으로 각각 정렬한다.
- m개 책을 들고 있으므로 m개씩 끊어서 ans에 더한다. 이때 2배를 해서 더하는데 가장 최대 거리를 보유하고 있는 단위는 마지막에 돌아오지 않도록 한다.

# [실전] PGS 택배 배달과 수거하기
- 끝에서부터 탐색해야됨.
- (시간 내 해결못함)

# [실전] PGS 42884 단속카메라
- 내림차순으로 정렬하여 항상 시작점에 단속카메라를 설치한다고 가정한다. 
- 그래서 위치 비교를 하며 새로 단속 카메라가 필요한지 여부를 확인한다.