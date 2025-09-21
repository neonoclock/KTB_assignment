package app;

import java.util.List;

public abstract class Activity {
    private final String name;

    public Activity(String name) { this.name = name; }
    public String getName() { return name; }

    public void recommend() {
        System.out.println(name + " 하는 것을 추천해요! 좋은 하루 보내세요!☀️");
    }

    public void start() {
        System.out.println("▶ " + name + " 시작!");
    }

    public abstract int estimateDurationMinutes();
    public abstract List<String> checklist();

    public String tip() {
        return "물 한 잔과 가벼운 스트레칭으로 시작해요 💧🙆";
    }

    public final void printDetails() {
        System.out.println("\n[준비물]");
        for (String item : checklist()) System.out.println("• " + item);

        System.out.println("\n[예상 소요]");
        System.out.println("• 약 " + estimateDurationMinutes() + "분");

        System.out.println("\n[팁]");
        System.out.println("• " + tip());
    }
}