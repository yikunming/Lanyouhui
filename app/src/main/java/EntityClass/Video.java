package EntityClass;

public class Video {

    /**
     * 视频id
     */
    private int id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频地址
     */
    private String videoSrc;

    /**
     * 视频来源
     */
    private String source;

    /**
     * 点赞人数
     */
    private String likes;

    /**
     * 视频缩略图
     */
    private String videoImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoSrc() {
        return videoSrc;
    }

    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLike() {
        return likes;
    }

    public void setLike(String likes) {
        this.likes = likes;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", videoSrc='" + videoSrc + '\'' +
                ", source='" + source + '\'' +
                ", like='" + likes + '\'' +
                ", videoImg='" + videoImg + '\'' +
                '}';
    }
}
