import sys
input = sys.stdin.readline

n = int(input())
liquids = list(map(int, input().split()))

left = 0
right = -1
mixture = float('inf')
result = (liquids[0], liquids[-1])

while liquids[left] < liquids[right]:

    if abs(mixture) > abs(liquids[left] + liquids[right]):
        result = (liquids[left], liquids[right])
        mixture = liquids[left] + liquids[right]

    if liquids[left] + liquids[right] < 0:
        left += 1
    else:
        right -= 1
        
print(result[0], result[1])