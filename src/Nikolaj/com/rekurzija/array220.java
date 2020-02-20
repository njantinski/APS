package Nikolaj.com.rekurzija;

public class array220 {
    public static boolean array220(int[] nums, int i){
        if(i == nums.length)
            return false;
        else{
            if(i + 1 == nums.length)
                return false;
            else{
                if(nums[i]*10 == nums[i + 1])
                    return true;
                else return array220(nums, i +1);
            }
        }
    }
}
