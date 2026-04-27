# -*- coding: utf-8 -*-
# Python 3.4.5
import sys

t = int(sys.stdin.readline())
for _ in range(t):
    # 입력
    a, b = map(int, sys.stdin.readline().split())

    # 불필요한 연산 제거
    if a == 1:
        print(1)
        continue
    elif a == 5:
        print(5)
        continue
    elif a == 6:
        print(6)
        continue

    # 계산
    result_list = []  # 반복되는 숫자 리스트
    temp = 1
    for _ in range(b):
        temp *= a
        temp %= 10
        if temp in result_list:
            break
        result_list.append(temp)

    # 결과 출력
    result = result_list[b % len(result_list) - 1]
    if result == 0:
        print(10)
    else:
        print(result)