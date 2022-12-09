
public class ArrayListQueue implements QueueADT{
    ArrayListMySelf s = new ArrayListMySelf();
    // s = new ArrayListMySelf(1);
    
    int front, rear;
    int count;
    Order order = new Order();

    public ArrayListQueue(){
        Queue();
    }

    public void Queue() {
        count = 0;
        front = 0;
        rear = -1;
        
    }

    public void enqueue(Object e) throws Exception {
        if(isFull()){
            throw new Exception("Queue is full");
        } else{
            rear++;
            count++;
            s.add(e);
        }
    }

    public Object dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }else{
            front++;
            count--;
            return s.get(front-1);
        }
    }

    public Object front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }else{
            return s.get(front);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void clear() throws Exception {
        s.clear();
        rear = -1;
        front = 0;
        count = 0 ;
    }

    public int length() {
        return count;
    }

    public Object SearchByOrderNumber(int OrderNumber){
        return s.get(OrderNumber-1);
    }
}
