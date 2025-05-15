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
