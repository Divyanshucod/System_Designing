package BuilderDesignPattern;

public class Cars{
    public String engineType;
    public String color;
    public String type;
    public float rating;
    public boolean airBags;
    public float wheelSize;

    public Cars(CarBuilder builder){
        this.type = builder.type;
        this.color = builder.color;
        this.wheelSize = builder.wheelSize;
        this.airBags = builder.airBags;
        this.rating = builder.rating;
        this.engineType = builder.engineType;
    }
    public String toString(){
        return " EngineType: "+this.engineType+
                " Color:"+this.color+
                " Type:"+this.type+
                " Rating:"+this.rating+
                " Air-Bags:"+this.airBags+
                " WheelSize:"+this.wheelSize;
    }
}
