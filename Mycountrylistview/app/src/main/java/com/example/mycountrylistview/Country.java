package com.example.mycountrylistview;

public class Country {
    String name;
    String populate;
    int img;

    public Country(){}
    public Country(String name,String populate){
        this.name = name;
        this.populate = populate;
    }
    public Country(String name, String  populate, int img){
        this.name = name;
        this.populate = populate;
        this.img = img;
    }

    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name = name;
    }
    public String getPopulate(){
        return populate;
    }
    public  void setPopulate(String populate){
        this.populate = populate;
    }
    public int getImg(){
        return img;
    }
    public  void setImg(int img){
        this.img = img;
    }
    @Override
    public String toString(){
        return "Country{" + "name='" + this.name + "\'" + ",populate='" +this.populate+ "\'" + ",img=" + this.img + "}";
    }

}
