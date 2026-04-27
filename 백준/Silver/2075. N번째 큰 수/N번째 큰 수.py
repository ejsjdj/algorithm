import sys

n = int(sys.stdin.readline())

d = list(map(int, sys.stdin.readline().split()))  # 초기값으로 N개 저장

for i in range(n - 1):
    temp = sorted(list(map(int, sys.stdin.readline().split())) + d, reverse=True)
    d = temp[:n]  # 큰 순서대로 N개만 저장

print(d[n - 1])