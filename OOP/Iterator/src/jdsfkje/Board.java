package jdsfkje;

public class Board {
    MyData myData;

    public Board(MyData myData) {
        this.myData = myData;
    }

    public void printData(){
        Iterator myDataIterator = myData.createIterator();
        System.out.println("Данные доски:");
        printData(myDataIterator);
    }

    private void printData(Iterator iterator){
        while (iterator.hasNext()){
            MyDataItem myDataItem = iterator.next();
            System.out.print(myDataItem.getFigures() + ", ");
            System.out.print(myDataItem.getA() + ", ");
            System.out.print(myDataItem.getB() + ", ");
            System.out.print(myDataItem.getC());
        }
    }
}
