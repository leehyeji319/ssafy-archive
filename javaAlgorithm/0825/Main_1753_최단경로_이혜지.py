import heapq
import sys
INF = int(1e9)

v, e = map(int, sys.stdin.readline().split())
k = int(input())
graph = [[] for i in range(v + 1)] # 각 노드에 연결되어 있는 노드에 대한 정보 
distance = [INF] * (v + 1)

# 간선 정보
for _ in range(e):
    a, b, c = map(int, sys.stdin.readline().split())
    #a번 노드에서 b번 노드로가는 비용 c
    graph[a].append((b,c))
    
def dijkstra(start):
    q = [] #우선순위 큐 
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: #큐가 비어있지 않다면
        #가장 최단 거리 짧은 노드 정보 꺼냄
        dist, now = heapq.heappop(q)
        if distance[now] < dist: # 현재 노드가 이미 처리된 노드라면 무시
            continue
        # 현재 노드와 인접한 노드 확인
        for i in graph[now]:
            cost = dist + i[1] # i[1] 거리값
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                
dijkstra(k)

for i in range(1, v + 1):
    # 도달할 수 없는 경우 inf 출력
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
