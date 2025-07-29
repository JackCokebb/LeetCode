// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    private int pointer;
    private List<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {

        this.pointer = 0;
        this.list = new ArrayList<>();

        while (iterator.hasNext()) {
            this.list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) {
            return null;
        }

        return this.list.get(this.pointer);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return this.list.get(Math.min(this.pointer++, this.list.size()));
    }

    @Override
    public boolean hasNext() {
        System.out.println("this.list.size() - 1: " + (this.list.size() - 1) + ", this.pointer: " + this.pointer);
        return this.list.size() > this.pointer;
    }
}