package Email_Id_Creator;

import java.util.Scanner;

public class CreateUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following Details -----");
        System.out.print("Name of User : ");
        String userName = sc.nextLine();
        System.out.print("Company Name : ");
        String companyName = sc.nextLine();
        System.out.print("Year of Joining : ");
        int yearOfJoining = sc.nextInt();
        UserId user = new UserId(userName, companyName, yearOfJoining);
        System.out.println("Email: " + user.getEmail() + "\nPassword: " + user.getPassword());
        sc.close();
    }
}
