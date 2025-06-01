import java.util.Scanner;

public class turing_machine {

    //Define Turing Machine states
    enum State {
        START,
        COMPARE,
        CHECK_END,
        ACCEPT,
        REJECT
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 4 digit PIN: ");
        String userPin = scanner.nextLine();
        scanner.close();

        String systemPin = "1234";

        if (userPin.length() != 4 || !userPin.matches("\\d{4}")) {
            System.out.println("Incorrect PIN format");
            return;
        }

        //Create character string for Turing Machine
        String input = "#" + userPin + "#" + systemPin + "#";
        char[] tape = input.toCharArray();

        int compareIndex = 0; 
        State state = State.START;

        System.out.println("Start Strip: " + new String(tape));

        while (true) {
            System.out.println("State: " + state + " | Strip: " + new String(tape));

            switch (state) {
                case START:
                    state = State.COMPARE;
                    break;

                //PINs comparison
                case COMPARE:
                    if (compareIndex < 4) {
                        char userChar = tape[1 + compareIndex];
                        char systemChar = tape[6 + compareIndex];
                        //Marking characters and comparison
                        if (userChar == systemChar) {       
                            tape[1 + compareIndex] = 'Y';
                            tape[6 + compareIndex] = 'Y';
                            compareIndex++;
                        } else if (userChar != systemChar) {
                            tape[1 + compareIndex] = 'X';
                            tape[6 + compareIndex] = 'X';
                            compareIndex++;
                        }
                    } else {
                        state = State.CHECK_END;
                    }
                    break;
                //Checking characters for marked successfully
                case CHECK_END:
                    boolean allMatched = true;
                    for (char c : tape) {
                        if (Character.isDigit(c)) {
                            allMatched = false;
                            break;
                        }
                    }
                    state = allMatched ? State.ACCEPT : State.REJECT;
                    break;
                //İf all comparison correct switches to state accept else switches to state reject 
                case ACCEPT:
                    System.out.println("Final State of the Strip: " + new String(tape));
                    System.out.println("Correct Password. Entry Successful.");
                    return;

                case REJECT:
                    System.out.println("Final State of the Strip: " + new String(tape));
                    System.out.println("Wrong Password. Entry denied.");
                    return;
            }
        }
    }
}
