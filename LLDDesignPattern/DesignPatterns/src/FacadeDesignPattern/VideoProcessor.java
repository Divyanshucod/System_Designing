package FacadeDesignPattern;

public class VideoProcessor{
        Decoders decoders = null;
        int volume = 10;
        public void processVideo(Video video){
            decoders = new Decoders();
            System.out.println("Processing Video");
            decoders.decode(video.fileformate);
        }
        public void adjustBrightness(int val){
            this.volume = val;
            System.out.println("Brightness Changed to "+this.volume);
        }
        public void renderFrame(Video vide){
            System.out.println("rendering optimized frame for your screen: "+vide.framerate);
        }
        public void playVideo(){
            System.out.println("Playing video");
        }
       public void pauseVideo(){
        System.out.println("Pausing video");
       }
}
