package Activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Apple");
		myList.add("Orange");
		myList.add("Banana");
		myList.add(3,"Jackfruit");
		myList.add(1,"Chicku");
		System.out.println("Print all Object");
		for (String s:myList) {
			System.out.println(s);	
		}
		System.out.println("Third Element is:"+myList.get(2));
		System.out.println("If Chichu contains in the list:"+myList.contains("Chicku"));
		System.out.println("Size of the name:"+myList.size());
		myList.remove("Jackfruit");
		System.out.println("Reprint the size new List:"+myList.size());
		
		for (String a:myList) {
			System.out.println("The List contains:"+a);
			}
			}
}
