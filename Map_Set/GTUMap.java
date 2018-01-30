package hw7n;
import javafx.util.Pair;

/**
 *
 * @author Tarık
 * @param <K> pairin keyi
 * @param <V> pairin value
 */
public class GTUMap<K,V> extends GTUSet<Pair<K, V>>{
	

    
    
     /**
     * 
     * @param key pair keyi alır.
     * @return pairin keyi ile kontrol eder esitse value dondurur.
     */
    public V at(K key) {
		for(int i = 0;i < size();i++)
		{
			if(getData(i).getKey().equals(key))
				return getData(i).getValue();
		}
		return null;
	}
    
        @Override
	public int erase(Pair<K,V> element) {
		int index = 0,flag = 0;
		for(int i = 0; i < size(); i++)
		{
			if(getData(i).getKey().equals(element.getKey()))
			{
				index = i;
				minusSize();
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
		{
			for(int j = index; j < size();j++)
			{
				setData(j);
                        }
			return 1;
		}
		return 0;
	}
        
        @Override
        public GTUIterator find(Pair<K,V> element){
		int index = 0;
		for(int i = 0; i < size();i++)
		{
			if(getData(i).getKey().equals(element.getKey()))
			{
				index = i;
				break;
			}
		}
		return new GTUIterator(index);
	}

}
