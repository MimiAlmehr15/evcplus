import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> transactions = new ArrayList<>();
    static int balance = 100;
    static int bankBalance = 10000;
    static final String correctShort = "*770#";
    static final int correctPin = 2244;
    static final int bankPin = 142187;

    public static void main(String[] args) {
        System.out.println(" EVC Plus Program ");
        showKeypad();

        if (!verifyShortcut()) return;
        if (!verifyPin()) return;

        while (true) {
            int option = showMainMenu();
            processOption(option);

            System.out.println("\nmadoonaysaa in aad ulaabato qeebi hore ? (1 = haa / 0 = maya): ");
            int again = input.nextInt();
            if (again != 1) break;
        }

        input.close();
        System.out.println("Mahadsanid!");
    }

    static void showKeypad() {
        System.out.println("1\t2\t3");
        System.out.println("4\t5\t6");
        System.out.println("7\t8\t9");
        System.out.println("0\t*\t#");
    }

    static boolean verifyShortcut() {
        System.out.print("Enter shortcut: ");
        String enteredShort = input.nextLine();
        if (!enteredShort.equals(correctShort)) {
            System.out.println("Shortcut qaldan ayaa soo gelisay");
            return false;
        }
        return true;
    }

    static boolean verifyPin() {
        System.out.print("Enter your pin: ");
        int enteredPin = input.nextInt();
        if (enteredPin != correctPin) {
            System.out.println("Pinka aad gelisay waa qalad");
            return false;
        }
        return true;
    }

    static int showMainMenu() {
        System.out.println("\nEvcplus Menu");
        System.out.println("1. Itusi haraagaaga");
        System.out.println("2. Kaarka hadalka");
        System.out.println("3. Bixi biil");
        System.out.println("4. U wareeji");
        System.out.println("5. Warbixin kooban");
        System.out.println("6. Salaam Bank");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

    static void processOption(int option) {
        switch (option) {
            case 1: // Haraaga Evcplus
                System.out.println("[-Evcplus-] Haraagaagu waa: $" + balance);
                break;
            case 2:
                kaarkaHadalka();
                break;
            case 3:
                bixiBiil();
                break;
            case 4:
                wareejiLacag();
                break;
            case 5:
                warbixinKooban();
                break;
            case 6:
                salaamBank();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    static void kaarkaHadalka() {
        System.out.println("1. Kushubo airtime");
        System.out.println("2. Ugu shub airtime");
        int subOption = input.nextInt();
        if (subOption == 1) {
            System.out.print("Fadlan geli lacagta: ");
            int amount = input.nextInt();
            System.out.print("1. Haa\n2. Maya\nDooro: ");
            int confirm = input.nextInt();
            if (confirm == 1 && amount <= balance) {
                balance -= amount;
                transactions.add("Kushubasho - $" + amount);
                System.out.println("Waxaad $" + amount + " ku shubtay numberkaaga. Haraagaagu waa $" + balance);
            } else {
                System.out.println("malagu guulaysan mahadsanid.");
            }
        } else if (subOption == 2) {
            input.nextLine();
            System.out.print("Geli number-ka: ");
            String mobile = input.nextLine();
            System.out.print("Geli lacagta: ");
            int amount = input.nextInt();
            System.out.print("1. Haa\n2. Maya\nDooro: ");
            int confirm = input.nextInt();
            if (confirm == 1 && amount <= balance) {
                balance -= amount;
                transactions.add("Ugu shubid - $" + amount + " to " + mobile);
                System.out.println("Waxaad $" + amount + " ugu shubtay " + mobile + ". Haraagaagu waa $" + balance);
            } else {
                System.out.println("malagu guulaysan mahadsanid .");
            }
        }
    }

    static void bixiBiil() {
        System.out.println("1. Bixi post paid");
        System.out.println("2. Ku iibso");
        int billChoice = input.nextInt();
        if (billChoice == 1) {
            System.out.println("Fadlan geli lacagta: ");
            int bill = input.nextInt();
            if (bill <= balance) {
                balance -= bill;
                transactions.add("Bixinta Biil - $" + bill);
                System.out.println("Bill-kii waad bixisay. Lacagtaada hadhay waa $" + balance);
            } else {
                System.out.println("Haraagaaga kuguma filna.");
            }
        } else {
            System.out.println("khalad ayaa dhacay fadlan iskuday mar kale.");
        }
    }

    static void wareejiLacag() {
        input.nextLine();
        System.out.print("Geli numberka aad u wareejinayso: ");
        String transferNumber = input.nextLine();
        System.out.print("Geli lacagta: ");
        int amount = input.nextInt();
        if (amount <= balance) {
            balance -= amount;
            transactions.add("U wareejin - $" + amount + " to " + transferNumber);
            System.out.println("Waxaad $" + amount + " u wareejisay " + transferNumber + ". Haraagaagu waa $" + balance);
        } else {
            System.out.println("Haraagaagu kuguma filna.");
        }
    }

    static void warbixinKooban() {
        System.out.println("1. Last transaction");
        System.out.println("2. Last 3 transactions");
        System.out.println("3. Email me my activity");
        int warbixin = input.nextInt();
        if (warbixin == 1) {
            if (transactions.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                System.out.println(transactions.get(transactions.size() - 1));
            }
        } else if (warbixin == 2) {
            if (transactions.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                int start = Math.max(0, transactions.size() - 3);
                for (int i = start; i < transactions.size(); i++) {
                    System.out.println(transactions.get(i));
                }
            }
        } else if (warbixin == 3) {
            input.nextLine();
            System.out.print("Enter your email: ");
            String email = input.nextLine();
            System.out.println("Transaction history sent to " + email);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    static void salaamBank() {
        System.out.println("Salaam Bank");
        System.out.println("1. Itusi haraagaaga bankiga");
        System.out.println("2. Lacag dhigasho");
        System.out.println("3. Lacag qaadasho");
        int bankChoice = input.nextInt();

        if (bankChoice == 1) {
            System.out.println("Haraagaaga bankiga waa $" + bankBalance);
        } else if (bankChoice == 2) {
            System.out.print("Geli lacagta: ");
            int deposit = input.nextInt();
            System.out.print("Geli PIN-ka bankiga: ");
            int enteredBankPin = input.nextInt();
            if (enteredBankPin == bankPin) {
                bankBalance += deposit;
                transactions.add("Bank Deposit - $" + deposit);
                System.out.println("Waxaad dhigatay $" + deposit + ". Haraagaaga bankiga waa $" + bankBalance);
            } else {
                System.out.println("Pinka bankiga waa khalad.");
            }
        } else if (bankChoice == 3) {
            System.out.print("Geli lacagta: ");
            int withdraw = input.nextInt();
            System.out.print("Geli PIN-ka bankiga: ");
            int enteredBankPin = input.nextInt();
            if (enteredBankPin == bankPin && withdraw <= bankBalance) {
                bankBalance -= withdraw;
                balance += withdraw;
                transactions.add("Bank Withdrawal - $" + withdraw);
                System.out.println("Waxaad ka qaaday bankiga $" + withdraw + ". Haraagaaga waa $" + bankBalance);
            } else {
                System.out.println("Lacagta ma jirto ama PIN waa khalad.");
            }
        }
    }
}