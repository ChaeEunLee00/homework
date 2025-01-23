import sys
input = sys.stdin.readline

wheels = [list(map(int, input().strip())) for _ in range(4)]
k = int(input())
turns = [list(map(int, input().split())) for _ in range(k)]

def rotate_wheel(wheel, direction):
    if direction == 1:
        return [wheel[-1]] + wheel[:-1]
    elif direction == -1:
        return wheel[1:] + [wheel[0]]
    
for num, direction in turns:
    num -= 1
    rotations = [0] * 4
    rotations[num] = direction

    for i in range(num - 1, -1, -1):
        if wheels[i][2] != wheels[i + 1][6]:
            rotations[i] = -rotations[i + 1]
        else:
            break

    for i in range(num + 1, 4):
        if wheels[i - 1][2] != wheels[i][6]:
            rotations[i] = -rotations[i - 1]
        else:
            break

    for i in range(4):
        if rotations[i] != 0:
            wheels[i] = rotate_wheel(wheels[i], rotations[i])

score = 0
for i in range(4):
    if wheels[i][0] == 1:
        score += 2 ** i

print(score)