const saveBooksForm = document.getElementById('saveBooksForm');

async function handleAddForm(event) {
    event.preventDefault();

    const form = event.currentTarget;
    const url = form.action;

    const author = document.getElementById("addFormAuthor").value;
    const title = document.getElementById("addFormTitle").value;
    const pages = document.getElementById("addFormPages").value;
    const isbn = document.getElementById("addFormISBN").value;

    let book = new Object();
    book.author = author;
    book.title = title;
    book.pages = pages;
    book.isbn = isbn;
    let bookJson = JSON.stringify(book)

    try {
        const fetchOptions = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
            body: bookJson
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
    saveBooksForm.addEventListener("submit", handleAddForm);
});