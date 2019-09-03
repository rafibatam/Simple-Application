package id.muhammadrafi.dicodingsubmission.listcar;

public class Car {
    private String name, describe;
    private int photo;

    public Car(int photo, String name, String describe) {
        this.photo = photo;
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
