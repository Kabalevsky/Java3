package Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStart {

    public static void main(String[] args) {
        Map<CarModel, String> carMap = new HashMap<>();


        CarModel vaz = new CarModel("vaz");

        carMap.put(vaz, "very bad!");
        carMap.put(new CarModel("bmw"), "nice car!");
        carMap.put(new CarModel("zaporozhec"), "amazing driving experience! Wow!");

        Map<String, String> countyCity = new HashMap<>();
        countyCity.put("Russia", "Moscow");
        countyCity.put("Belarus", "Minsk");
        countyCity.put("Ukraine", "Kiev");

        System.out.println(countyCity);
    }
}
