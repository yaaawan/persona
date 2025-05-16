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

    public void kurangHp(int jumlah) {
        this.hp = Math.max(0, this.hp - jumlah);
    }

    public void kurangSp(int jumlah) {
        this.sp = Math.max(0, this.sp - jumlah);
    }

    @Override
    public String toString() {
        return String.format("Musuh: %s | Skill: %s | HP: %d | SP: %d",
            nama, skill.toUpperCase(), hp, sp);
    }
}