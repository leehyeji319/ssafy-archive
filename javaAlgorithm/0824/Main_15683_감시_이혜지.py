import copy

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
direction = {
    1: [[0], [1], [2], [3]],
    2: [[0, 2], [1, 3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    5: [[0, 1, 2, 3]]
}  # cctv 종류에 따른 감시 방향

cctv = []
for i in range(N):
    for j in range(M):
        if graph[i][j] in [1, 2, 3, 4, 5]:
            cctv.append([graph[i][j], i, j])


def watch(temp_graph, r, c, direction): #여기서 direction을 헷갈려서 계속 틀림 ㅠㅠㅠ ..
    for d in direction:
        nr, nc = r, c
        while True:
            nr += dr[d]
            nc += dc[d]
            if nr < 0 or nc < 0 or nr >= N or nc >= M or temp_graph[nr][nc] == 6:
                break
            elif temp_graph[nr][nc] == 0:
                temp_graph[nr][nc] = 7


def dfs(graph, depth):
    global min_value
    temp_graph = copy.deepcopy(graph)

    if depth == len(cctv):
        count = 0
        for t in temp_graph:
            count += t.count(0)
        min_value = min(min_value, count)
        return

    cctv_num, r, c = cctv[depth]

    for d in direction[cctv_num]:
        watch(temp_graph, r, c, d)
        dfs(temp_graph, depth + 1)
        temp_graph = copy.deepcopy(graph)


min_value = int(1e9)

dfs(graph, 0)
print(min_value)
