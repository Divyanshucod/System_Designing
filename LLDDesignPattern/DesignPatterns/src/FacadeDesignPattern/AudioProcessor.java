package FacadeDesignPattern;

public class AudioProcessor{
    int volume=0;
    public void processAudio(Video video){
        System.out.println("Processing Audio of video");
    }
    public void adjustingVolume(int val){

        if(this.volume < val){
            System.out.println("Increasing Volume");
        }
        else{
            System.out.println("decreasing Volume");
        }
        this.volume = val;
        System.out.println("Volume Changed to "+this.volume);
    }
    public void applyEqualizer(Video vide){
        System.out.println("Adding Equalizer to video");
    }
}
