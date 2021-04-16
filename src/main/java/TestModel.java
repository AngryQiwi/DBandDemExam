public class TestModel {
    public int id;
    public String f_name;
    public String l_name;
    public String city;
    public int phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public TestModel(int id, String f_name, String l_name, String city, int phone) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.city = city;
        this.phone = phone;
    }
}
