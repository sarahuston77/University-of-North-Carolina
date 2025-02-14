package lec10.de;
import java.util.Date;

// Data Encapsulation

public class UncStudent {
    String _fName = "";
    String _lName = "";
    public int _age;
    private int _id = -1;

    void setID(int id){
        _id = id;
    }

    public int getID(){
        return _id;
    }
}
