package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStart {

    public static void main(String[] args) {
        List<CarModel> carModelList = new ArrayList<>();

        CarModel m1 = new CarModel("1231");

        carModelList.add(new CarModel("123"));
        carModelList.add(new CarModel("1234"));
        carModelList.add(m1);
        carModelList.add(new CarModel("1233"));
        carModelList.add(new CarModel("1243"));

        System.out.println(carModelList.indexOf(m1));
        System.out.println(carModelList.contains(m1));
        System.out.println(carModelList.remove(m1));
        System.out.println(carModelList.contains(m1));


        Iterator<CarModel> iterator = carModelList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(carModelList.size());
    }
}