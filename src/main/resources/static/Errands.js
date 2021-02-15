'use strict';

const listID = document.querySelector("#listID");
const description = document.querySelector("#description");
const priority = document.querySelector("#priority");
const deadline = document.querySelector("#deadline");
const status = document.querySelector("#status");

const searchID = document.querySelector("#searchID");

const updateID = document.querySelector("#updateID");
const updateListID = document.querySelector("#updateListID");
const updateDescription = document.querySelector("#updateDescription");
const updatePriority = document.querySelector("#updatePriority");
const updateDeadline = document.querySelector("#updateDeadline");
const updateStatus = document.querySelector("#updateStatus");

const deleteID = document.querySelector("#deleteID");

const newErrand = () => {
    const listIDVal = listID.value;
    const descriptionVal = description.value;
    const priorityVal = priority.value;
    const deadlineVal = deadline.value;
    const statusVal = status.value;
    
    let newData = {
        "listID": {"id" : listIDVal},
        "decription": descriptionVal,
        "priority": priorityVal,
        "deadline": deadlineVal,
        "status": statusVal
    }
    
    console.log(newData);
    
    console.log(JSON.stringify(newData));
    
    fetch("http://localhost:8080/Errands/create", {
        method: "POST",
        body: JSON.stringify(newData),
        headers:{
            "Content-Type":"application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`)); 
}

const showErrands = () => {
    fetch("http://localhost:8080/Errands/readAll")
    .then(response => response.json())
    .then(info => {
        for (let Errand of info) {
            console.log(Errand);
        }
    })
    .catch(err => console.error(`An Error Occured! ${err}`));
}

const searchErrands = () => {
    const searchIDVal = searchID.value;

    fetch(`http://localhost:8080/Errands/read/${searchIDVal}`)
    .then((response) => {
        if(response.status !== 200){
            throw new Error("Response not HTTP 200 OK");
        }else{
            response.json().then((returned) =>{
                console.log(returned);
            })
        }
    }).catch((err) => {
        console.error(err);
    })
}

const updateErrand = () => {
const updateIDVal = updateID.value;
const updateListIDVal = updateListID.value; 
const updateDescriptionVal = updateDescription.value;
const updatePriorityVal = updatePriority.value;
const updateDeadlineVal = updateDeadline.value;
const updateStatus = updateStatus.value;
 
 
    let data = {
        "listID": {"id" : updateListIDVal},
        "description": updateDescriptionVal, 
        "priority" : updatePriorityVal,
        "deadline" : updateDeadlineVal,
        "status" :  updateStatus
    }
 
    fetch(`http://localhost:8080/Errands/replace/${updateIDVal}`, {
        method: "PUT", 
        body: JSON.stringify(data),
        headers:{
            "Content-Type":"application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`));
}

const deleteErrand = () => {
    const deleteIDVal = deleteID.value;
 
    fetch(`http://localhost:8080/Errands/replace/${deleteIDVal}`, {
        method: "DELETE", 
        headers:{
            "Content-Type":"application/json"
        }
    })
    .then(response => response.json())
    .then(info => console.log(info))
    .catch(err => console.error(`An Error Occured! ${err}`));
}