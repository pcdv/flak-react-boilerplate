package flak.react.boilerplate;

import java.io.IOException;
import java.io.InputStream;

import flak.App;
import flak.Response;
import flak.annotations.Route;
import flak.plugin.resource.DefaultContentTypeProvider;
import flak.plugin.resource.FlakResourceImpl;

/**
 * Routes requests to '/' or '/foo' (like '/favico.ico') to embedded resource
 * dir.
 */
public class IndexHandler {

  private static final String RESOURCE_PATH =
    System.getProperty("webResources", "/app");

  public IndexHandler(App app) {
    FlakResourceImpl res = new FlakResourceImpl(app);
    res.setContentTypeProvider(new DefaultContentTypeProvider());

    ClassLoader loader = getClass().getClassLoader();
    res.servePath("/", "/app", loader, false);
  }

  @Route("/")
  public InputStream index(Response r) throws IOException {
    return get("index.html");
  }

  @Route("/:file")
  public InputStream get(String file) throws IOException {
    return openIndexHtml(file);
  }

  private InputStream openIndexHtml(String p) throws IOException {
    String path = RESOURCE_PATH + "/" + p;
    InputStream in = getClass().getResourceAsStream(path);
    if (in == null)
      throw new IOException("Not found: " + path);
    return in;
  }
}
