function addTask() {
  const taskInput = document.getElementById("taskInput");
  const taskText = taskInput.value.trim();

  if (taskText === "") return alert("Please enter a task.");

  const taskList = document.getElementById("taskList");

  const li = document.createElement("li");
  li.className = "task";

  const span = document.createElement("span");
  span.innerText = taskText;
  span.onclick = () => {
    li.classList.toggle("completed");
  };

  const deleteBtn = document.createElement("button");
  deleteBtn.innerText = "X";
  deleteBtn.onclick = () => li.remove();

  li.appendChild(span);
  li.appendChild(deleteBtn);

  taskList.appendChild(li);

  taskInput.value = "";
}

