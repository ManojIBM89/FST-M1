package Activities;

public class Activity2 {
	public static void main(String[] args) {
		Activity2 actobj = new Activity2();
		//create the array
		int[] nums = {10,77,10,54,11,10};
		//set the numbers to search for
		int searchnum = 10;
		int fixedsum = 30;
		
		//call the function to print the result
		System.out.println("Result:" +actobj.result(nums,searchnum,fixedsum));
		 
}
	public boolean result(int[] nums,int searchnum,int fixedsum) {
		int tempsum=0;
		//loop through array to calculate sum
		for(int number:nums)
		//check if value is equal to search num
			if(number==searchnum)
			{
				tempsum +=searchnum;
			}
		
		return fixedsum==tempsum;
	}
}
