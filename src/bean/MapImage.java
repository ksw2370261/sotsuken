package bean;

import java.io.InputStream;

public class MapImage {
    private int imageId; // imageIdフィールド
    private String mapName;
    private InputStream imageData;

    public MapImage(String mapName, InputStream imageData) {
        this.mapName = mapName;
        this.imageData = imageData;
    }

    // imageIdのgetterとsetter
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMapName() {
        return mapName;
    }

    public InputStream getImageData() {
        return imageData;
    }
}
