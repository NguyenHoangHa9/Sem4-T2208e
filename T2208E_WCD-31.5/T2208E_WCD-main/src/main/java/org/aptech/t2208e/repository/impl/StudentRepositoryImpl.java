package org.aptech.t2208e.repository.impl;

import org.aptech.t2208e.dto.StudentDto;
import org.aptech.t2208e.entity.Student;
import org.aptech.t2208e.repository.StudentRepository;
import org.aptech.t2208e.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl  implements StudentRepository {
    private static final String SQL_QUERY_STUDENT_BY_ID = "Select * from student where id  = ?";
    private static final String SQL_QUERY_STUDENT_BY_FIRST_NAME = "SELECT * FROM students WHERE first_name = ?";
    private static final String SQL_INSERT_STUDENT = "INSERT INTO student (first_name, last_name, address, age) VALUES (?, ?, ?, ?)";

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        Optional<List<Student>> s = studentRepository.getById("'1' or 0 =0 ");
        if(s.isPresent()){
            System.err.println("Student with id 1 : "+ s.get());
        }
    }
    @Override
    public Optional<List<Student>> getById(String id) {
//        Connection connection = DatabaseHelper.getConnection();
        List<Student> students = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        try {
            // fixme  : sql injection
            PreparedStatement pt = con.prepareStatement(SQL_QUERY_STUDENT_BY_ID);
            pt.setString(1,String.valueOf(id));
            ResultSet rs = pt.executeQuery();
//            Statemen  t statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(SQL_QUERY_STUDENT_BY_ID.replace("?"
//                    ,String.valueOf(id)));
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  Optional.of(students);
    }

    @Override
    public List<Student> getAll() {
        return List.of();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public Optional<List<Student>> getByFirstName(String firstName) {
        List<Student> students = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        try {
            PreparedStatement pt = con.prepareStatement(SQL_QUERY_STUDENT_BY_FIRST_NAME);
            pt.setString(1, firstName);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(students);
    }

    @Override
    public StudentDto addStudent(StudentDto studentdto) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, studentdto.getFirstName());
            preparedStatement.setString(2, studentdto.getLastName());
            preparedStatement.setString(3, studentdto.getAddress());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating student failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    studentdto.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating student failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding student", e);
        }
        return studentdto;
    }
    // extend vs implement
}
