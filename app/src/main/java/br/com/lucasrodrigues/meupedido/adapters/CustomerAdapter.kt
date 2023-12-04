package br.com.lucasrodrigues.meupedido.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.data.models.Customer

class CustomerAdapter(
    private var customers: List<Customer>
) : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {
    inner class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val customerNameTextView = itemView.findViewById<TextView>(R.id.tv_item_customer_name)
        val customerEmailTextView = itemView.findViewById<TextView>(R.id.tv_item_customer_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        return CustomerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_customer,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = customers.size

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val item = customers[position]
        holder.customerNameTextView.text = item.name
        holder.customerEmailTextView.text = item.email
    }

    fun updateDate(newCustomers: List<Customer>){
        customers = newCustomers
        notifyDataSetChanged()
    }

}
