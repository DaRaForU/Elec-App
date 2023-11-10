package kh.edu.rupp.ite.elec_app.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val cardView = binding.cardBodyProductDetails;
        cardView.setBackgroundResource(R.drawable.bg_card_body_product_details);

        binding.icBack.setOnClickListener { finish(); }

        //Get Data From HomeFragment
        val name = intent.getStringExtra("name");
        val image = intent.getStringExtra("image");
        val price = intent.getStringExtra("price");
        val description = intent.getStringExtra("description");
        val imageDetail = intent.getStringExtra("imageDetail");

        binding.NameProductDetails.text = name;
        if(intent.getStringExtra("image") != null){
            Picasso.get().load(image).into(binding.imgProductDetails);
        }else{
            Picasso.get().load(imageDetail).into(binding.imgProductDetails);
        }
        binding.priceProductDetails.text = price;
        binding.descriptionProductDetails.text = description;
    }
}