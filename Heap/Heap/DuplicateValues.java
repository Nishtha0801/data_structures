public boolean ContainsNearbyDuplicates(int[]nums,int k){
    HashMap<Integer,Integer>map=new Hashmap<>();
    for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            int prevIndex=map.get(nums[i]);
        if(i-prevIndex>k){
            map.put(nums[i],i);
        }
        else{
            return true;
        }
        }
        else{      //nhi chla
            map.put(nums[i],i);
        }
    }
    return false;
}