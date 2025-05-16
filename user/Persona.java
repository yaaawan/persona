package user;

public class Persona {
    private String nama;
    private String skill;
    private int hp;
    private int sp;

    public Persona(String nama, String skill) {
        this.nama = nama;
        this.skill = skill.toLowerCase();
        this.hp = 100;
        this.sp = 50;
    }
