# peopledirectory
The project is a web application of a people directory manager. 

# Installation 

## Step 1 : install *mongoDB* 

Follow this documentation : http://docs.mongodb.org/manual/installation/

## Step 2 : launch *mongoDB*

launch `mongod` command under *$mongodb_folder/bin*

## Step 2 : download *Tomcat server* last version (7.0.63) 

Follow this link : https://tomcat.apache.org/download-70.cgi

## Step 3 : clone the project

## Step 4 : build the project 

Build the project with `mvn clean install` 

## Step 5 : copy the war package 
Copy the war package peopledirectory.war to the folder *$apache-tomcat_home/webapps*

## Step 6 : start *tomcat* server

execute `startup` command located in *$apache-tomcat_home/bin*

## Step 7 : compile and execute the file *DataGenerator.java* 

File location in GitHub : https://github.com/medmelki/peopledirectory/blob/master/src/main/java/org/kapit/peopledirectory/DataGenerator.java

This step generates static data into the database.

# Rest API is now reachable under www.localhost:8080/peopledirectory/rest

