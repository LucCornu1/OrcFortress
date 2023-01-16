module com.ccicraft.orcfortress {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.ccicraft.orcfortress to javafx.fxml;
    exports com.ccicraft.orcfortress;
}