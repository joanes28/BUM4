package competitions;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javafx.embed.swing.SwingFXUtils;


public class ClientController {

    static List<Competition> competitions;

    static int index;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField areaIDArea;

    @FXML
    private TextField areaNameArea;

    @FXML
    private TextField compIDArea;

    @FXML
    private TextField compNameArea;

    @FXML
    private TextField countryCodeArea;

    @FXML
    private ImageView imageLbl;

    @FXML
    private Button nextBtn;

    @FXML
    private Button previousBtn;

    public static List<Competition> initializeCompetition(){

        //List<Competition> competitions;
        Manager manager = new Manager();
        String body = manager.request("competitions");

        Gson gson = new Gson();
        JsonObject jsonObject;

        jsonObject = gson.fromJson(body,JsonObject.class);

        Type competitionListType = new TypeToken<ArrayList<Competition>>(){}.getType();
        competitions = gson.fromJson((jsonObject.get("competitions")), competitionListType);

        index = 0;

        return competitions;
    }


    @FXML
    void nextMatch(ActionEvent event) {

        imageLbl.setImage(null);
        if (index == competitions.size() - 1){
            index = 0;
            compIDArea.setText("" + competitions.get(index).getId());
            compNameArea.setText(competitions.get(index).getName());
            areaIDArea.setText("" + competitions.get(index).getArea().id);
            areaNameArea.setText(competitions.get(index).getArea().name);
            countryCodeArea.setText(competitions.get(index).getArea().countryCode);
            if (competitions.get(index).emblemUrl != null) {
                if (competitions.get(index).emblemUrl.contains(".svg")) {
                    BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
                    try (InputStream file = new URL(competitions.get(index).emblemUrl).openStream()) {
                        TranscoderInput transIn = new TranscoderInput(file);
                        try {
                            transcoder.transcode(transIn, null);
                            Image img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                            imageLbl.setImage(img);
                        } catch (TranscoderException ex) {
                            System.out.println("There was an error charging the image");
                            //ex.printStackTrace();
                        }
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }else {
                    Image image = new Image(competitions.get(index).emblemUrl);
                    imageLbl.setImage(image);
                }
            }
        }else{
            index++;
            compIDArea.setText("" + competitions.get(index).getId());
            compNameArea.setText(competitions.get(index).getName());
            areaIDArea.setText("" + competitions.get(index).getArea().id);
            areaNameArea.setText(competitions.get(index).getArea().name);
            countryCodeArea.setText(competitions.get(index).getArea().countryCode);
            if (competitions.get(index).emblemUrl != null) {
                if (competitions.get(index).emblemUrl.contains(".svg")) {
                    BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
                    try (InputStream file = new URL(competitions.get(index).emblemUrl).openStream()) {
                        TranscoderInput transIn = new TranscoderInput(file);
                        try {
                            transcoder.transcode(transIn, null);
                            Image img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                            imageLbl.setImage(img);
                        } catch (TranscoderException ex) {
                            System.out.println("There was an error charging the image");
                            //ex.printStackTrace();
                        }
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }else {
                    Image image = new Image(competitions.get(index).emblemUrl);
                    imageLbl.setImage(image);
                }
            }
        }
    }

    @FXML
    void previousMatch(ActionEvent event) {

        imageLbl.setImage(null);
        if (index == 0){
            index = competitions.size() - 1;
            compIDArea.setText("" + competitions.get(index).getId());
            compNameArea.setText(competitions.get(index).getName());
            areaIDArea.setText("" + competitions.get(index).getArea().id);
            areaNameArea.setText(competitions.get(index).getArea().name);
            countryCodeArea.setText(competitions.get(index).getArea().countryCode);
            if (competitions.get(index).emblemUrl != null) {
                if (competitions.get(index).emblemUrl.contains(".svg")) {
                    BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
                    try (InputStream file = new URL(competitions.get(index).emblemUrl).openStream()) {
                        TranscoderInput transIn = new TranscoderInput(file);
                        try {
                            transcoder.transcode(transIn, null);
                            Image img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                            imageLbl.setImage(img);
                        } catch (TranscoderException ex) {
                            System.out.println("There was an error charging the image");
                            //ex.printStackTrace();
                        }
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }else {
                    Image image = new Image(competitions.get(index).emblemUrl);
                    imageLbl.setImage(image);
                }
            }
        }else{
            index--;
            compIDArea.setText("" + competitions.get(index).getId());
            compNameArea.setText(competitions.get(index).getName());
            areaIDArea.setText("" + competitions.get(index).getArea().id);
            areaNameArea.setText(competitions.get(index).getArea().name);
            countryCodeArea.setText(competitions.get(index).getArea().countryCode);
            if (competitions.get(index).emblemUrl != null) {
                if (competitions.get(index).emblemUrl.contains(".svg")) {
                    BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
                    try (InputStream file = new URL(competitions.get(index).emblemUrl).openStream()) {
                        TranscoderInput transIn = new TranscoderInput(file);
                        try {
                            transcoder.transcode(transIn, null);
                            Image img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                            imageLbl.setImage(img);
                        } catch (TranscoderException ex) {
                            System.out.println("There was an error charging the image");
                            //ex.printStackTrace();
                        }
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }else {
                    Image image = new Image(competitions.get(index).emblemUrl);
                    imageLbl.setImage(image);
                }
            }
        }
    }

    @FXML
    void initialize() {

        initializeCompetition();

        compIDArea.setText("" + competitions.get(index).getId());
        compNameArea.setText(competitions.get(index).getName());
        areaIDArea.setText("" + competitions.get(index).getArea().id);
        areaNameArea.setText(competitions.get(index).getArea().name);
        countryCodeArea.setText(competitions.get(index).getArea().countryCode);
        if (competitions.get(0).emblemUrl != null) {
            BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
            try (InputStream file = getClass().getResourceAsStream("/img/github.svg")) {
                TranscoderInput transIn = new TranscoderInput(file);
                try {
                    transcoder.transcode(transIn, null);
                    Image img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                    imageLbl.setImage(img);
                } catch (TranscoderException ex) {
                    ex.printStackTrace();
                }
            }
            catch (IOException io) {
                io.printStackTrace();
            }
            Image image = new Image(competitions.get(index).emblemUrl);
            imageLbl.setImage(image);
        }

    }

    public class BufferedImageTranscoder extends ImageTranscoder {

        private BufferedImage img = null;

        @Override
        public BufferedImage createImage(int width, int height) {
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        @Override
        public void writeImage(BufferedImage img, TranscoderOutput to) throws TranscoderException {
            this.img = img;
        }

        public BufferedImage getBufferedImage() {
            return img;
        }
    }






}
