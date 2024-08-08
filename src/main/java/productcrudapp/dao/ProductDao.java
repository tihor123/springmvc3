package productcrudapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import productcrudapp.model.Product;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product){
        this.hibernateTemplate.saveOrUpdate(product);
    }

    public List<Product> getProducts(){
        return this.hibernateTemplate.loadAll(Product.class);
    }
    @Transactional
    public void deleteProduct(int pid){
        Product p = this.hibernateTemplate.get(Product.class, pid);
        assert p != null;
        this.hibernateTemplate.delete(p);
    }

    public Product getProduct(int pid){
        return this.hibernateTemplate.get(Product.class, pid);
    }
}
