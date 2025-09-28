package app;

import java.util.List;

public class SelfCare extends Indoor {
    public SelfCare(String name) { super(name); }

    @Override
    public int estimateDurationMinutes() {
        String n = getName();
        if (n.contains("운동")) return 40;
        if (n.contains("방청소")) return 25;
        if (n.contains("일기")) return 15;
        return 20;
    }

    @Override
    public List<String> checklist() {
        String n = getName();
        if (n.contains("운동")) return List.of("운동복/매트", "물", "타이머앱");
        if (n.contains("방청소")) return List.of("쓰레기봉투", "행주/청소기", "정리용 박스");
        return List.of("펜/노트", "편한 자리", "따뜻한 차");
    }

    @Override
    public void start() {
        System.out.println("▶ " + getName() + " 시작! 나를 위한 시간, 천천히 해요 🕊️");
    }

    @Override
    public String tip() {
        return "15~30분 타이머로 짧게 시작하면 꾸준해져요 ⏱️";
    }
}

