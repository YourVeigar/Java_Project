package dop;

import java.util.ArrayList;

public class MyDataIterator implements  Iterator {

    ArrayList<MyDataItem> data;

    int p = 0;
    public MyDataIterator(ArrayList<MyDataItem> data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (p >= data.size()|| data.get(p) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MyDataItem next() {
        MyDataItem myDataItem = data.get(p);
        p = p + 1;
        return myDataItem;
    }
}
