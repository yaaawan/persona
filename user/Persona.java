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

    public String getNama() {
        return nama;
    }

    public String getSkill() {
        return skill;
    }

    public int getHp() {
        return hp;
    }

    public int getSp() {
        return sp;
    }

    public void tambahHp(int jumlah) {
        this.hp += jumlah;
    }

    public void tambahSp(int jumlah) {
        this.sp += jumlah;
    }

    public void kurangHp(int jumlah) {
        this.hp = Math.max(0, this.hp - jumlah);
    }

    public void kurangSp(int jumlah) {
        this.sp = Math.max(0, this.sp - jumlah);
    }

    @Override
    public String toString() {
        return String.format("Persona: %s | Skill: %s | HP: %d | SP: %d",
            nama, skill.toUpperCase(), hp, sp);
    }
}