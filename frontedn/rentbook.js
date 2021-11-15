fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books')
    .then(function (response) {
        return response.json();
    })
    .then(function (books) {
        showAllBooks(books);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books/members')
    .then(function (response) {
        return response.json();
    })
    .then(function (members) {
        showAllMembers(members);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });


function showAllBooks(books) {
    const mainContainer = document.getElementById("dropdownbooks");
    for (var i = 0; i < books.length; i++) {
        const option = document.createElement("option");
        option.innerHTML =books[i].title;
        option.value = books[i].id;
        mainContainer.appendChild(option);
    }
}

function showAllMembers(members) {
    const mainContainer = document.getElementById("dropdownmembers");
    for (var i = 0; i < members.length; i++) {
        const option = document.createElement("option");
        option.innerHTML = members[i].name;
        option.value = members[i].id;
        mainContainer.appendChild(option);
    }
}