package prakash.example.rest

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val TAG1 = "mainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var  productCardRecyclerView : RecyclerView
    lateinit var  progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productCardRecyclerView = findViewById(R.id.productCardRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        val add : Button = findViewById(R.id.add)
        val update : Button = findViewById(R.id.update)
        val get : Button = findViewById(R.id.get)

        val restApiService = RestApiService()
       // Log.d(TAG1, ApiData.products.toString())

        get.setOnClickListener {
             progressBar.visibility = View.VISIBLE
              restApiService.getProduct(::updateUI)
        }

        add.setOnClickListener {
              restApiService.addProduct(ProductItem(101, "Chawanprash", "baba ka product hai", 20, 0.0, 6.0, 4, "jaliPatan", "food", "nhi hai", listOf("khali hai")), this)
        }

        update.setOnClickListener {
            restApiService.updateProduct(ProductItem(null, "jadibooti", "kya karoge jaan k", null, null, null, null, null, null, null, null), this)
        }

        Log.d(TAG1, "calling getProduct")

        Log.d(TAG1, ApiData.products.toString())

    }

    fun updateUI(list : ArrayList<ProductItem>){
      //  Log.d(TAG, "callback called")
        progressBar.visibility = View.GONE
        val productAdapter = ProductCardAdapter(list)
//        adapter.notifyDataSetChanged()
        productCardRecyclerView.apply {
            this.adapter = productAdapter
            this.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

       // progressBar.visibility = View.GONE



    }
}