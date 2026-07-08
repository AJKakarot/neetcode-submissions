class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        

         int left = 0;

         int sum =0;

         int minLength = Integer.MAX_VALUE;




         for(int i = 0; i<numslength;i++){



     sum+=nums[right];

while(sum>=target){

      minLength = Math.min(minLength,  right - left +1);


      sum-=nums[left];
      
      left++;


}




         }

return minLength == Intger.MAX_VALUE ? 0 : minLength;


    }
}