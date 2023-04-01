package rbdiang.resolve.grpc.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/info/")
public class AppInfoController {

    @GetMapping("/info/terms-of-use")
    public String termsOfUse() {
        return """
<html>
  <body>
    <h1>Terms of use</h1>
    <p style="color:red; font-weight:bold;">
      Use at your own risk!
    </p>
  </body>
</html>
""";
    }
}
