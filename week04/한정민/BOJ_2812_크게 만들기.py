n, k = map(int, input().split())
data = list(input())
stack = []

for digit in data:
    while k > 0 and stack and stack[-1] < digit:
        stack.pop()
        k -= 1
    stack.append(digit)

print(''.join(stack[:len(stack)-k]))