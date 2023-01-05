import sys
from collections import deque

input = sys.stdin.readline

answer = []
H, W = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(H)]

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = 1
    count = 0
    while q:
        r, c = q.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < H and 0 <= nc < W and visited[nr][nc] == 0:
                visited[nr][nc] = 1
                if board[nr][nc] == 0:
                    q.append((nr, nc))
                elif board[nr][nc] == 1:  # 가장자리라면
                    board[nr][nc] = 0
                    count += 1
    answer.append(count)
    return count


hour = 0
while True:
    hour += 1
    visited = [[0] * W for _ in range(H)]
    count = bfs()

    if count == 0:
        break
print(hour - 1)
print(answer[-2])
