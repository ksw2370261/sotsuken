package bean;

import java.io.InputStream;

public class MapImage {
    private String mapName;
    private InputStream imageData;

    public MapImage(String mapName, InputStream imageData) {
        this.mapName = mapName;
        this.imageData = imageData;
    }

    public String getMapName() {
        return mapName;
    }

    public InputStream getImageData() {
        return imageData;
    }
}
