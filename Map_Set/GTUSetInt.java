package hw7n;
import hw7n.GTUSet.GTUIterator;
import java.security.InvalidParameterException;

/**
 *
 * @author Tarık
 * @param <T>
 */
public interface GTUSetInt<T> {

    /**
     *
     * @param element
     * @return
     */
    GTUIterator find(T element);
    
    /**
     *
     * @return
     */
    GTUIterator begin();
    
    /**
     *
     * @return
     */
    GTUIterator end();
    /**
     *
     * @return
     */
    boolean empty();

    /**
     *
     * @return
     */
    int size();

    /**
     *
     * @return
     */
    int max_size();

    /**
     *
     * @param element
     * @throws InvalidParameterException
     */
    void insert(T element) throws InvalidParameterException ;

    /**
     *
     * @param element
     * @return
     */
    int erase(T element);

    /**
     *
     */
    void clear();

    /**
     *
     * @param element
     * @return
     */
    int count(T element);

    /**
     *
     * @param s
     * @return
     */
    GTUSetInt<T> intersection(GTUSetInt<T> s);
}
