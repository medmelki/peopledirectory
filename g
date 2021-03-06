[1mdiff --git a/target/classes/log4j.properties b/target/classes/log4j.properties[m
[1mdeleted file mode 100644[m
[1mindex 1dba1c1..0000000[m
[1m--- a/target/classes/log4j.properties[m
[1m+++ /dev/null[m
[36m@@ -1,42 +0,0 @@[m
[31m-[m
[31m-# Define the root logger with appender[m
[31m-log4j.rootLogger=debug, stdout, peopledirectory[m
[31m-[m
[31m-[m
[31m-# Vider le fichier log a chaque demarrage de l'application[m
[31m-log4j.appender.rollingFile.Append=false[m
[31m-[m
[31m-# Define the appenders[m
[31m-# appender for console[m
[31m-log4j.appender.stdout=org.apache.log4j.ConsoleAppender [m
[31m-[m
[31m-# appender for the log file[m
[31m-log4j.appender.peopledirectory=org.apache.log4j.RollingFileAppender[m
[31m-# path to the log file[m
[31m-log4j.appender.peopledirectory.File=./logs/test.log[m
[31m-[m
[31m-# Define the layouts[m
[31m-log4j.appender.stdout.layout=org.apache.log4j.PatternLayout[m
[31m-log4j.appender.peopledirectory.layout=org.apache.log4j.PatternLayout[m
[31m-[m
[31m-[m
[31m-log4j.appender.stdout.layout.conversionPattern= [peopledirectory Message][%-5p] : %m%n[m
[31m-# pattern - ex : 2000-09-07 14:07:41,508 [main] INFO  launcher - Entering application.[m
[31m-#log4j.appender.peopledirectory.layout.ConversionPattern=%d [%t] %-5p %c - %m%n[m
[31m-log4j.appender.peopledirectory.layout.ConversionPattern=%d [%-5p]- %m%n[m
[31m-[m
[31m-[m
[31m-log4j.appender.peopledirectory.MaxFileSize=100KB[m
[31m-# Keep 5 backup file[m
[31m-log4j.appender.peopledirectory.MaxBackupIndex=1[m
[31m-[m
[31m-[m
[31m-# Desactiver les messages de logging de Quartz Scheduler[m
[31m-#log4j.logger.org.springframework=OFF[m
[31m-[m
[31m-[m
[31m-# Definition des niveaux [m
[31m-# Memo : DEBUG < INFO < WARN < ERROR < FATAL[m
[31m-#log4j.logger.org.peopledirectory=debug[m
[31m-[m
[31m-# end[m
\ No newline at end of file[m
[1mdiff --git a/target/maven-archiver/pom.properties b/target/maven-archiver/pom.properties[m
[1mdeleted file mode 100644[m
[1mindex a7be664..0000000[m
[1m--- a/target/maven-archiver/pom.properties[m
[1m+++ /dev/null[m
[36m@@ -1,5 +0,0 @@[m
[31m-#Generated by Maven[m
[31m-#Sat Jul 18 20:46:19 GMT+01:00 2015[m
[31m-version=1.0[m
[31m-groupId=org.kapit[m
[31m-artifactId=peopledirectory[m
[1mdiff --git a/target/peopledirectory/WEB-INF/classes/log4j.properties b/target/peopledirectory/WEB-INF/classes/log4j.properties[m
[1mdeleted file mode 100644[m
[1mindex 1dba1c1..0000000[m
[1m--- a/target/peopledirectory/WEB-INF/classes/log4j.properties[m
[1m+++ /dev/null[m
[36m@@ -1,42 +0,0 @@[m
[31m-[m
[31m-# Define the root logger with appender[m
[31m-log4j.rootLogger=debug, stdout, peopledirectory[m
[31m-[m
[31m-[m
[31m-# Vider le fichier log a chaque demarrage de l'application[m
[31m-log4j.appender.rollingFile.Append=false[m
[31m-[m
[31m-# Define the appenders[m
[31m-# appender for console[m
[31m-log4j.appender.stdout=org.apache.log4j.ConsoleAppender [m
[31m-[m
[31m-# appender for the log file[m
[31m-log4j.appender.peopledirectory=org.apache.log4j.RollingFileAppender[m
[31m-# path to the log file[m
[31m-log4j.appender.peopledirectory.File=./logs/test.log[m
[31m-[m
[31m-# Define the layouts[m
[31m-log4j.appender.stdout.layout=org.apache.log4j.PatternLayout[m
[31m-log4j.appender.peopledirectory.layout=org.apache.log4j.PatternLayout[m
[31m-[m
[31m-[m
[31m-log4j.appender.stdout.layout.conversionPattern= [peopledirectory Message][%-5p] : %m%n[m
[31m-# pattern - ex : 2000-09-07 14:07:41,508 [main] INFO  launcher - Entering application.[m
[31m-#log4j.appender.peopledirectory.layout.ConversionPattern=%d [%t] %-5p %c - %m%n[m
[31m-log4j.appender.peopledirectory.layout.ConversionPattern=%d [%-5p]- %m%n[m
[31m-[m
[31m-[m
[31m-log4j.appender.peopledirectory.MaxFileSize=100KB[m
[31m-# Keep 5 backup file[m
[31m-log4j.appender.peopledirectory.MaxBackupIndex=1[m
[31m-[m
[31m-[m
[31m-# Desactiver les messages de logging de Quartz Scheduler[m
[31m-#log4j.logger.org.springframework=OFF[m
[31m-[m
[31m-[m
[31m-# Definition des niveaux [m
[31m-# Memo : DEBUG < INFO < WARN < ERROR < FATAL[m
[31m-#log4j.logger.org.peopledirectory=debug[m
[31m-[m
[31m-# end[m
\ No newline at end of file[m
[1mdiff --git a/target/peopledirectory/WEB-INF/web.xml b/target/peopledirectory/WEB-INF/web.xml[m
[1mdeleted file mode 100644[m
[1mindex 7032961..0000000[m
[1m--- a/target/peopledirectory/WEB-INF/web.xml[m
[1m+++ /dev/null[m
[36m@@ -1,38 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8"?>[m
[31m-<!-- This web.xml file is not required when using Servlet 3.0 container, [m
[31m-	see implementation details http://jersey.java.net/nonav/documentation/latest/jax-rs.html -->[m
[31m-<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"[m
[31m-	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"[m
[31m-	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">[m
[31m-[m
[31m-	<display-name>peopledirectory</display-name>[m
[31m-[m
[31m-	<filter>[m
[31m-		<filter-name>CorsFilter</filter-name>[m
[31m-		<filter-class>org.apache.catalina.filters.CorsFilter</filter-class>[m
[31m-	</filter>[m
[31m-	[m
[31m-	<filter-mapping>[m
[31m-		<filter-name>CorsFilter</filter-name>[m
[31m-		<url-pattern>/*</url-pattern>[m
[31m-	</filter-mapping>[m
[31m-[m
[31m-	<servlet>[m
[31m-		<servlet-name>Jersey Web Application</servlet-name>[m
[31m-		<servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>[m
[31m-		<init-param>[m
[31m-			<param-name>jersey.config.server.provider.packages</param-name>[m
[31m-			<param-value>org.kapit.peopledirectory.webservices</param-value>[m
[31m-		</init-param>[m
[31m-		<load-on-startup>1</load-on-startup>[m
[31m-	</servlet>[m
[31m-	[m
[31m-	<servlet-mapping>[m
[31m-		<servlet-name>Jersey Web Application</servlet-name>[m
[31m-		<url-pattern>/rest/*</url-pattern>[m
[31m-	</servlet-mapping>[m
[31m-[m
[31m-	<welcome-file-list>[m
[31m-		<welcome-file>index.jsp</welcome-file>[m
[31m-	</welcome-file-list>[m
[31m-</web-app>[m
\ No newline at end of file[m
[1mdiff --git a/target/peopledirectory/index.jsp b/target/peopledirectory/index.jsp[m
[1mdeleted file mode 100644[m
[1mindex ad35a26..0000000[m
[1m--- a/target/peopledirectory/index.jsp[m
[1m+++ /dev/null[m
[36m@@ -1,12 +0,0 @@[m
[31m-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"[m
[31m-         pageEncoding="ISO-8859-1"%>[m
[31m-<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">[m
[31m-<html>[m
[31m-<head>[m
[31m-    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">[m
[31m-    <title>people directory d&eacute;ploy&eacute;</title>[m
[31m-</head>[m
[31m-<body>[m
[31m-Les services web de people directory sont en attente d'invocation.[m
[31m-</body>[m
[31m-</html>[m
\ No newline at end of file[m
