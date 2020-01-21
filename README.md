# flak-react-boilerplate

This project template allows to kick start a 
web application with a Java backend based on [flak](https://github.com/pcdv/flak) 
and a frontend based on [create-react-app](https://github.com/facebook/create-react-app).

It creates a standalone, executable jar that serves the application.

To run it:
  - go to `server/`
  - run `../gradlew shadowJar`
  - run `java -jar build/libs/flak-react-boilerplate-1.0-SNAPSHOT-all.jar`

As of this writing, the size of the bundled application is 120kb because
it includes a minimal set of dependencies (e.g. jackson is excluded).