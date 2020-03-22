package assignment4;

import java.util.Stack;

/**
 * <h1>Assignment 04</h1>
 * This program sorts an array of strings using bubble sort and
 * selection sort, determines if a given word is valid within an
 * assignment specified language, and converts a list of numbers
 * into an int, where the order of the numbers determines their
 * decimal "place."
 * <p>
 *
 * @author  Jarred Black
 * @version 0.1.1
 * @since  2020-03-20
 */
public class Assignment4 {

    //sort of a wrapper for allowing the sorting function to be passed a 0.
    public static <T extends Comparable <? super T>> void recursiveSelectionSort(T[] anArray, int length){
        recursiveSelectionSorter(anArray, length, 0);
    }

    private static <T extends Comparable <? super T>> void swap(T[] Array, int indexA, int indexB) {
        T temp = Array[indexA];
        Array[indexA] = Array[indexB];
        Array[indexB] = temp;
    }


    /**
     * Method to sort an array using a recursive selection sort.
     * @param Array The array to be sorted.
     * @param length The length of the array to be sorted.
     * @param index The index at which the method will begin sorting the array.
     */
    public static <T extends Comparable <? super T>> void recursiveSelectionSorter(T[] Array, int length, int index) {
        T currentMinName = Array[index];
        int currentMinIndex = index;
        //loop through the list, comparing the words as you go.
        for (int i = index; i < length; i++) {
            T currentName = Array[i];
            //if the currentName is 'smaller' than currentMinName...
            String minNameString = (String) currentMinName;
            if (minNameString.compareToIgnoreCase((String) currentName) > 0) {
                // ...it (and its index) becomes the new currentMinName.
                currentMinName = currentName;
                currentMinIndex = i;
            }
    }
        //if the starting entry IS NOT the 'smallest' in the list...
        if(!Array[index].equals(Array[currentMinIndex])) {
            // ...swap it with the entry that is.
            swap(Array, currentMinIndex, index);
        }
        //if we've reached the end of the array...
        if (index == length - 1) {
            //...return.
            return;
        }
        //if there's still more to the array...
        else {
            //...run this algorithm again, starting one index further into the array.
            recursiveSelectionSorter(Array, length, index + 1);
        }
    }


    /**
     * Method to sort an array using a recursive bubble sort.
     * @param Array The array to be sorted.
     * @param length The length of the array to be sorted.
     */
    public static <T extends Comparable <? super T>> void recursiveBubbleSort(T[] Array, int length) {
        boolean swapped = false;
        //for every element in the array...
        for(int i = 1; i < length; i++) {
            //look at the current element in the array...
            T currentName = Array[i-1];
            //...and the next element in the array...
            T nextName = Array[i];
            //cast the current element as a string named currentNameString.
            String currentNameString = (String) currentName;
            //if the current element is greater than the element after it...
            if (currentNameString.compareToIgnoreCase((String) nextName) > 0) {
                //...set swapped to true...
                swapped = true;
                //...and swap the elements.
                swap(Array, i-1, i);
            }
        }
        //if we've made it through the whole list without swapping any elements...
        if (!swapped) {
            //...the list must be sorted, so return the list.
            return;
        }
        //otherwise...
        else {
            //...run the algorithm again.
          recursiveBubbleSort(Array, length);
        }
    }


    /**
     * Method to determine if a given string is a valid word within a
     * language defined by the assignment specifications.
     * @param word The word that will be checked for validity.
     * @return A boolean value representing weather the string was a valid word.
     */
    public static boolean isInLanguage(String word) {
        //boolean flag to detect the centre point of the word.
        boolean middle = false;
        //stack to stack up the characters before the centre of the word.
        Stack<Character> letterStack = new Stack<Character>();

        //if we only have 1 letter...
        if (word.length() == 1) {
            //... and that letter is a '$', return false.
            if (word.equals("$")) {return false;}
            //otherwise, return true.
            else {return true;}
        }
        //otherwise, loop through the word
        for (int i=0; i < word.length(); i++) {
            //if we hit a '$', then we're at the middle of the word...
            if (word.charAt(i) == '$') {
                //...so set the middle flag to true...
                middle = true;
                //...and restart the loop.
                continue;
            }
            //if we haven't passed the middle of the word...
            if (!middle) {
                //...put the current letter on the stack.
                letterStack.push(word.charAt(i));
            }
            //if we've passed the '$' character...
            else {
                //check the current letter against the top of the stack.
                if (word.charAt(i) != letterStack.pop()) {
                    //if it doesn't match, return false.
                   return false;
                }
            }

        }
        //if we've made it through the for loop without returning false, then we've shown the word is the same, return true.
        return true;
    }


    /**
     * Method to convert a string of spaces and numbers into a single value,
     * where the order of the individual numbers determines their decimal place
     * in the final value.
     * @param str The string of numbers and spaces to be converted.
     * @return An int that is final value of the concatenated and converted total.
     */
    public static int convertToNumber(String str) {
        Stack<Character> numberStack = new Stack<Character>();
        int returnNumber = 0;
        int place = 1;
        //for all the characters in the string...
        for (int i=0; i < str.length(); i++) {
            //...if the current character is not a space...
            if (str.charAt(i) != ' ') {
                //...add it to the numberStack.
                numberStack.push(str.charAt(i));
            }
        }
        //while there are still numbers on the stack...
        while (!numberStack.empty()) {
            //...convert the object on the stack into a usable int...
            String currentChar = numberStack.pop().toString();
            int toAdd = Integer.parseInt(currentChar);
            //...add the current digit, multiplied by current decimal place, to the total...
            returnNumber = returnNumber + (toAdd * place);
            //...and increment the decimal place by multiplying by 10.
            place = place * 10;
        }
        //when we're done, return the final value.
        return returnNumber;
    }
}