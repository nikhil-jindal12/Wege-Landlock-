import java.util.NoSuchElementException;
import java.util.Iterator;

/** 
 * A class to represent a linked list of nodes
 * @author Nikhil Jindal
 * @author Chris Lozinak
 */
public class LinkedList<T> implements Iterable<T> {

  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;

  /**
   * Creates an initially empty linked list
   */
    public LinkedList() {
        firstNode = null;
    }

    /** 
     * Returns the first node
     * @return the first node
     */
    protected LLNode<T> getFirstNode() {
        return firstNode;
    }

    /** 
     * Changes the front node
     * @param node  the node that will be the first node of the new linked list
     */
    protected void setFirstNode(LLNode<T> node) {
        this.firstNode = node;
    }
    
    /** 
     * return whether the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return getFirstNode() == null;
    }   
    
    /** 
     * Add an element to the front of the linked list
     * @param element  the element to add to the front of the linked list
     */
    public void addToFront(T element) {
        setFirstNode(new LLNode<T>(element, getFirstNode()));
    }

    // could return a NullPointerException and will tell the user how this is implemented
    /** Removes and returns the element at the front of the linked list
      * @return the element removed from the front of the linked list
      * @throws NoSuchElementException if the list is empty
      */
    public T removeFromFront() {
        if (!isEmpty()) {
            T save = getFirstNode().getElement();
            setFirstNode(getFirstNode().getNext());
            return save;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the length of the linked list
     * @return the number of nodes in the list
     */
    public int length() {
        int count = 0;
        LLNode<T> nodePointer = getFirstNode();
        // subgoal: count equals # of nodes up to but not including 
        while (nodePointer != null) {
            count++;
            nodePointer = nodePointer.getNext();
        }
        return count;
    }

    public void addToEnd(T element) {
        if (!isEmpty()) {
            LLNode<T> nodePointer = getFirstNode();
            while (nodePointer.getNext() != null) {
                nodePointer = nodePointer.getNext();
            }
            // at the point nodePointer.getNext() == null, at last node
            nodePointer.setNext(new LLNode<T> (element, null));
        }
        else {
            addToFront(element);
        }
    }

    /*
    // inside LLNode class, using "recursion"
    public int lengthFromHere() {
        if (getNext() == null) {
            return 1;
        }
        else {
            return (1 + getNext().lengthFromHere());
        }
    }
    */    
    
    /** 
     * Returns a String representation of the list
     * @return a String representing the list
     */
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("list:");
      if (!isEmpty()) {
        LLNode<T> current = getFirstNode();
        while (current.getNext() != null) {
          builder.append(" " + current.getElement());
          current = current.getNext();
        }
        builder.append(" " + current.getElement());
      }
      return builder.toString();
    }
    
    /** 
     * Determines whether an element is stored in the list
     * @param element  the element to search for in the list
     * @return true if and only if the parameter element is in the list
     */
    public boolean contains(T element) {
      if (!isEmpty()) {
        LLNode<T> current = getFirstNode();
        while (current.getNext() != null) {
          if (current.getElement().equals(element)) {
            return true;
          }
          else {
            current = current.getNext();
          }
        }
        if (current.getElement().equals(element)) {
          return true;
        }
      }
      return false;
    }
    
    /** 
     * Deletes the first occurrance of an element in the list
     * if the element is not in the list, the list is unchanged
     * @param element  the element to remove
     */
    public void remove(T element) {
      if (!isEmpty()) {
        LLNode<T> current = getFirstNode();
        while (current.getNext() != null) {
          if (current.getNext().getElement().equals(element)) {
            //current.deleteNext();
          }
          else {
            current = current.getNext();
          }
        }
      }
    }

    /**
     * Returns an iterator for the list
     * @return an iterator starting at the first element of the list
     */
    public LinkedListIterator<T> iterator() {
        return (new LinkedListIterator<T>(getFirstNode()));
    }
    
    /**
     * Print the contents of a list
     * An example of declaring a generic for a method
     * @param list  the list to print
     */
    public static <T> void printList(LinkedList<T> list) {
        LLNode<T> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.println(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
        }
    }

    /**
     * Prints the contents of a linked list
     * An example of using the ? generic type wildcard
     * @param list  the list to print
     */
    public static void printList2(LinkedList<?> list) {
        LLNode<?> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.println(nodeptr.getElement());
            nodeptr = nodeptr.getNext();
        }
    }

    /**
     * Add each element into sorted order
     * Prerequisite: the list is already in sorted order
     * Postcondition: the element is added and the list is in sorted order
     * @param element  to add to the list
     * @param list  the list to add the element
     */
    public static <T extends Comparable<? super T>> void addInOrder(T element, LinkedList<T> list) {
      if (list.isEmpty() || list.getFirstNode().getElement().compareTo(element) > 0) {
        list.addToFront(element);
      }
      else {
        LLNode<T> nodeptr = list.getFirstNode();
        while (nodeptr.getNext() != null && nodeptr.getNext().getElement().compareTo(element) < 0) {
          nodeptr = nodeptr.getNext();
        }
        nodeptr.setNext(new LLNode<T>(element, nodeptr.getNext()));
      }
    }

    public static void main(String[] args) {
      // LinkedList<Integer> list = new LinkedList<Integer>()  ;
      // list.addToFront(5);
      // LinkedList.addInOrder(15, list);
      // LinkedList.addInOrder(3, list);
      // LinkedList.addInOrder(13, list);
      // for (Integer x : list) {
      //   System.out.println(x);
      // }

      
     LinkedList<Integer> list = new LinkedList<Integer>();
      list.addToFront(5);
      list.addToFront(4);
      list.addToFront(3);
      list.addToFront(2);
      list.addToFront(1);
      Iterator<Integer> it = list.iterator();
      while (it.hasNext()) {
          System.out.println(it.next());
      }
      /*
      for (Integer x : list) {
          System.out.println(x);
      } */
    }
}