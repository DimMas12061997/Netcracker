package by.training.nc.dev3.beans;


public class BlackList extends Entity{
    private int idBlackList;
    private int userId;
    private String createdDate;

    public int getIdBlackList() {
        return idBlackList;
    }

    public void setIdBlackList(int idBlackList) {
        this.idBlackList = idBlackList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
