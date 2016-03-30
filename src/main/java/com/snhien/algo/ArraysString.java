package com.snhien.algo;

/**
 * Exercises from 'Cracking the Coding Interview'
 *
 */
public class ArraysString {

	/*
	 * Replace <space> with "%20" string
	 */
	public static char[] replaceSpaces(char[] str, int length){
		int countSpace =0;
		for (int i=0; i<str.length; i++){
			if (str[i]==' '){
				countSpace++;
			}		
		}
		int newLength = str.length + 2*countSpace;
		char[] newString = new char[newLength];
		//str[newLength] = '\0';
		for(int i=length-1; i>=0; i--){
			if (str[i]==' '){
				newString[newLength-1] = '0';
				newString[newLength-2] = '2';
				newString[newLength-3] = '%';
				newLength = newLength - 3;
			}
			else{
				newString[newLength-1]=str[i];
				newLength = newLength - 1;
			}
		}
		return (newString);
	}
	
	public static void swap(char[] array, int i, int j){
		char tmp = array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	
	public static String compress(String input){
		StringBuffer compressed = new StringBuffer();
		if (input==null || input.length()<3){
			return(input);
		}
		char last = input.charAt(0);
		compressed.append(last);
		int count = 1;
		for(int i=1; i<input.length(); i++){
			char current = input.charAt(i);
			if(current!=last){
				last = current;
				compressed.append(count).append(current);
				count = 1;
			}
			else{
				count++;
			}
		}
		compressed.append(count);
		String res = compressed.length() > input.length()? input: compressed.toString();
		return res;
	}
	
	public static void main(String[] args){
		char[] array = {'a', ' ', 'b', 'c', ' '};
		char[] newArray = replaceSpaces(array, 5);
		System.out.println("replaceSpaces=" + new String(array) + " : " + new String(newArray));
		swap(array, 0, 2);
		System.out.println("swap=" + new String(array));
		
		System.out.println("compress=" + compress("aaaaabccdddeeeeeeeeee"));
	}
}
