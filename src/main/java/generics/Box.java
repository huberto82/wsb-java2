package generics;

public class Box<T> {
    private T content;


    public T getContent(){
        return content;
    }

    public boolean isEmpty(){
        return content == null;
    }

    public void setContent(T content){
        this.content = content;
    }
}
