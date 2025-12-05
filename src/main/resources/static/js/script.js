/**
 * Javascript to handle functions between the FE & BE
 */

const BASE_URL_USER = `/foodPunk/user`;

// 1st step - HTML - grab the full html document (DOM) and apply the methods
// this 'method'/'function/'object' grabs the whole html page until the end of the file
document.addEventListener('DOMContentLoaded', function() {

	// 2nd step A - FORMS - declare forms to work with
	// grab the forms from the DOM and create objects here to work with
	const formProduct = document.getElementById('popupFormProduct');
	const formTable = document.querySelector("table");
	const tableHeadEl = document.querySelector("thead");
	const tableBodyEl = document.querySelector("tbody");
	
	// 2nd step B - MAIN PAGE - create buttons when clicked show the form, passing its type
	document.getElementById('createProductBtn')
			.addEventListener('click', showForm.bind(null, 'Product'));
			
	// 2nd step C - MAIN PAGE - when pressing the get button, it looks for it in the database
	document.getElementById('getProductsBtn')
			.addEventListener('click', fetchAndDisplayData.bind(null, 'Product'));	
	
	document.getElementById('sortProductsBtn').addEventListener('click', fetchAndSortData.bind(null, 'Product'));
	
	document.getElementById('lowestPriceBtn').addEventListener('click', fetchLowestPrice.bind(null, 'Product'));
			
	// 2nd step E - FORM USER/PRODUCT, when pressing cancel, it hides the form and returns to main page
	document.getElementById('cancelProductBtn').addEventListener('click', hideForm);		
			
	// 2nd step B 2 - FORMS, looks for form type to display
	function showForm(type) {
		if (type === 'Product') {
			document.getElementById("productForm").style.display = "block";
		}
	}		
	
	// PASO 2 B 2 - FORMS, changes its attribute to hidden to remove form
	function hideForm() {
		document.getElementById(formProduct).style.display = "none";
		formProduct.reset();
	}			
	
	//								User , Product
	async function fetchAndDisplayData(type) {
		await fetch(`${BASE_URL_USER}/all${type}s`)
			.then(response => response.json())
			.then(data => {
				data.forEach(item => displayList(data, item));
			});
	}
	
	async function fetchAndSortData(type) {
		await fetch(`${BASE_URL_USER}/sort${type}s`)
			.then(response => response.json())
			.then(data => {
				data.forEach(item => displayList(data, item));
			});
	}
	
	async function fetchLowestPrice() {
		await fetch(`${BASE_URL_USER}/lowestPrice`)
			.then(response => response.json())
			.then(data => {
				data.forEach(item => displayList(data, item));
			});
	}
			
	function createTH(data) {
			const column = Object.keys(data[0]);
			const tableHead = tableHeadEl;
//			let tags = "<tr>";
			//loop to go thru headers data
			for (const headerText of column) {       
	//			const headerElement = document.createElement("th"); // created header
	//			headerElement.textContent = headerText; // adds text to that header
	//			tableHead.querySelector("tr").appendChild(headerElement); // appends it to the existing chain of headers
				tags += `<th>${headerText[i]}</tr>`;
				// if above line doesnt work, create for loop like java and change the variable
			}
//			tags += "</tr>";
			tableHeadEl.innerHTML = tags;
	}			
	
	////// CHANGE TO ONLY ADD DATA TO TABLE ///////
	function displayList(data, type) {
		
		//const listId = type === 'User' ? 'userList' : 'productList';
		
		const tableBody = tableBodyEl;
		
		createTH(data);
		tableBody.innerHTML = "";
		
		/////// either below code block or the data.foreach lambda loop
		/*
		function createTD() {
			const body = tableBody;
			let tags = "";
			
			Data.map(d => {
				tags += `<tr>
					<td>{$d.attribute}</td>
					and so on for the others
					</tr>`
			})
			body.innerHTML = tags;
		}
		*/
		
		// if type === user then below, need to make for product in separate
				data.forEach(item => {
		//			const li = document.createElement('li');
		//			li.id = `${type}-${item.id}`;
		//			li.textContent = `Name: ${item.name}, Email: ${item.email}`;
					
					for (const row of item) {       // loop to go thru row arrays
						const rowElement = document.createElement("tr"); // created row

						for (const cellText of row) {    // loop to go thru row data
							const cellElement = document.createElement("td"); // create new data

							cellElement.textContent = cellText;    // take the row info and adds to cell
							
							const updateButton = document.createElement('button');
							updateButton.textContent = 'Update';
							//updateButton.classList.add('update-btn');
							updateButton.addEventListener('click', () => editItem(item, type));

							const deleteButton = document.createElement('button');
							deleteButton.textContent = 'Delete';
							deleteButton.addEventListener('click', () => deleteItem(item.id, type));

							cellElement.appendChild(updateButton);
							cellElement.appendChild(deleteButton);
										
							rowElement.appendChild(cellElement);    // adds the cell to the row table
						}

						tableBody.appendChild(rowElement);    // once its done populating rows it then adds the full row set to the table
					}
		//			listElement.appendChild(li);
				});
		
	}
	
	////// review update and delete with cellelements instead of list item //////
	////////////////////////////////////////////////////////////////////////////

	// with this method i take the item and change its values with replacewith
	async function editItem(item, type) {   //item is product on backend
		
		// create a delete and update button
		// reapply the eventlistener to them
		const updateButton = document.createElement('button');
		updateButton.textContent = 'Update';
		//updateButton.classList.add('update-btn');
		updateButton.addEventListener('click', () => editItem(item, type));
		updateButton.setAttribute('data-id', item.id);

		const deleteButton = document.createElement('button');
		deleteButton.textContent = 'Delete';
		deleteButton.addEventListener('click', () => deleteItem(item.id, type));
		deleteButton.setAttribute('data-id', item.id);

		const li = document.createElement('li');
		li.textContent = `Name: ${item.name}, Price: ${item.price}`;
		li.id = `${type}-${item.id}`;

		const listItem = document.getElementById(`${type}-${item.id}`);

		li.appendChild(updateButton);
		li.appendChild(deleteButton);

		listItem.parentNode.replaceChild(li, listItem);
	}
			
	// delete items should work whether its called thru User or Product as the ${type} should be flexible
	async function deleteItem(id, type) {
		await fetch(`${BASE_URL_USER}/id${type}/${id}`, {
			method: 'DELETE'
		}).then(response => {
			if (response.ok) {
				alert(`${type} deleted.`);
				document.getElementById(`${type}-${id}`).remove();
				//fetchAndDisplayData(type);	// dont think this line is needed to repopulate the list...?
			} else {
				alert(`Error deleting ${type} with id ${id}`);
			}
		}).catch(error => {
			console.error(`Error deleting ${type} with id ${id}`, error);
			alert(`Error deleting ${type}`);
		});
	}
			
	
});
