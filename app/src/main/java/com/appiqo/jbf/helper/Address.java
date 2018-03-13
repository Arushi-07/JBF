package com.appiqo.jbf.helper;

/**
 * Created by arushi on 8/16/17.
 */

public class Address {
    String name,line1,line2,line3,line4,line5,contactNo,cod;
    int def=0;

    public void setName(String name)
    {
        this.name=name;
    }
    public void setLine1(String line1)
    {
        this.line1=line1;
    }
    public void setLine2(String line2)
    {
        this.line2=line2;
    }
    public void setLine3(String line3)
    {
        this.line3=line3;
    }
    public void setLine4(String line4)
    {
        this.line4=line4;
    }
    public void setLine5(String line5)
    {
        this.line5=line5;
    }
    public void setContactNo(String contactNo)
    {
        this.contactNo=contactNo;
    }
    public void setCod(String name)
    {
        this.cod=name;
    }
    public String getName()
    {
        return name;
    }
    public String getLine1()
    {
        return line1;
    }
    public String getLine2()
    {
        return line2;
    }
    public String getLine3()
    {
        return line3;
    }
    public String getLine4()
    {
        return line4;
    }
    public String getLine5()
    {
        return line5;
    }
    public String getContactNo()
    {
        return contactNo;
    }
    public String getCod()
    {
        return cod;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getDef() {
        return def;
    }
}
