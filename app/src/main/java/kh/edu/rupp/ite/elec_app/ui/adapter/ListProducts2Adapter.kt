package kh.edu.rupp.ite.elec_app.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.elec_app.api.model.ListProducts2
import kh.edu.rupp.ite.elec_app.databinding.ViewHolder2Binding
import kh.edu.rupp.ite.elec_app.ui.activity.ProductDetailsActivity

class ListProducts2Adapter : ListAdapter<ListProducts2, ListProducts2Adapter.ProductViewHolder2>(
    object : DiffUtil.ItemCallback<ListProducts2>(){
        override fun areItemsTheSame(oldItem: ListProducts2, newItem: ListProducts2): Boolean {
            return oldItem == newItem;
        }

        override fun areContentsTheSame(oldItem: ListProducts2, newItem: ListProducts2): Boolean {
            return oldItem == newItem;
        }

    }
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context);
        val binding = ViewHolder2Binding.inflate(layoutInflater, parent, false);
        return ProductViewHolder2(binding);
    }

    override fun onBindViewHolder(holder: ProductViewHolder2, position: Int) {
        val item = getItem(position);
        holder.bind(item);
    }

    //Class View Holder2
    class ProductViewHolder2(val itemBinding: ViewHolder2Binding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(listProducts2: ListProducts2){
            Picasso.get().load(listProducts2.image).into(itemBinding.viewHolder2Img);
            itemBinding.viewHolder2Rating.text = listProducts2.rating
            itemBinding.viewHolder2Name.text = listProducts2.name;
            itemBinding.viewHolder2Price.text = listProducts2.price;


            itemBinding.root.setOnClickListener{
                val intent = Intent(itemBinding.root.context, ProductDetailsActivity::class.java);
                intent.putExtra("name", listProducts2.name);
                intent.putExtra("image", listProducts2.image);
                intent.putExtra("price", listProducts2.price);
                intent.putExtra("description", listProducts2.description);

                itemBinding.root.context.startActivity(intent);
            }
        }
    }
}