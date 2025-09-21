import java.util.Scanner;

class Activity {
    String name;
    Activity(String name) { this.name = name; }
    void recommend() {
        System.out.println(name + " 하는 것을 추천해요! 좋은 하루 보내세요!☀️");
    }
}

class Outdoor extends Activity {
    Outdoor(String name) { super(name); }
}
class Indoor extends Activity {
    Indoor(String name) { super(name); }
}

class Play extends Outdoor {
    Play(String name) { super(name); }
}
class Walk extends Outdoor {
    Walk(String name) { super(name); }
}
class Eat extends Outdoor {
    Eat(String name) { super(name); }
}
class SelfCare extends Indoor {
    SelfCare(String name) { super(name); }
}
class Watch extends Indoor {
    Watch(String name) { super(name); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Activity choice = null;

        System.out.println("오늘 무엇을 할지 고민이신가요?");
        System.out.println("제가 추천해드릴게요! 👍🏻");
        System.out.println("\n오늘은 어디에 있고 싶으신가요?");
        System.out.println("1. 외출 🏃🏻‍♀️");
        System.out.println("2. 집콕 🏠");
        System.out.print("번호를 입력해주세요 (1~2): ");
        int main = scanner.nextInt();

        if (main == 1) {
            System.out.println("\n밖에 나가서 기분 전환 좋죠! 나가서 무엇을 해볼까요?");
            System.out.println("1. 놀기 🛝");
            System.out.println("2. 산책 🚶🏻‍♀️");
            System.out.println("3. 먹기 🍽️");
            System.out.print("번호를 입력해주세요 (1~3): ");
            int out = scanner.nextInt();

            if (out == 1) {
                System.out.println("\n역시 나가면 놀아야죠! 무엇을 하며 놀까요?");
                System.out.println("1. 전시회 🖼️");
                System.out.println("2. 공연 🎸");
                System.out.println("3. 영화 🍿");
                System.out.print("번호를 입력해주세요 (1~3): ");
                int p = scanner.nextInt();
                if (p == 1) choice = new Play("전시회");
                else if (p == 2) choice = new Play("공연");
                else choice = new Play("영화");

            } else if (out == 2) {
                System.out.println("\n기분 전환에는 산책이 좋죠! 어디를 산책할까요?");
                System.out.println("1. 공원 🌳");
                System.out.println("2. 하천 🏝️");
                System.out.print("번호를 입력해주세요 (1~2): ");
                int w = scanner.nextInt();
                if (w == 1) choice = new Walk("공원 산책");
                else choice = new Walk("하천 산책");

            } else if (out == 3) {
                System.out.println("\n맛있는거 먹고 힘내봐요! 무엇을 드시고 싶으세요?");
                System.out.println("1. 밥 🍚");
                System.out.println("2. 카페 ☕️");
                int e = scanner.nextInt();
                if (e == 1) choice = new Eat("밥 먹기");
                else choice = new Eat("카페 가기");
            }

        } else if (main == 2) {
            System.out.println("\n역시 집이 최고죠! 집에서 무엇을 하고 싶으세요?");
            System.out.println("1. 셀프케어 🕊️");
            System.out.println("2. 영화/드라마 보기 📺");
            System.out.print("번호를 입력해주세요 (1~2): ");
            int home = scanner.nextInt();

            if (home == 1) {
                System.out.println("\n셀프케어를 하시고 싶으시군요! 무엇을 할까요?");
                System.out.println("1. 방청소 🧹");
                System.out.println("2. 운동 💪🏻");
                System.out.println("3. 일기쓰기 📝");
                System.out.print("번호를 입력해주세요 (1~3): ");
                int s = scanner.nextInt();
                if (s == 1) choice = new SelfCare("방청소");
                else if (s == 2) choice = new SelfCare("운동");
                else choice = new SelfCare("일기쓰기");

            } else if (home == 2) {
                choice = new Watch("영화 & 드라마 보기");
            }

        } else {
            System.out.println("잘못 입력했습니다.");
        }

        if (choice != null) {
            System.out.println();
            choice.recommend();
        }

        scanner.close();
    }
}