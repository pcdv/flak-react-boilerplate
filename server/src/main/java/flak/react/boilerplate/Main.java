package flak.react.boilerplate;

import java.awt.*;
import java.net.URI;

import flak.App;
import flak.Flak;

public class Main {

  private App app;

  public Main() {
  }

  public void start() throws Exception {
    // start web server and handlers
    int port = Integer.getInteger("port", 8080);
    app = Flak.createHttpApp(port);
    app.scan(new IndexHandler(app));
    app.start();

    Desktop.getDesktop().browse(new URI("http://localhost:" + port));
  }

  public void stop() {
    app.stop();
  }

  public static void main(String[] args) throws Exception {
    new Main().start();
  }
}
