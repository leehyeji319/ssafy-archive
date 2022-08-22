from collections import deque

def bfs(current_q):
    global result
    result = max(current_q)

    next_q = deque()

    while current_q:
        v = current_q.popleft()
        for i in graph[v]:
            if not visited[i]:
                next_q.append(i)
                visited[i] = True

    if next_q:
        bfs(next_q)


for t in range(1, 11):
    N, V = map(int, input().split())
    graph = [[] for i in range(101)]
    info = list(map(int, input().split()))
    for i in range(0, N, 2):
        graph[info[i]].append(info[i + 1])

    visited = [False] * 101
    visited[V] = True
    result = 0
    q = deque()
    q.append(V)

    bfs(q)

    print(f"#{t} {result}")



