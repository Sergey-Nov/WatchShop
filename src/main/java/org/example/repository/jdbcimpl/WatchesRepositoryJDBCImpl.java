//package org.example.repository.jdbcimpl;
//
//import org.example.entity.Manufacturer;
//import org.example.entity.Planet;
//import org.example.entity.Watches;
//import org.example.entity.enums.Type;
//import org.example.repository.WatchesRepository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WatchesRepositoryJDBCImpl implements WatchesRepository {
//    private static final String SQL_SELECT_WATCHES_BY_TYPE = "SELECT brand, price, amount, manufacturer_props, type from watches WHERE type=?";
//    private static final String SQL_SELECT_MECH_WATCHES_WITH_PRICE_LOWER =
//            "SELECT * from watches WHERE type=1 and price<? ";
//    private static final String SQL_SELECT_ALL_WATCHES = "SELECT * from watches";
//    @Override
//    public List<Watches> getWatchesByType(Type type) {
//        List<Watches> resultList = new ArrayList<>();
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = ConnectionCreator.createConnection();
//            statement = connection.prepareStatement(SQL_SELECT_WATCHES_BY_TYPE);
//            statement.setInt(1, type.ordinal());
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                resultList.add(new Watches(
//                        resultSet.getString(1),
//                        resultSet.getInt(2),
//                        resultSet.getInt(3),
//                        resultSet.getString(4),
//                        Type.values()[resultSet.getInt(5)]));
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }
//        return resultList;
//    }
//
//    @Override
//    public List<Watches> getMechanicalWatchesWithPriceLower(int price) {
//        return List.of();
//    }
//
//    @Override
//    public List<Watches> findAll() {
//        List<Watches> resultList = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = ConnectionCreator.createConnection();
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_WATCHES);
//            while (resultSet.next()) {
//                resultList.add(new Watches(
//                        resultSet.getString(1),
//                        resultSet.getInt(2),
//                        resultSet.getInt(3),
//                        resultSet.getString(4),
//                        Type.values()[resultSet.getInt(5)]));
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultList;
//    }
//
//
////    @Override
////    public List<Watches> getMechanicalWatchesWithPriceLower(int price) {
////        return List.of();
////    }
////
////    @Override
////    public List<Watches> getWatchesByCountry(String country) {
////        return List.of();
////    }
////
////    @Override
////    public List<Manufacturer> getManufacturerBySumPriceLess(int enteredPrice) {
////        return List.of();
////    }
//}
