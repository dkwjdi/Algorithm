import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 람다 {
	public static void main(String[] args) {
		 List<String> strings = new ArrayList<>();
		    strings.add("This code is free software");
		    strings.add("you can redistribute it");
		    strings.add("under the terms of the GNU General Public License version 2 only");
		    strings.add("This code is distributed in the hope that it will be useful");
		    strings.add("Please contact Oracle");
		    strings.add("500 Oracle Parkway, Redwood Shores, CA 94065 USA");

		    // Sorting 하기 전에 출력
		    for (String str : strings) {
		        System.out.println(str);
		    }

		    // 문자 길이로 sorting (오름차순)
		    Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
		    
		    String [] arr= {"dd","zz"};
		    int[] arr2= {3,4,1,2};
		    
		    Arrays.sort(arr2);
		    Arrays.sort(arr, (o1,o2)->(o1.compareTo(o2)));
		    

		    // sorting 후 출력
		    System.out.println();
		    for (String str : strings) {
		        System.out.println(str);
		    }
	}

}
