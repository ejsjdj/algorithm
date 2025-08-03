import sys
N, M = map(int, sys.stdin.readline().split())
(X, Y) = (M, N) if M > N else (N, M)

while X % Y:
    X, Y = Y, X%Y

sys.stdout.write(str(Y) + "\n") 
sys.stdout.write(str(N*M//Y))