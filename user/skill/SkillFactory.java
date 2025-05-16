package user.skill;

public class SkillFactory {
    public static Skill getSkill(String skillInput) {
        switch (skillInput.toLowerCase()) {
            case "api":
                return new Api();
            case "air":
                return new Air();
            case "tanah":
                return new Tanah();
            default:
                System.out.println("Skill tidak dikenali, default ke Api.");
                return new Api();
        }
    }
}