import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;
    public String category;
    public Double price;
    public Integer stock;

}
