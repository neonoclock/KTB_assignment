package app;

import java.util.List;

public class Play extends Outdoor {
    public Play(String name) { super(name); }

    @Override
    public int estimateDurationMinutes() {
        String n = getName();
        if (n.contains("영화")) return 120;
        if (n.contains("공연")) return 90;
        return 60;
    }

    @Override
    public List<String> checklist() {
        return List.of("교통카드/차키", "예매 확인(티켓/QR)", "가벼운 겉옷", "물");
    }

    @Override
    public void start() {
        System.out.println("▶ 즐거운 " + getName() + " 출발! 티켓/시간 확인 ✅");
    }

    @Override
    public String tip() {
        return "인기 전시는 분산 방문, 공연/영화는 좌석 미리 체크! 🎟️";
    }
}