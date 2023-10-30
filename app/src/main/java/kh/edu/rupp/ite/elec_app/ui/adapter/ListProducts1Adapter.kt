package kh.edu.rupp.ite.elec_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.elec_app.api.model.ListProducts1
import kh.edu.rupp.ite.elec_app.databinding.ViewHolder1Binding

class ListProducts1Adapter: ListAdapter<ListProducts1, ListProducts1Adapter.ProductViewHolder1>(
    object: DiffUtil.ItemCallback<ListProducts1>(){
        override fun areItemsTheSame(oldItem: ListProducts1, newItem: ListProducts1): Boolean {
            return oldItem == newItem;
        }

        override fun areContentsTheSame(oldItem: ListProducts1, newItem: ListProducts1): Boolean {
            return oldItem == newItem;
        }

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder1 {
        val layoutInflater = LayoutInflater.from(parent.context);
        val binding =ViewHolder1Binding.inflate(layoutInflater, parent, false);
        return ProductViewHolder1(binding);
    }

    override fun onBindViewHolder(holder: ProductViewHolder1, position: Int) {
        val item = getItem(position);
        holder.bind(item);
    }


    //Class View Holder
    class ProductViewHolder1(val itemBinding: ViewHolder1Binding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(listProducts1: ListProducts1){
            Picasso.get().load(listProducts1.image).into(itemBinding.viewHolder1Img);
            itemBinding.viewHolder1Name.text = listProducts1.name;
            itemBinding.viewHolder1PriceNumber.text = listProducts1.price;
        }
    }


}