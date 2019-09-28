FROM node:10.16-alpine as frontbuild
WORKDIR /usr/src
RUN npm install -g @angular/cli@8.3.5 \
    && npm cache clean --force \
    && ng new ProductsNG --routing=true --style=css --skipGit=true \
    && rm -rf ProductsNG/src/app/
COPY ./src/app /usr/src/ProductsNG/src/app
WORKDIR /usr/src/ProductsNG
RUN ng build --prod

FROM node:10.16-alpine
LABEL maintainer="jgaviri8@gmail.com"
RUN apk add --update tini \
    && npm install http-server -g
WORKDIR /app
COPY --from=frontbuild /usr/src/ProductsNG/dist/ProductsNG/ .
EXPOSE 80
ENTRYPOINT ["/sbin/tini", "--", "http-server", "-p", "80"]
