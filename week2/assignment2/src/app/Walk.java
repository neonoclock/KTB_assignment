package app;

import java.util.List;

public class Walk extends Outdoor {
    public Walk(String name) { super(name); }

    @Override
    public int estimateDurationMinutes() { return 30; }

    @Override
    public List<String> checklist() {
        return List.of("편한 신발", "이어폰", "물", "얇은 겉옷");
    }

    @Override
    public void start() {
        System.out.println("▶ " + getName() + " 시작! 보폭은 가볍게, 호흡은 편안하게 😌");
    }

    @Override
    public String tip() {
        return "밤에는 어두우니 밝을 때 걷고, 횡단보도 안전! 🌇";
    }
}
