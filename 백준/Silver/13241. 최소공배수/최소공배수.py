from math import gcd

x, y = map(int, input().split())

print(int(x * y/gcd(x, y)))