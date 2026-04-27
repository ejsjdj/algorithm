def GCD(a,b): return GCD(b,a%b) if b else a

N,M = map(int,input().split())
print(M-GCD(N,M))


