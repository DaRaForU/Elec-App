package kh.edu.rupp.ite.elec_app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.elec_app.view.fragment.HomeFragment
import kh.edu.rupp.ite.elec_app.view.fragment.MessageFragment
import kh.edu.rupp.ite.elec_app.view.fragment.ProfileFragment
import kh.edu.rupp.ite.elec_app.R
import kh.edu.rupp.ite.elec_app.view.fragment.TutorialFragment
import kh.edu.rupp.ite.elec_app.databinding.ActivityMainBinding
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        //Show Home Fragment Default
        showFragment(HomeFragment());

        binding.bottomBar.setOnTabSelectListener(object: AnimatedBottomBar.OnTabSelectListener{
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when(newIndex){
                    0 -> showFragment(HomeFragment());
                    1 -> showFragment(TutorialFragment());
                    2 -> showFragment(MessageFragment());
                    3 -> showFragment(ProfileFragment());
                }
            }

        })
    }

    private fun showFragment(fragment: Fragment){
        //Fragment Manager
        val fragmentManager = supportFragmentManager;

        //Fragment Transaction
        val fragmentTransaction = fragmentManager.beginTransaction();

        //Replace fragment in FrameLayout
        fragmentTransaction.replace(R.id.frameLayout, fragment);

        //Commit Transaction
        fragmentTransaction.commit();
    }
}



