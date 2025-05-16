package user.skill;

public class Tanah extends Skill {
    public Tanah() {
        super("Tanah");
    }

    @Override
    public void gunakanSkill() {
        System.out.println("Menggunakan skill tanah!");
    }

    public void gunakanSkill(String target) {
        System.out.println("Menggunakan skill tanah untuk menimbun " + target + "!");
    }

    public void gunakanSkill(int massa) {
        System.out.println("Menggunakan skill tanah dengan massa " + massa + " kg!");
    }

    public void gunakanSkill(String target, int massa) {
        System.out.println("Menggunakan skill tanah dengan massa " + massa + " kg untuk menimbun " + target + "!");
    }
}