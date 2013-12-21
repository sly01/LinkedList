package linkedlisttest;

public class Link {
	     
	     public String data;
	     public Link next;
	     public Link previous;
	 
	     public Link() {
	    	 next=null;
	    	 previous=null;
	     }
	 
	     public Link(String data) {
	    	 next=null;
	    	 previous=null;
	         this.data = data;
	     }
	     public void displayLink(){
	         System.out.println(data+" ");
	     }
	     
	 
	    
	 }
