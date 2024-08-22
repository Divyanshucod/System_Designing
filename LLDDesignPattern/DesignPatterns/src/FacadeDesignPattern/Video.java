package FacadeDesignPattern;


public class Video {
    String filename;
    String filepath;
    double filesize;
    String fileformate;
    String framerate;
    // more file informations

    public Video(String filename,String filepath,String fileformate,String framerate,double filesize){
        this.fileformate = fileformate;
        this.filename = filename;
        this.filepath = filepath;
        this.filesize = filesize;
        this.framerate = framerate;
    }
    public String getFilename(){
        return this.filename;
    }
    public String getFilepath(){
        return this.filepath;
    }
    public String getFileformate(){
        return this.fileformate;
    }
    public String getFileframeRate(){
        return this.framerate;
    } public double getFilesize(){
        return this.filesize;
    }
}
