#include<iostream>
#include<vector>
#include<queue>
using namespace std;
vector<vector<int>> kclosest(vector<vector<int>> &points,int k){
    int n=points.size();
    priority_queue<int>h;
    for(int i=0;i<n;i++){
        int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
        if(h.size()<k || dist<h.top()){
            if(h.size()==k){
                h.pop();
            }
            else{
                h.push(dist);
            }
        }
    }
        int num=h.top();
        int i=0;
        int j=n-1;
        while(i<=j){
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(dist<=num){
                i++;
            }
            else{
                swap(points[i],points[j]);
                j--;
            }
        }
        points.erase(points.begin()+k,points.end());
        return points;
    }
int main(){
    int n,k;
    cin>>n;
    vector<vector<int>>points;
    for(int i=0;i<n;i++){
        int x,y;
        cin>>x>>y;
        vector<int> temp;
        temp.push_back(x);
        temp.push_back(y);
        points.push_back(temp);
    }
    cin>>k;
    points=kclosest(points,k);
    for(int i=0;i<k;i++){
        cout<<points[i][0]<<" "<<points[i][1]<<endl;
    }
    return 0;
    
}