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

    private static String promptSkillInput() {

        System.out.println("--------------------------------------------");
        System.out.println("Pilih skill: ");
        System.out.println("--------------------------------------------");
        System.out.println("1. " + ANSI_RED + "Api" + ANSI_RESET);
        System.out.println("2. " + ANSI_BLUE + "Air" + ANSI_RESET);
        System.out.println("3. " + ANSI_GREEN + "Tanah" + ANSI_RESET);
        System.out.print("Pilihan: ");

        String input = scanner.nextLine().trim();
        String skillInput;

        try {
            int pilihan = Integer.parseInt(input);
            switch (pilihan) {
                case 1:
                    skillInput = SKILL_API;
                    break;
                case 2:
                    skillInput = SKILL_AIR;
                    break;
                case 3:
                    skillInput = SKILL_TANAH;
                    break;
                default:
                    System.out.println(ANSI_RED + "Pilihan tidak valid. Default ke skill Api." + ANSI_RESET);
                    skillInput = SKILL_API;
                    break;
            }
        } catch (NumberFormatException e) {
            skillInput = input.toLowerCase();
            if (!skillInput.equals(SKILL_API) && !skillInput.equals(SKILL_AIR) && !skillInput.equals(SKILL_TANAH)) {
                System.out.println(ANSI_RED + "Skill tidak valid. Default ke skill Api." + ANSI_RESET);
                skillInput = SKILL_API;
            }
        }

        System.out.print("Skill dipilih: ");
        if (skillInput.equals(SKILL_API)) {
            System.out.println(ANSI_RED + "API" + ANSI_RESET);
        } else if (skillInput.equals(SKILL_AIR)) {
            System.out.println(ANSI_BLUE + "AIR" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "TANAH" + ANSI_RESET);
        }

        return skillInput;
    }

    private static void printUserInfo(User user) {
        System.out.printf(FORMAT_INFO + "\n", "Nama User", ANSI_YELLOW + user.getNama() + ANSI_RESET);
        System.out.printf(FORMAT_INFO + "\n", "Nama Persona", ANSI_YELLOW + user.getPersona().getNama() + ANSI_RESET);

        String skill = user.getSkill();
        String skillColored;
        if (skill.equals(SKILL_API))
            skillColored = ANSI_RED + skill.toUpperCase() + ANSI_RESET;
        else if (skill.equals(SKILL_AIR))
            skillColored = ANSI_BLUE + skill.toUpperCase() + ANSI_RESET;
        else
            skillColored = ANSI_GREEN + skill.toUpperCase() + ANSI_RESET;

        System.out.printf(FORMAT_INFO + "\n", "Skill", skillColored);
        System.out.printf(FORMAT_INFO + "\n", "HP (Nyawa)", String.valueOf(user.getPersona().getHp()));
        System.out.printf(FORMAT_INFO + "\n", "SP (Kekuatan Persona)", String.valueOf(user.getPersona().getSp()));
    }

    private static void gameLoop(User user) {
        boolean exit = false;
        while (!exit) {
            if (user.getPersona().getHp() <= 0) {
                System.out.println(ANSI_RED + ANSI_BOLD + "\nHP Anda telah habis! GAME OVER!" + ANSI_RESET);
                return;
            }

            System.out.println(HORIZONTAL_LINE);
            System.out.println("Pilih aksi:");
            System.out.println("1. Bertarung");
            System.out.println("2. Lihat Profil");
            System.out.println("3. Lihat Riwayat Hadiah");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            String aksi = scanner.nextLine().trim();

            switch (aksi) {
                case "1":
                    bertarung(user);
                    break;
                case "2":
                    tampilkanProfil(user);
                    break;
                case "3":
                    tampilkanRiwayat(user);
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println(ANSI_RED + "Pilihan tidak valid, silakan coba lagi.\n" + ANSI_RESET);
            }
        }
    }

    private static void tampilkanProfil(User user) {
        System.out.println("\n" + WAVE_LINE);
        System.out.println(ANSI_PURPLE + ANSI_BOLD + "                PROFIL USER                " + ANSI_RESET);
        System.out.println(WAVE_LINE);
        printUserInfo(user);
        System.out.println(WAVE_LINE + "\n");
    }

    private static void bertarung(User user) {
        System.out.println("\n" + WAVE_LINE);
        System.out.println(ANSI_BOLD + "Pertarungan dimulai..." + ANSI_RESET);

        Dungeon dungeon = new Dungeon(user);
        dungeon.mulaiDungeon();

        user = dungeon.getUser();

        System.out.println("\nSetelah pertarungan, profil Anda:");
        printUserInfo(user);
        System.out.println(WAVE_LINE + "\n");
    }

    private static void tampilkanRiwayat(User user) {
        System.out.println("\n" + DOTTED_LINE);
        System.out.println(ANSI_CYAN + "Riwayat Hadiah yang sudah Anda dapatkan:" + ANSI_RESET);
        user.tampilkanRiwayatHadiah();
        System.out.println(DOTTED_LINE + "\n");
    }

    private static void printErrorMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
}


