package cabiso.daphny.com.bootcamplocator;

/**
 * Created by Lenovo on 8/13/2017.
 */

public class Devslopes {

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationImUrl() {
        return locationImUrl;
    }

    public void setLocationImUrl(String locationImUrl) {
        this.locationImUrl = locationImUrl;
    }

    private float longitude;
    private float latitude;
    private  String locationTitle;
    private  String locationAddress;
    private  String locationImUrl;

    public Devslopes(float latitude, float longitude, String locationTitle, String locationAddress, String locationImUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationTitle = locationTitle;
        this.locationAddress = locationAddress;
        this.locationImUrl = locationImUrl;
    }
}
