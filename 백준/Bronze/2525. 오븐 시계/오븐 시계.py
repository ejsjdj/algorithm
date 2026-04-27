h, m = map(int, input().split())

cooking_time = int(input())

h += cooking_time // 60
m += cooking_time % 60

if m >= 60:
    h += 1
    m -= 60

if h >= 24:
    h -= 24

print(h, m)