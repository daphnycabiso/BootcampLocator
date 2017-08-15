package cabiso.daphny.com.bootcamplocator;

import java.util.ArrayList;

/**
 * Created by Lenovo on 8/13/2017.
 */

public class DataService {

    private static final DataService INSTANCE = new DataService();

    public static DataService getInstance() {
        return INSTANCE;
    }

    public DataService() {
    }

    public ArrayList<Devslopes> getNearBootCampLocations(int zipcode){
        ArrayList<Devslopes> bootCamps =new ArrayList<>();
        bootCamps.add(new Devslopes( 10.3217381f , 123.8998818f, "Valentino Private Pool", "Cebu City, Central Visayas", "img"));
        bootCamps.add(new Devslopes( 10.3196824f,123.8998121f, "Sala Piano Museum", "Gorordo Avenue, Cebu City", "img"));
        bootCamps.add(new Devslopes( 10.3208975f,123.9000612f, "La Buona Italian Restaurant", "Acacia Street, Cebu City", "img"));
        return bootCamps;
    }


}
