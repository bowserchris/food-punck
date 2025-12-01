# 🍎 FRUIT-PUNχ!!! 👊  
---

## Table of Contents  
- [Intro](#introduction)
- [Project Description](#project-description)
- [Public Aim](#public-aim)
- [Planning Resources](#planning-resources)
- [Design](#design)
- [Roadmap](#roadmap)
	- [Version 1](#version-1)
	- [Version 2](#version-2)
	- [Version 3](#version-3)

---

## Introduction ☕  
Go ahead and grab a cup o' joe and let me tell you about **Fruit Punχ**. **Fruit Punχ** is an app designed to compare prices of products in local stores and identify where the best deals are.

---

## Project Description 🥫  

### Objectives 🍥  

The goal of this project is for users to compare prices/weights between various local stores (butchers, bakeries & fruit stands) as well as supermarkets, allowing them to find the best offers or better value for specific items.

### Main Features 🍄  
The app's main features include:
- `**Users**` can compare prices between two products from different stores or more.
- `**Users**` can search for stores and products by name, ZIP code, or product category.
- `**Users**` can rate and review stores based on their service and quality.
- `**Stores**` can notify customers of promotions and apply them to specific products.

## Public Goal 🍭  
The public goal targets two specific groups:

1. **Local Citizens** who want to find the best local stores with the best deals, enabling them to:
   - Gain a clear understanding of the local market
   - Identify if buying in bulk offers better value than individual pricing
   - Assist local businesses in competing with big chains

2. **Local Stores** can utilize the platform:
   - Instead of creating their own individual websites, which is costly and time-consuming, they can use a decentralized platform for both store owners and users to browse and compare options.
   - Promote products nearing expiration dates.
   - Run special promotions tailored to attract customers.
   - Highlight whether items are locally sourced or organic.
   - Attract new customers by showcasing the benefits of local businesses over corporate chains.

---

## Planning & Resources 🍴  

### Phases: 🥞  

*(to be elaborated on later)*

### Version Checklists: 🍟  

*(to be elaborated on later)*

### Dependencies 🦑  
- `**spring-boot-starter-data-jpa**`: To use JPA repositories with MySQL.
- `**spring-boot-starter-jdbc**`: For database connections.
- `**spring-boot-starter-web**`: To establish internet connections for the app.
- `**mysql-connector-j**`: To communicate with MySQL databases.
- `**spring-boot-starter-test**`: For testing classes and methods.
- `**spring-boot-starter-thymeleaf**`: To visualize HTML and CSS templates.
- `**spring-boot-starter-security**`: To implement security measures and HTTPS.
- `**springdoc-openapi-starter-webmvc-ui**`: To document the code.

---

## Design 🍱  


### App Flow 🍷

1. **Fruit Punχ** begins with the **User/Store Login Process** and proceeds in two directions:

	2. Upon arriving at the **User Index**, the user chooses between:
		1. **Searching for Products** by name, store, or ZIP code
		2. Checking the **Stores they're Following**
			1. If they have stores saved, then can **write reviews**
		3. **Write reviews** on stores
		4. **Create a product list** to compare in between them
		5. **Review past results** from previous comparisons
		6. If the `**User**` hasn't implemented any of the previous options, they're immediately sent to the `search products` section
		
	3. Upon arriving at the **Store Index**, the store chooses between:
		1. **Create and add** products to their inventory
		2. **Create and add** promotions to products
		3. **Create and send** notifications to `**Users**` that are following them.
			1. If the `**Store**` doesn't have any promotions created, automatically get sent to option 2.
		4. **Review and reply** to reviews sent by `**Users**`

---

### Roadmap 🍢   

### Features/Wishlist to Update 🍨

#### Version 1 🍅

Here’s a list of improvements needed to enhance the app's functionality or bugs that need fixing:

- [ ] **Search by ZIP Code and View on Map**: 
	- [ ] Utilize geolocation APIs to identify nearby fruit stands or stores based on the user's ZIP code
	- [ ] Display a map with updated prices for these products.

- [ ] **Stores Can Send General Notifications**: 
	- [ ] Implement a feature allowing store owners to create and manage promotions 
	- [ ] Sending bulk notifications to customers about special offers.

- [ ] **Store Profiles Using Local Providers**: Create a system to identify and display stores that use local ingredients, making it easier for users to find sustainable options.

- [ ] **Store Profiles with Organic Products**: Similar to the above, but specifically focus on organic products. Help users find fresh and natural products.

- [ ] **Implement User Login (Authentication)**: Develop authentication for both users and stores. Allow personalized tracking of inventory, preferences, and orders.

- [ ] **Allow Stores to Respond to Reviews**: Build an interface where users can leave reviews and opinions about products. Implement a moderation system to maintain content quality.

- [ ] **Product Search by Name, Store, or ZIP Code**: Enhance the search functionality to allow users to find products more efficiently based on various criteria.

- [ ] **Following Stores**: Implement a feature where users can track or follow specific stores to receive updates on new products and promotions.

- [ ] **Creating Product Lists**: Allow users to create custom product lists for easier organization and comparison.

- [ ] **Viewing Results**: Ensure that the search and comparison results are displayed in an organized and user-friendly manner.

- [ ] **Comparing Products**: Develop a feature where users can directly compare prices, specifications, and reviews of different products side by side.

- [ ] **Product Profile Pic** Users or stores and upload profile pics for their products. Otherwise by default have a generic photo in place for the type of product (fruit can be an apple, veggies - lettuce, baked goods - bread, etc.)

#### Version 2

**Incorporate "Recipes":**

In the next version of the app, the goal is to implement a functionality where users can create or save recipes and track their home inventory. The main functionality includes:

- [ ] **User Recipes**: Users can have saved recipes.
- [ ] **Personal Inventory**: Users can keep track of products they have at home (no need for full inventory).
- [ ] **Recipe Comparison**: The user can compare products in their inventory with the ingredients of saved recipes, as well as receive:
	- [ ] **Notifications**: Notify users when:
		- [ ] Products are missing and how much is needed.
		- [ ] Products are expiring soon, suggesting recipes that use those ingredients.
  
**Implementation Steps:**

- [ ] **Calculate Stock at Home**: Using the user's inventory and comparing it with recipe ingredients, the app will process this information to determine which products are lacking for completing a recipe. Additionally, implement a function to inform users about any product nearing expiration.
- [ ] **Save Recipes as User**: Users can create their own recipes or save them from a URL or pre-existing lists.
- [ ] **Recipe Recommendations**: Recipes can be linked with the user's home inventory. Recommendations will include:
	- [ ] Products that are close to expiring and used in recipes.
	- [ ] If a recipe is chosen, it will reflect what the user has or doesn't have in their stock at home.
		- [ ] With that info it will generate a shopping list of needed products along with required quantities.
		- [ ] Can be exported into other apps or as `markdown` for checklists.
- [ ] **Apply Different Currencies Abstractly**: Develop a flexible system to manage multiple currencies, allowing users to choose their preferred currency without direct encoding. Ensure all calculations are performed in the selected currency.
- [ ] **Apply Different Measures and Affect Prices Differently**: Implement functionality that handles various types of measurements (e.g., weight in kilograms/pounds, volume in liters/gallons) and adjusts prices accordingly.

#### Version 3

**Incorporate "Images" and "PhotoInterface":**

For Version 3, the plan is to allow users or stores to input product information by taking a photo, with the app automatically extracting relevant details using OCR (Optical Character Recognition). The necessary functionalities include:

- [ ] **Extract Product Information from Photos**: Implement a functionality that uses OCR to extract information like names, weights, and prices from product images. This information can be stored in a database for later use in comparisons and recommendations.
	- [ ] **Create "Image" Class and Table**: Establish a class and implementation for images.
	- [ ] **Create PhotoInterface**: Create an interface that can incorporate different types of cameras/phones as inputs and images.
- [ ] **Retrieve Information by ISBN**: Integrate an API that provides data on expiration dates and other relevant details based on product ISBNs. This will allow automatic form filling without manual entry. If the ISBN contains accurate information, compare it with the current date to alert users about expiring products. **NEEDS FURTHER INVESTIGATION ON WHAT ISBN CAN AND CAN'T DO**