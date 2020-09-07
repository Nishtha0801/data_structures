#include<iostream>
using namespace std;
int solution(int n){
    if(n<=3){
        return 1;
    }
    //rec case
    int fnm1=solution(n-1);
    int fnm4=solution(n-4);
    return fnm1+fnm4;
}
int main(){
    cout<<solution(4);
}
