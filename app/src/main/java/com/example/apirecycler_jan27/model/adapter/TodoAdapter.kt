package com.example.apirecycler_jan27.model.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycler_jan27.databinding.ItemTodoBinding
import com.example.apirecycler_jan27.model.network.models.Todo

class TodoAdapter(
    private val todoList: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    class TodoViewHolder(private val binding: ItemTodoBinding):
        RecyclerView.ViewHolder(binding.root){

            @SuppressLint("SetTextI18n")
            fun bind(todo: Todo) {
                with(binding){
                    titleTv.text = "Title: ${todo.title}"
                    todoIdTv.text = "Todo ID: ${todo.id}"
                    userIdTv.text = "User ID ${todo.userId}"
                    todoCompletedTv.text = "Completed: ${todo.completed}"

                }
            }
        }
}