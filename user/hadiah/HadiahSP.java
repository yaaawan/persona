package user.hadiah;

import user.User;

public class HadiahSP extends Hadiah {
    private int tambahanSP = 5;
    public HadiahSP() {
        super("Hadiah SP (5)");
    }
    
    public HadiahSP(int jumlahSP) {
        super("Hadiah SP (" + jumlahSP + ")");
        this.tambahanSP = jumlahSP;
    }

     @Override
    public void berikanHadiah(User user) {
        user.tambahSP(tambahanSP);
        System.out.println("Selamat! Anda mendapatkan tambahan SP sebanyak " + tambahanSP);
        user.tambahRiwayatHadiah(this);
    }
    
    public int getTambahanSP() {
        return tambahanSP;
    }
}

