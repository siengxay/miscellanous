package com.snhien.algo;

import java.util.*;

public class StackQuiz {
	  public static void main(String[] args) {
		    List<String> expression = new ArrayList<String>();
		    expression.add("2");
		    expression.add("3");
		    expression.add("+");
		    expression.add("4");
		    expression.add("*");

		    double res = calculate(expression);
		    System.out.println("result=" + res);
		  }
	  
	  
			// Calculate RPN expression (Reverse Polish Notation)
			// 2 3 + -> 2 +3 = 5
			// 2 3 + 4 * -> 5 4 * -> 5 * 4 =20
			// "2" "3" "+"
			//expression = ["2","3", "+"]		  
		  public static Double calculate(List<String> expression) throws NullPointerException, IllegalArgumentException{
		    if (expression==null){
		      throw new NullPointerException();
		    }
		      Stack<Double> stack = new Stack<Double>();
		      for(String item: expression){
		        if (item.equals("+")){
		          if (stack.size()>=2){
		            throw new IllegalArgumentException("Empty stack for operator" + item);
		          }
		          double op2 = stack.pop();
		          double op1 = stack.pop();
		          double res = op1 + op2;
		          stack.push(res);
		        }
		        else if (item.equals("-")){
		          if (stack.size()>=2){
		            throw new IllegalArgumentException("Empty stack for operator" + item);
		          }
		          double op2 = stack.pop();
		          double op1 = stack.pop();
		          double res = op1 - op2;
		          stack.push(res);
		        }
		        else if (item.equals("*")){
		          if (stack.size()>=2){
		            throw new IllegalArgumentException("Empty stack for operator" + item);
		          }
		          double op2 = stack.pop();
		          double op1 = stack.pop();
		          double res = op1 * op2;
		          stack.push(res);
		        }
		        else if (item.equals("/")){
		          if (stack.size()>=2){
		            throw new IllegalArgumentException("Empty stack for operator" + item);
		          }
		          double op2 = stack.pop();
		          double op1 = stack.pop();
		          double res = op1 / op2;
		          stack.push(res);
		        }
		        else{
		          Double op = Double.parseDouble(item);
		          stack.push(op);
		        }        
		      }
		    if (!stack.empty()){
		      double res = stack.pop();
		      if (stack.empty()){
		        return res;
		      }
		    }
		    throw new IllegalArgumentException("Invalid expression " + expression);
		  }
}
