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

fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/members')
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

        const booktitle = document.createElement("textarea")
        booktitle.innerHTML =books[i].id;
        booktitle.value = books[i].title;
        option.appendChild(booktitle);
        mainContainer.appendChild(option);
    }
}

function showAllMembers(members) {
    const mainContainer = document.getElementById("dropdownmembers");
    for (var i = 0; i < members.length; i++) {
        const option = document.createElement("option");

        const booktitle = document.createElement("textarea")
        booktitle.innerHTML = members[i].id;
        booktitle.value = members[i].userId;
        option.appendChild(booktitle);
        mainContainer.appendChild(option);
    }
}



function bttnFunc(){

}