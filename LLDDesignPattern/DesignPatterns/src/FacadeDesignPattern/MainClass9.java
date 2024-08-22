package FacadeDesignPattern;

public class MainClass9 {
    public static void main(String[] args){
        Video video = new Video("my-hero-academia","C:/users/movies/anime","mkv","24f",300);
        VideoPlayerFacade videoPlayerFacade = new VideoPlayerFacade(video);
        videoPlayerFacade.play();
        videoPlayerFacade.pause();
        videoPlayerFacade.changeVolume(40);
    }
}
