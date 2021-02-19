import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    private static ArrayList<Integer> arrlist = new ArrayList<Integer>(); // TODO: do we really need arrlist at all?
    private static ArrayList<Integer> expenses = new ArrayList<Integer>();

    public static void addSampleExpenses() {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist); // TODO: do we really need arrlist at all?

    }

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/

        addSampleExpenses();
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        System.out.println("\n**************************************\n");
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        for(int j=1;j<=slen;j++){
            if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        //TODO: Make the changes "sticky"
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        optionsSelection();

                        break;
                    case 3:
                        //TODO: Make the changes "sticky"
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                            expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        }

    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        Scanner sc = new Scanner(System.in);
        int  expense =  sc.nextInt();
        boolean found = false;
        System.out.println("\nYou are searching for: " + expense);

        for(Integer item : expenses){
            if(item == expense){
                found = true;
            }
        }

        if(found){
            System.out.println("\nYour search value was found.\n");
        }else{
            System.out.println("\nYour search value was not found.\n");
        }

    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
        Integer[] tempArrayList = new Integer[arrlength];
        tempArrayList = quickSort(arrayList.toArray(tempArrayList),arrlength);
        expenses.clear();
        Collections.addAll(expenses, tempArrayList);
        System.out.println("Your expenses have been sorted in ascending order.\n");
        System.out.println(expenses+"\n");
    }


    public static Integer[] quickSort(Integer[] arrayListToSort, int elements) {

        if(elements < 2 || arrayListToSort == null){
            return arrayListToSort;
        }

        int current_position=0;
        int temp;

        for(int i=1; i<elements; i++){
            if(arrayListToSort[i] <= arrayListToSort[0]){
                current_position++;
                temp = arrayListToSort[i];
                arrayListToSort[i] = arrayListToSort[current_position];
                arrayListToSort[current_position] = temp;
            }
        }

        temp = arrayListToSort[0];
        arrayListToSort[0] = arrayListToSort[current_position];
        arrayListToSort[current_position] = temp;

        Integer[] left = quickSort(arrayListToSort,current_position);

        Integer[] newArray = Arrays.copyOfRange(arrayListToSort, current_position+1, elements);

        Integer[] right = quickSort(newArray, elements-current_position-1);

        Integer[] finalArray = new Integer[elements];

        for(int i=0; i < current_position; i++){
            finalArray[i] = left[i];
        }

        finalArray[current_position] = arrayListToSort[current_position];

        for(int i=current_position+1; i<elements; i++){
            finalArray[i] = right[i-current_position-1];
        }

        return finalArray;

    }


}

