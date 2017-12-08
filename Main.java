import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();
        initialValues(bTree);
        Scanner in = new Scanner(System.in);
        String superhero;
        String yn;

        final int INITIALCOUNT = 5;
        int currentCount = INITIALCOUNT;
        int added = 0;
        int removed = 0;
        int stop = 0;

        try {
            while (stop != -1) {
                clearScreen();
                bTree.print();
                System.out.println("There are currently " + currentCount + " elements in the tree.\n");
                System.out.print("Enter the name of a superhero (-1 to quit):  ");
                superhero = in.nextLine();
                if (superhero.equals("-1")) {
                    stop = -1;
                } else if (bTree.find(superhero) != null) {
                    System.out.print("That superhero is already in the list. Would you like to remove it? (Y/N):  ");
                    yn = in.nextLine().toUpperCase();
                    if (yn.equals("Y")) {
                        removed = removeElement(bTree,superhero,removed);
                    } else {
                        System.out.println(superhero + " was not removed.\n");
                        pause();
                    }
                } else {
                    System.out.print("That superhero is not in the list. Would you like to add it? (Y/N):  ");
                    yn = in.nextLine().toUpperCase();
                    if (yn.equals("Y")) {
                        added = addElement(bTree, superhero, added);
                    } else {
                        System.out.println(superhero + " was not added.\n");
                        pause();
                    }
                }
                currentCount = INITIALCOUNT + added - removed;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nThe initial tree had " + INITIALCOUNT + " elements. You added " + added +
                " and removed " + removed + " for a final count of " + currentCount + " elements in the tree." +
                "\nEND OF FIND DATA PROGRAM");
    }

    private static void initialValues(BinarySearchTree bTree){
        bTree.add("Superman");
        bTree.add("Batman");
        bTree.add("Wonder Woman");
        bTree.add("The Flash");
        bTree.add("Aqua Man");
    }

    private static int addElement(BinarySearchTree bTree, String superhero, int added){
        bTree.add(superhero);
        added++;
        return added;
    }

    private static int removeElement(BinarySearchTree bTree, String superhero, int removed){
        bTree.remove(superhero);
        removed++;
        return removed;
    }

    private static void clearScreen(){
        System.out.print("\f" + "\n");
    }

    private static void pause() throws IOException {
        System.out.print("Press Enter key to continue: ");
        char c = (char) System.in.read();
    }

}

