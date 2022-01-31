package com.example.apirecycler_jan27.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycler_jan27.databinding.ItemTodoBinding
import com.example.apirecycler_jan27.model.network.models.Todo

class TodoAdapter(
    private val todoList: MutableList<Todo> = mutableListOf<Todo>()

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
                    userIdTv.text = todo.userId.toString()
                    todoIdTv.text = todo.id.toString()
                    titleTv.text = todo.title
                    todoCompletedTv.text = todo.completed.toString()

                }
            }
        }
}