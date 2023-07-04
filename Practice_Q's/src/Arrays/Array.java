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
			else if(arr[i]>second) {
				third=second;
				second=arr[i];
			}else if(arr[i]>third) {
				third=arr[i];
			}
		}
		System.out.println("3rd highest number : "+third);
		
		//Q.3) You are given array consisting of n integers. Your task is to find the maximum length of an increasing subarray of the given array.
		int max=1;
		int count=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				count++;
			}else {
				max=Math.max(max, count);
				count=1;
			}
		}
		max=Math.max(max,count);
		System.out.println("Maximum length : "+max);
		
		
//	 Q.4) Given an array of size n where all elements are in range from 0 to n-1, change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
		int [] a= {2,0,4,3,1};
		for(int i=0;i<a.length;i++) {
			while(a[i]!=i) {
				int temp=a[a[i]];
				a[a[i]]=a[i];
				a[i]=temp;
			}
		}
		
		for(int j=0;j<a.length;j++) {
			System.out.print(a[j]+ " ");
		}
		
		
		
		
		
		
		
		
		
	}
}
