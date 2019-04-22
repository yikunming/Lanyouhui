package EntityClass;

import java.util.Date;

/**
 * Comment
 * 用户评论实体类
 * @author wangxian
 * @date 2019/4/14
 */
public class Comment {

    /**
     * 评论表id
     */
    private int id;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 新闻或视频id
     */
    private int newsId;

    /**
     * 评论内容
     */
    private String replyMsg;

    /**
     * 评论时间
     */
    private Date createDate;

    /**
     * 点赞人数
     */
    private int like;


}
