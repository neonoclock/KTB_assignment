package app;

public abstract class Indoor extends Activity {
    public Indoor(String name) { super(name); }

    @Override
    public String tip() {
        return "환기와 수분 섭취를 잊지 마세요 🪟💧";
    }
}