package EntityClass;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by 易锟铭 on 2019/3/5. 评论实体类
 */

public class IndexComment implements Serializable {
    private String header;  //头像
    private String id;      //用户id
    private String time;   //发表时间
    private String commentcontent; //评论内容

    public IndexComment(){
        this.header=header;
        this.id=id;
        this.time=time;
        this.commentcontent=commentcontent;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }



}
