package app;

public abstract class Outdoor extends Activity {
    public Outdoor(String name) { super(name); }

    @Override
    public String tip() {
        return "날씨, 미세먼지 확인하고 편한 신발 신어요 👟";
    }
}