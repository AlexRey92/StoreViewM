package com.example.viewmodelplatzi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelplatzi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private  var adapter=ProductAdapter()
    var listofProducts= mutableListOf<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setRecyclerView()
        getListofProducts()
        setContentView(binding.root)


    }

    private fun getListofProducts() {
        CoroutineScope(Dispatchers.IO).launch{
            val call= service.getProducts()
            val response= call.body()
            runOnUiThread{
                if (call.isSuccessful){
                    listofProducts=response?.map { ProductResponse->ProductResponse.mapToProduct() } as MutableList<Product>
                    listofProducts?.forEach{
                        Log.d("API","Categoria:${it.category}")
                    }
                    val distinctProducts= listofProducts?.distinctBy { product -> product.category.name }

                    adapter.submitList(distinctProducts)

                }
            }
        }
    }

    private fun setRecyclerView() {
        binding.mainRV.let {
            it.layoutManager=GridLayoutManager(this,2)
            it.adapter=adapter
        }
    }
}