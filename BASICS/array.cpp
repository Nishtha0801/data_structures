#include<iostream>
#include<vector>
using namespace std;
void display(vector<int> &arr){
    for(int ele : arr){
        cout<<ele<<" ";
    }
    cout<<endl;
}
void input(vector<int> &arr)
{
    for(int ele=0;ele<arr.size();ele++){
        cin>>arr[ele];
    }
    //display(arr);
}
int find(vector<int> &arr,int data){
    int idx=0;
   
   
    for( idx=0;idx<arr.size();idx++){
    if(arr[idx]==data){
        cout<<"found"<<endl;
        break;
    }
   
    }
    
}
int max(vector<int> &arr){
    int i;
    int max=arr[i];
    for(i=0;i<arr.size();i++){
        if(arr[i+1]>=max)
        max=arr[i+1];
    }
    cout<<max;
}
int min(vector<int> &arr){
    int i;
    int min=arr[i];
    for(i=0;i<arr.size();i++){
        if(arr[i+1]>=min)
        min=arr[i+1];
    }
    cout<<min;
}
void swap(vector<int> &arr,int i,int j){
    
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
   
    
}
void reverse(vector<int> &arr,int si,int ei){
    while(si<=ei){
        swap(arr,si,ei);
        si++;
        ei--;
    }
     display(arr);
}
bool binaryS(vector<int> &arr,int data){ 
         //for strictly increasing
         int si=0;
         int ei=arr.size()-1;
int mid=(si+ei)/2;
while(si<=ei){
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

int main(int args,char**argv){
    //int n;
    //cin>>n;
    vector<int>arr={2,5,8,10,11,15,28,36,56,76,98};
   // input(arr);
   // display(arr);
   // find(arr,4);
   //swap(arr,2,3);
  // reverse(arr,0,5);
 // max(arr);
 //min(arr);
 cout<<(boolalpha)<<binaryS(arr,56)<<endl;
}
