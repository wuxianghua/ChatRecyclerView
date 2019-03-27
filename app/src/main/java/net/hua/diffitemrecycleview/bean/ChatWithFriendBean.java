package net.hua.diffitemrecycleview.bean;

public class ChatWithFriendBean {
    private String content;
    private boolean isFriendMsg;
    private String mapUrl;
    private String label;
    private String poiname;

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFriendMsg() {
        return isFriendMsg;
    }

    public void setFriendMsg(boolean friendMsg) {
        isFriendMsg = friendMsg;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }

    public String getContent() {
        return content;
    }
}
