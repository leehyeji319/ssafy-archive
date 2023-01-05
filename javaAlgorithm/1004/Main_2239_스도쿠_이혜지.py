import sys

input = sys.stdin.readline


def rowCheck(r, num):
    for c in range(9):
        if sudoku[r][c] == num:
            return False
    return True


def colCheck(c, num):
    for r in range(9):
        if sudoku[r][c] == num:
            return False
    return True


def square3by3Check(r, c, num):
    nr = (r // 3) * 3
    nc = (c // 3) * 3
    for i in range(3):
        for j in range(3):
            if sudoku[nr + i][nc + j] == num:
                return False
    return True


def dfs(depth):
    if depth == len(zero_list):
        for row in range(9):
            for col in range(9):
                print(sudoku[row][col], end="")
            print()
        exit()

    nr, nc = zero_list[depth]

    for num in range(1, 10):
        if rowCheck(nr, num) and colCheck(nc, num) and square3by3Check(nr, nc, num):
            sudoku[nr][nc] = num
            dfs(depth + 1)
            sudoku[nr][nc] = 0


sudoku = []
zero_list = []		# 0의 위치 담기
for r in range(9):
    sudoku.append(list(map(int, input().rstrip())))
    for c in range(9):
        if sudoku[r][c] == 0:
            zero_list.append((r, c))
dfs(0)
