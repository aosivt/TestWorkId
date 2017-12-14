package aos.Repository;

import java.io.Serializable;


public interface Directories<T extends Directories<T>> extends Serializable {
    public T getDirectories();

    public String getDirName();

}
