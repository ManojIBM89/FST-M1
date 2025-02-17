package Activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity4 actobj = new Activity4();
		int[] nums= {10,9,29,19,1,2,45,11};
		actobj.insertionsort(nums);
		System.out.println("Sorted array:"+Arrays.toString(nums));
	}
	public void insertionsort(int[] nums) {
		int size = nums.length;
		for (int i=1;i<size;i++) {
			int key = nums[i];
			int j=i-1;
			while(j>=0 && key < nums[j]) {
				nums[j+1]=nums[j];
				--j;
			}
			nums[j+1] = key;
		}
		
	}

}
