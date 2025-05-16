n = int(input())
number = int(input())

while number != 0:
    if number % n == 0:
        print("%d is a multiple of %d." % (number, n))
    else:
        print("%d is NOT a multiple of %d." % (number, n))
    number = int(input())