#include <iostream>
using namespace std;
int sub_array(int *a,int n,int sum){
    for(int i=0;i<=n-1;i++){
        int x=a[i],j;
        for(j=i+1;j<=n;j++){
            if(x==sum){
                cout<<i+1<<" "<<j<<endl;
                return 1;
                break;
            }
            if(x>sum||j==n)
            {
                break;
            }
            else
            {
              x+=a[j];
            }
        }
        
        
    }
    return -1;
    }
int main() {
   
    int T;
    cin>>T;
   
	for(int i=0;i<T;i++){
	    int n,k;
	    cin>>n>>k;
	    int*a=new int[n];
	    for(int i=0;i<n;i++) {
	        cin>>a[i];
	    }
	    int val=sub_array(a,n,k);
	    if(val == -1) {
	        cout<<"-1"<<endl;
	    }
	}
	
	
}