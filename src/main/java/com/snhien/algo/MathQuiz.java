package com.snhien.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MathQuiz {

	/*
    protected static ArrayList<Integer> findPrimes(int a){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        for(int i=5; i<a; i++){
            findPrime(i, primes);
        }
        return (primes);
    }
    
    protected static ArrayList<Integer> findPrime(int a, ArrayList<Integer> primes){
        boolean isPrime = true;
        for(Integer prime: primes){
            if (a % prime == 0 ){
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            primes.add(a);
        }
        return (primes);
    }

        public static ArrayList<Integer> primesum(int n){
    	ArrayList<Integer> allPrimes = findPrimes(n);
    	System.out.println("Found primes=" + allPrimes.size());
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	for(int i=0; i<allPrimes.size(); i++){
    		
    		for (int j=i; j<allPrimes.size(); j++){
    			if (allPrimes.get(i) + allPrimes.get(j) == n){
    				
    				res.add(allPrimes.get(i));
    				res.add(allPrimes.get(j));
    				return (res);
    			}
    		}
    	}
    	return res;
    }
    */
	
	public static ArrayList<Integer> findPrimes(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Map<Integer, Boolean> seqNumbers = new TreeMap<Integer, Boolean>();
		for (int i=2; i<n; i++){
			seqNumbers.put(i, true);
			
		}
		for(int i=2; i<n; i++){
			if (seqNumbers.get(i) == true){
				int j = i + i;
				while (j<n){
					seqNumbers.put(j, false);
					j=j+i;
				}
			}
		}
		
		for (int i=2; i<n; i++){
			if (seqNumbers.get(i)==true){
				primes.add(i);
			}
		}
		return primes;
	}
    


    public static boolean isPrime(int n){
    	double sqrt = Math.sqrt(n);
    	for (int i=2; i < sqrt; i++){
    		if (n%i == 0){
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public static ArrayList<Integer> primesum(int n){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Set<Integer> primes = new HashSet<Integer> ();
    	for (int i=2; i<n; i++){
    		if (primes.contains(i) || isPrime(i)){
    			primes.add(i);
    			for (int j = i; j<n; j++){
    				if (primes.contains(j) || isPrime(j)){
    					primes.add(j);
    					if (i+j == n){
    						res.add(i);
    						res.add(j);
    						return res;
    					}
    				}
    			}
    		}
    	}
    	return (null);
    }
    public static void main(String args[]){
    	ArrayList<Integer> primes = findPrimes(100);
    	for (Integer prime: primes){
    		System.out.print(" " + prime);
    	}
    	
    	int n=16777214;
    	System.out.println("\nprimeSum for n=" + n + ": ");
    	ArrayList<Integer> primeSum = primesum(n);
    	for (Integer prime: primeSum){
    		System.out.print(" " + prime);
    	}
    }
}
