package com.dsa.practicekotlin.todoapp.categories

sealed class TaskCategory(var isSelected: Boolean = true) {
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object University: TaskCategory()
    object Programming: TaskCategory()
    object Other: TaskCategory()

}
