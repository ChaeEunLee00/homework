from bisect import bisect_left, bisect_right

def count_by_range(array, left_value, right_value):
    left_index = bisect_left(array, left_value)
    right_index = bisect_right(array, right_value)
    return right_index - left_index

array = [[] for _ in range(10001)]
reversed_array = [[] for _ in range(10001)]

def solution(words, queries):
    answer = []
    for word in words:
        array[len(word)].append(word)
        reversed_array[len(word)].append(word[::-1])
        
    for i in range(10001):
        array[i].sort()
        reversed_array[i].sort()
    
    for query in queries:
        # 접미사에 와일드카드가 있는 경우
        if query[-1] == '?':
            cnt = count_by_range(array[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
        # 접두두사에 와일드카드가 있는 경우
        else:
            cnt = count_by_range(reversed_array[len(query)], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
        answer.append(cnt)
        
    return answer