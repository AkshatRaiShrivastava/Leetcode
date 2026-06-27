class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums,0, nums.length-1);

    }
     private int sort(int[] arr, int low, int high){
        int count = 0;
        if (low >= high) return count;
        int mid = (low+high)/2;
        count += sort(arr, low, mid);
        count += sort(arr, mid+1, high);
        count += count(arr,low,mid,high);
        merge(arr, low, mid, high);
        return count;
    } 
    private int count(int[] arr, int low, int mid, int high){
        int count = 0;
        int right = mid+1;
        for(int i = low;i <= mid;i++){
            while(right<=high && arr[i] > 2L*arr[right]){
                right++;
            }
            count += right-(mid+1);
        }
        return count;
    }  
    private void merge(int[] arr, int low, int mid, int high){
        int left = low, right = mid+1;
        List<Integer> list = new ArrayList<>();
    
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {   
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i-low);
        }

    }
}