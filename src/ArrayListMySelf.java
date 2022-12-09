import java.util.Arrays;

public class ArrayListMySelf {
    Object[] myArrayList = {};
    Object[] temp = {};
    int initialCapacity = 1;
    int currentSize;
    int currentIndex = 0;

    public ArrayListMySelf() {
        myArrayList = new Object[initialCapacity];
    }

    public ArrayListMySelf(int size) {
        myArrayList = new Object[size];
    }

    public void add(Object obj) {
        myArrayList[currentIndex] = obj;
        currentIndex++;
        temp = myArrayList;
        myArrayList = new Object[temp.length + 1];
        System.arraycopy(temp, 0, myArrayList, 0, temp.length);
    }

    public Object get(int index){
        return myArrayList[index];
    }

    public void clear(){
        myArrayList = new Object[initialCapacity];
        currentIndex = 0;
    }

    public int size(){
        return myArrayList.length;
    }

}
