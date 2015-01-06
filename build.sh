~/apache-tomcat-7.0.37/bin/shutdown.sh
mvn clean package
rm -rf ~/apache-tomcat-7.0.37/webapps/cabz
cp target/cabz.war ~/apache-tomcat-7.0.37/webapps/
~/apache-tomcat-7.0.37/bin/catalina.sh jpda run
