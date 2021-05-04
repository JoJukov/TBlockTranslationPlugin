package text.translation.impl;

import connection.impl.ProxyPropertyReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import text.formatting.impl.MessageConverter;
import text.translation.Destination;
import text.translation.Translator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleTranslator implements Translator {

    private final ProxyPropertyReader proxyPropertyReader;
    //
    private final MessageConverter messageConverter;
    //
    public GoogleTranslator() throws IOException {
        this.proxyPropertyReader = new ProxyPropertyReader();
        //
        this.messageConverter = new MessageConverter();
        //
    }

    @Override
    public String translate(String text, Destination dest) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dest", destinationToString(dest));
        jsonObject.put("text", text);

        final URL url;
        final HttpURLConnection con;
        try {
            url = new URL(proxyPropertyReader.getProperty("proxy_address"));
            // TODO: 5/2/21 in class
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            // TODO: 5/2/21 balance and put to class
            con.setDoOutput(true);
            final DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(jsonObject.toString());
            out.flush();
            out.close();

            String s = readResponse(con);

            // TODO: 5/2/21 to class
            Object obj = null;
            try {
                obj = new JSONParser().parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // TODO: 5/2/21 balance
            return ((JSONObject) obj).get("text").toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    private String destinationToString(Destination destination) {
        return destination.name().toLowerCase();
    }

    // TODO: 5/2/21 to class
    private String readResponse(HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
