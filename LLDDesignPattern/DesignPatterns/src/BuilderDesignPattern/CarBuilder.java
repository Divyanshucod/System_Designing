package BuilderDesignPattern;

public abstract class CarBuilder{
    public String engineType;
    public String color;
    public String type;
    public float rating;
    public boolean airBags;
    public float wheelSize;

    public CarBuilder BuildEngine(String engine) {
        this.engineType = (engine);
        return this;
    }


    public CarBuilder BuildAirBags(boolean airbags) {
        this.airBags = airbags;
        return this;
    }


    public CarBuilder BuildColors(String color) {
        this.color = color;
        return this;
    }


    public CarBuilder BuildType(String type) {
        this.type = type;
        return this;
    }


    public CarBuilder BuildRating(float rating) {
        this.rating =rating;
        return this;
    }


    public CarBuilder BuildWheel(float size) {
        this.wheelSize = size;
        return this;
    }

    public Cars build(){
        return new Cars(this);
    }
}

