package peaksoft;

import org.hibernate.Hibernate;
import peaksoft.dao.UserDaoHibernateImpl;

import peaksoft.model.User;
import peaksoft.util.Util;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


//        Util util=new Util();
//        UserDaoHibernateImpl userDaoHibernate=new UserDaoHibernateImpl();
//        userDaoHibernate.createUsersTable();
//
//        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("ENTER THE 1 FOR METHOD --> CREATUSERTABLE () ");
//            System.out.println("ENTER THE 2 FOR METHOD --> DROPUSERTABLE () ");
//            System.out.println("ENTER THE 3 FOR METHOD --> SAVEUSER () ");
//            System.out.println("ENTER THE 4 FOR METHOD --> REMOVEUSERBYID () ");
//            System.out.println("ENTER THE 5 FOR METHOD --> GETALLUSERS () ");
//            System.out.println("ENTER THE 6 FOR METHOD --> CLEANUSERTABLE () ");
//            int number = sc.nextInt();
//            switch (number) {
//                case 1:
//                    userDaoJdbc.createUsersTable();
//                    break;
//                case 2:
//                    userDaoJdbc.dropUsersTable();
//                    break;
//                case 3:
//                    userDaoJdbc.saveUser("Hadicha", "Zamirbekova", (byte) 18);
//                    break;
//                case 4:
//                    userDaoJdbc.removeUserById(1);
//                    break;
//                case 5:
//                    userDaoJdbc.getAllUsers();
//                    break;
//                case 6:
//                    userDaoJdbc.cleanUsersTable();
//                default:
//                    System.out.println("EXCEPTION!!!");
//           }
//        }

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
//        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.createUsersTable();
//        userDaoHibernate.saveUser("Nurisa","Abd", (byte) 18);
//        userDaoHibernate.getAllUsers();
        
    }
}