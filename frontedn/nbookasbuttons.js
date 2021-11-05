fetch('http://localhost:8080/Gradle___org_example____BookLibrary_1_0_SNAPSHOT_war/books/rentedbooks')
    .then(function (response) {
        return response.json();
    })
    .then(function (rentedbooks) {
        showCarsAsDivs(rentedbooks);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showCarsAsDivs(rentedbooks) {
    const mainContainer = document.getElementById("notavailable");
    for (var i = 0; i < rentedbooks.length; i++) {
        const notbutton = document.createElement("button");
        notbutton.innerHTML = 'Title: '+ rentedbooks[i].title + ' Overdrawn: '+ rentedbooks[i].overdrawn + ' ISBN: ' + rentedbooks[i].userId;
        mainContainer.appendChild(notbutton)
    }
}