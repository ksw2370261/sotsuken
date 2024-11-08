package bean;

import java.sql.Timestamp;

public class Kuchikomi {
    private int kuchikomiCd;          // `kuchikomi_cd` に対応
    private String kuchikomiContent;  // `kuchikomi_content` に対応
    private Timestamp kuchikomiTime;  // `kuchikomi_time` に対応

    // Getter と Setter
    public int getKuchikomiCd() {
        return kuchikomiCd;
    }

    public void setKuchikomiCd(int kuchikomiCd) {
        this.kuchikomiCd = kuchikomiCd;
    }

    public String getKuchikomiContent() {
        return kuchikomiContent;
    }

    public void setKuchikomiContent(String kuchikomiContent) {
        this.kuchikomiContent = kuchikomiContent;
    }

    public Timestamp getKuchikomiTime() {
        return kuchikomiTime;
    }

    public void setKuchikomiTime(Timestamp kuchikomiTime) {
        this.kuchikomiTime = kuchikomiTime;
    }
}
