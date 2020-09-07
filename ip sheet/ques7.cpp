#include <iostream>
using namespace std;
int pair_diff(int a[],int l,int n){
    for(int i=0;i<l;i++){
        for(int j=i;j<l;j++){
            if(a[i]-a[j]==n || a[j]-a[i]==n){
                return 1;
            }
            
            
        }
    }
    return -1;
}
int main() {
	int T,l,n;
	cin>>T;
	while(T-->0){
	    cin>>l;
	    cin>>n;//l is no of elements here
	     
	     int a[100];
	     for(int i=0;i<l;i++){
	         cin>>a[i];
	     }
	     int val=pair_diff(a,l,n);
	     cout<<val<<endl;
	}
	return 0;
}