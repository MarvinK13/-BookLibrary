package repository;

import configuration.DatabaseConnection;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MemberRepository {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addMember(Member member) {
        String sql = "INSERT INTO members(name) VALUES(?)";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setString(1, member.getName());

            prepareStatement.executeUpdate();
            System.out.println("Finished Task");

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void removeMemberById(int id) {
        String sql = "DELETE FROM members WHERE userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

    }

    public String findNameByMemberId(int id) {
        String sql = "SELECT name FROM members WHERE userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            resultSet.next();
            String name = resultSet.getString("name");
            resultSet.close();
            return name;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public List<Member> findMembersByName(String name) {
        String sql = "SELECT * FROM members WHERE name = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();

            List<Member> members = new LinkedList<>();
            while (resultSet.next()) {
                Member member=new Member();
                member.setId(resultSet.getInt("userId"));
                member.setName(resultSet.getString("name"));
                members.add(member);
            }
            resultSet.close();
            return members;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public Member findMemberById(int id) {
        String sql = "SELECT * FROM members WHERE userId = ?";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();

            Member member = new Member();
            member.setId(resultSet.getInt("userId"));
            member.setName(resultSet.getString("name"));
            resultSet.close();

            return member;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return null;
    }

    public List<String> findAllNames() {
        String sql = "SELECT name FROM members";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
             ResultSet resultSet = prepareStatement.executeQuery();
        ) {
            List<String> names = new LinkedList<>();
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
            return names;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }

    public List<Member> findAllMembers() {
        String sql = "SELECT * FROM members";

        try (Connection databaseConnection = this.databaseConnection.getConnection();
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
             ResultSet resultSet = prepareStatement.executeQuery();
        ) {
            List<Member> members = new LinkedList<>();
            while (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getInt("userId"));
                member.setName(resultSet.getString("name"));
                members.add(member);
            }
            return members;
        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }

        return null;
    }
}
