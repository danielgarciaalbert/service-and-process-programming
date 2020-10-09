module HealthyMenu {
    requires javafx.controls;
    requires javafx.fxml;

    opens healthymenu;
    opens healthymenu.views.main;
    opens healthymenu.data;
    opens healthymenu.views.chart;
}