package user.hadiah;

import user.User;

public class HadiahHP extends Hadiah {
    private int tambahanHP = 10; 
    public HadiahHP() {
        super("Hadiah HP (10)");
    }
    
    public HadiahHP(int jumlahHP) {
        super("Hadiah HP (" + jumlahHP + ")");
        this.tambahanHP = jumlahHP;
    }
    
    @Override
    public void berikanHadiah(User user) {
        user.tambahHP(tambahanHP);
        System.out.println("Selamat! Anda mendapatkan tambahan HP sebanyak " + tambahanHP);
        user.tambahRiwayatHadiah(this);
    }
    
    public int getTambahanHP() {
        return tambahanHP;
    }
}