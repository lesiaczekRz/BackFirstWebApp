FROM openjdk:11-bullseye
RUN useradd -u 1000 -ms /bin/bash spring
RUN mkdir /mnt/DockerVolume
RUN apt update && apt install -y postgresql-client
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","app.BackFirstWebAppApplication"]