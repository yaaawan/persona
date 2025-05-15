package user.skill;

public class SkillFactory {
    public static Skill getSkill(String skillInput) {
        switch (skillInput.toLowerCase()) {
            case "api":
                return new Api();
            case "air":
                return new Air();
