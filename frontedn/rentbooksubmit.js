const rentbooks = document.getElementById('rentbooks');

async function handleAddForm(event) {
    event.preventDefault();

    const form = event.currentTarget;
    const url = form.action;

    const userId = document.getElementById("dropdownmembers").value;
    const bookId = document.getElementById("dropdownbooks").value;

    let rentBook = new Object();
    rentBook.userId = userId;
    rentBook.bookId= bookId;
    let rentedBookjson = JSON.stringify(rentBook)

    try {
        const fetchOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
            body: rentedBookjson
        };

        const response = await fetch(url, fetchOptions);

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
    } catch (error) {
        console.error(error);
    }
}

window.addEventListener('load', (event) => {
    rentbooks.addEventListener("submit", handleAddForm);
});