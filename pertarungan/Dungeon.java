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

        if (user.getPersona().getHp() <= 0) {
            System.out.println(ANSI_RED + "Anda kalah. Game over." + ANSI_RESET);
        } else {
            System.out.println(ANSI_YELLOW + ANSI_BOLD + "Selamat, Anda menang!" + ANSI_RESET);
            Hadiah hadiah = hadiahRandom();
            hadiah.berikanHadiah(user);
            System.out.println("Anda mendapatkan hadiah: " + hadiah);
            
    
            System.out.println("\nStatus setelah mendapatkan hadiah:");
            user.tampilkanProfil();
        }
        System.out.println(BATTLE_SEPARATOR); 
    }

    private void serang(Object attacker, Object defender) {
        int damage = 15;
        if (attacker instanceof User) {
            Musuh musuh = (Musuh) defender;
            musuh.kurangHp(damage);
            System.out.println("Anda menyerang " + musuh.getNama() + " dan memberikan " + damage + " damage.");
        } else if (attacker instanceof Musuh) {
            Persona persona = (Persona) defender;
            persona.kurangHp(damage);
            System.out.println("Musuh menyerang Anda dan memberikan " + damage + " damage.");
        }
    }

    private void gunakanSP(User user, Musuh musuh) {
        Persona p = user.getPersona();
        String skillName = user.getSkill();
        Skill skill = SkillFactory.getSkill(skillName);
        
        if (p.getSp() >= 10) {
            String target = musuh.getNama();
            int kekuatan = 5 + (int)(Math.random() * 10); 
            
            if (skillName.equals("api")) {
                Api apiSkill = (Api) skill;
                apiSkill.gunakanSkill(target, kekuatan);
            } else if (skillName.equals("air")) {
                Air airSkill = (Air) skill;
                airSkill.gunakanSkill(target, kekuatan);
            } else if (skillName.equals("tanah")) {
                Tanah tanahSkill = (Tanah) skill;
                tanahSkill.gunakanSkill(target, kekuatan);
            }
            
            int baseDamage = 30;
            int finalDamage = baseDamage;
            
            if (skillName.equals("api")) {
                finalDamage += 5; 
                System.out.println("Api membakar musuh dan memberikan damage tambahan!");
            } else if (skillName.equals("air")) {
                p.tambahHp(5); 
                System.out.println("Air menyegarkan dan memulihkan 5 HP!");
            } else if (skillName.equals("tanah")) {
                finalDamage -= 5;
                p.tambahSp(3);
                System.out.println("Tanah mengembalikan 3 SP kepada Anda!");
            }
            
            musuh.kurangHp(finalDamage);
            p.kurangSp(10);
        
            System.out.println("Anda menggunakan SP dan memberikan " + finalDamage + " damage ke musuh.");
        } else {
            System.out.println("SP tidak cukup untuk menyerang.");
        }
        
        System.out.println(ACTION_SEPARATOR); 
    }
