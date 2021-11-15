fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books/rentedbooks')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showAllBooks(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });




function showAllBooks(books) {
    const mainContainer = document.getElementById("books");
    for (var i = 0; i < books.length; i++) {
        const option = document.createElement("option");
        option.innerHTML =books[i].title + " | "+books[i].name;
        option.value = books[i].bookId;
        mainContainer.appendChild(option);
    }
}