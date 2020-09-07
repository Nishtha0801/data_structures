 #include<iostream>
 #include<string>
 #include<stack>
 using namespace std;
 string removeKdigits(string num, int k) {
         stack<char>st;
    for(int i=0;i<num.length();i++){
        char digit=num[i];
        while(st.size()!=0 && k>0 && st.top()>digit){
          st.pop();
          k--;
        }
        st.push(digit);
    }
    while(st.size()!=0 && k-->0){
        st.pop();
    }
    string ans="";
    while(st.size()!=0){
        ans+=st.top();
        st.pop();
    }
    while(ans.size()!=0){
        if(ans.back()!='0'){
            break;
        }
        ans.pop_back();
    }
    reverse(ans.begin(),ans.end());
    return ans.length()==0? "0" : ans;
    }