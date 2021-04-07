public class VideoSystem implements VideoFactory{

    public enum VideoType{
        VHS(1),
        CD(2),
        DVD(3);
        VideoType(int i) {
        }
    }

    @Override
    public Video createVideo(String title, int videoType, int priceCode) {

        if(videoType == VideoType.VHS.ordinal())
            return new VHS(title, Video.convertVideoCode(priceCode));
        else if(videoType == VideoType.CD.ordinal())
            return new CD(title, Video.convertVideoCode(priceCode));
        else if(videoType == VideoType.DVD.ordinal())
            return new DVD(title, Video.convertVideoCode(priceCode));

        return null;
    }
}
