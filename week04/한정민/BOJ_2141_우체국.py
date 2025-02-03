import sys
input = sys.stdin.readline
n = int(input())

towns = []
for _ in range(n):
    towns.append(list(map(int, input().split())))
towns.sort()

people = sum(towns[i][1] for i in range(n))
count = 0
for i in range(n):
    count += towns[i][1]
    if count >= (people + 1) // 2:
        print(towns[i][0])
        break