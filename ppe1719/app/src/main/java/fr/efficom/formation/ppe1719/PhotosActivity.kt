package fr.efficom.formation.ppe1719

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_photos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosActivity : AppCompatActivity() {

val bornesService: BornesService

    init {
    bornesService = createBornesService()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
         getPhotoAsList()


    }

    fun getPhotoAsList() {
        val code = intent.getStringExtra("codeEvent")
        val request = bornesService.getPhotoAsList(code)
        request.enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

            }
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photos = response.body()
                if (photos !=null){
                    Log.d("PhotosActivity", "Photos: $photos")
                    //création de l'adapter et on le renseigne dans le recycler view
                    photosRecyclerView.adapter = PhotosAdapter(photos)
                    photosRecyclerView.layoutManager = LinearLayoutManager(this@PhotosActivity)
                    /*
                    Glide.with(imageViewPhoto.context)
                        .load(photos[0].url)
                        .into(imageViewPhoto)
                    */
                }
            }



        })
    }
}
