package Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

abstract class BaseRepository<ID, T> {
    HashMap<ID, T> Map;
    protected ArrayList<T> List;

    public findId(ID id){
        return id;
    }

    public findAll(){
        return allData;
    }

    abstract void save(T entity);

    abstract  int getID(T entity){
        return ID;
    }
}
