def fib(n):
    if n == 0: return n
    last = 0
    next = 1
    for _ in range(1, n):
        last, next = next, last + next
    return next

print(fib(int(input())))