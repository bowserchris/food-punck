const BASE_URL_USER = `/foodPunk/user`;
const BASE_URL_STORE = `/foodPunk/store`;


// PASO 1 - HTML - cogemos el documento entero de html y le aplicamos "acciones"
// este 'metodo'/'funcion/'objeto' coge la pagina de html entero y le aplica todo hasta el final
document.addEventListener('DOMContentLoaded', function() {

	// PASO 2a - FORMS - declaro y trabajo con los formularios
	// cogemos los formularios del documento y crea objetos para trabajr con ellos
	const formUser = document.getElementById('popupFormUser');
	const formProduct = document.getElementById('popupFormProduct');
	const formTable = document.querySelector("table");
	const tableHeadEl = document.querySelector("thead");
	const tableBodyEl = document.querySelector("tbody");

	// PASO 2B - MAIN PAGE - los create btns al ser pulsado busca y enseña su form, pasando su datatipo
	document.getElementById('createUserBtn')
			.addEventListener('click', showForm.bind(null, 'User'));
	document.getElementById('createProductBtn')
			.addEventListener('click', showForm.bind(null, 'Product'));
	// PASO 2C - MAIN PAGE - al pulsar los get buttons, ve y hace busqueda en fetch con datatipo
	document.getElementById('getUsersBtn')
			.addEventListener('click', fetchAndDisplayData.bind(null, 'User'));
	document.getElementById('getProductsBtn')
			.addEventListener('click', fetchAndDisplayData.bind(null, 'Product'));

	// PASO 2D - FORM USER/PRODUCT, al pulsar send, hace fetch post y guarda en bbdd, (event) is needed to be called and 'wrap' the event object to be used in the next function
	document.getElementById('sendUserBtn')
			.addEventListener('click', (e) => saveToDatabase(e,'User'));
	document.getElementById('sendProductBtn')
			.addEventListener('click', (e) => saveToDatabase(e,'Product'));

	// PASO 2E - FORM USER/PRODUCT, al pulsar cancelar, esconde formulario y vuelve a pagina principal
	document.getElementById('cancelUserBtn').addEventListener('click', hideForm);
	document.getElementById('cancelProductBtn').addEventListener('click', hideForm);

	// PASO 2B 2 - FORMS, aqui busca tipo de form y cambia su atributo a enseñarlo
	function showForm(type) {
		if (type === 'User') {
			document.getElementById("userForm").style.display = "block";
			formProduct.reset();
			document.getElementById("productForm").style.display = "none";
		} else if (type === 'Product') {
			document.getElementById("productForm").style.display = "block";
			formUser.reset();
			document.getElementById("userForm").style.display = "none";
		}
	}

	// PASO 2E 2 - FORMS, cambia su atributo a esconderlo
	function hideForm() {
		document.getElementById(formUser).style.display = "none";
		document.getElementById(formProduct).style.display = "none";
		formUser.reset();
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
	
	function createTH(data) {
		const column = Object.keys(data[0]);
		const tableHead = tableHeadEl;
		let tags = "<tr>";
		for (const headerText of column) {       //loop to go thru headers data
//			const headerElement = document.createElement("th"); // created header
//			headerElement.textContent = headerText; // adds text to that header
//			tableHead.querySelector("tr").appendChild(headerElement); // appends it to the existing chain of headers
			tags += `<th>${headerText[i]}</tr>`;
			// if above line doesnt work, create for loop like java and change the variable
		}
		tags += "</tr>";
		tableHead.innerHTML = tags;
	}

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

	// most likely need to do for each type
	// User, User or Product, Product
	async function saveToDatabase(e, type) {
		e.preventDefault();
		const evt = e;
		console.log(evt.target);
		console.log(type);
		const formType = document.querySelector('#popupForm' + type);
		console.log(formType);
		const formData = new FormData(formType);
		const data = Object.fromEntries(formData.entries());
		console.log(formData);
		console.log(data);
		
		
		const dataAll = Array.from(formType).reduce((acc, input) => ({ ...acc,[input.id]: input.value}), {});
		console.log(dataAll);
		//const data = {};
//		for (const [key, value] of dataAll) {
//		  // Check if the key already exists and if it should be an array
//		  if (dataAll[key] !== undefined) {
//		    // If it's already an array, push the new value
//		    if (Array.isArray(dataAll[key])) {
//		      dataAll[key].push(value);
//		    } else {
//		      // Convert the single value to an array
//		      dataAll[key] = [dataAll[key], value];
//		    }
//		  } else {
//		    // If it's a single value, store it directly
//		    dataAll[key] = value;
//		  }
//		}
		
		for (var key in dataAll) {
		    if (dataAll.hasOwnProperty(key)) {
		        console.log("Key: " + key + ", Value: " + dataAll[key]);
		    }
		}
		
		await fetch(`${BASE_URL_USER}/add${type}`, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(dataAll)
		}).then(response => response.json())
			.then(dataAll => {
				console.log('Success:', dataAll)
				fetchAndDisplayData(type);	//review this is getting the correct data or type
				hideForm();
			})
			.catch((error) => {
				console.error(`Error saving ${type} to database`, error);
			})
	}
	
	////// review update and delete with cellelements instead of list item //////
	////////////////////////////////////////////////////////////////////////////

	// con este metodo cojo el texto contenido y le guardo un nuevo valor y lo cambio con replacewith
	async function editItem(item, type) {   //item is producto on otherside

		// creamos un boton delete y update para ello
		// aplicamos logica por si se clickea a ello para borrar el item con eventlistener
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
		li.textContent = `Name: ${item.name}, Email: ${item.email}`;
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


