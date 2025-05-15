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

     public String getNama() {
        return nama;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getSkill() {
        return skill.getNamaSkill().toLowerCase();
    }

    public void tambahHP(int jumlah) {
        persona.tambahHp(jumlah);
    }

    public void tambahSP(int jumlah) {
        persona.tambahSp(jumlah);

        totalHadiahSP += jumlah;
    }

    public int getTotalHadiahSP() {
        return totalHadiahSP;
    }

    public void tambahRiwayatHadiah(Hadiah hadiah) {
        riwayatHadiah.add(hadiah);
    }

    public void tampilkanRiwayatHadiah() {
        if (riwayatHadiah.isEmpty()) {
            System.out.println("Belum ada hadiah yang Anda dapatkan.");
            return;
        }
        
        int count = 1;
        for (Hadiah hadiah : riwayatHadiah) {
            System.out.println(count++ + ". " + hadiah.getNamaHadiah());
        }
    }

        public void tampilkanProfil() {
        System.out.println("=== PROFIL PENGGUNA ===");
        System.out.println("Nama User: " + nama);
        System.out.println(persona.toString());
        System.out.println("Total SP dari Hadiah: " + totalHadiahSP);
        System.out.println("======================");
        
        System.out.println("\nRiwayat Hadiah:");
        tampilkanRiwayatHadiah();
    }
}

