public static int lengthOflongestSubsDistinct(String s,int k){
    int n=s.length();
    int left=0;
    int max_len=0;
    Hashmap<Character,Integer>map=new Hashmap<>();
    for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        map.put(ch,i);
        if(map.size()==k+1){
            char ch_min_index='0';
            int min_index=Integer.MAX_VALUE;
            for(char key : map.keySet()){
                if(map.get(key)<min_index){
                    ch_min_index=key;
                    min_index=map.get(key);
                }
            }
            left=min_index +1;
            map.remove(ch_min_index);
        }
        max_len=Math.max(max_len,i-left+1);
    }
    return max_len;
}