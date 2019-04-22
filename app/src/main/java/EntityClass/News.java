package EntityClass;

import java.util.Date;

/**
 * @author wangxian
 * @date 2019/4/20
 */
public class News {

    /**
     * 新闻id
     */
    private int id;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻图片
     */
    private String img;

    /**
     * 新闻图片2
     */
    private String imgTwo;

    /**
     * 新闻图片3
     */
    private String imgThree;

    /**
     * 新闻来源
     */
    private String source;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 新闻时间
     */
    private Date time;

    /**
     * 新闻类型 0:推荐 1:NBA 2:CBA
     */
    private int newsType;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgTwo() {
        return imgTwo;
    }

    public void setImgTwo(String imgTwo) {
        this.imgTwo = imgTwo;
    }

    public String getImgThree() {
        return imgThree;
    }

    public void setImgThree(String imgThree) {
        this.imgThree = imgThree;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", imgTwo='" + imgTwo + '\'' +
                ", imgThree='" + imgThree + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", newsType=" + newsType +
                '}';
    }
}
