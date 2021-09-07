package LoopedListGithub;

public class Element {
	
	private Object storedObject; 
	private Element previous;
	private Element next;
	
	public Element(Object o, Element previousElement) 
	{
		storedObject = o;
		previous = previousElement;
		next = null;
	}
	
	public Object getValue() 
	{
		return storedObject;
	} 
	
	public Element getPrevious() 
	{
		return previous;
	}
	
	public Element getNext() 
	{
		return next;
	}
	
	public void setNext(Element nextElement) 
	{
		next = nextElement;
	}
	
	public void setPrevious(Element previousElement) 
	{
		previous = previousElement;
	}
	
	public void setValue(Object o) 
	{
		storedObject = o;
	}
	
}
