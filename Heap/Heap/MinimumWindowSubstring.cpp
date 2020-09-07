#include<iostream>
#include<string>
#include<climits>
using namespace std;
string find_Window(string s,string p){
    int SL=s.length();
    int PL=p.length();
    //1.corner case
    if(PL>SL){
        return "none";
    }
    //2. freq maps
    int FS[256]={0};
    int FP[256]={0};
    for(int i=0;i<PL;i++){
        char ch=p[i];
        FP[ch]++;
    }
    // 3.Sliding window(Expansion and contraction + update the minimum length window)
    int cnt=0;
    int start=0;
    int min_len=INT_MAX;
    int start_idx=-1;
    for(int i=0;i<SL;i++){
        char ch=s[i];
        FS[ch]++;
        // maintain count of characters
        if(FP[ch]!=0 && FS[ch]<=FP[ch]){
            cnt++;
        }
        //if all the chARACTers match
        if(cnt==PL){
            //start shrinking the window from the last
            char temp=s[start];
            //loop to remove all unwanted characters
            while(FS[temp]==0 || FS[temp]>FP[temp]){
                FS[temp]--;
                start++;
                temp=s[start];
            }
            // window size
            int window_len=i-start+1;
            if(window_len<min_len){
                min_len=window_len;
                start_idx=start;
            }
        }
    }
    if(start_idx==-1){
        return "none";
    }
    string ans=s.substr(start_idx,min_len);
    return ans;
}
int main(){
    string s="helllaoe";
    string p="eelo";
    cout<<find_Window(s,p)<<endl;
}