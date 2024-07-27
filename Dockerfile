#PLATFORMS="linux/arm64,linux/amd64"
#REGISTRY=xxx
#TAG=mTLS101-stub:multiarch
#docker buildx build . --progress=plain --platform $PLATFORMS -t $REGISTRY/$TAG --push

ARG API_PORT=8080

FROM --platform=$BUILDPLATFORM gradle:8.8-jdk21 AS build
ARG TARGETPLATFORM
ARG BUILDPLATFORM
RUN echo " :::::::::::::::::::: Running on $BUILDPLATFORM, building for $TARGETPLATFORM ::::::::::::::::::::"
WORKDIR /home/gradle/mTLS101
COPY --chown=root:root --chmod=755 src src/
COPY --chown=root:root --chmod=755 settings.gradle.kts settings.gradle.kts
COPY --chown=root:root --chmod=755 build.gradle.kts build.gradle.kts
RUN gradle --no-daemon

FROM amazoncorretto:21-al2023
# Alternative base images:
# * amazoncorretto:21-alpine
# * alpine/java:21-jdk
ARG API_PORT
ARG TARGETPLATFORM
ARG BUILDPLATFORM
EXPOSE ${API_PORT}

RUN echo " :::::::::::::::::::: Running on $BUILDPLATFORM, building for $TARGETPLATFORM ::::::::::::::::::::"
RUN mkdir /mTLS101
RUN chown 1000:1000 -R /mTLS101
USER 1000:1000

COPY --from=build /home/gradle/mTLS101/build/libs/*.jar /mTLS101/mTLS101.jar
WORKDIR /mTLS101
ENTRYPOINT ["java", "-jar", "/mTLS101/mTLS101.jar"]
