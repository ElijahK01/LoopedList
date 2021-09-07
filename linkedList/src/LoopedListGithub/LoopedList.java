package LoopedListGithub;

/*
 * Custom data type is of the linked list family, but adds in 
 * functionality for wrapping around to the beginning of the
 * linked list as well as switching elements left or right.
 * 
 * Operations:
 *  ++ add(Object) : void			- Add object to list
 *  ++ remove()	   : void			- Remove object from list
 *  ++ next()	   : void			- Increment pointer
 *  ++ previous()  : void			- Decrement pointer
 *  ++ currentElement() : Element	- Returns element at pointer
 *  ++ getElementValue(): Object	- Returns element value at pointer
 *  ++ changeValue(Object) : void	- Change value of element at pointer
 *  ++ jump(int)     : void 		- Change pointer location by multiple places
 *  ++ switchUp()	 : void			- Switch element at pointer with next element
 *  ++ switchDown()  : void			- Switch element at pointer with previous element
 *  ++ toBeginning() : void			- Set pointer to list beginning
 *  ++ toEnd()		 : void			- Set pointer to list end
 *  ++ len()   		 : int			- Returns length of list
 *  ++ toArray() 	 : Object[]		- Returns list elements' contents as array
 *  ++ toString()	 : String		- Returns list elements' contents as a string
 */



public class LoopedList {
	
	private Element elementUp;    // list pointer
	private Element lastElement;  // last element in the list
	private Element firstElement; // first element in the list
	
	private int length = 0; // length of list
	
	private boolean empty = true; // shows if the list is empty
	
	public LoopedList()  // constructor
	{
		elementUp = null;
		lastElement = null;
		firstElement = null;
	}
	
	public void add(Object o) // add element to the end of the list
	{
		Element e = new Element(o, elementUp);
		if(empty) 
		{
			firstElement = e; // change from null
			elementUp = e;
			lastElement = e;
			e.setPrevious(e);
			e.setNext(e);
			
			length ++;
			empty = false;
		}
		else 
		{
			lastElement.setNext(e);      // links from last element to new element
			firstElement.setPrevious(e); // links from first element to new element (backwards direction)
			
			e.setPrevious(lastElement);  // links from new element to previous last element
			e.setNext(firstElement);     // links from new element to first element (wrap around)
			
			lastElement = e;			 // changes lastElement to reflect new end of list
			length ++;
		}
	}
	
	public void remove() { // removes element at the pointer
		if(!empty) { // only runs if there are elements in the list
			
			// dereferencing object to delete
			elementUp.getPrevious().setNext(elementUp.getNext());    // stitch element behind to element in front
			elementUp.getNext().setPrevious(elementUp.getPrevious());// stitch element in front to element behind
			
			elementUp = (firstElement == elementUp ?  elementUp.getNext() : elementUp.getPrevious()); // if the element up is the first element in the list, 
																					  // the element up becomes the next element: otherwise the 
																					  // element up becomes the previous element.
			length --; // decrement length
			if(length == 0) 
				empty = !empty; // turn empty true if length reaches zero
			
		}
		else {
			new EndOfListException("Cannot remove from an empty list.");
		}
	}
	
	public void next() // move pointer forward
	{
		elementUp = elementUp.getNext();
	}
	
	public void previous()  // move pointer back
	{
		elementUp = elementUp.getPrevious();
	}
	
	public Element currentElement()  // return the element at the pointer in the list
	{
		return elementUp;
	}
	
	public Object getElementValue()  // return the value of the element at the pointer
	{
		return elementUp.getValue();
	}
	
	public void changeValue(Object o) // change the value of the element at the pointer
	{
		elementUp.setValue(o);
	}
	
	public void jump(int n) // move pointer n spaces, positive numbers for forward, negative for backward
	{
		boolean goBack = false; // direction flag
		if(n < 0){
			n *= -1; // make n positive
			goBack = true;
		}
		
		for(int i = 0; i < n; i++) { // n determines amount of times pointer goes foreward or back
			if(goBack)
				previous();
			else
				next();
		}
	}
	
	public void switchUp() // flips current element with element in front
	{
		Object tmp = elementUp.getValue();
		elementUp.setValue(elementUp.getNext().getValue());
		elementUp.getNext().setValue(tmp);
	}
	
	public void switchDown() // flips current element with element behind
	{
		Object tmp = elementUp.getValue();
		elementUp.setValue(elementUp.getPrevious().getValue());
		elementUp.getPrevious().setValue(tmp);
	}
	
	public void toBeginning() // sets pointer to list beginning
	{
		elementUp = firstElement;
	}
	
	public void toEnd() // sets pointer to list end
	{
		elementUp = lastElement;
	}
	
	public int len() // returns length of list
	{
		return length;
	}
	
	public Object toArray()  // returns the values of the elements of the list in object array form
	{
		Object[] o = new Object[length];
		Element temp = elementUp;
		toBeginning(); // save value of pointer to be reset at the end
		
		for(int i = 0; i < length; i++) {
			o[i] = elementUp.getValue();
			next();
		}
		
		elementUp = temp;
		return o;
	}
	
	@Override 
	public String toString() // returns the values as a string
	{
		String s = "";
		Element temp = elementUp;
		toBeginning(); // save value of pointer to be reset at the end
		
		for(int i = 0; i < length; i++) {
			s = (s + " " + String.valueOf(elementUp.getValue()));
			next();
		}
		
		elementUp = temp;
		
		return s;
		
	}
	
}
