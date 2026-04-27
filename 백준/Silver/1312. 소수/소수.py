A, B, N = map(int,input().split(" "))

A %= B
i = 1
while True:
    A *= 10
    if i == N:
        print(A//B)
        break
    A %= B
    i += 1