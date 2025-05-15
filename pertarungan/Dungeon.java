package pertarungan;

import java.util.Scanner;
import user.Persona;
import user.User;
import user.hadiah.Hadiah;
import user.hadiah.HadiahHP;
import user.hadiah.HadiahSP;
import user.skill.*;

public class Dungeon {
    private User user;
    private Musuh musuh;
    private Scanner scanner;
    
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BOLD = "\u001B[1m";
    
    private static final String BATTLE_SEPARATOR = "---------------------------------------------";
    private static final String TURN_SEPARATOR = "· · · · · · · · · · · · · · · · · · · · · · ·";
    private static final String ACTION_SEPARATOR = "- - - - - - - - - - - - - - - - - - - - - - -";

    public Dungeon(String namaUser, String namaPersona, String skill) {
        this.scanner = new Scanner(System.in);
        this.user = new User(namaUser, namaPersona, skill);
        this.musuh = new Musuh("Goblin", randomSkill());
    }
    
    public Dungeon(User user) {
        this.scanner = new Scanner(System.in);
        this.user = user;
        this.musuh = new Musuh("Goblin", randomSkill());
    }
    private String randomSkill() {
        String[] skills = {"api", "air", "tanah"};
        int idx = (int) (Math.random() * skills.length);
        return skills[idx];
    }

    public void mulaiDungeon() {
        System.out.println("Petualangan dimulai!");
        System.out.println(musuh);
        System.out.println(BATTLE_SEPARATOR);

        if (user.getPersona().getHp() <= 0) {
            System.out.println(ANSI_RED + "HP Anda telah habis! Tidak dapat memulai pertarungan." + ANSI_RESET);
            return; 
        }
        
        boolean userTurn = true;
        while (user.getPersona().getHp() > 0 && musuh.getHp() > 0) {
            if (userTurn) {
                System.out.println("\nGiliran Anda bertarung.");
                System.out.println("1. Serang");
                System.out.println("2. Gunakan SP");
                System.out.print("Pilih aksi: ");
                String aksi = scanner.nextLine();

                if ("1".equals(aksi)) {
                    serang(user, musuh);
                } else if ("2".equals(aksi)) {
                    gunakanSP(user, musuh);
                } else {
                    System.out.println("Aksi tidak dikenali, giliran hilang.");
                }
                System.out.println(TURN_SEPARATOR);
            } else {
                System.out.println("\nGiliran musuh menyerang...");
                serang(musuh, user.getPersona());
                System.out.println(TURN_SEPARATOR); 
                
                if (user.getPersona().getHp() <= 0) {
                    break;
                }
            }
            userTurn = !userTurn;
            tampilkanStatus();
        }