Contributors:     Jeremy Goold

Description:      The following is the implementation of 2 projects.  Part one is balanced
                  parenthesis checking and making sure that there is the correctly placed curly braces in a java program.
                  Part 2 is a software solution to keeping track of who is enrolled in a class or on the waitlist and gives
                  the ability to remove students from a class.


Usage:            Part 1 you must run the BalancedParentheses class.  You must also have a java program renamed to input.txt
                  in the root directory of the program.  You will receive an output of Balanced or Unbalanced.

                  Part 2 will need you to run the StudetnRegistration class.  You must also have the Records.txt file in the
                  root directory that contain <name><space><id>.  you must enter the number of seats in the class.  The you can
                  pick 3 options which will repeat until exiting..  [1] remove student , [2] display students, [3] exit...
                  removing a student will require an id... I recommend printing them to view the id's first.



Files:
               StackInterface.class
               StackArray.class  implements ^

               QueueInterface.class
               QueueArray.class  implements ^

               StudentInfo.class

               BalancedParentheses.class   main()   p1
               StudentRegistration.class   main()   p2




class StackArray:


constructor and Description

  StackArray(int size):
  Initializes an array with the given size
  LIFO implementation


Modifier and Type                       Method and Description
void                                    push(Object e)
                                          adds object to the stack

Object                                  pop()
                                            removes object from the stack and returns it


boolean                                 isEmpty()
                                            returns true if the stack is empty

boolean                                 isFull()
                                            returns true if the stack is full.


void                                    printStack()
                                            prints all the elements in the stack.

Object                                  peek()
                                            returns the next to be removed from the stack without pop


class QueueArray:

constructor and Description

  StackArray(int size):
  Initializes and array with the given size
  FIFO impementation


  Modifier and Type                       Method and Description
  void                                    enqueue(Object e)
                                            adds object to the queue

  Object                                  dequeue()
                                              removes object from the queue and returns it

  boolean                                 isEmpty()
                                              returns true if the stack is empty

  boolean                                 isFull()
                                              returns true if the stack is full.

  Object                                  peek()
                                              returns the next to be removed from the queue without dequeue

  int                                     size()
                                              returns the size of the




class StudentInfo:

constructor and Description

  StudentInfo(String name, int id):
  sets the name and id parameters to a local object variables


  Modifier and Type                       Method and Description
  String                                  getName()
                                            retunrs the name object variable

  int                                     getRedID()
                                            returns the id object variable


class StudentRegistration:

Modifier and Type                       Method and Description
void                                     main(String[] args)
                                             contains logic for adding and dropping students to an enrolled students list


void                                      dropStudent(StudentInfo[] enrolledStudents, QueueArray[] queue)
                                             contains the logic for dropping a student and replacing the spot with a waitlisted
                                             student if there are any in the queue.

void                                      printStudents(StudentInfo[] enrolledStudnets, QueueArray[] queue)
                                             prints the students that are in the enrolledstudents list along with
                                             the ones in the wialist queue if there are any.



Interfaces:

QueueInterface  implemented by QueueArray
ArrayInterface  implemented by StackArray
