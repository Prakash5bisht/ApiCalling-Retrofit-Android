package prakash.example.rest

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val TAG = "restApiService"
class RestApiService {

    val productItems = ArrayList<ProductItem>()

    fun getProduct(updateUI : (list : ArrayList<ProductItem>) -> Unit){

        val serviceBuilder = ServiceBuilder.buildService(RestApi::class.java)

        val call : Call<Product> = serviceBuilder.getProduct()

        call.enqueue(object : Callback<Product>{

            override fun onResponse(call: Call<Product>, response: Response<Product>) {

                if(response.isSuccessful){

                    val items : ArrayList<ProductItem> = response.body()?.products as ArrayList<ProductItem>

                    Log.d(TAG, response.body()?.products.toString())

                    for(item in items){
                        productItems.add(item)
                    }
                    ApiData.setData(productItems)
                     Log.d(TAG, "calling callback")
                    updateUI(productItems)
                }

            }

            override fun onFailure(call: Call<Product>, t: Throwable) {

            }
        })

    }

    fun addProduct(productItem: ProductItem, context: Context){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)

        retrofit.addProduct(productItem).enqueue(
            object : Callback<ProductItem>{
                override fun onResponse(call: Call<ProductItem>, response: Response<ProductItem>) {
                    Toast.makeText(context, "Added product ${productItem.title}", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, response.body().toString())
                }

                override fun onFailure(call: Call<ProductItem>, t: Throwable) {
                   Log.d(TAG, "failure calling post")
                }
            }
        )

    }

    fun updateProduct(productItem: ProductItem, context: Context){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)

        retrofit.updateProduct(productItem).enqueue(
            object : Callback<ProductItem>{
                override fun onResponse(call: Call<ProductItem>, response: Response<ProductItem>) {
                     if(response.isSuccessful){
                         Toast.makeText(context, "Updated product : ${productItem.title}", Toast.LENGTH_SHORT).show()
                         Log.d(TAG, response.body().toString())
                     }else{
                         Toast.makeText(context, "unsuccessful", Toast.LENGTH_SHORT)
                     }
                }

                override fun onFailure(call: Call<ProductItem>, t: Throwable) {

                }
            }
        )
    }

}