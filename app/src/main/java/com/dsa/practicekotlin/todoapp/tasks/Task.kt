package com.dsa.practicekotlin.todoapp.tasks

import com.dsa.practicekotlin.todoapp.categories.TaskCategory

data class Task(val name: String, val category: TaskCategory, var isSelected: Boolean = false)
