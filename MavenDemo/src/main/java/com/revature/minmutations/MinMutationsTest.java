package com.revature.minmutations;

/* Problem
 * Minimum Mutations!

A gene string can be represented by an 8-character long string, with 
choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" 
to "end"), where ONE mutation is defined as ONE single character changed 
in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene 
mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what 
is the minimum number of mutations needed to mutate from "start" to 
"end".
If there is no such a mutation, return -1.
If the start and end string are the same, return 0.

Example:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2

Note:
	Starting point is assumed to be valid, so it might not be 
included in the bank.
	If multiple mutations are needed, all mutations during in the 
sequence must be valid.

Organize your solution into a driver class (with a main method) and 
utility class containing the logical implementation.
Points will be docked for code that's too tightly coupled.
The starting and ending sequences and mutation bank may be (in 
descending order of points awarded) read from a file, input through the 
console, or hard coded in the driver class. 


REFERENCE:

Reading/writing to/from files in Java, you will need to use a 
FileInputStream passed to an ObjectInputStream. 

Submit your solution in this folder on your branch as .java files (if 
you wrote your solution in Eclipse/STS, make sure no compiled .class 
files or project metadata make their way up to GitHub. 
 */


public int static MinMutationsTest() {

    //scanner input, assuming the same number of characters for start and end will give OutOfBounds if not
    Scanner scan = new Scanner(System.in);
    int input = 1;
    
    String str = "";
        System.out.print("start: ");
            str = scan.nextLine();
            
        //setting a bank
       String[] bank = {"AACCGGTT", "AACCGGTA"};
          
          
    
    String ed = "";
        System.out.print("end: ");
            ed= scan.nextLine();
            
    //verifying the end is a proper gene in the bank
    boolean inBank = false;
            
        //this loop checks if the the end is in the bank
          for (int i =0; i < bank.length; i++) {
              if (bank[i].equals(ed))
              {
                  inBank = true;
              }
          }
          //went through bank, didn't find end in bank
          if (inBank == false) {
              return -1;
              
              //did find end in bank, compares start and end using a counter
              //character to character because of charAt
              //if it finds a difference, added to counter
          } else {
              int count = 0;
              for (int i = 0; i <str.length(); i++) {
                  if (str.charAt(i) != ed.charAt(i)){
                      count++;
                  }
              } return count;
              
          }
          
}
    
public static void main(String[] args) {
    int ans = minMutation();
    System.out.println(ans);
    
}