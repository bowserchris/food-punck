# 🍎🍌🦍🍌🍎 Food Punck 🥝👊🐵👊🍐
A price comparator app for local stores

Para desplegar el app en tu entorno local, utilizando los métodos por **IDE**, continue los siguientes pasos:
## Paso 1: Clonar el Repositorio
Primero, clona el repositorio desde **GitHub** con el comando `git clone <url>` y a continuación con el comando `cd <file/path` creas un directorio donde se almacena el repositorio:

```bash
git clone https://github.com/bowserchris/food-punck.git
cd food-punck
```

## Paso 2: Importar el Proyecto en el IDE
Accede a tu **IDE** preferido y continue los siguientes pasos:
### Eclipse

1. Abre **Eclipse**.
2. Ve a `File` -> `Import`.
3. Selecciona `Maven` -> `Existing Maven Projects`.
4. Haz clic en `Browse` y selecciona la carpeta del proyecto clonado (`food-punck`).
5. Haz clic en `Finish`.

### IntelliJ IDEA

1. Abre **IntelliJ IDEA**.
2. Ve a `File` -> `New` -> `Project from Existing Sources`.
3. Selecciona la carpeta del proyecto clonado (`food-punck`).
4. Elije `Import project from external model` y selecciona `Maven`.
5. Haz clic en `Next`, luego en `Finish`.

### NetBeans

1. Abre **NetBeans**.
2. Ve a `File` -> `Open Project...`.
3. Navega hasta la carpeta del proyecto clonado (`food-punck`) y selecciónala.
4. Haz clic en `Open`.

## Paso 3: Configurar el Archivo `application.properties`
En cuanto tienes el proyecto importado en tu **IDE**, busca y abre el fichero `application.properties` y cambie/añade los siguientes campos:
### Atributos a Cambiar

1. **spring.datasource.url**: Asegúrate de que la **URL** de la base de datos sea correcta.
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fruit_punk
```
Si tu BBDD de **MySQL** no esta configurado de otra manera, por defecto sera en `localhost:3306`, y si no, cambia el puerto `3306` al que tienes configurado en tu perfil de MySQL. 
Lo que sigue después de ello `/fruit_punk` es el nombre del schema que tendrá el model de **MySQL**, a menos que lo cambies por otro al crear el schema en tu BBDD.

2. **spring.datasource.username** y **spring.datasource.password**: Asegúrate de que el nombre de usuario y la contraseña sean correctos a tu perfil.
```properties
spring.datasource.username=<PON AQUI TU PERFIL MYSQL>
spring.datasource.password=<CONTRASEÑA DE TU PERFIL MYSQL
```

3. **server.port**: Cambia el puerto si es necesario y no ocupado por otro programa, por ejemplo, a 9090.
```properties
server.port=9090
```

4. **server.ssl.enabled**: Desactiva la configuración SSL si no es necesaria.
```properties
server.ssl.enabled=false
```

## Paso 4: Crear la Base de Datos y Tablas

Asegúrate de que tienes una base de datos **MySQL** instalada y ejecuta el siguiente comando en tu terminal de **OS** para crear la base de datos y tablas:

```bash
mysql -u <AQUI PON TU USUARIO> -p <AQUI TU CONTRASEÑA>
```

El comando de arriba debería activar el shell y terminal de **MySQL** y podrás interactuar con ellos directamente. Si prefieres un **GUI** (Graphical User Interface) también hay **MySQL-Workbench** y ejecutas los siguientes comando en un nuevo script.

En el shell de **MySQL**, ejecuta los siguientes comandos:

```sql
CREATE DATABASE fruit_punk;
USE fruit_punk;

-- Ejecuta los scripts SQL en resources/mysql/createSchema.sql dentro de la carpeta del proyecto para crear las tablas
SOURCE /src/main/resources/mysql/createSchema.sql
SOURCE /src/main/resources/mysql/insertTestData.sql
```

## Paso 5: Configurar la Base de Datos en el IDE

### Eclipse

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot App`).
3. En `Project`, selecciona tu proyecto (`food-punck`).
4. En `Main class`, asegúrate de que apunte al archivo principal de la aplicación Spring Boot.
5. En `VM arguments`, asegúrate de que no incluya opciones relacionadas con SSL.

### IntelliJ IDEA

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot`).
3. En `Configuration tab`, selecciona tu proyecto (`food-punck`).
4. En `Environment variables`, asegúrate de que no incluya opciones relacionadas con SSL.

### NetBeans

1. Ve a `Run` -> `Run Project`.

## Paso 6: Ejecutar la Aplicación

Después de configurar las opciones, ejecuta el proyecto:

### Eclipse

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run As` -> `Java Application`.

### IntelliJ IDEA

1. Haz clic derecho en el archivo principal de la aplicación Spring Boot.
2. Selecciona `Run 'MainClassName.main()'`.

### NetBeans

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run Project`.

## Paso 7: Acceder a la Aplicación

Una vez que la aplicación esté ejecutando, puedes acceder a ella a través del navegador web de tu elección (Como Firefox, Brave, etc.):

```
http://localhost:9090
```

Si has cambiado el puerto en el archivo `application.properties`, utiliza ese puerto en lugar de 9090. Te debería llevar al indice principal del html del proyecto en:

```
https://localhost:9090/food-punck

o

https://localhost:9090/food-punck.html
```
