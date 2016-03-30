package com.snhien.algo;

import java.util.*;

public class ClearSlide {

	//Special case for newline mapping to '\n'
	public static final String NEWLINE = "[newline]";
	/**
	 * Utility function to create reverse map for decoding
     * @param encoding array of encoding lines
	 * @return a map of code to character
	 */
    static Map<String, Character> getMapping(String[] encodings){
        Map<String,Character> map = new HashMap<String, Character>();
        for(String encoding: encodings){
            String[] tokens = encoding.split("\t");
            if (tokens!=null && tokens.length==2){
            	if (tokens[0].length()==1){
            		//regular code is single character
            		Character c  = tokens[0].charAt(0);
            		String code = tokens[1];
            		map.put(code, c);
            	}
            	else{
            		//special case for newline
            		if (tokens[0].equals(NEWLINE)){
            			String code = tokens[1];
            			map.put(code, '\n');
            		}
            	}
            }
        }
        return(map);
    }
    

    /**
     * Decode encodedString based on encodings
     * @param encodings
     * @param encodedString
     * @return decoded string
     */
    static String Decoding(String[] encodings, String encodedString) {
    	if (encodings==null || encodedString==null) return null;
    	StringBuilder decode = new StringBuilder();
    	Map<String, Character> map = getMapping(encodings); //initialize the decoding map
    	int startIdx = 0;
    	for(int i=0; i<=encodedString.length(); i++){
    		String code = encodedString.substring(startIdx, i);
    		if (map.get(code)!=null){
    			decode.append(map.get(code));
    			startIdx = i;
    		}
    	}
    	return decode.toString();
    }
    
    public static void main(String args[]){
    	String[] encodings = {"[newline]\t010100","W\t100100","i\t00011","t\t00111","h\t111111"};
    	String encodedstring = "1001000101000001100111111111";
    	
    	String decoded = Decoding(encodings, encodedstring);
    	System.out.println(decoded);
    	
    }
}
