import sys
input = sys.stdin.readline

T = int(input())
INF = int(1e9)

for tc in range(1, T + 1):
    n = int(input())
    points = [list(map(int, input().split())) for _ in range(n + 2)]
    graph = [[INF] * (n + 2) for _ in range(n + 2)]

    for i in range(n + 2):
        for j in range(n + 2):
            if i == j: #자기자신으로 가는 거
                continue
            if abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]) <= 1000:
                graph[i][j] = 1

    for k in range(n + 2):
        for a in range(n + 2):
            for b in range(n + 2):
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

    if graph[0][n + 1] != INF:
        print('happy')
    else:
        print('sad')
