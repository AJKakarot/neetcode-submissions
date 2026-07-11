class Solution {
    public int search(int[] nums, int target) {
        
            int i = 0;
            int j = nums.length;


            int mid = i+(j-l)/2;


            if(nums[mid] == target ){

                return mid;
            }else if(nums[mid]>target){
                j--;
            }else{
                i++;
            }

return -1;






    }
}
