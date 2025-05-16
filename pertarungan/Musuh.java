package pertarungan;

public class Musuh {
    private String nama;
    private String skill;
    private int hp;
    private int sp;

    public Musuh(String nama, String skill) {
        this.nama = nama;
        this.skill = skill.toLowerCase();
        this.hp = 80;
        this.sp = 40;
    }