package competitions;

import com.google.gson.reflect.TypeToken;
import competitions.Competition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.kordamp.bootstrapfx.BootstrapFX;



import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class ClientApplication extends Application {

    public static void main(String args[]){
        Manager manager = new Manager();
        String body = manager.request("competitions");

        Gson gson = new Gson();
        JsonObject jsonObject;

        jsonObject = gson.fromJson(body,JsonObject.class);

        Type competitionListType = new TypeToken<ArrayList<Competition>>(){}.getType();
        List<Competition> competitions = gson.fromJson((jsonObject.get("competitions")), competitionListType);

        System.out.println(competitions.get(0).getId());
        System.out.println(competitions.get(0).getArea());
        System.out.println(competitions.get(0).getName());

        launch();

    }

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("/bum4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 430);
        stage.setTitle("Competitions");
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setScene(scene);
        stage.show();
    }


}
