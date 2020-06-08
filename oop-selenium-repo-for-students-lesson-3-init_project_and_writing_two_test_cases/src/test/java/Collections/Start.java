package Collections;

public class Start {

    public static void main(String[] args) {
        CarModel carModel1 = new CarModel("vaz-2106");
        CarModel carModel2 = new CarModel("vaz-21026");
        CarModel carModel3 = null;
        CarModel carModel4 = null;

        System.out.println(carModel1.hashCode());
        System.out.println(carModel2.hashCode());
    }
}

class CarEngineType {
    private String type;

    public CarEngineType(String type) {
        this.type = type;
    }
}

class CarModel {
    private String model;
    private int year;

    public CarModel(String model) {
        this.model = model;
        year = 0;
    }

    public CarModel(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModel carModel = (CarModel) o;

        if (year != carModel.year) return false;
        return model != null ? model.equals(carModel.model) : carModel.model == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 14 * result + year + 3;
        return result;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
