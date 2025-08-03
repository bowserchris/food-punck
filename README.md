# 🥝🍌🦍🍌🍐 Food Punχ 🍎👊🐵👊🍎
![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript)

# 🥦 ¿Que es Food Punck? 🥦
Food Punck es una aplicacion donde usuarios pueden comparar precios entres sus fruterias/panaderias locales (e incluso supermercados) para ver donde esta la mejor oferta. Es una aplicacion para dar plataforma a los negocios locales y ayuda al ciudadno en vez de buscar la facil solucion conglomerado. Otras funciones seran agregados en su tiempo, miren al apartado [Futuras Mejoras](#futuras-mejoras-) para mas detalles.

### 🍎 ¿Porque Fruit Punχ? 👊

El nombre de la aplicación viene de la combinación **Fruit** y **Punk** con su explicación a continua :

- **Fruit / Food** : **Fruta / Alimentación**. Versiones futuras podrá comparar contra cualquier tipo de productos, no solo de comida.
- **Punk** : con '**k**' de kilo, empezó como un movimiento cultural a finales de los '70's. Gente de la movida punk normalmente iba en oposición o a contraria de los autoridades o lo que los punks mismos veían como lo 'establecido' o normal de su cultura. No solo en música y ropa, si no muchos aspectos de la vida. 
- **Punch** : con '**ch**' de churros, **Fruit Punch** es una bebida mezclada de varias frutas y azúcar con 'toque' (a veces fuerte) de alcohol, que se siente como un **punch** (puñetazo) del sabor intenso no esperado del alcohol.
- **Punck** : es una mezcla entre el **punk** y **punch**, influido por la letra **Chi χ** del alfabeto griego haciendo el sonido '**ch**' de '**k**' fuerte.

De ahí viene **Fruit Punχ**, 🍎👊, un puñetazo de frutas y ayuda no esperada!

**Punk** ademas normalmente se asocia a un futuro negativo/deprimente, por lo menos en lo mas conocido en la cultura popular como el **Cyber Punk** de **Blade Runner** (aunque es una estética chuilisima). 

Sin embargo con **Fruit Punχ** intentaremos enfocar en su actitud anti-sistema establecida y mas en contra de lo normal, porque aunque seas punk no quiere decir que eres anti sociable. Punks tienen sus propios grupos y inclusiones de intereses y nuestro interés es dar herramientas y plataformas al ciudadano y tienda local de Main Street contra el Wall Street, como el **Solar Punk** 🌞 a lo positividad de lo somos capaces en el futuro próximo.

### Tabla de Contenidos
- [Objetivos](#-objetivos-de-food-punck-)
- [Funcionalidades Principales](#-funcionalidades-principales-)
- [Flujo del app](#-flujo-de-food-punck-)
- [Arrancar el app](#-como-arrancar-el-app-como-programador-)
- [Futuras Mejoras](#-futuras-mejoras-)

# 🍅 Objetivos de Food Punck 🍅
El **Food Punck** es para que un usuario puede comparar precios/pesos entre varias tiendas locales (como fruterías y panaderías) e incluso supermercados. Las tiendas locales podrian ofrecer y notificar a usuarios de las ofertas o cambios de precios que tienen en sus locales, y asi evitar el desgaste de su producto. 

# 🍇 Funcionalidades principales 🍇
Las **funcionalidades principales** del app son:
- `Users` pueden comparar precios entre 2 productos de 2 tiendas diferentes (o mas)
- `Users` pueden buscar tiendas y productos por su nombre, código postal o por producto
- `Users` pueden dar rankings y reviews a tiendas por su servicio y calidad
- `Stores` pueden notificar usuarios de promociones y aplicarlos a productos

# 🍷 Flujo de Food Punck 🍷
1. **Food Punck** empezara con el [[#1. Login del Usuario y Tienda|Start Login]] y ira en 2 caminos
	1. Llegara al **Indice del Usuario** y decidirá que opción hacer:
		1. **Opción 1** - empezara la [[#2. Usuario buscando productos por nombre, tienda o codigo postal|Búsqueda de Products]] 
		2. **Opción 2** - mirara las [[#3. Usuario "siguiendo" una Tienda|Tiendas que sigue]] el **usuario**
			1. Si tiene **tiendas**, puede crear **reseñas** de ellos y ir a **opción 3**
		3. **Opción 3** - **usuario** [[#4. Usuario crea una reseña|crea reseñas]]
		4. **Opción 4** - **usuario** [[#5. Usuario crea una lista de productos|crea listas de productos]]
		5. **Opción 5**  - **usuario** revisa sus **resultados** y sino salta directo a **Opción 6** [[#6. Usuario compara productos|a comparar productos]]
		6. Si el **usuario** no tiene algo dentro de las **opciones 2-6**, va directo a [[#2. Usuario buscando productos por nombre, tienda o codigo postal|buscar productos]]
	2. Llegará al **Indice de la Tienda** y decidirá que opción hacer:
		1. **Opción 1** - la **tienda** puede [[#7. Tienda crea y añade productos a su inventario|crear y añadir productos]]  a su **inventario**
		2. **Opción 2** - la **tienda** puede [[#8. Tienda crea promociones y los aplica a productos|crear y añadir promociones]] a sus **productos**
		3. **Opción 3** - la **tienda** puede [[#9. Tienda hace notificaciones de sus productos|mandar notificaciones]] a **usuarios**
			1. Si no tiene **promociones** creados se redirige a [[#8. Tienda crea promociones y los aplica a productos|opción 2]]
		4. **Opción 4** - la **tienda** puede [[#10. Tienda revisa sus reseñas|revisar sus reseñas]] que le han hecho **usuarios**

# 🍕 Como arrancar el app como programador 🍕
Para desplegar el app en tu entorno local, utilizando los métodos por **IDE**, continue los siguientes pasos:
## Paso 1: Clonar el Repositorio 🐑
Primero, clona el repositorio desde **GitHub** con el comando `git clone <url>` y a continuación con el comando `cd <file/path` creas un directorio donde se almacena el repositorio:

```bash
git clone https://github.com/bowserchris/food-punck.git
cd food-punck
```

## ☕ Paso 2: Importar el Proyecto en el IDE ☕
Accede a tu **IDE** preferido y continue los siguientes pasos:
### 🌒 Eclipse 🌒

1. Abre **Eclipse**.
2. Ve a `File` -> `Import`.
3. Selecciona `Maven` -> `Existing Maven Projects`.
4. Haz clic en `Browse` y selecciona la carpeta del proyecto clonado (`food-punck`).
5. Haz clic en `Finish`.

### 🍋 IntelliJ IDEA 🍋

1. Abre **IntelliJ IDEA**.
2. Ve a `File` -> `New` -> `Project from Existing Sources`.
3. Selecciona la carpeta del proyecto clonado (`food-punck`).
4. Elije `Import project from external model` y selecciona `Maven`.
5. Haz clic en `Next`, luego en `Finish`.

### 🫘 NetBeans 🫘

1. Abre **NetBeans**.
2. Ve a `File` -> `Open Project...`.
3. Navega hasta la carpeta del proyecto clonado (`food-punck`) y selecciónala.
4. Haz clic en `Open`.

## 🍏 Paso 3: Configurar el Archivo `application.properties` 🍏
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

## 🛒 Paso 4: Crear la Base de Datos y Tablas 🛒

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

## 🥑 Paso 5: Configurar la Base de Datos en el IDE 🥑

### 🌒 Eclipse 🌒

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot App`).
3. En `Project`, selecciona tu proyecto (`food-punck`).
4. En `Main class`, asegúrate de que apunte al archivo principal de la aplicación Spring Boot.
5. En `VM arguments`, asegúrate de que no incluya opciones relacionadas con SSL.

### 🍋 IntelliJ IDEA 🍋

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot`).
3. En `Configuration tab`, selecciona tu proyecto (`food-punck`).
4. En `Environment variables`, asegúrate de que no incluya opciones relacionadas con SSL.

### 🫘 NetBeans 🫘

1. Ve a `Run` -> `Run Project`.

## Paso 6: Ejecutar la Aplicación 🍳

Después de configurar las opciones, ejecuta el proyecto:

### 🌒 Eclipse 🌒

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run As` -> `Java Application`.

### 🍋 IntelliJ IDEA 🍋

1. Haz clic derecho en el archivo principal de la aplicación Spring Boot.
2. Selecciona `Run 'MainClassName.main()'`.

### 🫘 NetBeans 🫘

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run Project`.

## 🍍 Paso 7: Acceder a la Aplicación 🍍

Una vez que la aplicación esté ejecutando, puedes acceder a ella a través del navegador web de tu elección (Como Firefox, Brave, etc.):

```
http://localhost:9090
```

Si has cambiado el puerto en el archivo `application.properties`, utiliza ese puerto en lugar de 9090. Te debería llevar al indice principal del html del proyecto en:

```
https://localhost:9090/foodPunk
```

# 🧅 Futuras Mejoras 🧅

Aqui esta una lista de futuras mejoras, y tambien sirve para mapa de futuro contenido, para facilitar el uso y flexibilidad de la aplicacion:

- [ ]
