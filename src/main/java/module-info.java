module competitions {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires batik.transcoder;
    requires javafx.swing;


    opens competition to javafx.fxml;
    //exports eus.ehu.bum4;
    exports competitions;
    opens competitions to javafx.fxml, com.google.gson;


}