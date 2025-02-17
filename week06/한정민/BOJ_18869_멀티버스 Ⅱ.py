import sys
input = sys.stdin.readline

m, n = map(int, input().split())
universe = [list(map(int, input().split())) for _ in range(m)]

rank = []
for row in universe:
    sorted_rank = {val: idx for idx, val in enumerate(sorted(set(row)))}
    rank.append(tuple(sorted_rank[val] for val in row))

count = 0
for i in range(m):
    for j in range(i+1, m):
        if rank[i] == rank[j]:
            count += 1

print(count)