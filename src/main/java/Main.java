

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        String hql = "SELECT course_name FROM PurchaseList WHERE course_name LIKE 'PHP-разработчик с 0 до PRO'";
        List<Course> courseList = session.createQuery(hql).getResultList();
        System.out.println(courseList.size());


//        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
//        List<Course> courseList = session.createQuery(hql).getResultList();
//
//        System.out.println(courseList.size());

//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Course> query = builder.createQuery(Course.class);
//        Root<Course> root = query.from(Course.class);
//        query.select(root);
//        List<Course> courseList = session.createQuery(query).getResultList();
//
//        for (Course course : courseList) {
//            System.out.println(course.getName());
//        }


//        Transaction transaction = session.beginTransaction();
//        Course course = session.get(Course.class, 1);
//        List<Student> studentList = course.getStudents();
//        studentList.forEach(student -> {
//            System.out.println(student.getName());
//        });
//        transaction.commit();
        sessionFactory.close();
        }
}


// TODO: 20.12.2022 WORK_16.5
/*    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    Course course = session.get(Course.class, 45);
        course.setName("Управление продуктом");


// TODO: 20.12.2022 Создаем новый курс
//        Course course = new Course();
//        course.setName("Новый курс");
//        course.setType(CourseType.BUSINESS);
//        course.setTeacherId(1);

                // TODO: 20.12.2022 удаляем курс        
//        session.delete(course);


                session.save(course);
                transaction.commit();



//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName());
                sessionFactory.close();*/








// TODO: 20.12.2022 Старый метод парсинга таблицы
/*        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "jcnhjdtw22";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            statement.execute("UPDATE Courses SET name='Веб-разработчик с нуля до PRO' WHERE id = 1");


            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
            while(resultSet.next()){
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));

                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }
            resultSet.close();
            statement.close();
            connection.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }*/