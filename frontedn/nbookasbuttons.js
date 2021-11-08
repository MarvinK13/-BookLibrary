fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books/rentedbooks')
    .then(function (response) {
        return response.json();
    })
    .then(function (rentedbooks) {
        showRentedBooksAsButtons(rentedbooks);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showRentedBooksAsButtons(rentedbooks) {
    const notavadiblecontainer = document.getElementById("notavailable");
    for (var i = 0; i < rentedbooks.length; i++) {
        const notbutton = document.createElement("p");
        notbutton.innerHTML = '<b> Title: '+ rentedbooks[i].title + '</b><br>' +
            ' Overdrawn: '+ rentedbooks[i].overdrawn + '<br>' +
            ' UserId: ' + rentedbooks[i].userId;
        notavadiblecontainer.appendChild(notbutton)
    }
}