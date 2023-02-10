package jp.ac.it_college.std.s21014.map

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import jp.ac.it_college.std.s21014.map.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: ArrayAdapter<String>

    val parkList = listOf(
        "緑ヶ丘公園", "崇元寺公園", "与儀公園",
        "美栄橋公園", "真嘉比中央公園", "旭ヶ丘公園",
        "天久ちゅらまち公園", "壷川中公園", "牧志公園",
        "弁ヶ岳公園", "末吉公園", "黄金森公園",
        "森口公園", "にじ公園", "海軍壕公園",
    )

    val data = mutableListOf(
        "沖縄県",
        "北海道",
        "青森県",
        "岩手県",
        "宮城県",
        "秋田県",
        "山形県",
        "福島県",
        "茨城県",
        "栃木県",
        "群馬県",
        "埼玉県",
        "千葉県",
        "東京都",
        "神奈川県",
        "新潟県",
        "富山県",
        "石川県",
        "福井県",
        "山梨県",
        "長野県",
        "岐阜県",
        "静岡県",
        "愛知県",
        "三重県",
        "滋賀県",
        "京都府",
        "大阪府",
        "兵庫県",
        "奈良県",
        "和歌山県",
        "鳥取県",
        "島根県",
        "岡山県",
        "広島県",
        "山口県",
        "徳島県",
        "香川県",
        "愛媛県",
        "高知県",
        "福岡県",
        "佐賀県",
        "長崎県",
        "熊本県",
        "大分県",
        "宮崎県",
        "鹿児島県",
    )

    val data2 = mutableListOf(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListView()
        setupSearchView()
    }

    private fun setupListView() {
        adapter = ArrayAdapter(this, R.layout.simple_list_item_1, parkList)
        binding.listView.adapter = adapter
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val isMatchFound = parkList.contains(p0)
                val msg = if (isMatchFound) "Found: $p0" else getString(R.string.no)
                Toast.makeText(this@SearchActivity, msg, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

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
        binding.search3.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}