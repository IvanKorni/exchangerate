FROM maslick/minimalka:jdk11

EXPOSE 8080

RUN mkdir ./app

COPY ./exrate-0.0.1.jar ./app

CMD java -jar ./app/exrate-0.0.1.jar