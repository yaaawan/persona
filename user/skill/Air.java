package user.skill;

public class Air extends Skill {
    public Air() {
        super("Air");
    }

    @Override
    public void gunakanSkill() {
        System.out.println("Menggunakan skill air!");
    }

    public void gunakanSkill(String target) {
        System.out.println("Menggunakan skill air untuk membasahi " + target + "!");
    }

    public void gunakanSkill(int volume) {
        System.out.println("Menggunakan skill air dengan volume " + volume + " liter!");
    }

    public void gunakanSkill(String target, int volume) {
        System.out.println("Menggunakan skill air dengan volume " + volume + " liter untuk membasahi " + target + "!");
    }
}
