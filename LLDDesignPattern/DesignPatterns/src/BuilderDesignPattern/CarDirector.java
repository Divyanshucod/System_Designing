package BuilderDesignPattern;

public class CarDirector {
    CarBuilder carBuilder;
    public CarDirector(CarBuilder build){
        this.carBuilder = build;
    }

    public Cars constructCar(){
        if(carBuilder instanceof NormalCarBuilder){
            return carBuilder.BuildAirBags(false).BuildEngine("200hp").BuildColors("White").BuildWheel(15).BuildRating(3).BuildType("SUVs").build();
        }
        else{
            return carBuilder.BuildAirBags(true).BuildEngine("V8").BuildColors("Black").BuildWheel(15).BuildRating(3).BuildType("Supra").build();
        }
    }
}