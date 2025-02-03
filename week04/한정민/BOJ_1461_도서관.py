n, m = map(int, input().split())
books = list(map(int, input().split()))
answer = 0

minus = sorted([-book for book in books if book < 0], reverse = True)
plus = sorted([book for book in books if book > 0], reverse = True)
final = max(minus[0] if minus else 0, plus[0] if plus else 0)

for i in range(0, len(minus), m):
    if minus[i] == final:
        answer += minus[i]
    else:
        answer += minus[i] * 2

for i in range(0, len(plus), m):
    if plus[i] == final:
        answer += plus[i]
    else:
        answer += plus[i] * 2

print(answer)