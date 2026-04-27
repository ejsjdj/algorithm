x = int(input())
y = int(input())

list = [x, y]

if list[0] > 0 and list[1] > 0:
    print(1)
elif list[0] < 0 and list[1] > 0:
    print(2)
elif list[0] < 0 and list[1] < 0:
    print(3)
elif list[0] > 0 and list[1] < 0:
    print(4)