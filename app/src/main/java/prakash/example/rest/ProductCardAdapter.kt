package prakash.example.rest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductCardAdapter(var products : List<ProductItem>) : RecyclerView.Adapter<ProductCardAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = R.layout.product_card
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val title : TextView = holder.itemView.findViewById(R.id.title)
        val price : TextView = holder.itemView.findViewById(R.id.price)
        val thumbnail : ImageView = holder.itemView.findViewById(R.id.thumbnail)
        val stock : TextView = holder.itemView.findViewById(R.id.stock)
        val discountPercentage : TextView = holder.itemView.findViewById(R.id.discountPercentage)
        val rating : TextView = holder.itemView.findViewById(R.id.rating)
        val description : TextView = holder.itemView.findViewById(R.id.description)
        val productImages : RecyclerView = holder.itemView.findViewById(R.id.images)

        title.text = products[position].title
        price.text = "$"+products[position].price.toString()
        Picasso.get().load(products[position].thumbnail).into(thumbnail)
        stock.text = "In Stock:- " + products[position].price.toString()
        discountPercentage.text = "discount:- " + products[position].discountPercentage.toString() + "%"
        rating.text = products[position].rating.toString() + "/5"
        description.text = products[position].description.toString()

        val imageList : ArrayList<String> = ArrayList<String>()

        for(image in products[position].images!!){
            imageList.add(image)
        }

        val productImagesAdapter = ProductImagesAdapter(imageList)

        productImages.apply {
            adapter = productImagesAdapter
            layoutManager = LinearLayoutManager(holder.itemView.context, RecyclerView.HORIZONTAL, false)
        }

       // Log.d("Card", products[position].thumbnail)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}