class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums,0);
    }
    public List<List<Integer>> subsets(int[]nums,int idx){
        if(idx==nums.length){
            List<List<Integer>> base=new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> tres=subsets(nums,idx+1);
        List<List<Integer>> res=new ArrayList<>();

        for(List<Integer> subset:tres){
            //take
            List<Integer> temp=new ArrayList<>();
            temp.add(nums[idx]);
            for(int i:subset){
                temp.add(i);
            }
            res.add(temp);

            //not take
            res.add(subset);
        }
        return res;
    }
}
