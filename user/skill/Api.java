package user.skill;

public class Api extends Skill {
    public Api() {
        super("Api");
    }

    @Override
    public void gunakanSkill() {
        System.out.println("Menggunakan skill api!");
    }

    public void gunakanSkill(String target) {
        System.out.println("Menggunakan skill api untuk membakar " + target + "!");
    }

    public void gunakanSkill(int kekuatan) {
        System.out.println("Menggunakan skill api dengan kekuatan " + kekuatan + "!");
    }

    public void gunakanSkill(String target, int kekuatan) {
        System.out.println("Menggunakan skill api dengan kekuatan " + kekuatan + " untuk membakar " + target + "!");
    }
}
