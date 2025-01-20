#include <bits/stdc++.h>
using namespace std;


int n;

bool isDecimal(int num){
    for (int i = 2; i <= sqrt(num); i++) {
		if (num%i == 0)
			return false;
	}
	return true;
}

void recur(int num, int len){
    if (len == n) {
		cout << num << "\n";
		return;
	}

	for (int i = 1; i <= 9; i++) {
		if (isDecimal(num * 10 + i))
			recur(num * 10 + i, len + 1);
	}

	return;
}



int main(){
    cin >> n;

    recur(2, 1);
    recur(3, 1);
    recur(5, 1);
    recur(7, 1);
}