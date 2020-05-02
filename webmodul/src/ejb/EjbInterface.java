package ejb;

import javax.ejb.Local;

@Local
public interface EjbInterface {
    String getName();
}
