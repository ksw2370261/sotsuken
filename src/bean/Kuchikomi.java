package bean;
import java.sql.Timestamp;

public class Kuchikomi {
    private String kuchikomi_id;
    private String kuchikomi_content;
    private Timestamp kuchikomi_time; // 修正点

    public String getKuchikomi_id() {
        return kuchikomi_id;
    }

    public void setKuchikomi_id(String kuchikomi_id) {
        this.kuchikomi_id = kuchikomi_id;
    }

    public String getKuchikomi_content() {
        return kuchikomi_content;
    }

    public void setKuchikomi_content(String kuchikomi_content) {
        this.kuchikomi_content = kuchikomi_content;
    }

    public Timestamp getKuchikomi_time() {
        return kuchikomi_time;
    }

    public void setKuchikomi_time(Timestamp kuchikomi_time) {
        this.kuchikomi_time = kuchikomi_time;
    }
}
