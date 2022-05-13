package kr.readvice.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Data @Lazy //Lazy Loading: 내가 필요할 때만 사용
public class Vector<T> {
    // save, update, delete, findAll, findById, findByName, count, clear, existsById
    // add, set, remove, X, get(i), get(), size, clear
    // ArrayList가 내가 넣는 타입으로 그때그때 바뀌게 된다.
    private ArrayList<T> list;
    public Vector() { this.list = new ArrayList<>();}

    public void add(T t){
        list.add(t);
    }
    public void set(int i, T t){
        list.set(i, t);
    }
    public void remove(T t){
        list.remove(t);
    }
    public void clear(){
        list.clear();
    }
    public List<T> get(){
        return list;
    }
    public T get(int i){
        return list.get(i);
    }
    public int size() {
        return list.size();
    }

}
