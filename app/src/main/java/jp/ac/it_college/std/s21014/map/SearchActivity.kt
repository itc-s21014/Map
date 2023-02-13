package jp.ac.it_college.std.s21014.map

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import jp.ac.it_college.std.s21014.map.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    val data = mutableListOf(
        "那覇市",
        "宜野湾市",
        "石垣市",
        "浦添市",
        "名護市",
        "糸満市",
        "沖縄市",
        "豊見城市",
        "うるま市",
        "宮古島市",
        "南城市",
        "国頭村",
        "大宜味村",
        "東村",
        "今帰仁村",
        "本部町",
        "恩納村",
        "宜野座村",
        "金武町",
        "伊江村",
        "読谷村",
        "嘉手納町",
        "北谷町",
        "北中城村",
        "中城村",
        "西原町",
        "与那原町",
        "南風原町",
        "渡嘉敷村",
        "座間味村",
        "粟国村",
        "渡名喜村",
        "南大東村",
        "北大東村",
        "伊平屋村",
        "伊是名村",
        "久米島町",
        "八重瀬町",
        "多良間村",
        "竹富町",
        "与那国町",
    )

    val data2 = mutableListOf(
        "樋川", "天久", "牧志",
        "久茂地", "若狭", "壺川",
        "小禄",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(
            this, R.layout.simple_list_item_1, data
        )
        binding.list.adapter = adapter

        val adapter2 = ArrayAdapter(
            this, R.layout.simple_list_item_1, data2
        )
        binding.List.adapter = adapter2

        binding.back.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        binding.search2.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}