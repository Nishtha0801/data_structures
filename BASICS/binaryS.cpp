#include<iostream>
#include<vector>
using namespace std;
bool binaryS(vector<int> &arr,int data){ 
         //for strictly increasing
         int si=0;
         int ei=arr.size()-1;

while(si<=ei){
    int mid=(si+ei)/2;
    if(arr[mid]==data){
        cout<<"index"<<mid<<endl;
     return true;
    }
    else if(arr[mid]<data)
    si=mid+1;
    else
        ei=mid-1;
    
}
return false;
}

int BSLB(vector<int> &arr,int data){
         int si=0;
         int ei=arr.size()-1;
         while(si<=ei){
             int mid=(si+ei)/2;
             if(arr[mid]==data){
                 if(mid-1>=0 && arr[mid-1]==arr[mid])
                 ei=mid-1;
                 else
              return mid;
                 }
             else if(arr[mid]<data)
             si=mid+1;
             else 
             ei=mid-1;
         }
 
}
int BSUB(vector<int> &arr,int data){
    int si=0;
    int ei=arr.size()-1;
    while(si<=ei){
        int mid=(si+ei)/2;
        if(arr[mid]==data){
        if(mid+1<arr.size() && arr[mid+1]==arr[mid])
        si=mid+1;
        else 
        return mid;
        }
        else if(arr[mid]<data)
        si=mid+1;
        else 
        ei=mid-1;
    }
}
int min_Diff(vector<int> &arr,int data){
    if(data<arr[0]){
        return arr[0];
    }
    else if(data>arr[arr.size()-1])
    return arr[arr.size()-1];
    int si=0;
    int ei=arr.size()-1;
    while(si<=ei){
        int mid=(si+ei)/2;
        if(arr[mid]==data){
            return mid;
        }
        else if(arr[mid]<data)
        si=mid+1;
        else
        ei=mid-1;
    }
    if(data-arr[ei]<=arr[si]-data){
        return arr[ei];
    }
    else
    return arr[si];

}
int sqRoot(int data){
    int si=0;
    int ei=(data)/2;
    while(si<=ei){
        int mid=(si+ei)/2;
        if(mid*mid==data){
            return mid;
        }
        else if(mid*mid<data)
        si=mid+1;
        else
        ei=mid-1;
    }
}
int main(int args,char**argv){
     vector<int>arr={2,5,8,8,8,15,28,36,56,76,98};
    // cout<<(boolalpha)<<binaryS(arr,56)<<endl;
   //cout<< BSLB(arr,8);
  // cout<<BSUB(arr,8);
  //cout<<min_Diff(arr,21);
  cout<<sqRoot(101)<<endl;
}