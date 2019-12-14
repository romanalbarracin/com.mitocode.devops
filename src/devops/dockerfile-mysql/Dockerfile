FROM mysql:5.7.25

ENV MYSQL_ROOT_PASSWORD=sistemas
ENV MYSQL_ROOT_DATABASE=devopsbd
ENV MYSQL_ROOT_HOST=%

COPY ./scripts/ /docker-entrypoint-initdb.d/
#ENTRYPOINT [ "executable" ]
CMD ["--default-authentication-plugin=mysql_native_password"]
