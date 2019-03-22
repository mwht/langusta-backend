FROM tomcat:8.5.38-alpine
VOLUME /usr/local/tomcat/webapps
ADD target/langusta-backend-0.1.0.war webapps/langusta-backend.war
RUN bash -c 'touch /langusta-backend.war'