#!/usr/bin/env python3
# -*- coding: utf8 -*-

import sys
from collections import deque, defaultdict

# se preferisci leggere e scrivere da file
# ti basta decommentare le seguenti due righe:

sys.stdin = open('OII/interruttori/input.txt')
sys.stdout = open('OII/interruttori/output.txt', 'w')

def solve():
    input()
    N, A, B = map(int, input().split())
    Z = [None] * A
    X = [None] * B
    Y = [None] * B

    graph = defaultdict(list)

    for j in range(A):
        Z[j] = int(input())
    for j in range(B):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    
    distance = [None] * N
    queue = deque(Z)

    for z in Z:
        distance[z] = 1

    while queue:
        node = queue.popleft()
        for node_next in graph[node]:
            if not distance[node_next] or distance[node_next] > distance[node] + 1:
                distance[node_next] = distance[node] + 1
                queue.append(node_next)

    num = max(distance)
    idx = distance.index(num)

    return (idx, num)


T = int(input())

for t in range(1, T+1):
    print("Case #{}: {} {}".format(t, *solve()))