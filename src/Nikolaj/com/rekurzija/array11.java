package Nikolaj.com.rekurzija;

public class array11 {

    public static int array11(int[] nums, int i){
        if(i == nums.length)
            return 0;
        else{
            if(nums[i] == 11)
                return 1 + array11(nums, i +1);
            else return 0 + array11(nums,i + 1);
        }
    }
}
