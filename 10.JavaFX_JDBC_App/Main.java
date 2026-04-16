import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class Main extends Application {

    RestaurantDAO dao = new RestaurantDAO();

    @Override
    public void start(Stage stage) {

        // 🔹 Fields
        TextField id = new TextField();
        TextField name = new TextField();
        TextField price = new TextField();
        TextField resId = new TextField();

        TextArea output = new TextArea();

        // 🔹 Buttons
        Button insert = new Button("Insert");
        Button select = new Button("Select");
        Button update = new Button("Update");
        Button delete = new Button("Delete");

        // 🔹 INSERT
        insert.setOnAction(e -> {
            dao.insertMenuItem(
                Integer.parseInt(id.getText()),
                name.getText(),
                Integer.parseInt(price.getText()),
                Integer.parseInt(resId.getText())
            );
            output.setText("Inserted Successfully");
        });

        // 🔹 SELECT
        select.setOnAction(e -> {
            try {
                ResultSet rs = dao.getMenuItems();
                StringBuilder sb = new StringBuilder();

                while (rs.next()) {
                    sb.append(rs.getInt(1)).append(" ")
                      .append(rs.getString(2)).append(" ")
                      .append(rs.getInt(3)).append(" ")
                      .append(rs.getInt(4)).append("\n");
                }

                output.setText(sb.toString());

            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        // 🔹 UPDATE
        update.setOnAction(e -> {
            dao.updatePrice(
                Integer.parseInt(id.getText()),
                Integer.parseInt(price.getText())
            );
            output.setText("Updated Successfully");
        });

        // 🔹 DELETE
        delete.setOnAction(e -> {
            dao.deleteItem(Integer.parseInt(id.getText()));
            output.setText("Deleted Successfully");
        });

        // 🔹 Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("ID"), 0, 0);
        grid.add(id, 1, 0);

        grid.add(new Label("Name"), 0, 1);
        grid.add(name, 1, 1);

        grid.add(new Label("Price"), 0, 2);
        grid.add(price, 1, 2);

        grid.add(new Label("ResId"), 0, 3);
        grid.add(resId, 1, 3);

        grid.add(insert, 0, 4);
        grid.add(select, 1, 4);
        grid.add(update, 0, 5);
        grid.add(delete, 1, 5);

        grid.add(output, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 400, 400);

        stage.setTitle("Restaurant Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}