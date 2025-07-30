document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('createUserBtn').addEventListener('click', showForm.bind(null, 'user'));
    document.getElementById('getUsersBtn').addEventListener('click', fetchAndDisplayData.bind(null, 'users'));
    document.getElementById('createProductBtn').addEventListener('click', showForm.bind(null, 'product'));
    document.getElementById('getProductsBtn').addEventListener('click', fetchAndDisplayData.bind(null, 'products'));

    document.getElementById('sendUserBtn').addEventListener('click', () => saveToDatabase('users', 'user'));
    document.getElementById('cancelUserBtn').addEventListener('click', hideForm);
    document.getElementById('sendProductBtn').addEventListener('click', () => saveToDatabase('products', 'product'));
    document.getElementById('cancelProductBtn').addEventListener('click', hideForm);

    function showForm(type) {
        if (type === 'user') {
            document.getElementById('userForm').classList.remove('hidden');
            document.getElementById('productForm').classList.add('hidden');
        } else if (type === 'product') {
            document.getElementById('productForm').classList.remove('hidden');
            document.getElementById('userForm').classList.add('hidden');
        }
    }

    function hideForm() {
        document.getElementById('userForm').classList.add('hidden');
        document.getElementById('productForm').classList.add('hidden');
    }

    async function fetchAndDisplayData(type) {
        try {
            const response = await fetch(`/get${type}`);
            const data = await response.json();
            displayList(data, type);
        } catch (error) {
            console.error(`Error fetching ${type}:`, error);
        }
    }

    function displayList(data, type) {
        const listId = type === 'users' ? 'userList' : 'productList';
        const listElement = document.getElementById(listId);
        listElement.innerHTML = '';

        data.forEach(item => {
            const li = document.createElement('li');
            li.id = item.id;
            li.textContent = `ID: ${item.id}, Name: ${item.name}`;

            const updateButton = document.createElement('button');
            updateButton.textContent = 'Update';
            updateButton.addEventListener('click', () => editItem(item, type));

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            deleteButton.addEventListener('click', () => deleteItem(item.id, type));

            li.appendChild(updateButton);
            li.appendChild(deleteButton);

            listElement.appendChild(li);
        });
    }

    async function saveToDatabase(type, formType) {
        const formData = new FormData(document.getElementById(formType + 'Form'));
        const data = Object.fromEntries(formData.entries());

        try {
            const response = await fetch(`/add${type}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                fetchAndDisplayData(type);
                hideForm();
            } else {
                console.error(`Error saving ${formType} to database`);
            }
        } catch (error) {
            console.error(`Error saving ${formType} to database`, error);
        }
    }

    async function editItem(item, type) {
        // Implement update logic here
        alert('Update logic not implemented');
    }

    async function deleteItem(id, type) {
        try {
            const response = await fetch(`/delete${type}/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                fetchAndDisplayData(type);
            } else {
                console.error(`Error deleting ${type} with id ${id}`);
            }
        } catch (error) {
            console.error(`Error deleting ${type} with id ${id}`, error);
        }
    }
});