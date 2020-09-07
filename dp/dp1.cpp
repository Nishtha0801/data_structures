#include<iostream>
#include<vector>
using namespace std;
   int mcostPath(int sr,int sc,int dr,int dc,vector<int>&costs){
        if(sr==dr && sc==dc){
            return costs[sr][sc];
        }
        int mcstod=0;
        int mcihtod=INT_MAX;    //intermediate horizontal
        int mcivtod=INT_MAX;   //vertical
        if(sr<dr)
            mcivtod=mcostPath(sr+1,sc,dr,dc,costs);
        if(sc<dc)
            mcihtod=mcostPath(sr,sc+1,dr,dc,costs);
        
        mcstod=costs[sr][sc]+std::min(mcivtod,mcihtod);
        return mcstod;
     }
int main(int args,char**argv){
 vector<int>costs={{2,3,0,4},
               { 0,6,5,2},
               {8,0,3,7}
               {2,0,4,2}   };
     cout<<mcostPath(0,0,costs.size()-1,costs[0].size()-1.costs)
}