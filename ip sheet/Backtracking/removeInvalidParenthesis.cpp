#include<iostream>
#include<string>
#include<stack>
using namespace std;

class Solution {
public:
    string minRemoveToMakeValid(string s) {
        

    stack<int> st;

    int n = s.length();
    for (int i = 0; i < n; i++)
    {
        if (s[i] == ')')
        {
            if (st.size() != 0)
                st.pop();
            else
                s[i] = '#';
        }
        else if (s[i] == '(')
            st.push(i);
    }

    while (st.size() != 0)
    {
        s[st.top()] = '#';
        st.pop();
    }

    string ans = "";
    for (int i = 0; i < n; i++)
    {
        if (s[i] != '#')
            ans += s[i];
    }

    return ans;


    }
};