import sys

input = sys.stdin.readline

INF = int(1e9)

N, M = map(int, input().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    f, t = map(int, input().split())
    graph[f][t] = 1

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            if graph[a][b] == 1 or (graph[a][k] == 1 and graph[k][b] == 1):
                graph[a][b] = 1
ans = 0

print(graph)

for a in range(1, N + 1):
    height = 0
    for b in range(1, N + 1):
        height += graph[a][b] + graph[b][a]
    if height == N - 1:
        ans += 1
print(ans)
