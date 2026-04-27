def get_best_mas_sal(n):
    mas_sal = [list(map(int,input().split())) for _ in range(n)]
    mas_sal.sort(reverse=True, key=lambda x: (x[0]/x[1], -x[1]))

    return mas_sal[0][1]

for _ in range(int(input())):
    print(get_best_mas_sal(int(input())))