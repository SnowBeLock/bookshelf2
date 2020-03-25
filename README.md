# Bookshelf

## Project Setup

### Configuration
1. Create project (simple java). Project Name:bookshelf
2. Create project structure:
    
    src\main\java
    
    package: lv.itlat.bookshelf
   
    src\main\resources\META-INF\persistence.xml
    
    src\main\resources\META-INF\beans.xml
    
```
    <?xml version="1.0" encoding="UTF-8"?>

    <beans xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/beans_2_0.xsd"
       bean-discovery-mode="all" version="2.0">
    </beans>

``` 
   
   src\main\webapp\WEB-INF\web.xml
   
    
3. Copy .mvn and mvnw.cmd to bookshelf directory
4. Copy pom.xml to bookshelf directory

### GIT Configuration
Open your http://github.com

Login and create Repository with name bookshelf

Open cmd:

>bookshelf>git init
>
>git remote add origin https://github.com/yourname/bookshelf.git 
>

PUSH to GIT and check on your repository

### Database confogiration
Open cmd for database:
> 
>

### TomEE configuration
Open tomee.xml
and add:



```
<Resource id="jdbc/bookshelfDB" type="DataSource">
        JdbcDriver org.hsqldb.jdbc.JDBCDriver
        JdbcUrl jdbc:hsqldb:hsql://localhost:9001/Bookshelf
        UserName sa
        Password
    </Resource>
```
### Persistence Unit
persistence.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        version="2.1"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="bookshelfPU" transaction-type="JTA">
        <jta-data-source>jdbc/bookshelfDB</jta-data-source>
        <properties>
            <property name="javax.persistence.schema-generation.database.action" value="create"/>
<!--            <property name="javax.persistence.sql-load-script-source" value="META-INF/data.sql"/>-->
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```


### UI Headers

```
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets" 
      xmlns:f="http://xmlns.jcp.org/jsf/core">

</html>
```

# Run Bookshelf application

Steps:
1. Checkout project from current repository.
2. Property in persistence.xml must be 

```
<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
```

It's necessary for first run to delete and create new tables. 

Others run could be:
```
<property name="javax.persistence.schema-generation.database.action" value="create"/>
````

3. Run TomEE from IDEA configuration
4. Will be available Login and Registration Buttons on header.
5. Please register a user (just fill form with correct data)
6. Then will be available Login form. Log in with already registered user.
7. You can Create Book and View a list of books.
8. When Book was created, then you can open Manage Reservation. 





