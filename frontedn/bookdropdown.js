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

function showTitlesAsOptions(books) {
    const availablecontainer = document.getElementById("books");
    for (var i = 0; i < books.length; i++) {
        const option = document.createElement("option");
        option.innerHTML = 'Title: ' + books[i].title;
        availablecontainer.appendChild(option)
    }
}