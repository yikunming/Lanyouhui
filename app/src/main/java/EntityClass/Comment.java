package EntityClass;

import java.util.Date;

/**
 * Comment
 * 用户评论实体类
 * @author wangxian
 * @date 2019/4/14
 */
public class Comment {

    private int id;
    private int userId;
    private int newsId;
    private String replyMsg;
    private Date createDate;
    private int likes;
    private String img;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getReplyMsg() {
        return replyMsg;
    }

    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", newsId=" + newsId +
                ", replyMsg='" + replyMsg + '\'' +
                ", createDate=" + createDate +
                ", likes=" + likes +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
//    /**
//     * 评论表id
//     */
//    private int id;
//
//    /**
//     * 用户id
//     */
//    private int userId;
//
//    /**
//     * 用户昵称
//     */
//    private String userName;
//
//    /**
//     * 用户头像
//     */
//    private String userImg;
//
//    /**
//     * 新闻或视频id
//     */
//    private int newsId;
//
//    /**
//     * 评论内容
//     */
//    private String replyMsg;
//
//    /**
//     * 评论时间
//     */
//    private Date createDate;
//
//    /**
//     * 点赞人数
//     */
//    private int like;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    @Override
//    public String toString() {
//        return "Comment{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", userName='" + userName + '\'' +
//                ", userImg='" + userImg + '\'' +
//                ", newsId=" + newsId +
//                ", replyMsg='" + replyMsg + '\'' +
//                ", createDate=" + createDate +
//                ", like=" + like +
//                '}';
//    }
//
//    public String getUserImg() {
//        return userImg;
//    }
//
//    public void setUserImg(String userImg) {
//        this.userImg = userImg;
//    }
//
//    public int getNewsId() {
//        return newsId;
//    }
//
//    public void setNewsId(int newsId) {
//        this.newsId = newsId;
//    }
//
//    public String getReplyMsg() {
//        return replyMsg;
//    }
//
//    public void setReplyMsg(String replyMsg) {
//        this.replyMsg = replyMsg;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public int getLike() {
//        return like;
//    }
//
//    public void setLike(int like) {
//        this.like = like;
//    }
}
