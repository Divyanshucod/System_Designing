package FacadeDesignPattern;

public class VideoPlayerFacade {
    Video video;
    AudioProcessor audioProcessor;
    VideoProcessor videoProcessor;
    public VideoPlayerFacade(Video video){
        this.video = video;
        this.videoProcessor = new VideoProcessor();
        this.audioProcessor = new AudioProcessor();
        initialization();
    }
    void initialization(){
        videoProcessor.processVideo(video);
        videoProcessor.adjustBrightness(10);
        videoProcessor.renderFrame(video);
        audioProcessor.processAudio(video);
        audioProcessor.adjustingVolume(10);
        audioProcessor.applyEqualizer(video);
    }
    public void play(){
        videoProcessor.playVideo();
    }
    public void pause(){
        videoProcessor.pauseVideo();
    }
    public void changeVolume(int val){
        audioProcessor.adjustingVolume(val);
    }
}
