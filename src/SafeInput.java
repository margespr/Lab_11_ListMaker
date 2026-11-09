import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You must enter a valid integer.");
                pipe.nextLine();
            }
        }
        while(!done);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You must enter a valid double.");
                pipe.nextLine();
            }
        }
        while(!done);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt;
        boolean done = false;

        do
        {
            retInt = getInt(pipe, prompt + " [" + low + "-" + high + "]");

            if(retInt >= low && retInt <= high)
            {
                done = true;
            }
            else
            {
                System.out.println("Value must be between " + low + " and " + high);
            }
        }
        while(!done);

        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble;
        boolean done = false;

        do
        {
            retDouble = getDouble(pipe, prompt + " [" + low + "-" + high + "]");

            if(retDouble >= low && retDouble <= high)
            {
                done = true;
            }
            else
            {
                System.out.println("Value must be between " + low + " and " + high);
            }
        }
        while(!done);

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
        }
        while(!response.equalsIgnoreCase("Y") &&
                !response.equalsIgnoreCase("N"));

        return response.equalsIgnoreCase("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();

            if(response.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Input does not match required format.");
            }
        }
        while(!done);

        return response;
    }

    public static void prettyHeader(String msg)
    {
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();

        int spaces = (54 - msg.length()) / 2;

        System.out.print("***");

        for(int i = 0; i < spaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        int remaining = 54 - spaces - msg.length();

        for(int i = 0; i < remaining; i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();
    }
}