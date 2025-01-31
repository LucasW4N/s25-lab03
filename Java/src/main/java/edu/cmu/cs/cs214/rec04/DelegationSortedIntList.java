package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList list;
    private int totalAdded = 0;

    public DelegationSortedIntList() {
        list = new SortedIntList();
    }

    @Override
    public boolean add(int num) {
        totalAdded++;
        return list.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            totalAdded++; // Count every attempted addition
            changed |= this.list.add(list.get(i)); // Delegate to SortedIntList
        }
        return changed;
    }

    @Override
    public int get(int index){
        return list.get(index);
    }

    @Override
    public boolean remove(int num) {
        return list.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return list.removeAll(list);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}