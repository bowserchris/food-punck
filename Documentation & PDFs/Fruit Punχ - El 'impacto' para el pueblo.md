![[Solarpunk9 3.png]]

Version Documento: v3
Fecha Actualización: 31/07/2025
Autor: Christian James Parry Bowser
Resumen: Aplicacion para comparar precios entre productos y sus tiendas, recomendando mejor sitio. 


## Tabla de Contenido

- Portada y Titulo
- Tabla de Contenido
1. Introducción
	- ¿Porque Fruit Punχ?
2. Descripción del Proyecto
	- Objetivos del Proyecto
	- Funcionalidades Principales
	- Publico Objetivo
3. Planificación
	- Crono-grama de desarrollo
	- Requisitos Funcionales y no Funcionales
		- Funcional
			- Usuario
			- Tienda
		- No Funcional
	- Estimación de Tiempo y Recursos Necesarios
4. Análisis y Diseño
	- Diagramas de Flujo y UML
		- Diagramas de Flujo del Back-end
			- Login
			- Búsqueda Usuario
			- Usuario y sus Tiendas
			- Usuario y sus Reseñas
			- Usuario y sus Productos
			- Usuario y sus Comparaciones
			- Tienda y su Inventario
			- Tienda y sus Promociones
			- Tienda y sus notificaciones
			- Tienda y sus reseñas de usuarios
			- Flowchart de todos Procesos Resumido
			- El Flow del Programa (en texto)
		- Diagrama UML del Base de Datos en MySQL
			- Nomenclatura del BBDD
		- Diagrama UML de Java Back-end
			- Nomenclatura del Back-End
	- Diseño de la Arquitectura General y de la Base de Datos
5. Implementacion
	- Descripción detallada de las Herramientas y tecnologías utilizadas
		- Eclipse IDE
		- GitHub
		- Obsidian
		- Ollama
			- Qwen2.5-Coder
			- OpenWebUI
			- Docker
		- Java OpenJDK v21.0.8
		- Lombok v1.18.38
		- Spring-boot v3.5.3
			- spring-boot-starter-data-jpa
			- spring-boot-starter-jdbc
			- spring-boot-starter-web
			- mysql-connector-j
			- spring-boot-starter-test
			- spring-boot-starter-thymeleaf
			- spring-boot-starter-security
			- springdoc-openapi-starter-webmvc-ui
	- Explicación del Código y de los servicios implementados
		- El Flow del Programa
		- Estructura de los Objetos
	- Capturas de Pantalla de la Interfaz
		- Store Controller Directo
		- User Controller Directo
		- Fruit Punχ con HTML y CSS
		- Fruit Punχ llamando al Controller y Errores
6. Pruebas
	- Plan de Pruebas y Resultados
		- Pruebas Unitarias
			- Prueba Unitaria 1: Prueba de Conexión Inicial con Back-end
			- Prueba Unitaria 2: Prueba de Repositorio Product
			- Prueba Unitaria 3: Prueba de Repositorio User
			- Prueba Unitaria 4: Prueba del Controller User # 1
			- Prueba Unitaria 5: Prueba del Controller User # 2
			- Prueba Unitaria 6: Prueba del Controller Store
		- Pruebas de Integración
			- Prueba de Integración 1: Prueba del Flujo Completo de Comparación de Productos
			- Prueba de Integración 2: Prueba del Flujo Completo de Registro de Usuario
	- Casos de Prueba y su Documentación
		- Prueba Unitaria 1: Prueba de Conexión Inicial documentada
		- Prueba Unitaria 4: Prueba del Controller User # 1 documentada
		- Prueba Unitaria 5: Prueba del Controller User # 2 documentada
7. Despliegue
	- Instrucciones para desplegar la aplicación en un entorno local y configuraciones necesarias
		- Paso 1: Clonar Repositorio
		- Paso 2: Importar Proyecto en el IDE
			- Eclipse
			- IntelliJ Idea
			- Netbeans
		- Paso 3: Configurar el Archivo application.properties
			- Atributos a Cambiar
		- Paso 4: Crear la Base de Datos y Tablas
		- Paso 5: Configurar la Base de Datos en el IDE
			- Eclipse
			- IntelliJ Idea
			- Netbeans
		- Paso 6: Ejecutar la Aplicacion			
			- Eclipse
			- IntelliJ Idea
			- Netbeans
			- Paso 7: Acceder a la Aplicación
8. Mantenimiento
	- Plan para Mejoras Futura y Actualizaciones Recomendadas
		- Mejoras o Actualizaciones Inmediatas para Fruit Punχ v1
		- Version 2 - Incorporar Recipe
		- Version 3 - Incorporar Images y PhotoInterface
9. Manual de Usuario
	- Propósito y Alcance
	- Conocimientos Previos Necesarios
	- Requisitos Tecnicos
	- Politicas de Seguridad
	- Inicio de Sesion
	- Mapa de Navegacion
	- Descripcion de funcionalidades
		- Funcionalidades de Usuario
		- Funcionalidades de Tienda
	- Soporte Tecnico
	- Solucion de Problemas Comunes
	- Contacto

## Introducción

Esto es la documentación del Proyecto Final de Desarrollo de una Aplicación con Enfoque en Back-end **UF2406 del Ironhack - *Fruit Punχ***. Un app diseñado para comparar precios de productos en tiendas locales y ver cual es la mejor oferta. 

### ¿Porque Fruit Punχ? 

El nombre de la aplicación viene de la combinación **Fruit** y **Punk** con su explicación a continua :

- **Fruit / Food** : **Fruta / Alimentación**. Versiones futuras podrá comparar contra cualquier tipo de productos, no solo de comida.
- **Punk** : con '**k**' de kilo, empezó como un movimiento cultural a finales de los '70's. Gente de la movida punk normalmente iba en oposición o a contraria de los autoridades o lo que los punks mismos veían como lo 'establecido' o normal de su cultura. No solo en música y ropa, si no muchos aspectos de la vida. 
- **Punch** : con '**ch**' de churros, **Fruit Punch** es una bebida mezclada de varias frutas y azúcar con 'toque' (a veces fuerte) de alcohol, que se siente como un **punch** (puñetazo) del sabor intenso no esperado del alcohol.
- **Punck** : es una mezcla entre el **punk** y **punch**, influido por la letra **Chi χ** del alfabeto griego haciendo el sonido '**ch**' de '**k**' fuerte.

De ahí viene **Fruit Punχ**, 🍎👊, un IMPACTO de frutas y ayuda no esperada!

**Punk** ademas normalmente se asocia a un futuro negativo/deprimente, por lo menos en lo mas conocido en la cultura popular como el **Cyber Punk** de **Blade Runner** (aunque es una estética chuilisima). 

![[Blade-Runner-Cityscape 1.webp]]

Sin embargo con **Fruit Punχ** intentaremos enfocar en su actitud anti-sistema establecida y mas en contra de lo normal, porque aunque seas punk no quiere decir que eres anti sociable. Punks tienen sus propios grupos y inclusiones de intereses y nuestro interés es dar herramientas y plataformas al ciudadano y tienda local de Main Street contra el Wall Street, como el **Solar Punk** 🌞 a lo positividad de lo somos capaces en el futuro próximo.

![[Solarpunk9 2.png]]


## 1. Descripción del Proyecto

### Objetivos del proyecto
El **objetivo del proyecto** es para que un usuario puede comparar precios/pesos entre varios sitios de tiendas locales (como fruterías y panaderías) e incluso supermercados para ver donde cual lleva la mejor oferta. 
### Funcionalidades principales
Las **funcionalidades principales** del app son:
- `Users` pueden comparar precios entre 2 productos de 2 tiendas diferentes (o mas)
- `Users` pueden buscar tiendas y productos por su nombre, código postal o por producto
- `Users` pueden dar rankings y reviews a tiendas por su servicio y calidad
- `Stores` pueden notificar de promociones y aplicarlos a productos
### Público objetivo.
El objetivo público serian 2 grupos en particular:
1. **Ciudadanos locales** que buscarían las mejores tiendas y mejores ofertas. De esta manera:
	- Pueden tener una idea clara de como es el mercado local
	- Podrán ver si por la cantidad ganan mas que el precio individual
	- Pueden apoyar a las tiendas locales en vez de los supermercados y tiendas corporativas
2. **Tiendas locales** podrán utilizar la plataforma:
	- En vez de crear su propia pagina web individual, que cuesta tiempo, dinero y habilidad, podrá haber un sitio central para que las tiendas y usuarios pueden revisar y comparar entre todos. 
	- Da una vista amplia a las tiendas locales a clientes nuevos, de esta manera podrán defenderse de los monopolios corporativas que dominan acceso a clientes por su nombre corporativo.
	- Promocionar productos cerca de caducidad
	- Promocionar ofertas distintas
	- Desglosar si son productos locales
	- Desglosar si son productos ecológicos

## 2. Planificación

### Crono-grama de desarrollo

![[Project Schedule 1.png]]

En bloques generales, la foto de arriba enseña el tiempo de desarrollo del proyecto en varios partes.
1. **Fase Inicial** (1 o 2 días):
	1. Planning del Proyecto entero
	2. Documentación necesaria para el proyecto
	3. Diagramas UML de MySQL y Java
2. **Fase Principal** (5 días):
	1. Crear el base de datos en MySQL
	2. Crear el back-end en Java Spring-boot
	3. Crear el front-end (básico)
	4. Usar metodología TDD para el testing en el proceso
3. **Fase Final** (1 o 2 días):
	1. Finalizar la documentación a entregar

### Requisitos funcionales y no funcionales
Hay varios funciones necesarios dependiendo de si es un `User` o un `Store` que veremos a continuación:

#### Funcional
##### Usuario
- [ ] El `User` puede crear una comparación entre 2 `Product`'s
- [ ] El `User` puede crear una lista de un `Store` y de otra. De ahí puede comparar las 2 listas juntas con los productos elegidos de cada tienda (también importar una lista en CSV)
- [ ] El `User` puede 'seguir' un `Store`
- [ ] El `User` puede buscar por `Product`, `Store`, código postal o una combinación de los 3
- [ ] El `User` puede dar `Review`'s y rankings a `Store`'s por su servicio y calidad de productos
##### Tienda
- [ ] `Store` puede crear `Product` para su inventario
- [ ] `Store` puede crear `Promotion` para sus `Product`'s
- [ ] `Store` puede aplicar descuentos a sus `Product`'s
- [ ] `Store` puede dar categorías a sus `Product`'s y `Store` (si su proveedor es local, si el producto es ecológico, etc)

#### No Funcional
- [ ] La aplicación se enciende sin ningún error
- [ ] Los trayectos de todos los enlaces URL funcionan sin error 404
- [ ] Disponibilidad del sistema - ver que la conexión no se corta en un tramite
- [ ] Autorización por cada cuenta es correcta - registrar y login como usuario correcto

### Estimación de tiempo y recursos necesarios
El desarrollo del proyecto en total debería tardar 1 semana o semana y medio en desarrollarse. Hay 3 fases, como fue mencionado en [[#Crono-grama de desarrollo]]:

1. 1 o 2 días para la **Fase Inicial**, sobre el planning del proyecto
2. 5 días para la **Fase Principal**, sobre el desarrollo principal de la aplicación y testing
3. 1 o 2 días para **Fase Final**, seria finalizar la documentación necesaria

Los **recursos** utilizados para diseñar el proyecto son:

- **Eclipse IDE** - [software](https://eclipseide.org/) para escribir el código
- **GitHub** - control de versiones y repositorio para el [proyecto](https://github.com/bowserchris/food-punck)
- **Obsidian** - [software](https://obsidian.md/) para escribir la documentación en markdown y convertirlo en PDF o imágenes necesarios
- **Ollama** -  Servicio y [API local](https://ollama.com/) para utilizar LLM's en propio portátil en vez del cloud
	- **Qwen2.5-Coder** - [Modelo](https://ollama.com/library/qwen2.5-coder) utilizado para dudas y explicaciones. Ahora en [v3](https://github.com/QwenLM/Qwen3-Coder)
	- **OpenWebUi** - [GUI](https://openwebui.com/) bonita para comunicar con LLM en vez de la consola
	- **Docker** - [software](https://www.docker.com/) para poder implementar y conectar entre el GUI y LLM
- **Java OpenJDK v21.0.8** - [version](https://openjdk.org/projects/jdk/24/) de Java para el proyecto
- **Lombok v1.18.38** - librería externa para automatizar código - [enlace](https://projectlombok.org/download)
- **Spring-boot v3.5.3** - [framework](https://spring.io/projects/spring-boot) para aplicación web de Java
- **Spring-boot Dependencias**:
	- *spring-boot-starter-data-jpa* / para utilizar JPA repositorios con MySQL
	- *spring-boot-starter-jdbc* / para conexiones de BBDD
	- *spring-boot-starter-web* / para crear conexiones de internet con el app
	- *mysql-connector-j* / para poder comunicar con BBDD MySQL
	- *spring-boot-starter-test* / para poder hacer clases de testing
	- *spring-boot-starter-thymeleaf* / para poder visualizer HTML y CSS
	- *spring-boot-starter-security* / para implementar seguirdad y HTTPS
	- *springdoc-openapi-starter-webmvc-ui* / para documentar el codigo


## 3. Análisis y Diseño

### Diagramas de flujo y UML 

#### Diagramas de Flujo del Backend
A continuación son los procesos principales que debe hacer el programa en diagramas de flujo. Al final de todos es un resumen de todos los flowcharts juntos:
##### 1. Login del Usuario y Tienda
![[1 User and Store Login Flowchart.png]]
##### 2. Usuario buscando productos por nombre, tienda o código postal
![[2 User Search Flowchart.png]]
##### 3. Usuario "siguiendo" una Tienda
![[3 User Follow Store Flowchart.png]]
##### 4. Usuario crea una reseña
![[4 User Create Review Flowchart.png]]
##### 5. Usuario crea una lista de productos
![[5 User Create Product List Flowchart.png]]
##### 6. Usuario compara productos
![[6 User Compares Products Flowchart.png]]
##### 7. Tienda crea y añade productos a su inventario
![[7 Store Adds Product To Inventory Flowchart.png]]
##### 8. Tienda crea promociones y los aplica a productos
![[8 Store Creates Promotions Flowchart.png]]
##### 9. Tienda hace notificaciones de sus productos
![[9 Store sends Notification of Discounts Flowchart.png]]
##### 10. Tienda revisa sus reseñas
![[10 Store Reviews its own Reviews Flowchart.png]]
##### FlowChart Resumido
![[11 Fruit Punck Overview.png]]

##### El Flow del Programa
1. **Fruit Punχ** empezara con el [[#1. Login del Usuario y Tienda|Start Login]] y ira en 2 caminos
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


#### Diagrama UML del Base de Datos en MySQL
Abajo es el diagrama UML del base de datos en MySQL. Hay 3 grupos para poder diferenciar lo que tiene acceso cada objeto principal en el programa.
- **Users** tiene acceso a:
	- **Users_follow_Stores** - para poder seguir a tiendas
	- **Reviews** - usuarios pueden crear reseñas sobre tiendas
	- **Users_has_Products** - usuarios tendrán una lista de Productos, que utilizaran para hacer las comparaciones
	- **Result_Comparative_Log** - la tabla donde se guardara los resultados de las comparaciones
- **Products** tiene acceso a:
	- **Products_has_Promotions** - enlazando a las promociones con los productos
- **Stores** tiene acceso a:
	- **Stores_Inventory** - que enlaza con productos y es el inventario de los productos
	- **Promotions** - las promociones que crea la tienda
##### Nomenclatura del BBDD
- Todos los ID's siguen un patron de `id_Tabla`
- Si hay varias palabras para un atributo se separa por un `_` 
- Todos los campos de fechas siguen el patron de `date_contexto`


![[fruitPunkModel.png]]

#### Diagrama UML de Java Back-end
![[fruit-punk-javaUML-v1.drawio.png]]

##### Nomenclatura del Back-end
- Cada clase tiene su propio id simplemente nombrado `id`
- Para nombre clases, atributos, etc se utilizara el modo camelCase
- Todos los campos de fechas siguen el patron de `dateContexto`

### Diseño de la arquitectura general y de la base de datos.
El proyecto de **Fruit Punχ** seguirá una arquitectura similar al del micro-servicios. Es un proyecto de *Java* hecho con el framework de *Spring-boot* y con *Maven* para manejar las dependencias. El base de datos sera en *MySQL* y se comunicara entre ello y el back-end por el *Hibernate*. 
El front-end estará hecho con *HTML*, como estructura, *CSS* para aumentar su aspecto y *JavaScript* para mejorar su funcionalidad. *JavaScript* se comunicara entre el front-end y back-end por los controllers de *Java*. El proyecto seguirá una estructura como detallado abajo:

```v1
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── fruit_punck
│   │               ├── fruit_punckAppApplication.java
│   │               ├── controller
│   │               │   ├── UserController.java
│   │               │   └── StoreController.java
│   │               ├── model
│   │               │   ├── User.java
│   │               │   ├── Product.java
│   │               │   ├── Store.java
│   │               │   ├── ResultCompare.java
│   │               │   ├── Promotion.java
│   │               │   ├── Address.java
│   │               │   └── Review.java
│   │               └── repository
│   │               │   ├── UserRepository.java
│   │               │   ├── ProductRepository.java
│   │               │   ├── StoreRepository.java
│   │               │   ├── ResultCompareRepository.java
│   │               │   ├── PromotionRepository.java
│   │               │   └── ReviewRepository.java
│   │               └── util
│   │                   └── CommonConsts.java
│   ├── resources
│   │   ├── application.properties
│   │   ├── static
│	│	│   ├── js
│	│	│	│   └── script.js
│	│	│   └── css
│	│	│	    └── style.css
│	│	│
│   │   ├── templates
│	│	│   ├── searchList.html
│	│	│   ├── followedStores.html
│	│	│   ├── createReview.html
│	│	│   ├── productList.html
│	│	│   ├── resultComparison.html
│	│	│   ├── addProduct.html
│	│	│   ├── addPromotion.html
│	│	│   ├── sendNotification.html
│	│	│   └──storeReviews.html
│	│	│
│   │   └── index.html
│	│	
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── fruit_punck
│                       └── fruit_punckAppApplication.java
└── pom.xml
```

Desde el front-end el app comunicara con 2 Controllers y cada uno tendrá sus repositorios necesarios para poder hacer sus operaciones CRUD:

- **UserController**
	- **UserRepository** - para poder buscar usuarios con su login id
	- **PromotionRepository** - para buscar productos con promociones
	- **ProductRepository** - para buscar productos específicos y añadirlo a la comparación
	- **StoreRepository** - para buscar tiendas especificas
	- **ResultRepository** - para buscar los resultados de las comparaciones
	- **ReviewRepository** -  para poder crear y buscar reseñas
- **StoreController**
	- **PromotionRepository** - para poder buscar y crear promociones
	- **ProductRepository** - para poder añadir y buscar productos de su inventario
	- **StoreRepository** - para poder buscar tiendas con su login id

Los repositorios tiene sus métodos específicos por lo casos diferentes necesarios en su modo respectivo. Por ejemplo:
- **UserRepository**
	- **findByEmail(String)** - buscar un usuario por su email único y devolverlo
	- **findByUserName(String)** - buscar un usuario por su nombre de usuario único y devolverlo


## 4. Implementación

### Descripción detallada de las herramientas y tecnologías utilizadas 

A continuación es una descripción de todos las herramientas y tecnologías utilizadas para el proyecto de **Fruit Punχ**, software y librerías/dependencias utilizadas para documentar y programa la aplicación.

#### Eclipse IDE
**Eclipse** Integrated Development Environment ([IDE](https://eclipseide.org/)) es una *herramienta de desarrollo integrado* utilizada para escribir, depurar y ejecutar aplicaciones de software. Ofrece funcionalidades avanzadas como auto-completado de código, revisión ortográfica y sugerencias de refactoring, facilitando el desarrollo rápido y eficiente.

#### GitHub
**GitHub** es un *control de versiones distribuido* que permite almacenar e intercambiar código fuente de proyectos. Ofrece funcionalidades como ramas para la colaboración, solicitudes de fusión y versionado semántico, facilitando el seguimiento y manejo del desarrollo de software. Es el *repositorio central* para este proyecto en el siguiente [enlace](https://github.com/bowserchris/food-punck).

#### Obsidian
**Obsidian** es una [aplicación](https://obsidian.md/) de escritura que utiliza *sintaxis markdown* para crear notas y documentos. Ofrece un enfoque centrado en los datos, permitiendo organizar, vincular y buscar información dentro de un solo espacio. Se adapta bien a la creación de documentación detallada y estructurada.

#### Ollama
**Ollama** es una *inteligencia artificial* desarrollada por [Meta](https://ollama.com/) con el objetivo de facilitar la comunicación, colaboración y aprendizaje entre los usuarios. Utilizando algoritmos avanzados de procesamiento del lenguaje natural, **Ollama** puede entender y responder a preguntas en lenguaje humano, proporcionando información precisa sobre una amplia variedad de temas. Para facilitar su uso, también utilizaba las siguientes herramientas para interactuar con ello: 

- ##### Qwen2.5-Coder
	**Qwen2.5 Coder** es una versión avanzada de **Ollama**, específicamente diseñada para asistir en el *desarrollo de software*. Esta [inteligencia artificial](https://ollama.com/library/qwen2.5-coder) proporciona un entorno local y offline donde los desarrolladores pueden trabajar sin necesidad de conexión a internet, ofreciendo funciones como autocompletado de código, diagnóstico de errores y generación de código. Ahora existe en [version 3](https://github.com/QwenLM/Qwen3-Coder).

- ##### OpenWebUi
	**OpenWebUI** es una *interfaz de usuario* basada en web que permite interactuar con aplicaciones de manera ágil y sencilla. Proporciona una experiencia visual intuitiva que facilita la navegación, interacción y uso de herramientas digitales. Su información esta disponible en el siguiente [enlace](https://openwebui.com/).

- ##### Docker
	**Docker** es una [plataforma](https://www.docker.com/) que permite *empaquetar aplicaciones y sus dependencias* en unidades portátiles llamadas *contenedores*. Estos *contenedores* pueden ejecutarse en cualquier sistema que tenga el motor de **Docker**, lo que facilita la implementación y despliegue de aplicaciones. 

#### Java OpenJDK v21.0.8
**OpenJDK** es una implementación de [Java](https://openjdk.org/projects/jdk/24/) que sigue el estándar de código abierto. Version 21.0.8 ofrece las últimas características y mejoras de rendimiento del lenguaje, proporcionando una base sólida para el *desarrollo de aplicaciones web y de back-end*.
#### Lombok v1.18.38
**Lombok** es una [librería](https://projectlombok.org/download) **Java** que simplifica el código auto generado, eliminando la necesidad de escribir *boilerplate code* (código repetitivo). Ofrece anotaciones para generar automáticamente constructores, métodos getter/setter, y más, reduciendo así la cantidad de código a escribir.

#### Spring-boot v3.5.3
**Spring Boot** es un [framework](https://spring.io/projects/spring-boot) para crear aplicaciones web y *micro-servicios* basadas en **Java**. Ofrece una configuración predeterminada que permite la creación de aplicaciones listas para el uso con muy poco código, facilitando el desarrollo de aplicaciones empresariales. A continuación son las dependencias incluidas en el **pom.xml** utilizados en este proyecto:

- ##### spring-boot-starter-data-jpa
	**Spring Boot Starter Data JPA** es un módulo que facilita la integración de JPA en aplicaciones Spring Boot, proporcionando una simplificación y automatización del acceso a bases de datos utilizando JPA.

- ##### spring-boot-starter-jdbc
	**Spring Boot Starter JDBC** es un módulo que facilita la integración de JDBC en aplicaciones Spring Boot, proporcionando una simplificación y automatización del acceso a bases de datos utilizando JDBC.

- ##### spring-boot-starter-web
	**Spring Boot Starter Web** es un módulo que facilita la creación de aplicaciones web basadas en Java utilizando Spring MVC. Proporciona funcionalidades para manejar solicitudes HTTP y generar respuestas.

- ##### mysql-connector-j
	**mysql-connector-j** es el controlador JDBC oficial para **MySQL**, permitiendo la comunicación entre aplicaciones **Java** y bases de datos **MySQL**. Ofrece una interfaz estándar para realizar operaciones *CRUD* en las bases de datos.

- ##### spring-boot-starter-test
	**Spring Boot Starter Test** es un módulo que facilita el desarrollo de *pruebas unitarias* y de *integración* en aplicaciones Spring Boot, proporcionando funcionalidades para configurar y ejecutar tests de manera eficiente.

- ##### spring-boot-starter-thymeleaf
	**Spring Boot Starter Thymeleaf** es un módulo que facilita la integración de **Thymeleaf** en aplicaciones Spring Boot, proporcionando una simplificación y automatización del renderizado de vistas **HTML** utilizando **Thymeleaf**.

- ##### spring-boot-starter-security
	**Spring Boot Starter Security** es un módulo que facilita la *implementación de seguridad* en aplicaciones Spring Boot, proporcionando funcionalidades para *autenticación* y *autorización* de usuarios, así como protección contra ataques comunes.

- ##### springdoc-openapi-starter-webmvc-ui
	**Springdoc OpenAPI Starter Web MVC UI** es un módulo que facilita la *documentación de APIs* en aplicaciones Spring Boot utilizando el estándar **OpenAPI 3.0**, proporcionando una interfaz gráfica para visualizar y probar las operaciones disponibles en la *API*.


### Explicación del código y de los servicios implementados

El programa **Fruit Punχ** sigue un flujo de un `User` que puede dividirse en dos principales ramas: la experiencia del `User` (**Usuario**) y la experiencia del `Store` (**Tienda**). Ambas experiencias interactúan con diferentes servicios y controladores definidos en las carpetas `controller`, `model`, y `repository`. Si hay algo que falta por implementarse o seguir, el [proyecto](https://github.com/users/bowserchris/projects/6/views/3) de **Fruit Punχ** tiene el historial de los cambios y implementaciones futuras en GitHub como referencia. A continuación, se detalla cómo funciona cada rama del flujo de programa.
##### El Flow del Programa

1. **Login del Usuario y Tienda**: El programa comienza con el inicio de sesión del usuario o la tienda. Este paso es gestionado por el controlador `UserController.java` y `StoreController.java`. Los usuarios inician sesión utilizando sus credenciales, mientras que las tiendas pueden realizar acciones como crear productos, promociones, y enviar notificaciones. Flow chart: [[#1. Login del Usuario y Tienda|Start Login]]
2. **Indice del Usuario**:
	1. - **Opción 1**: El usuario puede buscar productos por nombre, tienda o código postal.
		- [[#2. Usuario buscando productos por nombre, tienda o codigo postal|Search Products]]: Este paso se gestiona mediante el controlador `UserController.java` y la vista correspondiente (`searchList.html`). El usuario ingresa su búsqueda, y el sistema muestra los resultados coincidentes.
	2. **Opción 2**: El usuario puede ver las tiendas que sigue.
	    - [[#3. Usuario "siguiendo" una Tienda|Stores Followed]]: Esta funcionalidad se maneja a través del controlador `UserController.java` y la vista (`followedStores.html`). Las tiendas seguidas son mostradas al usuario, y pueden ser utilizados para crear reseñas.
	3. **Opción 3**: El usuario puede crear reseñas sobre tiendas.
	    - : [[#4. Usuario crea una reseña|Create Reviews]]: La creación de reseñas se gestiona mediante el controlador `UserController.java` y la vista (`createReview.html`). Los usuarios pueden escribir una reseña detallada sobre una tienda de su calidad o servicio, que es luego guardada en la base de datos.
	4. **Opción 4**: El usuario puede crear listas de productos.
	    - [[#5. Usuario crea una lista de productos|Create Product List]]: Esta funcionalidad se maneja a través del controlador `UserController.java` y la vista (`productList.html`). Los usuarios pueden agrupar varios productos en una lista, facilitando su comparación y gestión.
	5. **Opción 5**: El usuario puede revisar los resultados de las comparaciones entre sus productos.
	    - [[#6. Usuario compara productos|Review Results]]: Esta parte del flujo se gestiona a través del controlador `UserController.java` y la vista (`resultComparison.html`). Los usuarios pueden comparar productos basándose en sus precios, precios/peso, reseñas y listas existentes.
	6. **Opción 6**: Si el usuario no tiene reseñas, listas o otras interacciones dentro de las **opciones 2-5**, se redirige a la **opción 1** para [[#2. Usuario buscando productos por nombre, tienda o codigo postal|buscar productos]].
3. **Indice de la Tienda**:
    1. **Opción 1**: La tienda puede crear y añadir productos a su inventario.
        - [[#7. Tienda crea y añade productos a su inventario|Create & Add Inventory]]: Esta funcionalidad se gestiona mediante el controlador `StoreController.java` y la vista (`addProduct.html`). Las tiendas pueden agregar nuevos productos a su inventario.
    - **Opción 2**: La tienda puede crear promociones y aplicarlas a productos.
        - [[#8. Tienda crea promociones y los aplica a productos|Create & Add Promotions]]: Esta parte del flujo se gestiona a través del controlador `StoreController.java` y la vista (`addPromotion.html`). Las tiendas pueden definir promociones para sus productos, aumentando su visibilidad.
    - **Opción 3**: La tienda puede enviar notificaciones de sus productos.
        - [[#9. Tienda hace notificaciones de sus productos|Send Notifications]]: Esta funcionalidad se gestiona a través del controlador `StoreController.java` y la vista (`sendNotification.html`). Las tiendas pueden enviar notificaciones a los usuarios sobre nuevos productos o promociones. Si la tienda no tiene productos se redirige a [[#8. Tienda crea promociones y los aplica a productos|opción 2]].
    - **Opción 4**: La tienda puede revisar sus reseñas.
        - [[#10. Tienda revisa sus reseñas|Review User-reviews]]: Esta parte del flujo se gestiona a través del controlador `StoreController.java` y la vista (`storeReviews.html`). Las tiendas pueden leer y responder a las reseñas que les han hecho los usuarios.

##### Estructura de los Objetos

La aplicación está estructurada en varias capas para mantener el código organizado y escalable:

1. **Controladores (controller)**: Controlan las solicitudes del usuario y llaman al servicio correspondiente.
    - `UserController.java`: Gestionar las acciones relacionadas con usuarios, como inicio de sesión y gestión de reseñas.
    -  `StoreController.java`: Gestionar las acciones relacionadas con tiendas, como creación de productos, promociones y envío de notificaciones.
2. **Modelos (model)**: Representan los datos de la aplicación, incluyendo entidades como usuarios, productos, tiendas, reseñas, etc.
    - `User.java`: Representa a un usuario con atributos como nombre, correo electrónico, contraseña, y lista de tiendas seguidas.
    - `Product.java`: Representa un producto con atributos como nombre, descripción, precio, peso, categoría  y promociones aplicables.
    - `Store.java`: Representa una tienda con atributos como nombre, dirección, productos en inventario, y reseñas recibidas.
    - `ResultCompare.java`, `Promotion.java`, `Address.java`, `Review.java`: Representan otros objetos de datos necesarios para la funcionalidad del sistema.
3. **Repositorios (repository)**: Interactúan con la base de datos para almacenar, recuperar y gestionar los datos.
    - Repositorios específicos para cada entidad (`UserRepository.java`, `ProductRepository.java`, etc.) gestionan las operaciones CRUD en la base de datos.
4. **Utilidades (util)**: Contienen clases de utilidad que proporcionan métodos comunes utilizados en el sistema, como constantes globales (`CommonConsts.java`).
5.  **Recursos (resources)**: Almacenan archivos estáticos y configuración.
    - `application.properties`: Archivo de configuración con propiedades del servidor y otras preferencias.
    - `static/js/script.js` y `static/css/style.css`: Archivos JavaScript y CSS para la interfaz del usuario.
    - Vistas (`html`): Archivos HTML que definen la estructura y el diseño de las páginas web.
6. **Vistas (html)**: Definen la interfaz del usuario y cómo se muestran los datos al usuario.    

Esta estructura asegura una separación clara entre la lógica de negocio, la presentación y la gestión de datos, lo que facilita el mantenimiento y escalabilidad del sistema.

### Capturas de pantalla de la interfaz

Esta sección contiene las capturas de pantalla de la interfaz con la aplicación. Son las conexiones iniciales a los controllers antes de implementar el front-end y después con HTML, CSS y JavaScript:
#### Store Controller directo
![[backendConnection.png]]

#### User Controller directo
![[backendConnectionuser.png]]

#### Fruit Punχ con HTML y CSS
![[FRUITPUNK 1.png]]
#### Fruit Punχ llamando al Controller y errores

Aquí intentando añadir productos por el usuario, llamando al endpoint `/user/addProduct`
![[postProductEndpointFE.png]]

Aquí intentando agregar el usuario por `/user/addUser`
![[postUserEndpointFE.png]]

## 5. Pruebas

### Plan de pruebas y resultados

A continuación es el plan de pruebas para el proyecto, con sus objetivos y resultados esperados. Los resultados actuales y fechas en que se intento la prueba también estarán incluidas.
#### Pruebas Unitarias
##### Prueba Unitaria 1: Prueba de conexión inicial con back-end
**Plan:** 
- **Clase/Test Case:** `FoodPunckApplication.java`
- **Objeto/Aplicación Main:** Encender el app y llegar a tener conexión con el back-end
- **Resultado Esperado:** Encender el app, con base de datos también, y poder ver y interactuar con el `User` o `Store` controllers
- **Método Prueba:** Encender el app

**Resultado:** [[Fruit Punχ - El 'impacto' para el pueblo#Prueba Unitaria 1 Conexión inicial documentada|Foto Documentada]]
1. **26/7** - No se llega a dar conexión y salio error, como detallado en [[IronHack Final Project - Fruit PunchFruit Punk BUG REPORT#Bug 2 26-07|report bug #3]]
2. Anotaciones de las clases necesitan ser actualizadas antes de comenzar el testing
3. **27/7** - Comprobado al simplificar y borrar varias clases, que al tener las anotaciones en las clases correctamente se llega dar conexión, aunque falta las anotaciones correctas con el app completo

##### Prueba Unitaria 2: Prueba del Repositorio Product
**Plan:** 
- **Clase/Test Case:** `ProductRepository.java`
- **Objeto/Repositorio:** El `ProductRepository` que gestiona las operaciones CRUD en la base de datos para los productos.
- **Resultado Esperado:** La prueba debe asegurar que el repositorio esté correctamente implementado y funcione, lo que implica comprobar que los métodos CRUD se ejecuten con éxito.
- **Método Prueba:** **Crear** dos objetos `Product` del mismo tipo pero de diferentes tiendas, invocar el método de **creación** en el repositorio, **obtener** los productos desde la base de datos, **verificar** si los productos se han creado correctamente, luego **actualizar** y **eliminar** los mismos.

**Resultado:**

##### Prueba Unitaria 3: Prueba del Repositorio User
**Plan:** 
- **Clase/Test Case:** `UserRepository.java`
- **Objeto/Repositorio:** El `UserRepository` que gestiona las operaciones CRUD en la base de datos para los usuarios.
- **Resultado Esperado:** La prueba debe asegurar que el repositorio esté correctamente implementado y funcione según las especificaciones establecidas, lo que implica comprobar que los métodos CRUD se ejecuten con éxito.
- **Método Prueba:** **Crear** un objeto `User`, invocar el **método de creación** en el repositorio, **obtener** el usuario desde la base de datos, **verificar** si el usuario se ha creado correctamente.

**Resultado:**

##### Prueba Unitaria 4: Prueba del Controller User # 1
**Plan:** 
- **Clase/Test Case:** `UserController.java`
- **Objeto/Controller:** El `UserController` que gestiona las operaciones CRUD y comparativas de productos.
- **Resultado Esperado:** La prueba debe asegurar que el controller esté correctamente implementado y funcione, lo que implica la creación, lectura, actualización y eliminación de productos en la base de datos.
- **Método Prueba:** **Crear** dos objetos `Product` del mismo tipo pero de diferentes tiendas, invocar el **método de comparación** de precios por peso en el controller, **verificar** si el **resultado** de la comparación es correcto.

**Resultado:** [[Fruit Punχ - El 'impacto' para el pueblo#Prueba Unitaria 4 Prueba del Controller User 1 documentada|Foto Documentada]]

##### Prueba Unitaria 5: Prueba del Controller User # 2
**Plan:** 
- **Clase/Test Case:** `UserController.java`
- **Objeto/Controller:** El `UserController` que gestiona las operaciones CRUD y métodos relacionados con los usuarios.
- **Resultado Esperado:** La prueba debe asegurar que el controller esté correctamente implementado y funcione, lo que implica la creación, lectura, actualización y eliminación de usuarios en la base de datos.
- **Método Prueba:** **Crear** un objeto `User`, invocar el **método de registro** en el controller, **obtener** los usuarios desde la base de datos, **verificar** si el usuario se ha creado correctamente.

**Resultado:** [[Fruit Punχ - El 'impacto' para el pueblo#Prueba Unitaria 5 Prueba del Controller User 2 documentada|Foto Documentada]]

##### Prueba Unitaria 6: Prueba del Controller Store
**Plan:** 
- **Clase/Test Case:** `StoreController.java`
- **Objeto/Controller:** El  `StoreController` que gestiona las operaciones CRUD y métodos relacionados con las tiendas.
- **Resultado Esperado:** La prueba debe asegurar que el controller esté correctamente implementado y funcione, lo que implica la creación, lectura, actualización y eliminación de tiendas en la base de datos.
- **Método Prueba:** **Crear** un objeto `Store`, **invocar** el método de registro en el controller, **obtener** las tiendas desde la base de datos, **verificar** si la tienda se ha creado correctamente.

**Resultado:**
#### Pruebas de Integración
##### Prueba de Integración 1: Prueba del Flujo Completo de Comparación de Productos
**Plan:** 
- **Clase/Test Case:** `ProductComparisonTest.java`
- **Objeto/Aplicación Completa:** El flujo completo que incluye los controladores y repositorios necesarios para comparar productos.
- **Resultado Esperado:** La prueba debe asegurar que el flujo completo de comparación de productos esté correctamente implementado y funcione, lo que implica comprobar que la comparación de precios es correcta y que se devuelve el resultado al usuario.
- **Método Prueba:** Utilizar un cliente web como `RestTemplate` para realizar una solicitud HTTP con dos productos del mismo tipo pero de diferentes tiendas y verificar que la respuesta contiene los datos esperados.

**Resultado:**
##### Prueba de Integración 2: Prueba del Flujo Completo de Registro de Usuario
**Plan:** 
- **Clase/Test Case:** `UserRegistrationTest.java`
- **Objeto/Aplicación Completa:** El flujo completo que incluye los controladores, servicios y repositorios necesarios para registrar un nuevo usuario.
- **Resultado Esperado:** La prueba debe asegurar que el flujo completo de registro de usuario esté correctamente implementado y funcione según las especificaciones establecidas, lo que implica comprobar que la creación del usuario es correcta y que se devuelve una respuesta satisfactoria.
- **Método Prueba:** Utilizar un cliente web como `RestTemplate` para realizar una solicitud HTTP con los datos del nuevo usuario y verificar que la respuesta contiene los datos esperados.

**Resultado:**

### Casos de prueba y su documentación

##### Prueba Unitaria 1: Conexión inicial documentada
![[frontEnd-http-wOut-css-correctIndex.png]]

##### Prueba Unitaria 4: Prueba del Controller User # 1 documentada
![[postProductEndpointFE 1.png]]

##### Prueba Unitaria 5: Prueba del Controller User # 2 documentada
![[postUserEndpointFE 1.png]]


## 6. Despliegue

### Instrucciones para desplegar la aplicación en un entorno local y configuraciones necesarias

Como la letra 'χ' no es facil de interpretar a nivel de codigo, el repositorio en GitHub se llamara `food-punck`, **food** para que fuera mas general el concepto y **punck** para distinguirlo mejor. 

Para desplegar el app en tu entorno local, utilizando los métodos por **IDE**, continue los siguientes pasos:
#### Paso 1: Clonar el Repositorio
Primero, clona el repositorio desde **GitHub** con el comando `git clone <url>` y a continuación con el comando `cd <file/path` creas un directorio donde se almacena el repositorio:

```bash
git clone https://github.com/bowserchris/food-punck.git
cd food-punck
```

#### Paso 2: Importar el Proyecto en el IDE
Accede a tu **IDE** preferido y continue los siguientes pasos:
##### Eclipse

1. Abre **Eclipse**.
2. Ve a `File` -> `Import`.
3. Selecciona `Maven` -> `Existing Maven Projects`.
4. Haz clic en `Browse` y selecciona la carpeta del proyecto clonado (`food-punck`).
5. Haz clic en `Finish`.

##### IntelliJ IDEA

1. Abre **IntelliJ IDEA**.
2. Ve a `File` -> `New` -> `Project from Existing Sources`.
3. Selecciona la carpeta del proyecto clonado (`food-punck`).
4. Elije `Import project from external model` y selecciona `Maven`.
5. Haz clic en `Next`, luego en `Finish`.

##### NetBeans

1. Abre **NetBeans**.
2. Ve a `File` -> `Open Project...`.
3. Navega hasta la carpeta del proyecto clonado (`food-punck`) y selecciónala.
4. Haz clic en `Open`.

#### Paso 3: Configurar el Archivo `application.properties`
En cuanto tienes el proyecto importado en tu **IDE**, busca y abre el fichero `application.properties` y cambie/añade los siguientes campos:
##### Atributos a Cambiar

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

#### Paso 4: Crear la Base de Datos y Tablas

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

#### Paso 5: Configurar la Base de Datos en el IDE

##### Eclipse

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot App`).
3. En `Project`, selecciona tu proyecto (`food-punck`).
4. En `Main class`, asegúrate de que apunte al archivo principal de la aplicación Spring Boot.
5. En `VM arguments`, asegúrate de que no incluya opciones relacionadas con SSL.

##### IntelliJ IDEA

1. Ve a `Run` -> `Edit Configurations`.
2. Crea una nueva configuración (`Spring Boot`).
3. En `Configuration tab`, selecciona tu proyecto (`food-punck`).
4. En `Environment variables`, asegúrate de que no incluya opciones relacionadas con SSL.

##### NetBeans

1. Ve a `Run` -> `Run Project`.

#### Paso 6: Ejecutar la Aplicación

Después de configurar las opciones, ejecuta el proyecto:

##### Eclipse

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run As` -> `Java Application`.

##### IntelliJ IDEA

1. Haz clic derecho en el archivo principal de la aplicación Spring Boot.
2. Selecciona `Run 'MainClassName.main()'`.

##### NetBeans

1. Haz clic derecho en el proyecto (`food-punck`).
2. Selecciona `Run Project`.

#### Paso 7: Acceder a la Aplicación

Una vez que la aplicación esté ejecutando, puedes acceder a ella a través del navegador web de tu elección (Como Firefox, Brave, etc.):

```
http://localhost:9090
```

Si has cambiado el puerto en el archivo `application.properties`, utiliza ese puerto en lugar de 9090. Te debería llevar al indice principal del html del proyecto en:

```
https://localhost:9090/foodPunk
```


## 7. Mantenimiento

### Plan para mejoras futuras y actualizaciones recomendadas.

##### Mejoras o Actualizaciones inmediatas para Fruit Punχ v1

Aquí esta un listado de las mejoras necesarias para incrementar la funcionalidad del app, o los bugs que faltan por eliminar:

- [ ] **Buscar por código postal y ver en Mapa**
	Utilizar geo-localización y APIs de búsqueda para identificar las fruterías más cercanas al código postal del usuario o buscado. Mostrar un mapa con los precios actualizados de estos productos.

- [ ] `Store` **podran notificar a usuarios un aviso general de ofertas**
	Implementar una funcionalidad que permita a los dueños de las tiendas crear y gestionar promociones específicas. Envío de notificaciones masivas a los clientes para alertar sobre ofertas especiales.

- [ ] **Perfiles de tiendas utilizando proveedores locales:**
	Crear un sistema que identifique y muestra las tiendas que utilizan productos locales, facilitando la búsqueda de opciones más sustentables.

- [ ] **Perfiles de tiendas con productos orgánicos:**
	Similar a lo anterior, pero se enfoca específicamente en productos orgánicos. Ayudar a los usuarios a encontrar y comprar productos frescos y naturales.

- [ ] **Incorporar una funcionalidad de inicio de sesión (login):**
	Implementar autenticación para usuarios y tiendas, permitiendo un seguimiento personalizado del inventario, preferencias y pedidos.

- [ ] **Permitir a las tiendas responder a reseñas (creación de clase de mensaje):**
	Desarrollar una interfaz que le permita a los usuarios dejar reseñas y opiniones sobre productos. Implementar un sistema de moderación para mantener la calidad del contenido.

- [ ] **Permitir a las tiendas enviar notificaciones en masa:**
	Crear una clase y sistema de distribución que les permita a las tiendas enviar mensajes o promociones a sus clientes, facilitando el marketing y la comunicación con los usuarios.
##### Version 2 - Incorporar `Recipe`

En la siguiente version del app implementaremos una funcionalidad donde el `User` puede tener, crear o guardar `Recipe` y tener una lista de un inventario personal de `Product` en casa. La funcionalidad principal seria:
- El `User` tendría `Recipes`
- El `User` tendría un inventario de `Product` para su stock en casa
- El `User` podría comparar productos que tiene en su inventario con recetas que tiene guardado y le podría notificar:
	- Que productos le faltan y la cantidad
	- Que productos pronto estarán por caducarse y ofrecer recetas con esos ingredientes

El listado para implementar estas funciones siguen a continuación:

- [ ] **Calcular el stock que tienes en casa:**
	Utilizando el inventario del `User` y comparando con los ingredientes del `Recipe` el app procesara esta información para determinar cuántos productos le faltan para terminar la receta. Al mismo tiempo, implementar una función que avise a los usuarios sobre cualquier producto que esté por vencer.

- [ ] **Guardar recetas como Usuario:**
	`User` puede crear sus propios recetas, guardarlas de un enlace URL o si tiene listas de recetas incorporarlas directamente.

- [ ] **Recetas puede dar recomendaciones**:
	`Recipe` puede ser enlazado con el `Product` stock que tiene un `User` en su casa. De esta manera puede recomendar recetas de las siguientes maneras:
	- [ ] Productos que están cerca de caducarse, y que recetas las utilizan
	- [ ] Si elijes una receta, reflejara lo que tiene o no tiene el `User` en su stock en casa
		- [ ] De ahí creara una lista de compras de los productos que falta, con la cantidad necesaria

- [ ] **Aplicar diferentes divisas abstractamente (no codificarlas directamente):**
	Desarrollar un sistema flexible para manejar múltiples divisas, permitiendo que los usuarios elijan su moneda peso, etc de una manera no predeterminada. Asegurar que todos los cálculos se realicen en la moneda seleccionada.

- [ ] **Aplicar diferentes medidas y afectar el precio de manera diferente (por unidad, peso en kilogramos, volumen en litros, etc):**
	Implementar una funcionalidad que maneje diferentes tipos de medidas para los productos, adaptando automáticamente el cálculo del precio según la medida seleccionada.

- [ ] **Cómo calcular correctamente entre un artículo individual y uno con peso diferente al mismo producto y aplicar el precio por su peso total:**
	Desarrollar una fórmula que permita calcular el precio de productos basados en la cantidad y el peso, asegurando que los cálculos reflejen correctamente el valor del producto.
##### Version 3 - Incorporar `Images` y `PhotoInterface`

En version 3 el plan de incorporar en el app es que en vez de introducir la información de los productos manualmente, el `User` o `Store` podría introducir esa información al sacar una foto, y el app desde la foto sacar la información relevante. Las funciones necesarias serian a continuación:

- [ ] **Sacar fotos de productos y automatizar la información de la foto:** 
	Implementar una funcionalidad que utilice OCR (Reconocimiento Última Origen del Carácter) para extraer información como el nombre, peso y precio de las imágenes de productos (o ISBN si se puede). Esta información se puede almacenar en la base de datos para su posterior uso en comparaciones y recomendaciones.
	- [ ] Crear clase `Image` y tabla
	- [ ] Crear clase y implementacion de `PhotoInterface`

- [ ] **Coger información de un producto por su ISBN**
	Integrar una API que proporcione datos de caducidad, y otra información, basados en los códigos ISBN de los productos. De esta manera automatizar y rellenar el formulario del producto y no introducirlo manualmente. Ademas si el ISBN tiene la información correcta, comparar estos datos con la fecha actual para alertar a los usuarios sobre cualquier producto que esté por vencer.

## 8. Manual de Usuario

### Propósito y alcance
Este manual está diseñado para orientarte en la utilización de **Fruit Punχ**, una aplicación innovadora que facilita el proceso de comparar varios productos de tiendas diferentes y recomendar la mejor oferta. El manual cubre desde la configuración inicial hasta las funcionalidades avanzadas, asegurándote de que puedas aprovechar al máximo todas las ventajas proporcionadas de **Fruit Punχ**.

### Conocimientos previos necesarios
Para utilizar **Fruit Punχ** de manera efectiva, es recomendable tener una comprensión básica de navegador webs y aplicaciones móviles. No obstante, la app está diseñada para ser intuitiva y fácil de usar, por lo que incluso los usuarios con poca experiencia tecnológica pueden navegar sin problemas.

### Requisitos técnicos
Para el funcionamiento óptimo de **Fruit Punχ**, es necesario cumplir con los siguientes requisitos:

- **Sistema Operativo:** Cualquiera que da acceso a paginas web o Android y Iphones.
- **Navegador web:** Brave, Google Chrome, Mozilla Firefox
- **Conexión a Internet:** Alta velocidad recomendada

### Políticas de seguridad
Para garantizar tu seguridad en **Fruit Punχ**, es importante seguir estas políticas:

1. **Nunca** compartas información sensible, como contraseñas y números de tarjetas de crédito.
2. Realiza los **cierres de sesión** cuando termines una sesión o compartas un dispositivo público.
3. Utiliza **contraseñas fuertes** que incluyan letras mayúsculas, minúsculas, números y símbolos.
4. ***No compartiremos tu información a ningún tercer partido.*** 

### Inicio de sesión
Para iniciar sesión en **Fruit Punχ**, sigue estos pasos:

1. Abre el navegador web y ve a https://fruitpunχ.com
2. Haz clic en "**Iniciar sesión**".
3. Ingresa tu **correo electrónico** asociado con tu cuenta.
4. Proporciona tu **contraseña**.

Si olvidas tu contraseña, puedes recuperarla siguiendo las instrucciones indicadas en el formulario de inicio de sesión.

### Mapa de navegación
Para navegar por la interfaz de **Fruit Punχ**, sigue esta estructura:

1. **Inicio**: Una pantalla principal con opciones rápidas a tu disposición como
	1. Buscar Producto
	2. Buscar Tienda
	3. Crear Reseñas
	4. Comparar Productos
2. **Perfil**: Configuración personal y gestión de tus datos.
3. **Explorar**: Descubre nuevos productos o tiendas.

### Descripción de funcionalidades

Si entras como un usuario **cliente** sigue abajo las instrucciones de **Funcionalidades de Usuario**, y si entras como un usuario **tienda** sigues las instrucciones en el apartado **Funcionalidades de Tienda**:

##### Funcionalidades de Usuario
Después de hacer el login en tu cuenta tendrás las siguientes opciones disponibles en pantalla:

1. **Buscar Productos**: Entraras y veras el formulario para buscar productos por nombre, tienda o código postal y se mostrara los resultados coincidentes.

2. **Ver Tiendas que sigues**: Entraras y veras una lista de las tiendas que sigues. Al lado de cada tienda veras la opción de crear o actualizar una reseña para esa tienda. Si no tienes ninguna tienda en seguimiento, aparecerá un botón indicando para empezar la búsqueda y te llevara a la pagina de búsqueda.

3. **Ver tus reseñas**: Entraras y veras una lista de las reseñas que has creado sobre tiendas y podrás actualizarlas si necesitas sobre su servicio o calidad de productos que tienen. Si no tienes ninguna creada, aparecerá un botón indicando para empezar la búsqueda y te llevara a la pagina de búsqueda para tiendas.

4. **Ver tus productos guardados**: Entraras y veras los productos que has guardado y quieres seguir viendo frecuentemente. Al lado de cada producto habrá un botón para llevar a su tienda y otro botón donde puedes iniciar una comparación. Si no tienes ninguna creada, aparecerá un botón indicando para empezar la búsqueda y te llevara a la pagina de búsqueda para productos.

5. **Ver Resultados**: Entraras y veras el historial de los resultados de comparaciones que ya has hecho. Si no tienes ninguna creada, aparecerá un botón indicando para empezar la búsqueda y te llevara a la pagina de búsqueda para productos.

##### Funcionalidades de Tienda
Después de hacer el login en tu cuenta tendrás las siguientes opciones disponibles en pantalla:

1. **Crear o añadir productos a tu inventario**: Si tienes ningún producto guardado en tu inventario, veras el formulario para empezar y rellenar tu primer producto. Sino veras la lista de tus productos con la opción de actualizarlos en un botón al lado de cada uno ademas de aplicarle una promoción (si tienes uno ya creado, sino te llevara al formulario de promoción en el siguiente paso). En un botón flotante, tendrás la opción de añadir otro producto que te llevara al formulario para crear un nuevo producto.

2. **Crear o añadir promociones**: Entraras y veras las promociones que has creado en tu tienda con un botón al lado para aplicarlo a cualquier producto que tienes creado en tu tienda. En un botón flotante, tendrás la opción de crear otra promoción que te llevara al formulario para crear una nueva promoción.

3. **Crear y mandar notificaciones**: Entraras y veras una lista de tus productos existentes con promociones aplicados a ellos. Podrás mandar notificaciones individualmente, o de todos tus productos, y lo recibirá los usuarios que siguen a to tu tienda, o podrás hacer de manera '**KLAXON**' que mandara una notificación abierta a todos los usuarios de la aplicación. 

4. **Ver las reseñas de tu tienda**: Este apartado te enseñara las reseñas que te han hecho usuarios a tu tienda y tendrás la opción de contestarlos. Todas reseñas y comunicaciones serán publicas a todos usuarios y tiendas. 


### Soporte técnico
En caso de dudas o problemas, no dudes en contactar nuestro equipo de soporte técnico:

- Nuestro proyecto esta disponible en [GitHub](https://github.com/bowserchris/food-punck)
- Cualquier bug o problema que encuentres con el app lo puedes documentar en nuestro [issues](https://github.com/bowserchris/food-punck/issues) de github

### Solución de problemas comunes
Aquí hay algunas soluciones a problemas frecuentes:

- **Pregunta**: ¿Qué hago si olvido mi contraseña?
	**Respuesta:** No hay problema. Ve al formulario de inicio de sesión, selecciona la opción "**Olvidaste tu contraseña**", y sigue las instrucciones para restablecerla.

- **Pregunta**: ¿Puedo cambiar mis datos personales desde la aplicación?
	**Respuesta:** Sí, puedes hacerlo desde el perfil de usuario. Ve a la sección "**Perfil**" en el menú principal y modifica los campos deseados.

- **Pregunta**: ¿Cómo puedo eliminar mi cuenta?
	**Respuesta:** Para eliminar tu cuenta, ve al perfil de usuario, selecciona la opción "**Eliminar cuenta**", y sigue las instrucciones detalladas.

- **Pregunta**: ¿Puedo comparar productos directamente desde la aplicación?
	**Respuesta:** Sí, puedes hacerlo fácilmente. Mientras estás viendo un producto, selecciona la opción "**Comparar**" para agregarlo a una lista de comparación y ver cómo se compara con otros productos. Cuando tienes una lista completa haz click en **"FRUIT PUNχ"**.

### Contacto
Para cualquier pregunta o sugerencia, no dudes en contactarnos:

- Correo electrónico: info@fruitpunχ.com
- Github:  https://github.com/bowserchris/food-punck

Esperamos que este manual te haya sido útil y disfrutes de todas las funcionalidades de **Fruit Punχ**

**Fruit Punχ**
01/08/2025
