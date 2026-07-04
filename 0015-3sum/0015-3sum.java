class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // O(n^2)
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < nums.length; j++){
                int third = -(nums[i]+nums[j]);
                if(set.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    result.add(temp);
                }
                set.add(nums[j]);
            }
            
        }
        return new ArrayList<>(result);
    }
}