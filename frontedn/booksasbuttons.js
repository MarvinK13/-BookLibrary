fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showBooksAsButtons(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showBooksAsButtons(books) {
    const availablecontainer = document.getElementById("available");
    for (var i = 0; i < books.length; i++) {
        const button = document.createElement("button");
        button.innerHTML = '<b> Title: ' + books[i].title + '</b><br>' +
            ' Author: ' + books[i].author + '<br>' +
            ' ISBN: ' + books[i].isbn;
        button.onclick = function () {
            location.href = 'RentBook.html'
        };
        availablecontainer.appendChild(button)
    }
}