package BuilderDesignPattern;

public class MainClass8 {
    public static void main(String[] args){

        CarBuilder buildSportsCar = new SportsCarBuilder();
        CarBuilder buildNormalCar = new NormalCarBuilder();
        CarDirector director = new CarDirector(buildNormalCar);
        Cars car = director.constructCar();
        System.out.println(car.toString());
    }
}
