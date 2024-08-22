package FacadeDesignPattern;

public class Decoders {
    public void decode(String fileformate){

        if(fileformate.equals("mkv")){
            DecodeMKV();
        }
        else if(fileformate.equals("mp4")){
            DecodeMP4();
        }
        else if(fileformate.equals("avi")){
            DecodeAVI();
        }
    }
    public void DecodeMKV(){
        System.out.println("Decoding mkv formated video");
    }
    public void DecodeAVI(){
        System.out.println("Decoding avi formated video");
    }
    public void DecodeMP4(){
        System.out.println("Decoding mp4 formated video");
    }
}
