package Nikolaj.com.rekurzija;

public class array6 {
    public static boolean array6(int[] nums, int index) {
        if(nums.length == index)
            return false;
        else{
            if(nums[index] == 6)
                return true;
            else return array6(nums,index + 1);
        }
    }

}
