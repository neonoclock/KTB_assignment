package app;

import java.util.Scanner;

public class Main {

    private static final int MENU_OUTDOOR = 1;
    private static final int MENU_INDOOR  = 2;

    private static final int OUT_PLAY = 1;
    private static final int OUT_WALK = 2;
    private static final int OUT_EAT  = 3;

    private static final int HOME_SELFCARE = 1;
    private static final int HOME_WATCH    = 2;

    private static final int PLAY_EXHIBITION = 1;
    private static final int PLAY_CONCERT    = 2;
    private static final int PLAY_MOVIE      = 3;

    private static final int WALK_PARK   = 1;
    private static final int WALK_RIVER  = 2;

    private static final int EAT_MEAL = 1;
    private static final int EAT_CAFE = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("오늘 무엇을 할지 고민이신가요?");
            System.out.println("제가 추천해드릴게요! 👍🏻");
            System.out.println("\n오늘은 어디에 있고 싶으신가요?");
            System.out.println(MENU_OUTDOOR + ". 외출 🏃🏻‍♀️");
            System.out.println(MENU_INDOOR  + ". 집콕 🏠");

            int mainChoice = readInt(scanner, "번호를 입력해주세요 (1~2): ", 1, 2);

            Activity choice = switch (mainChoice) {
                case MENU_OUTDOOR -> handleOutdoor(scanner);
                case MENU_INDOOR  -> handleIndoor(scanner);
                default -> handleOutdoor(scanner);
            };

            if (choice != null) {
                System.out.println();
                choice.recommend();

                final Activity selected = choice;

                Thread countdown = new Thread(() -> {
                    System.out.println("\n5초 뒤에 시작합니다!");
                    for (int i = 5; i > 0; i--) {
                        System.out.println("[카운트다운] " + i + "...");
                        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                    }
                    System.out.println("준비 완료!");
                });

                countdown.start();
                try { countdown.join(); } catch (InterruptedException ignored) {}

                selected.printDetails();
                selected.start();
            }
        }
    }

    private static Activity handleOutdoor(Scanner sc) {
        System.out.println("\n밖에 나가서 기분 전환 좋죠! 나가서 무엇을 해볼까요?");
        System.out.println(OUT_PLAY + ". 놀기 🛝");
        System.out.println(OUT_WALK + ". 산책 🚶🏻‍♀️");
        System.out.println(OUT_EAT  + ". 먹기 🍽️");

        int out = readInt(sc, "번호를 입력해주세요 (1~3): ", 1, 3);

        return switch (out) {
            case OUT_PLAY -> handlePlay(sc);
            case OUT_WALK -> handleWalk(sc);
            case OUT_EAT  -> handleEat(sc);
            default -> handlePlay(sc);
        };
    }

    private static Activity handlePlay(Scanner sc) {
        System.out.println("\n역시 나가면 놀아야죠! 무엇을 하며 놀까요?");
        System.out.println(PLAY_EXHIBITION + ". 전시회 🖼️");
        System.out.println(PLAY_CONCERT    + ". 공연 🎸");
        System.out.println(PLAY_MOVIE      + ". 영화 🍿");

        int p = readInt(sc, "번호를 입력해주세요 (1~3): ", 1, 3);
        return switch (p) {
            case PLAY_EXHIBITION -> new Play("전시회 🖼️");
            case PLAY_CONCERT    -> new Play("공연 🎸");
            case PLAY_MOVIE      -> new Play("영화 🍿");
            default -> new Play("전시회 🖼️");
        };
    }

    private static Activity handleWalk(Scanner sc) {
        System.out.println("\n기분 전환에는 산책이 좋죠! 어디를 산책할까요?");
        System.out.println(WALK_PARK  + ". 공원 🌳");
        System.out.println(WALK_RIVER + ". 하천 🏝️");

        int w = readInt(sc, "번호를 입력해주세요 (1~2): ", 1, 2);
        return switch (w) {
            case WALK_PARK -> new Walk("공원 산책 🌳");
            case WALK_RIVER -> new Walk("하천 산책 🏝️");
            default -> new Walk("공원 산책 🌳");
        };
    }

    private static Activity handleEat(Scanner sc) {
        System.out.println("\n맛있는 거 먹고 힘내봐요! 무엇을 드시고 싶으세요?");
        System.out.println(EAT_MEAL + ". 밥 🍚");
        System.out.println(EAT_CAFE + ". 카페 ☕️");

        int e = readInt(sc, "번호를 입력해주세요 (1~2): ", 1, 2);
        return switch (e) {
            case EAT_MEAL -> new Eat("밥 먹기 🍚");
            case EAT_CAFE -> new Eat("카페 가기 ☕️");
            default -> new Eat("밥 먹기 🍚");
        };
    }

    private static Activity handleIndoor(Scanner sc) {
        System.out.println("\n역시 집이 최고죠! 집에서 무엇을 하고 싶으세요?");
        System.out.println(HOME_SELFCARE + ". 셀프케어 🕊️");
        System.out.println(HOME_WATCH    + ". 영화/드라마 보기 📺");

        int home = readInt(sc, "번호를 입력해주세요 (1~2): ", 1, 2);
        return switch (home) {
            case HOME_SELFCARE -> {
                System.out.println("\n셀프케어를 하시고 싶으시군요! 무엇을 할까요?");
                System.out.println("1. 방청소 🧹");
                System.out.println("2. 운동 💪🏻");
                System.out.println("3. 일기쓰기 📝");

                int s = readInt(sc, "번호를 입력해주세요 (1~3): ", 1, 3);
                yield switch (s) {
                    case 1 -> new SelfCare("방청소 🧹");
                    case 2 -> new SelfCare("운동 💪🏻");
                    case 3 -> new SelfCare("일기쓰기 📝");
                    default -> new SelfCare("방청소 🧹");
                };
            }
            case HOME_WATCH -> new Watch("영화 & 드라마 보기 📺");
            default -> new Watch("영화 & 드라마 보기 📺");
        };
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(input);
                if (v < min || v > max) {
                    System.out.printf("→ %d~%d 사이의 숫자만 입력해주세요.%n", min, max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("→ 숫자를 입력해주세요. (입력값: " + input + ")");
            }
        }
    }
}
