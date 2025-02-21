import bean.Annonce;
import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List<Annonce> annonces = session.createQuery("from Annonce").list();
            System.out.println(annonces.size());
            t.commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
