from collections import deque

T = int(input())

for tc in range(1, T + 1):
    n, m = map(int, input().split())

    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    visited = [False] * (n + 1)
    cnt = 0
    queue = deque()
    for i in range(1, n + 1):
        if not visited[i]:
            cnt += 1
            queue.append(i)
            visited[i] = True

        while queue:
            v = queue.popleft()
            for i in graph[v]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
    print(f"#{tc} {cnt}")
