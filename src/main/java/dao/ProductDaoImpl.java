package dao;

import config.HibernateConfig;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final SessionFactory sessionFactory;
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(Product product) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findAllByIds(List<Long> ids) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from product_table where id in (:ids)",
                Product.class);
        query.setParameter("ids", ids);

        return query.getResultList();
    }
}
