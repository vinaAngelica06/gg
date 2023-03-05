import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
public class ProductResource {
    @Inject
    ProductRepository repository;

    @GET
    public List<Product> listProduct() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public Product create(Product product) {
        repository.persist(product);
        return product;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Product update(@PathParam("id") Long id, Product product) {
        Product currentProduct = Product.findBy(id);
        currentProduct.name = product.name;
        currentProduct.description = product.description;
        currentProduct.category = product.category;
        currentProduct.price = product.price;
        currentProduct.stock = product.stock;
        return currentProduct;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}