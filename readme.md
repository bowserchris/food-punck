### Introduction

Fruit Punχ es un app diseñado para comparar precios de productos en tiendas locales y ver cual es la mejor oferta. 

### Project Description

#### Objetivos del proyecto
El **objetivo del proyecto** es para que un usuario puede comparar precios/pesos entre varios sitios de tiendas locales (como fruterías y panaderías) e incluso supermercados para ver donde cual lleva la mejor oferta. 
#### Funcionalidades principales
Las **funcionalidades principales** del app son:
- `Users` pueden comparar precios entre 2 productos de 2 tiendas diferentes (o mas)
- `Users` pueden buscar tiendas y productos por su nombre, código postal o por producto
- `Users` pueden dar rankings y reviews a tiendas por su servicio y calidad
- `Stores` pueden notificar de promociones y aplicarlos a productos
#### Público objetivo.
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


### Planning & Resources

#### Phases:

#### Versions checklist:

#### Dependencies
- *spring-boot-starter-data-jpa* / para utilizar JPA repositorios con MySQL
- *spring-boot-starter-jdbc* / para conexiones de BBDD
- *spring-boot-starter-web* / para crear conexiones de internet con el app
- *mysql-connector-j* / para poder comunicar con BBDD MySQL
- *spring-boot-starter-test* / para poder hacer clases de testing
- *spring-boot-starter-thymeleaf* / para poder visualizer HTML y CSS
- *spring-boot-starter-security* / para implementar seguirdad y HTTPS
- *springdoc-openapi-starter-webmvc-ui* / para documentar el codigo

### Design

Below is a general overview of a flowchart for the version 1.0.0 of Fruit Punχ.

![[11 Fruit Punck Overview.png]]

#### El Flow del Programa
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


### Roadmap

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