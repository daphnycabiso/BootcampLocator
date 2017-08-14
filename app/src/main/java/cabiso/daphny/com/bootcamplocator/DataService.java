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
        bootCamps.add(new Devslopes( 10.292315f , 123.864007f, "Siege Paintball Cebu", "Cebu City", "img"));
        bootCamps.add(new Devslopes( 10.2908704f,123.8614377f, "USJR Coliseum", "Cebu City", "img"));
        bootCamps.add(new Devslopes( 10.2898032f,123.8597002f, "Gear Up Cebu", "Cebu City", "img"));
        return bootCamps;
    }


}
