# 포화 이진트리 크기(2**n-1)로 패딩
def pad_binary(binary_num):
    length = len(binary_num)
    n = 0
    while (2 ** n - 1) < length:
        n += 1
    target_length = 2 ** n - 1
    return binary_num.zfill(target_length)

# 이진트리로 표현 가능한지 확인
def check(binary_num):
    if len(binary_num) == 1 or not '1' in binary_num:
        return 1

    mid = len(binary_num) // 2
    root = binary_num[mid] # 현재 서브트리의 루트

    if root == '0':
        return 0

    left_check = check(binary_num[:mid])  
    right_check = check(binary_num[mid+1:])    

    return left_check and right_check

def solution(numbers):
    answer = []
    for number in numbers:
        binary_num = format(number, 'b')
        padded_num = pad_binary(binary_num)
        answer.append(check(padded_num))
    return answer