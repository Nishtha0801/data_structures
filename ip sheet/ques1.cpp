#include <iostream>
#include<vector>
using namespace std;
vector<int> KCN(vector<int> &arr,int k,int n){
    vector<int>helper(arr.size()*k,0);
    vector<int>ans;
    int i=0;
    int j=0;
    while(i<n*k){
       
         if(j<n*k){
            helper[j++]=arr[(i)%n];
         }
         i++;
            
    }
    for(int j=0;j<arr.size()*k;j++){
        ans.push_back(helper[j]);
    }
    return ans;
}
int subarraySum(vector<int>&A,int i){
    
    int current_sum=0;
    int maxSum=0;
    for( i=0;i<A.size();i++){
        for(int j=i;j<A.size();j++){
            current_sum=0;
            for(int k=i;k<=j;k++){
              current_sum+=A[k];
            }
             if(maxSum<current_sum){
               maxSum=current_sum;
           }
        }
    
    }
    return maxSum;
}

int main() {
    int T;
	cin>>T;
	for(int i=0;i<T;i++){
	    int n;
        int k;
	    cin>>n;
	    cin>>k;
	    vector<int>arr(n,0);
	    for(int i=0;i<n;i++){
	        cin>>arr[i];
	    }
        
        vector<int>myAns=KCN(arr,k,n);
        cout<<subarraySum(myAns,0);
	}
	return 0;
}
