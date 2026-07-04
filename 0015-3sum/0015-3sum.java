class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // O(n^2)
        // Set<List<Integer>> result = new HashSet<>();
        // for(int i = 0; i < nums.length; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j = i+1; j < nums.length; j++){
        //         int third = -(nums[i]+nums[j]);
        //         if(set.contains(third)){
        //             List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(temp);
        //             result.add(temp);
        //          }
        //         set.add(nums[j]);
        //     }
            
        // }
        // return new ArrayList<>(result);

        // Optimised
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0){
                    j++;
                }
                else if (sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }


        return result;
    }
}