
NAME: Jeremy Goold
ID: 834570403


******* DESCRIPTION ****************************************************************************************************************************************
The following source code is for 2 different sets of projects.  We will be calling this Part A and Part B

Part A: Uses a circularly Linked List to implement a Priority Queue.

Part B: Uses a array to implement a heap.

******* USAGE ****************************************************************************************************************************************

Part A:

        The main class is RoundRobin.  Running the class will give you a menu where you will be able to

Enter a time Quantum   then you will be given another menu where you will then choose an option.

choosing entering a process will prompt you with giving the process a name, a time, and a priority.

You can then Execute the simulation which will result in the processes being removes each iteration as

they lose time in their process time that was entered by the user.

There exit option will close the program.




Part B:

        The main class is MainProgram.  Running this class will prompt you with a menu of different options.

You can enter a process which will tell you to enter the process name, time, and the priority.

You have the option to create a heap (But the heap is created everytime an object is added to the class so its

already a head).

You can delete the max priority item.

You can grab the object with the max priority

You can print the priority of the object with the max priority

Then you can display the heap and the items in the list.  This will give you 2 print outs.

Each are different ways of representing the heap.


******* FILES ****************************************************************************************************************************************

Part A:
ListInterface.java
Node.java
ProcessInfo.java
RoundRobin.java [MAIN]


Part B:
HeapClass.java
ProcessInfo.java
MainProgram.java [MAIN]

******* CLASS METHODS ****************************************************************************************************************************************


HeapClass:

     Type                            Name                            Description
===============================================================================================================================
Constructor                        HeapClass                   initializes the array and max
                                                               size of the heap
int                                parent                      returns index of parent
int                                leftChild                   returns the index of the left child
int                                rightChild                  returns the index of the right child
boolean                            isLeaf                      returns if the element at an index is a leaf
void                               add                         adds an element to the heap
void                               swap                        swaps the elements given 2 indexes
E                                  removeMax                   removes the top of the heap
E                                  max                         returns the top of the heap
void                               heapify                     creates a heap with the given index being the top
void                               display                     prints the elements of the heap by priority
void                               displayHeap                 prints the heap with the parent - Lchild - Rchild associations
==================================================================================================================================


MainProgram:

     Type                            Name                            Description
===============================================================================================================================
void                                 main                            prompts the user with the menu and options that loops till exit
void                                enterProcess                     holds the menu and logic to enter a process to keep the
                                                                     main method from looking messy
==================================================================================================================================


Node:

     Type                            Name                            Description
===============================================================================================================================
Constructor                        Node                       sets the data in the node and the nextNode
E                                  getNext                    returns the nextNode variable
void                               setNext                    sets the nextNode
void                               toString                   Overrides the toString method
int                                compareTo                  Overrides the compareTo method from the Comparable class
==================================================================================================================================


ProcessInfo:

     Type                            Name                            Description
===============================================================================================================================
Constructor                        ProcessInfo                 sets the data for the class
void, string                       setName, getName            getters and setters for the name variable
void, float                        setTime, getProcessTime     getters and setters for the processTime variable
void                               toString                    Overrides the toString method
int                                compareTo                   Overrides the compareTo method in the Comparable class
==================================================================================================================================


RoundRobin:

     Type                            Name                            Description
===============================================================================================================================
void                               main                        prints menus, and controls the logic for accessing the HeapClass
==================================================================================================================================


SinglyLinkedListClass:

ProcessInfo:

     Type                            Name                            Description
===============================================================================================================================
int                                 size                            returns the size of the list
boolean                             isEmpty                         returns if the list is empty
E                                   first                           returns the first element of the list
E                                   last                            returns the tail element of the list
void                                rotate                          rotates the list and moves the tail
void                                addItemByComparison             adds an item by using the comparable class
void                                addFirst                        adds an item to the beginning
void                                addLast                         adds an item to the end
E                                   removeFirst                     removes the first item in the list
void                                display                         displays all the items in the list
==================================================================================================================================

