list = [0, 0, 0, 0]
i = 1
n = 1
y = 0

xx = 0
yy = 0
z = 0
v = 0
while i <= 5:
    xx, yy, z, v = map(int, input().split())
    list[0] = int(xx)
    list[1] = int(yy)
    list[2] = int(z)
    list[3] = int(v)
    x = sum(list)
    if x > y:
        y = x
        n = i
    i += 1
print(n, y)