def passfuction(n):
    if n < 8:
        return n + 1
    else:
        return 1

def bomb(t):
    explosion = 210
    if t >= explosion:
        return True
    else:
        return False

person_n = int(input())
question_n = int(input())
time = 0
i = 1
while i <= question_n:
    run_time, right_or_wrong = input().split()
    i += 1
    time += int(run_time)

    if bomb(time):
        print(person_n)
        break
    if right_or_wrong == "T":
        person_n = passfuction(person_n)
    elif right_or_wrong == "P":
        continue
    elif right_or_wrong == "N":
        continue