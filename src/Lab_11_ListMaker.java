import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_ListMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String choice;
        boolean done = false;

        do
        {
            System.out.println("\nCurrent List:");

            if(list.size() == 0)
            {
                System.out.println("[Empty]");
            }
            else
            {
                for(int i = 0; i < list.size(); i++)
                {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
            }

            choice = SafeInput.getRegExString(
                    in,
                    "\nA-Add D-Delete I-Insert P-Print Q-Quit",
                    "[AaDdIiPpQq]");

            switch(choice.toUpperCase())
            {
                case "A":
                    addItem(list, in);
                    break;

                case "D":
                    deleteItem(list, in);
                    break;

                case "I":
                    insertItem(list, in);
                    break;

                case "P":
                    printList(list);
                    break;

                case "Q":
                    done = SafeInput.getYNConfirm(
                            in,
                            "Are you sure you want to quit?");
                    break;
            }

        } while(!done);

        System.out.println("Program terminated.");
    }

    private static void addItem(ArrayList<String> list, Scanner in)
    {
        String item = SafeInput.getNonZeroLenString(
                in,
                "Enter item to add");

        list.add(item);
    }

    private static void insertItem(ArrayList<String> list, Scanner in)
    {
        String item = SafeInput.getNonZeroLenString(
                in,
                "Enter item to insert");

        int position = SafeInput.getRangedInt(
                in,
                "Enter insertion position",
                1,
                list.size() + 1);

        list.add(position - 1, item);

        System.out.println("Item inserted.");
    }

    private static void deleteItem(ArrayList<String> list, Scanner in)
    {
        if(list.size() == 0)
        {
            System.out.println("List is empty.");
            return;
        }

        printList(list);

        int itemNum = SafeInput.getRangedInt(
                in,
                "Enter item number to delete",
                1,
                list.size());

        list.remove(itemNum - 1);

        System.out.println("Item deleted.");
    }

    private static void printList(ArrayList<String> list)
    {
        System.out.println("\nCurrent List:");

        if(list.size() == 0)
        {
            System.out.println("[Empty]");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}