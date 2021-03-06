package Mainclasses;
import Tools.InputClass;
import Tools.randomID;
import Users.addedMembers;
import Users.Member;
import Menus.ownerMenu;
import Menus.managerMenu;
import Menus.developerMenu;
import Import_Export.importAndExportSavedInfo;

public class startApp {

    static InputClass printOutput = new InputClass();
    static addedMembers addedmembers = addedMembers.getInstance();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static randomID randID = randomID.getInstance();
    importAndExportSavedInfo ie = new importAndExportSavedInfo();

    public void run(){

        randID.generate();

        String choices = "1";
        String choices1;


        while (!choices.equals("4")) {
            System.out.println(ANSI_WHITE + "\n\nWelcome to EFICAZ! The one and only Project Management Tool right now.\n" + ANSI_RESET);

            choices = printOutput.readLine(ANSI_CYAN + "Insert a number between 1-3 and then hit `Enter´:\n\n1. Login\n2. New User? Register now!\n3. Exit program\n\n" + ANSI_RESET);
            int levelCheck;

            switch (choices) {
                case "1":

                    String userName = printOutput.readLine("Username: ");
                    String passWord = printOutput.readLine("Password: ");
                    levelCheck = addedmembers.findMember(userName, passWord);
                    if (levelCheck > 0) {
                        addedmembers.setActiveUser(userName);
                        menuDirectory(levelCheck);
                    } else {
                        printOutput.printLine(ANSI_RED +"Invalid login information, please try again." + ANSI_RESET);
                    }

                    break;
                    case "2":
                    newUser();
                    printOutput.printLine("Your account was successfully added");
                    ie.exportUsers();
                    break;
                case "3": {
                    printOutput.printLine("\nThank you for using EFICAZ.\nSee you next time!");
                    ie.exportProjects();
                    System.exit(0);
                }
                default:
                    printOutput.printLine(ANSI_RED + "Wrong input, try again:\n"+ ANSI_RESET);
            }
        }
    }
    public void newUser(){

        String name = printOutput.readLine("Enter your full name: ");

        String userName = printOutput.readLine("Create a username: ");
        String pass = printOutput.readLine("Create a password: ");

        int level = printOutput.read123("Whats your profession? Choose from the options below.\n\n" +
                "1. Product owner\n2. Project manager\n3. Developer/Designer\n (Enter 1-3 depending on your profession)\n\n");

        int memberKey = randID.getRandom();
        Member createMember = new Member(name, userName, pass, level,memberKey);
        addedmembers.addMember(createMember);
    }
    public void menuDirectory(int level){

         switch (level) {
             case 1:
                 printOutput.printLine ("\nPlease wait...\n");
                 ownerMenu oM = new ownerMenu();
                 oM.menu();
                 break;

             case 2:
                 printOutput.printLine ("\nPlease wait...\n");
                 managerMenu ManagerMenu = new managerMenu();
                 ManagerMenu.menu();
                 break;
             case 3:
                 printOutput.printLine ("\nPlease wait...\n");
                 developerMenu DeveloperMenu = new developerMenu();
                 DeveloperMenu.menu();
                 break;
         }
    }
}

