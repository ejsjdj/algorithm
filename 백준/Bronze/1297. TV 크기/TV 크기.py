import math
x, y, z = map(int, input().split(' '))
width = math.sqrt((x ** 2 / ((z / y) ** 2 + 1)))
height = math.sqrt((x ** 2 / ((y / z) ** 2 + 1)))

print(int(width), int(height))