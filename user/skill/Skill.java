package user.skill;

public abstract class Skill implements UsableSkill {
    protected String namaSkill;

    public Skill(String namaSkill) {
        this.namaSkill = namaSkill;
    }

    public String getNamaSkill() {
        return namaSkill;
    }
}
