package com.snhien.algo;

public class Inheritance {
	
	public class A {
		private double a;
		
		public A(){
			a = Math.random();
		}
		
		public A(A other){
			this.a = other.a;
		}
		
		public String toString(){
			return ("a="+a);
		}
		
		public A myClone(){
			A newObj = new A();
			newObj.a = a;
			return (newObj);
		}
		
	}
	
	public class B extends A{
		private double b;
		
		public B(){
			super();
			b = Math.random();
		}
		
		public B(B that){
			super(that);
			this.b = that.b;
		}
		
		public String toString(){
			return (super.toString() + " : b="+b);
		}
		
		public A myClone(){
			try{
				B newObj = (B)newInstance();
				newObj.b = b;
				return(newObj);
			}
			catch(Exception e){
				System.out.println("Error myClone: " + e.getMessage());
				return (null);
			}
		}
				
		public A newInstance(){
			B newObj = new B(this);
			return (newObj);
		}
		
	}

	public class C extends B{
		private double c;
		
		public C(){
			super();
			c = Math.random();
		}
		
		public C(C that){
			super(that);
			this.c = that.c;
		}
		
		public String toString(){
			return (super.toString() + " : c=" + c);
		}
		public A myClone(){
			C newObj = (C)newInstance();
			newObj.c = this.c;
			return(newObj);
		}
		
		public A newInstance(){
			C newObj = new C(this);
			return(newObj);
		}
		
	}
	
	public static void main(String args[]){
		Inheritance i = new Inheritance();
		Inheritance.A obj =  i.new C();
		System.out.println("obj=" + obj.toString());
		C newObj = (C) obj.myClone();
		System.out.println("newObj=" + newObj.toString());
	}
	
}
