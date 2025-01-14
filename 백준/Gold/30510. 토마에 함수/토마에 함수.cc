#include <iostream>
using namespace std;
typedef long long ll;

ll P, Q, L = 1, R = 100000;
bool sieve[100001];
ll eulerphi[100001];

void init() {
    sieve[0] = sieve[1] = 1;
    for (int i = 2; i * i < 100001; i++) {
        if (sieve[i]) continue;
        for (int j = i * i; j < 100001; j += i) sieve[j] = 1;
    }
    for (int i = 1; i < 100001; i++) eulerphi[i] = i;
    for (int i = 1; i < 100001; i++) {
        if (sieve[i]) continue;
        for (int j = i; j < 100001; j += i) {
            eulerphi[j] /= i;
            eulerphi[j] *= i - 1;
        }
    }
}

ll ans;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> P >> Q;
    while (L < R) {
        ll mid = (L + R) / 2 + 1;
        if (Q >= P * mid) L = mid;
        else R = mid - 1;
    }

    init();
    for (int i = 1; i <= L; i++) ans += eulerphi[i];
    cout << ans + 1;
}