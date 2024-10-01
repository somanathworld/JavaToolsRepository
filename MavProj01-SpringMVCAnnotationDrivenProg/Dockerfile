FROM tomcat

copy . /usr/local/tomcat/webapps/

EXPOSE 8080

RUN sed -i '/<\/Context>/ i <Resource auth="Container"		\
driverClassName="org.postgresql.Driver" maxIdle="10"	\
maxTotal="100" maxWaitMillis="90000" name="DsJndi"		\
password="kH8fC2jbujF1aSUjaJNByWqWDxXXpy3z" type="javax.sql.DataSource" \
url="jdbc:postgresql://dpg-crf9c4lds78s73cj7edg-a.oregon-postgres.render.com:5432/empdb_8dzd" username="empdb_8dzd_user"/> \
' /usr/local/tomcat/conf/context.xml

CMD ["catalina.sh" , "run"]
