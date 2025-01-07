import sys

input = sys.stdin.readline

n = int(input())
result = []

for _ in range(n):
    S, T = input().split()
    idx = S.lower().index('x')
    result.append(T[idx].upper())

print("".join(result))