package jp.ac.it_college.std.s21014.map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import jp.ac.it_college.std.s21014.map.databinding.ActivitySubBinding
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id") ?: "1"

        onMarkerSet(id)
    }

    private fun onMarkerSet(id: String) {
        val assetManager = resources.assets
        val inputStream = assetManager.open("data.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val dataJson: String = bufferedReader.readText()
        val rootJson = JSONArray(dataJson)

        for (i in 0 until rootJson.length()) {
            val data = rootJson.getJSONObject(i)
            val currentId = data.getString("id")
            if (currentId == id) {
                binding.parkName.text = data.getString("park")
                binding.time.text = data.getString("time")
                binding.distance.text = data.getString("distance")
                Picasso.get().load(data.getString("link"))
                    .into(binding.parkImage)
            }
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        binding.Search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        binding.map.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}