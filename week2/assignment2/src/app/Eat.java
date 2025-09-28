package app;

import java.util.List;

public class Eat extends Outdoor {
    public Eat(String name) { super(name); }

    @Override
    public int estimateDurationMinutes() { return 60; }

    @Override
    public List<String> checklist() {
        return List.of("지갑/카드", "웨이팅 확인 앱", "알레르기 체크");
    }

    @Override
    public void start() {
        System.out.println("▶ " + getName() + " 시작! 맛있게 드세요 😋");
    }

    @Override
    public String tip() {
        return "피크 타임은 피하고, 인기 메뉴는 리뷰로 미리 확인해요 📱";
    }
}
