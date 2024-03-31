#Dockerfile para dockerização da aplicação Spring com java 17
FROM openjdk:17.0.2-jdk-slim

RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir -p ./usr/src/app

WORKDIR ./usr/src/app

COPY ./target/*.jar ./

COPY entrypoint.sh ./

## Instalação do DOCKERIZE, usado para aguardar outro container subir (dependencia, SQL SERVER)
ENV DOCKERIZE_VERSION v0.7.0
RUN wget -O - https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz | tar xzf - -C /usr/local/bin \
    && apt-get autoremove -yqq --purge wget && rm -rf /var/lib/apt/lists/*

EXPOSE 8082

ENTRYPOINT ["./entrypoint.sh"]