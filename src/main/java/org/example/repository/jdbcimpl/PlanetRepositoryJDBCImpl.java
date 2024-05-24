package org.example.repository.jdbcimpl;

import org.example.entity.Planet;
import org.example.repository.PlanetRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetRepositoryJDBCImpl implements PlanetRepository {

    private static final String SQL_SELECT_ALL_PLANETS = "SELECT * FROM planet";
    private static final String SQL_SELECT_PLANET_BY_NAME = "SELECT name, diameter, temperature FROM planet WHERE name = ?";
    private static final String SQL_INSERT_PLANET = "INSERT INTO planet (diameter, temperature, name) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_PLANET = "UPDATE public.planet SET diameter=?, temperature=? WHERE name=?;";
    private static final String SQL_DELETE_PLANET = "DELETE FROM public.planet WHERE name=?;";

    @Override
    public List<Planet> findAll() {
        List<Planet> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PLANETS);
            while (resultSet.next()) {
                resultList.add(new Planet(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3)));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Planet getPlanetByName(String name) {
        Planet planet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_PLANET_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                planet = new Planet(
                        resultSet.getString(1),
                        resultSet.getInt(3),
                        resultSet.getDouble(2)
                );
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planet;
    }

    @Override
    public Planet save(Planet planet) {
        Planet planetByName = getPlanetByName(planet.getName());
        String sqlQuery = planetByName == null ? SQL_INSERT_PLANET : SQL_UPDATE_PLANET;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setDouble(1, planet.getDiameter());
            statement.setInt(2, planet.getTemperature());
            statement.setString(3, planet.getName());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getPlanetByName(planet.getName());
    }

    @Override
    public Planet delete(Planet planet) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_DELETE_PLANET);
            statement.setString(1, planet.getName());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planet;
    }
}
