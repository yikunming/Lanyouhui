package EntityClass;

import java.io.Serializable;

public class Nbamessages {


        private String message;/*******   标题   ***/
        private String root;   /*******   来源   ***/
        private String commentimage;/*******   评论的图片   ***/
        private int commentnumber;/*******   评论的条数   ***/
        private String collectimage;/*******   收藏的图片   ***/
        private int collectnumber;/*******   收藏的数字  ***/
        private String unlike;/*******   不喜欢   ***/
        private String show_1;/*******   图片   ***/
        private String show_2;/*******   图片   ***/
        private String show_3;/*******   图片   ***/

        //    public Nbamessage {
//
//    }
        public Nbamessages(){
            this.message=message;
            this.root=root;
            this.commentimage=commentimage;
            this.commentnumber=commentnumber;
            this.collectimage=collectimage;
            this.collectnumber=collectnumber;
            this.unlike=unlike;
            this.show_1=show_1;
            this.show_2=show_2;
            this.show_3=show_3;
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
        public String getShow_1() {
            return show_1;
        }

        public void setShow_1(String show_1) {
            this.show_1 = show_1;
        }
    public String getShow_2() {
        return show_2;
    }

    public void setShow_2(String show_2) {
        this.show_2 = show_2;
    }
    public String getShow_3() {
        return show_3;
    }

    public void setShow_3(String show_3) {
        this.show_3 = show_3;
    }


}
