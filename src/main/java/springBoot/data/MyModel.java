package springBoot.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author brobinson
 */
@Entity
public class MyModel {

    @Id
    @GeneratedValue
    private Long id;

    private String myFirstName;

    private String myLastName;
}
