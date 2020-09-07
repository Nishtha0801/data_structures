#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

void wordbreak(vector<string>&dict ,string str,string ans){
    if(str.length()==0){
        cout<<ans<<endl;
        return;
    }
    
    for(int i=0;i<=str.length();i++){
    string prefix=str.substr(0,i);
    if(find(dict.begin(),dict.end(),prefix)!=dict.end()){
        wordbreak(dict,str.substr(i),ans+" "+prefix);
    }
}
}
int main(){
    vector<string>dict={"i", "like", "sam", "sung", "samsung", "mobile", "ice", 
  "cream", "icecream", "man", "go", "mango"};
  string str="ilikesamsungmobile";
  wordbreak(dict,str," ");
}