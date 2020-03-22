package assignment4;

public class Main {

    public static void main(String[] args){
        String [] anArray1 = {"Ben","Ali","Nancy","Paul","Zack","Caroline","Greg","Rebecca","Emily","Jake"};
        String [] anArray2 = {"Ben","Ali","Nancy","Paul","Zack","Caroline","Greg","Rebecca","Emily","Jake"};

        System.out.println("After SELECTION SORT: \n");
        Assignment4.recursiveSelectionSort(anArray1,anArray1.length);

        for (String name : anArray1) {
            System.out.println(name);
        }

        System.out.println("\n\n");

        System.out.println("After BUBBLE SORT: \n");
        Assignment4.recursiveBubbleSort(anArray2,anArray2.length);

        for (String name : anArray2) {
            System.out.println(name);
        }
    }
}
