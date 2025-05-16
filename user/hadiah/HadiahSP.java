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
