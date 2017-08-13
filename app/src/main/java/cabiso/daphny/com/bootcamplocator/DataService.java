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
        bootCamps.add(new Devslopes( 10.3048171f , 123.9473218f, "Tojong Inc. Maternity and General Hospital", "Lapu-Lapu City", "img"));
        bootCamps.add(new Devslopes( 10.309251f,123.948099f, "Lapu-Lapu City Central School", "Lapu-Lapu City", "img"));
        bootCamps.add(new Devslopes( 10.309774f,123.948707f, "OPON Kindergarten and Nursery School", "Lapu-Lapu City", "img"));
        return bootCamps;
    }
}
