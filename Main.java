import java.util.Scanner;
import pertarungan.Dungeon;
import user.User;

public class Main {
    private static final String HORIZONTAL_LINE = "==================================================================";
    private static final String DOUBLE_LINE = "======================================================================";
    private static final String DOTTED_LINE = "----------------------------------------------------------------------";
    private static final String WAVE_LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_BOLD = "\u001B[1m";

    private static final String SKILL_API = "api";
    private static final String SKILL_AIR = "air";
    private static final String SKILL_TANAH = "tanah";

    private static final String FORMAT_PROMPT = "%-30s : ";
    private static final String FORMAT_INFO = "%-20s : %s";

    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) {
        try {
            printUserGuide();

            if (!promptPlayGame()) {
                System.out.println(ANSI_CYAN + "\nTerima kasih sudah mampir. Sampai jumpa!" + ANSI_RESET);
                return;
            }

            User user = createUserProfile();

            System.out.println(ANSI_GREEN + ANSI_BOLD + "\n>> PERMAINAN DIMULAI <<" + ANSI_RESET + "\n");

            gameLoop(user);

            System.out.println(ANSI_YELLOW + "\nTerima kasih sudah bermain!" + ANSI_RESET);

        } catch (Exception e) {
            printErrorMessage("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void printUserGuide() {
        System.out.println(DOUBLE_LINE);
        System.out.println(
                ANSI_YELLOW + ANSI_BOLD + "                SELAMAT DATANG DI GAME PERSONA             " + ANSI_RESET);
        System.out.println(DOUBLE_LINE);
        System.out.println("Game ini memungkinkan Anda untuk bertarung dan mendapatkan hadiah.");
        System.out.println("Anda bisa memilih untuk bertarung, melihat riwayat hadiah, melihat profil, atau keluar.");
        System.out.println("Setiap bertarung, Anda bisa mendapatkan hadiah berupa tambahan HP atau SP.");
        System.out.println("Semoga berhasil dan selamat bermain!");
        System.out.println(DOTTED_LINE + "\n");
    }

    private static boolean promptPlayGame() {
        System.out.print("Apakah Anda ingin bermain? (y/n): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("y");
    }

    private static User createUserProfile() {
        System.out.println(WAVE_LINE);
        System.out.println(ANSI_PURPLE + ANSI_BOLD + "                REGISTRASI USER                " + ANSI_RESET);
        System.out.println(WAVE_LINE);

        System.out.printf(ANSI_CYAN + FORMAT_PROMPT + ANSI_RESET, "Masukkan nama user");
        String namaUser = scanner.nextLine().trim();

        System.out.printf(ANSI_CYAN + FORMAT_PROMPT + ANSI_RESET, "Masukkan nama persona");
        String namaPersona = scanner.nextLine().trim();

        String skillInput = promptSkillInput();

        User user = new User(namaUser, namaPersona, skillInput);

        System.out.println(DOTTED_LINE);
        System.out.println(ANSI_CYAN + "PROFIL USER:" + ANSI_RESET);
        System.out.println(DOTTED_LINE);
        printUserInfo(user);
        System.out.println(DOTTED_LINE + "\n");

        return user;
    }
