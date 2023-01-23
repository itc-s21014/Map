package jp.ac.it_college.std.s21014.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import jp.ac.it_college.std.s21014.map.databinding.ActivityParkDetailsBinding

class ParkDetails : AppCompatActivity() {
    private lateinit var binding: ActivityParkDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityParkDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btn = findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            finish()
        }
    }
}