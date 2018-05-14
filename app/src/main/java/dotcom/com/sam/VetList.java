package dotcom.com.sam;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import dotcom.com.sam.Adapters.DiagnosticListAdapter;
import dotcom.com.sam.Adapters.MatingAdapter;
import dotcom.com.sam.Adapters.PetOldageListAdapter;
import dotcom.com.sam.Adapters.VetListAdapter;
import dotcom.com.sam.Utils.Constats;

public class VetList extends AppCompatActivity {
    CardView up_button,down_button;
    LinearLayout seachlayout;
    Animation visbile_anim,invisible_anim;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_list);
        intitViewS();
        searchDrawer();
        setViewVisiblity();
        initList();


    }

    private void setViewVisiblity() {
        if(MainActivity.module_name==Constats.Module.ADOPTED)
        {// invisible search drawer for adapted
            seachlayout.setVisibility(View.GONE);
            down_button.setVisibility(View.GONE);
        }
        else {
            seachlayout.setVisibility(View.VISIBLE);
            down_button.setVisibility(View.VISIBLE);
        }
    }


    void searchDrawer()
    {
        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* down_button.setVisibility(View.VISIBLE);
                seachlayout.setVisibility(View.GONE);
                seachlayout.setAnimation(visbile_anim);*/


                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY",-seachlayout.getHeight());
                animation.setDuration(800);
                animation.start();
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 /*               seachlayout.setVisibility(View.VISIBLE);
               seachlayout.setAnimation(invisible_anim);
*/
                ObjectAnimator animation = ObjectAnimator.ofFloat(seachlayout, "translationY",0);
                animation.setDuration(800);
                animation.start();
            }
        });

    }







    void intitViewS()
    {
        up_button=findViewById(R.id.crad_buttonup);
        down_button=findViewById(R.id.crad_buttondown);
        seachlayout=findViewById(R.id.seach_layout);
        visbile_anim= AnimationUtils.loadAnimation(this,R.anim.visible_animation_);
        invisible_anim= AnimationUtils.loadAnimation(this,R.anim.invisible_animation);
        recyclerView=findViewById(R.id.recyclerview);


    }
    private void initList()
    {
        RecyclerView.Adapter adapter = null;
        if(MainActivity.module_name==Constats.Module.MATING||MainActivity.module_name==Constats.Module.ADOPTED)
       {
        adapter =new MatingAdapter(this);
        }
        else if(MainActivity.module_name==Constats.Module.PET_OLDAGE_HOME)
        {
            adapter =new PetOldageListAdapter(this);
        }
        else {
            if (PetDoctor.categeory == Constats.VET_AT_HOME || PetDoctor.categeory == Constats.VET_NEAR_ME||PetDoctor.categeory == Constats.VACCINATION) {
                adapter = new VetListAdapter(this);
            } else if (PetDoctor.categeory == Constats.DIAGNOSTICS) {
                adapter = new DiagnosticListAdapter(this);
            }
        }






        //   GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(), 2);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
