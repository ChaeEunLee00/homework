from collections import defaultdict, deque

def dfs(graph, start, visited):
    node_count, edge_count = 0, 0
    stack = [start]

    while stack:
        current = stack.pop()
        if visited[current]:
            continue

        visited[current] = True
        node_count += 1

        for i in graph[current]:
            edge_count += 1
            if not visited[i]:
                stack.append(i)

    return edge_count, node_count

def solution(edges):
    graph = defaultdict(list)
    in_degree = defaultdict(int)

    max_node = 0
    for a, b in edges:
        graph[a].append(b)
        in_degree[b] += 1
        max_node = max(max_node, a, b)

    visited = [False] * (max_node + 1)

    # 생성한 정점의 번호 찾기
    new_node = None
    for i in range(1, max_node + 1):
        if in_degree[i] == 0 and len(graph[i]) > 1:
            new_node = i
            break

    answer = [new_node, 0, 0, 0]

    # 정점과 간선의 개수 비교하여 그래프 모양 확인하기
    for i in graph[new_node]:
        if visited[i]:
            continue

        edge_count, node_count = dfs(graph, i, visited)

        if edge_count == node_count:
            answer[1] += 1
        elif edge_count + 1 == node_count:
            answer[2] += 1
        else:
            answer[3] += 1

    return answer