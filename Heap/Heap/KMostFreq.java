class KMostFreq{
    public List<Integer> KMostFreq(int a[],int k){
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int i : a){
            m.put(i,m.containsKey(i)? 1+m.get(i): 1);
        }
            List<Integer> freq[]=new ArrayList<>();
            for(int i=0;i<a.length;i++){
                freq[i]=new ArrayList<>();
            }
            for(int key : m.keySet()){
                freq[m.get(key)-1].add(key);
            }
            for(int i=a.length-1;i>=0;i--){
                while(!freq[i].isEmpty && k>0){
                    ans.add(freq[i].remove(0));
                    k--;
                }                                   //better way in pep
            }
            return ans;

        
    }
}