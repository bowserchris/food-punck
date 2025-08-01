package org.ironhack.Food_Punck.util;

public class CommonConst {
	
	private CommonConst() { }
	
	//////////////////////////////////
	/// GENERAL SOFTWARE VARIABLES ///
	//////////////////////////////////

	private static final String APP_NAME = "Fruit_Punk\u2122";
	public static final String HOST_START = "localhost:3306/fruit_punk";
	public static final String ADD_MAPPINGS = "/**"; // CONFIRM WHAT THIS REPRESENTS
	public static final int MAX_AGE_SITE = 3600; // CONFIRM WHAT THIS REPRESENTS
	public static final String ALLOWED_ORIGINS = "https://localhost:9090";
	public static final String ALLOWED_METHOD_GET = "GET";
	public static final String ALLOWED_METHOD_POST = "POST";
	public static final String ALLOWED_METHOD_PUT = "PUT";
	public static final String ALLOWED_METHOD_DELETE = "DELETE";
	public static final String ALLOWED_METHOD_OPTIONS = "OPTIONS";
	public static final String ALLOWED_HEADERS = "*";
	public static final boolean ALLOWED_CREDENTIALS = true;

	/////////////////////////////////
	/// CONTROLLER INDEX MAPPINGS ///
	/////////////////////////////////

	/// GENERAL MAPPINGS
	public static final String INDEX = "/";
	public static final String INDEX_STORE = "/store";
	public static final String INDEX_USER = "/user";
	
	/// GET MAPPINGS ///
	public static final String URL_GET_ALL_USERS = "/allUsers";
	public static final String URL_GET_ALL_REVIEWS = "/allReviews";
	public static final String URL_GET_ALL_RESULTS = "/allResults";
	public static final String URL_GET_ALL_STORES = "/allStores";
	public static final String URL_GET_ALL_PRODUCTS = "/allProducts";
	public static final String URL_GET_ALL_PROMOS = "/allPromos";
	
	/// POST MAPPINGS ///
	public static final String URL_ADD_STORE = "/addStore";
	public static final String URL_ADD_PRODUCT = "/addProduct";
	public static final String URL_ADD_PROMO = "/addPromo";
	public static final String URL_ADD_USER = "/addUser";
	public static final String URL_ADD_REVIEW = "/addReview";
	public static final String URL_ADD_RESULT = "/addResult";
	
	/// BY ID FOR GET1, PUT, DELETE ///
	public static final String URL_BY_STORE_ID = "/idStore/{id}";
	public static final String URL_BY_PRODUCT_ID = "/idProduct/{id}";
	public static final String URL_BY_PROMO_ID = "/idPromo/{id}";
	public static final String URL_BY_USER_ID = "/idUser/{id}";
	public static final String URL_BY_REVIEW_ID = "/idReview/{id}";
	public static final String URL_BY_RESULT_ID = "/idResult/{id}";
	
	/////////////////////////////////
	///   MYSQL NAME VARIABLES	  ///
	/////////////////////////////////
	
	/// MYSQL TABLE NAMES ///
	public static final String MYSQL_TABLE_USERS = "Users";
	public static final String MYSQL_TABLE_USERS_STORES = "Users_follow_Stores";
	public static final String MYSQL_TABLE_USERS_PRODUCTS = "Users_has_Products";
	public static final String MYSQL_TABLE_REVIEWS = "Reviews";
	public static final String MYSQL_TABLE_RESULT_COMPARE = "Result_Comparative_Log";
	public static final String MYSQL_TABLE_ADDRESSES = "Addresses";
	public static final String MYSQL_TABLE_STORES = "Stores";
	public static final String MYSQL_TABLE_STORES_INVENTORY = "Stores_Inventory";
	public static final String MYSQL_TABLE_PROMOTIONS = "Promotions";
	public static final String MYSQL_TABLE_PRODUCTS = "Products";
	public static final String MYSQL_TABLE_PRODUCTS_PROMOTIONS = "Products_has_Promotions";
	
	/// MYSQL ID NAMES ///
	public static final String MYSQL_ID_ONLY = "id";
	public static final String MYSQL_ID_USER = "id_User";
	public static final String MYSQL_ID_STORE = "id_Store";
	public static final String MYSQL_ID_REVIEW = "id_Review";
	public static final String MYSQL_ID_PRODUCT = "id_Product";
	public static final String MYSQL_ID_RESULT = "id_Result";
	public static final String MYSQL_ID_ADDRESS = "id_Address";
	public static final String MYSQL_ID_PROMOTION = "id_Promotion";
	
	/////////////////////////////////
	/// ///
	/////////////////////////////////
	
}
