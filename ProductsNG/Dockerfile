FROM node:10.16-alpine as frontbuild
WORKDIR /usr/src/app
RUN npm install -g @angular/cli \
    && npm cache clean --force
COPY . /usr/src/app
RUN ng build --prod

FROM node:10.16-alpine
LABEL maintainer="jgaviri8@gmail.com"
RUN apk add --update tini \
    && npm install http-server -g
WORKDIR /app
COPY --from=frontbuild /usr/src/app/dist/ProductsNG/ .
EXPOSE 80
ENTRYPOINT ["/sbin/tini", "--", "http-server", "-p", "80"]
