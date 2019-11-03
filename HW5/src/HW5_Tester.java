/* Program for helping grade HW5 submissions for CS1302
Creates randomly generated lists of sizes 3-8 to test students'
selection sort and dual selection sort methods

After the Main method, paste students' methods into the class
and edit the method call lines (lines 65 and 81)

HW5 Parts:
1. Write a modified version of selection sortalgorithm that sorts an array 
of Strings and selects the largest element each time and movies it to the 
end of the array, rather than selecting the smallest element and moving it 
to the beginning.
2. Write a modified “dual” version of the selection sort algorithm that 
sorts an array of integers and selects both the largest and smallest elements 
on each pass and moves eacho f them to the appropriate end of the array.

Most common method errors (for copy-paste): 
Selection sort algorithm does not sort properly for all lists
In selection sort algorithm there should only be one swap per iteration
Selection sort does not compare the lengths of strings
Sorted list after selection sort is not in ascending order
Dual selection sort method does not work for all lists
Dual selection sort does not sort an int array
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class HW5_Tester {
	public static void main(String[] hi){
		
		// creates randomly generated lists with lengths 3-8 
		for (int i = 2; i <= 8; i++){
			ArrayList<Integer> intList = new ArrayList<Integer>(); 
			ArrayList<String> StringList = new ArrayList<String>();
			
			// randomly creates elements for int array
			for (int j = 0; j <= i; j++){
				int rand = (int)(Math.random() * 100);	
				intList.add(rand);
			}
			
			// randomly creates elements of different sizes for String array
			for (int k = 0; k <= i; k++){
				int wordSize = (int)(Math.random() * 10);
				String word = ""; 
				Random r = new Random();
				for (int j = 0; j < wordSize; j++){
					word += (char)(r.nextInt(26) + 'a');
				}
				StringList.add(word);
			}
			
			// copies random String list into 2 String arrays
			String[] words = new String[StringList.size()];
			String[] words2 = new String[StringList.size()];
			for (int q = 0; q < StringList.size(); q++){
				words[q] = StringList.get(q);
				words2[q] = StringList.get(q);
			}
			
			// paste selection sort method here with words as parameter
			selectionSort(words);
			
			// does standard sort of same list
			Arrays.sort(words2, new Comparator<String>(){
				public int compare(String s1,String s2){
				    return s1.length() - s2.length(); }});
			// compares the 2 sorted lists
			System.out.print(Arrays.equals(words, words2) + " ");
			
			// copies random int list into 2 int arrays
			int[] arr = intList.stream().mapToInt(k -> k).toArray();
			int[] arr2 = new int[arr.length];
			for (int k = 0; k < arr.length; k++)
				arr2[k] = arr[k];
			
			// paste dual selection sort method here with arr as parameter 
			dualSelectionSort(arr);
						
			// does standard sort of same list
			Arrays.sort(arr2);
			// compares the 2 sorted lists
			System.out.print(Arrays.equals(arr2, arr));
						
			System.out.println();
		}
	}
	
	
	
	public static void selectionSort(String [] array){
	    for (int j=0; j < array.length-1; j++ )
	    {
	      int max = j;
	      for ( int k=j+1; k < array.length; k++ )
	        if (array[k].compareTo(array[max] ) < 0 ) 
	        	max = k;  

	      String temp = array[max];
	      array[max] = array[j];
	      array[j] = temp;
	    }
	  
	  }
	
	public static void dualSelectionSort(int arr[]){
		 for (int i = 0; i < arr.length / 2; i++) {
			 int min = i;
			 int max = arr.length - 1 - i;
			 for (int j = i; j < arr.length - i; j++) {
			 if (arr[j] < arr[min]) {
			 min = j;
			 }
			 if (arr[j] > arr[max]) {
			 max = j;
			 }
			 }
			 if (max == i) { // fixes the tricky max=i case
			 max = min;
			 }
			 swap(arr, i, min);
			 swap(arr, arr.length - 1 - i, max);
			 }
			}
		
		public static void swap(final int[] arr, final int pos1, final int pos2){
		    final int temp = arr[pos1];
		    arr[pos1] = arr[pos2];
		    arr[pos2] = temp;
		}

}
