# LoopedList
Data type based on Linked List

 * Custom data type is of the linked list family, but adds in 
 * functionality for wrapping around to the beginning of the
 * linked list as well as switching elements left or right.
 * 
 * Operations:
 *  ++ add(Object) : void		    	- Add object to list
 *  ++ remove()	   : void		    	- Remove object from list
 *  ++ next()	   : void		      	- Increment pointer
 *  ++ previous()  : void	    		- Decrement pointer
 *  ++ currentElement() : Element	- Returns element at pointer
 *  ++ getElementValue(): Object	- Returns element value at pointer
 *  ++ changeValue(Object) : void	- Change value of element at pointer
 *  ++ jump(int)     : void 		  - Change pointer location by multiple places
 *  ++ switchUp()	 : void		    	- Switch element at pointer with next element
 *  ++ switchDown()  : void		  	- Switch element at pointer with previous element
 *  ++ toBeginning() : void		  	- Set pointer to list beginning
 *  ++ toEnd()		 : void		    	- Set pointer to list end
 *  ++ len()   		 : int			    - Returns length of list
 *  ++ toArray() 	 : Object[]	  	- Returns list elements' contents as array
 *  ++ toString()	 : String		    - Returns list elements' contents as a string
