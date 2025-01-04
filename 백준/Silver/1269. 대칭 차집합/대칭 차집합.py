input()

s1 = set(map(int,input().split()))
s2 = set(map(int,input().split()))

print(len(s1.difference(s2)) + len(s2.difference(s1)))