package user.hadiah;

import user.User;

public abstract class Hadiah {
    protected String namaHadiah;

    public Hadiah(String namaHadiah) {
        this.namaHadiah = namaHadiah;
    }

    public abstract void berikanHadiah(User user);

    public String getNamaHadiah() {
        return namaHadiah;
    }
    
    @Override
    public String toString() {
        return namaHadiah;
    }
}
