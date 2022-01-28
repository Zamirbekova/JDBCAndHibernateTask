package peaksoft.dao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;
import java.sql.SQLException;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    @Override
    public void createUsersTable() throws SQLException {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        System.out.println("Connected");
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        String sql = "drop table if exists userdao";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        System.out.println("delete");
        session.close();
    }
    @Override
        public void saveUser(String name, String lastName, byte age) {
            User user = new User(name, lastName, age);
            try {
                Session session = Util.getSession().openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();
                System.out.println("Successfully added");
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void removeUserById(long id) {
            try {
                Session session = Util.getSession().openSession();
                session.beginTransaction();
                User user = session.get(User.class, id);
                session.delete(user);
                session.getTransaction().commit();
                session.close();
                System.out.println("deleted successfully");
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public List<User> getAllUsers() {
            try {
                Session session = Util.getSession().openSession();
                session.beginTransaction();
                List<User> users = session.createSQLQuery("FROM userdao").list();
                session.getTransaction().commit();
                session.close();
                System.out.println("Found " + users.size() + " users");
                return users;
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        @Override
        public void cleanUsersTable() {
            try {
                Session session = Util.getSession().openSession();
                session.beginTransaction();
                session.createSQLQuery("DELETE FROM user").executeUpdate();
                session.getTransaction().commit();
                session.close();
                System.out.println("Successfully deleted all users");
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

