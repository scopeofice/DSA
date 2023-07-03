package Arrays;

public class Array {

	public static void main(String[] args) {
		
		int []arr= {2,3,9,8,4,2,6,8,5,1,2};
		
		//Q.1) Write a Java program to find the index of an array element.
		int value=5;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==value) {
				System.out.println(value+" is at index : "+i);
				break;
			}
		}
		
		//Q.2) You will be given an array and you need to find the third largest 
		
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		int third=Integer.MIN_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>first) {
				third=second;
				second=first;
				first=arr[i];
			}
		}
		System.out.println("3rd highest number : "+arr[2]);
		
	}
}
