'use strict';

const listName = document.querySelector("#listName");

const searchID = document.querySelector("#searchID");

const updateID = document.querySelector("#updateID");
const updateName = document.querySelector("#updateName");

const deleteID = document.querySelector("#deleteID");

const createList = () => {
    const listNameVal = listName.value;

    let data = {
        "name": listNameVal
    }

    fetch("http://localhost:8080/List/create", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`)); 
}

const rshowLists = () => {
    fetch("http://localhost:8080/List/readAll")
        .then(response => response.json())
        .then(info => {
            for (let ToDoList of info) {
            console.log(ToDoList);
        }
    })
    .catch(err => console.error(`An Error Occured! ${err}`)); 
}

const searchList = () => {
    const searchIDVal = searchID.value;

    fetch(`http://localhost:8080/List/read/${searchIDVal}`)
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`));
}


const updateList = () => {
    const updateIDVal = updateID.value;
    const updateNameVal = updateName.value;

    let data = {    
        "name": updateNameVal
    }

    fetch(`http://localhost:8080/List/replace/${updateIDVal}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`));
}

const deleteList = () => {
    const deleteIdVal = deleteID.value;

    fetch(`http://localhost:8080/List/delete/${deleteIdVal}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`));
}
