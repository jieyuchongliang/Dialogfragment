package greendaotest.wq.com.demo.bean;

/**
 * Created by 860617010 on 2018/6/22.
 */

public class Animal {
    private int type;
    private String name;
    private String belong;//所属集合
    private boolean showOrNot;//是否显示的标记

    public Animal(int type, String name, String belong, boolean showOrNot) {
        this.type = type;
        this.name = name;
        this.belong = belong;
        this.showOrNot = showOrNot;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getShowOrNot() {
        return showOrNot;
    }

    public void setShowOrNot(boolean showOrNot) {
        this.showOrNot = showOrNot;
    }
}
