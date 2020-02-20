package Nikolaj.com.lists;

public class Array<E> {

    private E data[];
    private int size;

    public Array(int size){
        this.size = size;
        data = (E[])new Object[size];
    }
    public void set(int position, E obj){
        if(position> data.length)
            throw new IndexOutOfBoundsException("No such index");
        data[position] = obj;
    }
    public int getLength(){
        return this.size;

    }
    public E get(int position){
        if(position> data.length)
            throw new IndexOutOfBoundsException("No such index");
        return data[position];
    }

    public int find(E o) throws Exception {
        for(int i = 0; i < data.length ; i++){
            if(data[i].equals(o))
                return i;
        }
        throw new Exception("No such element");
    }
    public void insert(int position, E o){
        if(position<=0 && position<= size){
            E[] newData = (E[])new Object[size + 1];
            for(int i = 0; i < position; i++){
                newData[i] = data[i];
            }
            newData[position] = o;

            for(int i = position+1 ; i < newData.length ; i++){
                newData[i] = data[i];
            }
            data = newData;
            size = size+1;
            }
        }

        public void delete(int position){
            if(position < 0 || position>size)
                throw new IndexOutOfBoundsException("No such element");

            E []newData =(E[]) new Object[size-1];

            for(int i = 0; i< position; i++){
                newData[i] = data[i];
            }
            for(int i = position + 1; i < position; i++){
                newData[i] = data[i];
            }
            data = newData;
            size -=size;
        }
        public void resize(int size){
            E[] newData = (E[]) new Object[size];
            for(int i = 0; i < size; i++){
                newData[i] = data[i];
            }
            data = newData;
            this.size = size;

        }

    }
