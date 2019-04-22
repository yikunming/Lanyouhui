package EntityClass;

import java.util.Date;

public class UserInfo {

    /**
     * id
     */
    private int id;

    /**
     * 登录表id
     */
    private int login_id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 用户头像
     */
    private String img;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户简介
     */
    private String introduction;

    /**
     * 用户生日
     */
    private Date birthday;

    /**
     * 用户地区
     */
    private String area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", login_id=" + login_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", img='" + img + '\'' +
                ", gender='" + gender + '\'' +
                ", introduction='" + introduction + '\'' +
                ", birthday=" + birthday +
                ", area='" + area + '\'' +
                '}';
    }
}
