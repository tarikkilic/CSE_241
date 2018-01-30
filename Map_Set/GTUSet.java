package hw7n;
import java.security.InvalidParameterException;


/**
 *
 * @author Tarık
 * @param <T> setin tipi
 */
public class GTUSet<T> implements GTUSetInt<T> {
	private int capacity;
	private int size;
	private T[] data;

    /**
     *
     * @param s GTUsetInt ten turemis tipler parametre olarak gelebilir.
     * @return iki kümenin ortak elemanlarini bulur ve return eder.
     * 
     */
    @Override
	public GTUSetInt<T> intersection(GTUSetInt<T> s){
		GTUSetInt<T> intSec = new GTUSet<  >();

	        for (T t : data) {
	            if(s.count(t) == 1) {
	                intSec.insert(t);
	            }
	        }
	        return intSec;
	}
	
    /**
     *
     * @return verileri stringe cevirip string return eder.
     */

        
    /**
     *
     * @param i index alir.
     */
    protected void setData(int i) { this.data[i] = this.data[i+1];}
    protected T getData(int i) { return this.data[i];}
    protected void minusSize() { this.size--; }
    /**
     *
     */
    public class GTUIterator{
		private int index;
		
            /**
             *
             */
            public GTUIterator() {
			index = 0;
		}
		
            /**
             *
             * @param newIndex iteratorun hangi indexten baslayacagini alir.
             */
            public GTUIterator(int newIndex) {
			index = newIndex;
		}
		
            /**
             *
             * @return devami varsa true yoksa false reutn eder.
             */
            public boolean hasNext() {
			return index < size;
		}

            /**
             *
             * @return öncesi varsa true yoksa false return eder.
             */
            public boolean hasPrevious() {
			return index != 0;
		}

            /**
             *
             * @return iteratorun gösterdigi yeri bastirir ve bi sonraki yere gecer.
             */
            public T next()
		{
			return data[index++];
		}

            /**
             *
             * @return iteratorun gösterdigi yeri bastirir ve bi önceki yere gecer.
             */
            public T prev() {
			return data[index--];
		}
	}
	
    /**
     *
     * @param element
     * @return verilen elemani bulur ve iterator return ederç
     * 
     */
    public GTUIterator find(T element){
		int index = 0;
		for(int i = 0; i < this.size;i++)
		{
			if(this.data[i].equals(element))
			{
				index = i;
				break;
			}
		}
		return new GTUIterator(index);
	}
	
    /**
     *
     * @return baslangic iteratoru return eder.
     */
    public GTUIterator begin(){
		return new GTUIterator(0);
	}
	
    /**
     *
     * @return iteratorun sonunu return eder.
     */
    public GTUIterator end(){
		return new GTUIterator(this.size);
	}
	
    /**
     *
     * @return capacity retur eder.
     */
    public int cap() {
		return capacity;
	}
	
    /**
     *
     */
    @SuppressWarnings("unchecked")
	public GTUSet(){
		this.capacity = 10;
		this.size = 0;
		this.data=(T[])new Object[this.capacity];
	}
        
       @SuppressWarnings("unchecked")
       public void resetData(){
		this.data=(T[])new Object[this.capacity];
	}
	
    /**
     *
     * @return bos olup olmadigini return eder.
     */
    @Override
	public boolean empty() {
		return this.size == 0;
	}

    /**
     *
     * @return size return eder.
     */
    @Override
	public int size() {
		return this.size;
	}

    /**
     *
     * @return max capacity return eder
     */
    @Override
	public int max_size() {
		return 9999;
	}
	
	@SuppressWarnings("unchecked")
        @Override
	public void insert(T element) throws InvalidParameterException {
		boolean flag = true;
		for(int i = 0;i < this.size;i++)
		{
			if(this.data[i].equals(element))
			{
				flag = false;
			}
		}
		
		
		if(this.size >= this.capacity && flag)
		{
			T[] temp=(T[])new Object[this.capacity];
			System.arraycopy(this.data, 0, temp, 0, this.size);
			this.capacity*=2;
			this.data=(T[])new Object[this.capacity];
			System.arraycopy(temp, 0, this.data, 0, this.size);
			this.data[this.size] = element;
			this.size++;
		}
		else if(flag)
		{
			this.data[this.size] = element;
			this.size++;
		}
		if(!flag)
			throw new InvalidParameterException("HATA");
	}
	
    /**
     *
     * @param element silinecek eleman
     * @return silinirse 1 silinmezse 0 return eder.
     */
    @SuppressWarnings("unchecked")
        @Override
	public int erase(T element) {
		int index = 0,flag = 0;
		for(int i = 0; i < this.size; i++)
		{
			if(this.data[i].equals(element))
			{
				index = i;
				this.size--;
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
		{
			for(int j = index; j < this.size;j++)
			{
				this.data[j] = this.data[j+1];
			}
			T[] temp=(T[])new Object[this.capacity];
			System.arraycopy(this.data, 0, temp, 0, this.size);
			this.data=(T[])new Object[this.capacity];
			System.arraycopy(temp, 0, this.data, 0, this.size);
			return 1;
		}
		return 0;
	}
	
    /**
     *
     */
    @SuppressWarnings("unchecked")
        @Override
	public void clear() {
		this.capacity = 10;
		this.size = 0;
		this.data=(T[])new Object[this.capacity];
	}
	
    /**
     *
     * @param element var olup olmadigini kontrol edilir.
     * @return varsa 1 yoksa 0 return eder.
     */
    @Override
	public int count(T element) {
		for(int i = 0; i < this.size;i++)
		{
			if(this.data[i].equals(element))
				return 1;
		}
		return 0;
	}
	
}
