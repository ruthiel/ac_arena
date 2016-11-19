package org.academiadecodigo.acarena;


import org.academiadecodigo.acarena.networking.server.Server2nd;
import java.io.IOException;

/**
 * Created by codecadet on 14/11/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        LanternaField lanternaField = new LanternaField(10,10);
//        lanternaField.init();
//        PlayerTest playerTest = new PlayerTest(lanternaField);

        Server2nd server2nd = new Server2nd(4000);
        server2nd.run();

    }
}
