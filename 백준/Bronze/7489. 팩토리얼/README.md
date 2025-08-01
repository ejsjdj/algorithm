# [Bronze II] 팩토리얼 - 7489 

[문제 링크](https://www.acmicpc.net/problem/7489) 

### 성능 요약

메모리: 14072 KB, 시간: 120 ms

### 분류

임의 정밀도 / 큰 수 연산, 수학

### 제출 일자

2025년 6월 16일 21:35:10

### 문제 설명

<p>n!은 정수 n에 대한 팩토리얼 수를 나타내는데, 이는 1부터 n까지의 모든 정수의 곱을 의미한다. 팩토리얼은 굉장히 빨리 커지기 때문에 13!는 대부분의 컴퓨터에서 32비트 정수형을, 70!은 대부분의 부동 소수점 변수의 범위를 넘어선다. 우리는 n!에 대하여 0이 아닌 최우측 수(<strong>the rightmost non-zero digit</strong>)를 찾으려고 한다. 예를 들어, 5! = 1 * 2 * 3 * 4 * 5 = 120 이므로 5!의 최우측 0이 아닌 수는 2이다. 마찬가지로 7! = 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040이며 7!의 0이 아닌 최우측 수는 4가 된다.</p>

### 입력 

 <p>첫 줄에 테스트 케이스의 수 <strong>t</strong> ( 0 < <strong>t</strong> < 15)가 주어진다. 연속하여 t개의 줄에는 정수 <strong>n</strong>이 하나씩 주어진다. ( 0 < <strong>n</strong> < 1001).</p>

### 출력 

 <p>n!의 최우측 0이 아닌 수(<strong>the rightmost non-zero digit</strong>)를 출력하시오.</p>

