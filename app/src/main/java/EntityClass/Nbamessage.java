package EntityClass;

import java.io.Serializable;

/**
 * Created by 易锟铭 on 2019/2/27.
 */

public class Nbamessage implements Serializable {

    private String message;
    private String root;
    private String commentimage;
    private int commentnumber;
    private String collectimage;
    private int collectnumber;
    private String unlike;
    private String fimage;

//    public Nbamessage {
//
//    }
    public Nbamessage(){
     this.message=message;
     this.root=root;
     this.commentimage=commentimage;
     this.commentnumber=commentnumber;
     this.collectimage=collectimage;
     this.collectnumber=collectnumber;
     this.unlike=unlike;
     this.fimage=fimage;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getCommentimage() {
        return commentimage;
    }

    public void setCommentimage(String commentimage) {
        this.commentimage = commentimage;
    }

    public int getCommentnumber() {
        return commentnumber;
    }

    public void setCommentnumber(int commentnumber) {
        this.commentnumber = commentnumber;
    }

    public String getCollectimage() {
        return collectimage;
    }

    public void setCollect(String collectimage) {
        this.collectimage = collectimage;
    }

    public int getCollectnumber() {
        return collectnumber;
    }

    public void setCollectnumber(int collectnumber) {
        this.collectnumber = collectnumber;
    }

    public String getUnlike() {
        return unlike;
    }

    public void setUnlike(String unlike) {
        this.unlike = unlike;
    }
    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }


}
