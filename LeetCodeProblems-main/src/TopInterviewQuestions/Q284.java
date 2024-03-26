class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue;
   
    public PeekingIterator(Iterator<Integer> iterator) {
       queue = new LinkedList<>();
       while (iterator.hasNext()){
           queue.add(iterator.next());
       }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;


class PeekingIterator implements Iterator<Integer> {
    Integer peek;
    Iterator<Integer> itr;

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            peek = iterator.next();
        }
        itr = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peek == null){
            throw new NoSuchElementException();
        }
        Integer temp = peek;
        peek = null;
        if(itr.hasNext()){
            peek = itr.next();
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return peek != null;
    }
}
