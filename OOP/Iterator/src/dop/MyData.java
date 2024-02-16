package dop;

import java.util.ArrayList;

public class MyData {
    ArrayList<MyDataItem> myDataItems;

    public MyData(){
        myDataItems = new ArrayList<MyDataItem>();

        String figures[] = new String[]{"square", "triangle"};

        DataItem(figures, 1, 2.3, 'c');
    }

    public Iterator createIterator() {
        return new MyDataIterator(myDataItems);
    }

    public void DataItem(String[] figures, int a, double b, char c){
        MyDataItem myDataItem = new MyDataItem(figures, a, b, c);
        myDataItems.add(myDataItem);
    }
}
