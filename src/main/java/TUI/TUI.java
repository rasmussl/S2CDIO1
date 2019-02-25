package TUI;

import Logic.SwitchLogic;
import data.dal.IUserDAO;
import data.dto.UserDTO;

import java.util.Scanner;

public class TUI {

    // ------------------------ Fields -------------------------

    IUserDAO DB_interface;

    // ------------------------- Constructor --------------------

    public TUI (IUserDAO userDAO) {

        DB_interface = userDAO;

    }

    // -------------------- Public Method ------------------------
    public void TUI() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            startMenu();
            int choice = scan.nextInt();
            TheSwitch(choice);
        }
    }


    // ---------------------- Private Method ------------------------
    // Menu beskederne

    private void startMenu() {
        System.out.println();
        System.out.println("Enter a number for which action you want to take");
        System.out.println("1. Add new user");
        System.out.println("2. Show users");
        System.out.println("3. Update user");
        System.out.println("4. Remove user");
        System.out.println("5. Close the program");
        System.out.println("6. Check password of a user");
    }

    //Menu switchen

    private void TheSwitch(int choice) {

        SwitchLogic SL = new SwitchLogic(DB_interface);

        switch (choice) {
            // 1. Add New User.
            case 1:
                SL.AddUser();
                break;

            // 2. Show Users.
            case 2: //some thing
                SL.Print();
                break;

            // 3. Update User.
            case 3: //some thing
                SL.update();
                break;

            // 4. Delete User.
            case 4: //some thing
                SL.delete();
                break;

            // 5. Close the program.
            case 5:

                System.exit(0);
                break;

            // 6. Check Password for a User.
            case 6:
                Scanner scan = new Scanner(System.in);
                System.out.println("Write index of the user you want to check password on");
                int nr = scan.nextInt();
                try {
                    System.out.println(DB_interface.getUser(nr).getPassword());
                }
                catch (IUserDAO.DALException ex) {
                    System.out.println(ex);
                }
                break;
            default:
                System.out.println("Please enter a valid input");
                System.out.println();
        }

    }

}
