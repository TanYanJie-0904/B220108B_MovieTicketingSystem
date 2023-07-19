module com.yanjie.test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yanjie.test to javafx.fxml;
    exports com.yanjie.test;
}