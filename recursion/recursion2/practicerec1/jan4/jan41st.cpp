#include<iostream>
#include<vector>
using namespace std;
//void type
int subseq(string str,string ans){  //count k chkkr m int
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    //character ne aane k lie mna krdia
   count+= subseq(str.substr(1),ans);
    //character ne aane k lie hn krdi
   count+= subseq(str.substr(1),ans+str[0]);
    return count;
}
 string words[]={"_","+-/"," abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","*()%","#@$"};

int keypad (string str, string ans) {
if(str.length()==0){
    cout<<ans<<endl;
    return 1;
}
int count=0;
int idx1=str[0]-'0';
string word=words[idx1];
for(int i=0;i<word.length();i++){
    count+=keypad(str.substr(1),ans+word[i]);
}
// for special cases when want to treat as 10
if(str.length()>=2){
    int idx=(idx1*10 +(str[1]-'0'));
   // if(idx>=10 && idx<=11){
       if(idx==10 || idx==11){
        word=words[idx];
        for(int i=0;i<word.length();i++){
            count+=keypad(str.substr(2),ans+word[i]);
        }
    }
}
return count;
}
int permutation(string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0;i<str.length();i++){
        string stri=str.substr(0,i)+str.substr(1+i);   //sabko pehle aane ka chance milega
        count+= permutation(stri,ans+str[i]);
    }
    return count;
}
int permu2(string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    vector<bool>vis(26,false);
    for(int i=0;i<str.length();i++){
        if(!vis[str[i]-'a']){                          // b-a is 1
vis[str[i]-'a']=true;
string stri=str.substr(0,i)+str.substr(1+i);
count+=permu2(stri,ans+str[i]);
        }
    }
    return count;
}
// in form of bits  doubt
int permu3(string str,string ans){
    if(str.length()==0){ 
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    int arr=0;
    for(int i=0;i<str.length();i++){
        int mask=1<<(str[i]-'a');      //left shift lsb side se 0 append hojaega
        if((arr&mask)==0){
            arr|=mask;
            string stri=str.substr(0,i)+str.substr(1+i);
           count+= permu3(stri,ans+str[i]);
        }
    }
    return count;
}
f
int main(int args,char**argv){
   // cout<<subseq("abc"," ")<<endl;  //cout islie kiya kunki count ko bhi print krana tha
  
//   cout<<keypad("10110"," ")<<endl;
//cout<<permutation("abc"," ")<<endl;
//cout<<permu2("aba"," ")<<endl;
cout<<permu3("aba"," ")<<endl;

}