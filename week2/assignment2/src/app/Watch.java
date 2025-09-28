package app;

import java.util.List;

public class Watch extends Indoor {
    public Watch(String name) { super(name); }

    @Override
    public int estimateDurationMinutes() { return 120; }

    @Override
    public List<String> checklist() {
        return List.of("간식/물", "편한 담요", "OTT 로그인");
    }

    @Override
    public void start() {
        System.out.println("▶ " + getName() + " 시작! 알림은 잠시 꺼두고 몰입해봐요 🎬");
    }

    @Override
    public String tip() {
        return "조명은 은은하게, 시청 후 가벼운 스트레칭으로 마무리 🙆";
    }
}