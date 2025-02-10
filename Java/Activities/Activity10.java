package Activities;
import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		System.out.println("The List is:");
		System.out.println("The Hashtag sets are:"+hs);
			
		hs.remove("D");
		if(hs.remove("F")) {
			System.out.println("F is removed");
		}else {
			System.out.println("F is not Present");
		}
		
		System.out.println("The Current List size:"+hs.size());
		System.out.println("Updated Hashset:"+hs);
	}

}
