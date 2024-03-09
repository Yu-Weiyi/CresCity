FROM ghcr.io/graalvm/jdk-community:17
ENV LANG=en_US.UTF-8 \
    LANGUAGE=en_US.UTF-8
ENV JAVA_TOOL_OPTIONS "-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -XX:+DisableExplicitGC -Djava.security.egd=file:/dev/./urandom -XX:ActiveProcessorCount=8 -Djava.awt.headless=true  -XX:+UseG1GC -XX:+UseStringDeduplication"
VOLUME /tmp
EXPOSE 8080
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
MAINTAINER yuweiyi