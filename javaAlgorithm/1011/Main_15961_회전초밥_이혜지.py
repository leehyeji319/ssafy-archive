import sys
input = sys.stdin.readline

N, d, k, c = map(int, input().split())  # 접시의 수, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰번호

count = [0] * (d + 1)
count[c] += 1
nodes = [int(input()) for _ in range(N)]
ans = -1

# idx = 0
# idx2 = k - 1
kind = 1

for i in range(k):
    count[nodes[i]] += 1
    if count[nodes[i]] == 1:
        kind += 1

for i in range(N):
    count[nodes[i]] -= 1
    if count[nodes[i]] == 0: kind -= 1
    count[nodes[(i + k) % N]] += 1
    if count[nodes[(i + k) % N]] == 1: kind += 1
    ans = max(ans, kind)


# while idx < N:
#     idx += 1
#     count[nodes[idx - 1]] -= 1
#     if count[nodes[idx - 1]] == 0: kind -= 1  # 빼주는애
#
#     idx2 += 1
#     if idx2 >= N:
#         idx2 -= N
#
#     count[nodes[idx2]] += 1
#     if count[nodes[idx2]] == 1:
#         kind += 1  # 더해주는애
#
#     ans = max(kind, ans)

print(ans)
