package user;

import java.util.ArrayList;
import java.util.List;
import user.hadiah.Hadiah;
import user.skill.Skill;
import user.skill.SkillFactory;

public class User {
    private String nama;
    private Persona persona;
    private List<Hadiah> riwayatHadiah;
    private Skill skill;
    private int totalHadiahSP; 

    public User(String namaUser, String namaPersona, String skillInput) {
        this.nama = namaUser;
        this.persona = new Persona(namaPersona, skillInput);
        this.skill = SkillFactory.getSkill(skillInput);
        this.riwayatHadiah = new ArrayList<>();
        this.totalHadiahSP = 0; 
    }

