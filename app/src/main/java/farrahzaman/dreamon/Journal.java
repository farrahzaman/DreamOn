package farrahzaman.dreamon;

/**
 * Created by farrahzaman on 26/03/15.
 */
public class Journal {

    //private variables
    int _id;
    String _date;
    String _title;
    String _dream;

    // Empty constructor
    public Journal (){

    }
    // constructor
    public Journal(int id, String date, String title, String dream){
        this._id = id;
        this._date = date;
        this._title = title;
        this._dream = dream;

    }

    // constructor
    public Journal(String date, String title, String dream) {
        this._date = date;
        this._title = title;
        this._dream = dream;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting date
    public String getDate(){
        return this._date;
    }

    // setting date
    public void setDate(String date){
        this._date = date;
    }

    // getting title
    public String getTitle(){
        return this._title;
    }

    // setting title
    public void setTitle(String title){
        this._title = title;
    }

    // getting dream
    public String getDream(){
        return this._dream;
    }

    // setting dream
    public void setDream(String dream){
        this._dream = dream;
    }
}
