const inputBox = document.getElementById("input-box");
const listContainer = document.getElementById("list-container");

// LOAD ALL TASKS FROM BACKEND
async function loadTasks() {
    const response = await fetch("http://localhost:8080/tasks");
    const tasks = await response.json();

    listContainer.innerHTML = ""; // Clear old UI

    tasks.forEach(task => {
        let li = document.createElement("li");
        li.innerText = task.title;
        li.dataset.id = task.id;

        if (task.completed) li.classList.add("checked");

        let span = document.createElement("span");
        span.innerHTML = "\u00d7"; // delete icon
        li.appendChild(span);

        listContainer.appendChild(li);
    });
}

// ADD TASK
async function addTask() {
    const newTaskText = inputBox.value.trim();
    if (newTaskText === "") {
        alert("You must write something!");
        return;
    }

    await fetch("http://localhost:8080/tasks", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ title: newTaskText, completed: false })
    });

    inputBox.value = "";
    loadTasks();
}

// CLICK EVENTS (CHECK + DELETE)
listContainer.addEventListener("click", async function (e) {
    if (e.target.tagName === "LI") {
        const id = e.target.dataset.id;
        const newStatus = !e.target.classList.contains("checked");

        await fetch(`http://localhost:8080/tasks/${id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({ completed: newStatus })
        });

        loadTasks();
    } else if (e.target.tagName === "SPAN") {
        const id = e.target.parentElement.dataset.id;
        await fetch(`http://localhost:8080/tasks/${id}`, { 
            method: "DELETE" 
        });
        loadTasks();
    }
});

// INITIAL LOAD
loadTasks();
