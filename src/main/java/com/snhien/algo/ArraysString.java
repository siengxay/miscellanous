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
	
	public static int isPalindrome(String a) {
	    String lower = a.toLowerCase();
	    lower = lower.replaceAll("[^a-z0-9]", "");
	    StringBuilder sb = new StringBuilder();
	    for (int i=lower.length() -1; i>=0; i--){
	        sb.append(lower.charAt(i));
	    }
	    String reverse = sb.toString();
	    boolean isPalindrome = lower.equals(reverse);
	    return(isPalindrome?1:0);
	}
	
	public static int strStr(final String haystack, final String needle) {
		int pos = -1;
		if (needle==null) return pos;
		if (haystack==null) return pos;
		if (needle.length()>haystack.length()) return pos;
		for(int i=0; i<haystack.length() && pos<0; i++){
			if (haystack.charAt(i) == needle.charAt(0)){
				int posFirst = i;
				boolean match = true;
				for (int j=1; j<needle.length() && match ; j++){
					match = (i+j<haystack.length())? 
									haystack.charAt(i+j)==needle.charAt(j)
									: false;
				}
				if (match==true){
					pos = posFirst;
				}
			}
		}
		return pos;
	}
	
	public static String reverseWords(String a) {
	    if (a==null){
	        return null;
	    }
	    if (a.length()==0){
	        return a;
	    }
	    String[] tokens = a.split(" +");
	    if (tokens.length==1){
	        return tokens[0];
	    }
	    else{
	        StringBuilder sb = new StringBuilder();
	        for (int i=tokens.length; i>0; i--){
	            if (sb.length()>0){
	                sb.append(" ");
	            }
	            sb.append(tokens[i-1]);
	        }
	        return (sb.toString());
	    }
	}
	public static void main(String[] args){
		char[] array = {'a', ' ', 'b', 'c', ' '};
		char[] newArray = replaceSpaces(array, 5);
		System.out.println("replaceSpaces=" + new String(array) + " : " + new String(newArray));
		swap(array, 0, 2);
		System.out.println("swap=" + new String(array));
		
		System.out.println("compress=" + compress("aaaaabccdddeeeeeeeeee"));
		
		System.out.println("isPalindrome = " + isPalindrome("A man, a plan, a canal: Panama"));
		
		System.out.println("strStr = " + strStr("bbbbbbbbab", "baba"));
		
		System.out.println("reverseWords = " + reverseWords("the sky  is blue"));
	}
}
