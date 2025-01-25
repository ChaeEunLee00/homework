from collections import defaultdict
import sys
input = sys.stdin.readline

n = int(input())
student = defaultdict(list)
classroom = [[0] * n for _ in range(n)]

for _ in range(n**2):
    data = list(map(int, input().split()))
    student_num = data[0]
    likes = data[1:]
    student[student_num] = likes

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(num):
    global classroom
    candidates = []

    for i in range(n):
        for j in range(n):
            if classroom[i][j] == 0:
                like_count = 0
                empty_count = 0
                for d in range(4):
                    nx = i + dx[d]
                    ny = j + dy[d]
                    if 0 <= nx < n and 0 <= ny < n:
                        if classroom[nx][ny] in student[num]:
                            like_count += 1
                        elif classroom[nx][ny] == 0:
                            empty_count += 1
                candidates.append((like_count, empty_count, i, j))
                
    # 정렬 (좋아하는 학생 수 -> 비어있는 칸 수 -> 행의 번호 -> 열의 번호)
    candidates.sort(key = lambda x : (-x[0], -x[1], x[2], x[3]))

    _, _, x, y = candidates[0]
    classroom[x][y] = num

# 각각의 학생의 만족도를 구하는 함수
def cal_satisfaction(x, y):
    num = classroom[x][y]
    count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and classroom[nx][ny] in student[num]:
            count += 1

    if count > 0:
        return 10 ** (count - 1)
    return 0

for student_num in student.keys():
    bfs(student_num)

satisfaction = 0
for i in range(n):
    for j in range(n):
        satisfaction += cal_satisfaction(i, j)

print(satisfaction)