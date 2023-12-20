////////////////////////////////////////////////////////////////
public class Link
   {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
      iData = id;                 // initialize data
      dData = dd;                 // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (first==null);
      }
// -------------------------------------------------------------
//QUESTION 1
// insert at start of list
   public void insertFirst(int id, double dd)
      {
      Link newLink = new Link(id, dd);
      newLink.next = first;      
      first = newLink;                   
      }  
//QUESTION 2
// -------------------------------------------------------------
   public Link deleteFirst()     
      {   
      Link temp = first;          
      first = first.next;         
      return temp;                        
      }	

//QUESTION 3  
// -------------------------------------------------------------
   public void displayList()
      {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
	 
	// ------------------------------------------------------------- 

//QUESTION 4	 
// -------------------------------------------------------------
   public void displaytheLastNODEiData()
      {
      Link current = first;
      if (first==null) {
         System.out.println("null");
      }
      while (current.next!=null) {
         current = current.next;
      }
      current.displayLink();
      System.out.println("");
      }
    
// ------------------------------------------------------------- 
//QUESTION 5   
	public int findMin(){
      Link current = first;
      int min = first.iData;
      while (current!=null) {
         if (current.iData<min) {
            min = current.iData;
         }
         current=current.next;
      }
      System.out.println(min);
      return min;
   }
    

//QUESTION 6	 
// -------------------------------------------------------------  
    
   public void DeleteElementwithiData(int a){
      Link current = first;
      Link previous = null;
      while (current!=null) {
         if (current.iData==a) {
            if (previous==null) {
               first = current.next;
            }
            else {
               previous.next=current.next;
            }
         }
         previous=current;
         current=current.next;
      }
   } 
 
//QUESTION 7    
// ------------------------------------------------------------- 
    	 
   public void removeDuplicates(){
      Link master = first;
      Link hound = null;
      while (master!=null && master.next!=null) {
         hound=master;
         while (hound.next!=null) {
            if (master.iData==hound.next.iData&&master.dData==hound.next.dData) {
               hound.next = hound.next.next;
            }
            else {
               hound = hound.next;
            }
         }
         master = master.next;
      }
   } 
	 
// -------------------------------------------------------------
   //Question 8
   //This is optional, there will be no partial credit
   //BUT it is a good practice for the exam
   
   public void sortLinkedList() {
       // Node current will point to head
      Link current = first, index = null;
 
      int temp;
      Double temp1;
 
      if (first == null) {
         return;
      }
      else {
         while (current != null) {
                // Node index will point to node next to
                // current
               index = current.next;
 
               while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                  if (current.iData> index.iData) {
                     temp = current.iData;
                     temp1= current.dData;
                     current.iData = index.iData;
                     current.dData = index.dData;
                     index.iData = temp;
                     index.dData = temp1;
                  }
 
                  index = index.next;
                }
               current = current.next;
         }
      }
   }  
   
   
   // end class LinkList
   
}
////////////////////////////////////////////////////////////////
class miniHW4
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list
      //this code is for you to use to test you code
      //feel free to modify it. 

      theList.insertFirst(22, 2.99);      // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);
      theList.displayList();
      theList.insertFirst(45,9.876);
      theList.DeleteElementwithiData(44);
      theList.displayList();
      theList.displaytheLastNODEiData();
      theList.deleteFirst();
      theList.displayList();
      theList.findMin();
      theList.insertFirst(22,2.99);
      theList.removeDuplicates();
      theList.displayList();
      theList.sortLinkedList();
      theList.displayList();
      theList.displaytheLastNODEiData();
      }  // end main()
   }  // end class LinkListApp
////////////////////////////////////////////////////////////////
