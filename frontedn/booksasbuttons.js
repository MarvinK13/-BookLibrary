fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showCarsAsDivs(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showCarsAsDivs(books) {
    const mainContainer = document.getElementById("available");
    for (var i = 0; i < books.length; i++) {
        const button = document.createElement("button");
       button.innerHTML = 'Title: '+ books[i].title + ' Author: '+ books[i].author + ' ISBN: ' + books[i].isbn;
        mainContainer.appendChild(button)
    }
}