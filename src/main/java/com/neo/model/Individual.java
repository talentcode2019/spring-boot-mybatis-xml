package com.neo.model;

public class Individual {
    //select ti.name, rs.name as rs,ti.dateofbirth, tf.Element as element

    private  String name;
    private  String rs;
    private  String dateofbirth;
    private  String element;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "name='" + name + '\'' +
                ", rs='" + rs + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", element='" + element + '\'' +
                '}';
    }
}
