package com.example.newone;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import com.example.newone.SQLiteDemo.MySQLiteHelper;
import com.example.newone.ui.home.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NavigationUser extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    RecyclerView recyclerView;
    SQLiteDatabase sqLiteDatabaseObj1;
    MySQLiteHelper db =new MySQLiteHelper(this);
    ArrayList<String> words = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation_user );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        System.out.println("fsjfsfhofwhoog");
        db.getReadableDatabase();
        Cursor obj = db.getAllData( db);
        if(obj.getCount() == 0){
            System.out.println("fsjfsfhofwhoog");

        }

        int i=1;
        while (obj.moveToNext()){
            StringBuffer buffer = new StringBuffer();
            buffer.append(String.valueOf(
                    i
            )+": "+obj.getString(0)+" "+obj.getString(1)+" "+obj.getString(2)+" "+obj.getString(3)+" "+obj.getString(4)+" "+obj.getString(5)+" "+obj.getString(6)+" "+obj.getString(7)+" "+obj.getString(8)+"n");
            words.add(
                    buffer.toString()
            );

            i++;
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);


//        Fragment newFragment = new HomeFragment( );
//        FragmentTransaction transaction = getSupportFragmentManager( ).beginTransaction( );
//        transaction.replace( R.id.nav_host_fragment, newFragment );
//        transaction.addToBackStack( null );
//        transaction.commit( );

        //replaceFragment( new HomeFragment(), R.id.nav_host_fragment, HomeFragment.class.getName( ) );


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        super.onBackPressed( );
        finishAffinity();
    }

    void replaceFragment(Fragment mFragment, int id, String tag) {
        FragmentTransaction mTransaction = getSupportFragmentManager( ).beginTransaction( );
        mTransaction.replace( id, mFragment );
        mTransaction.addToBackStack( tag );
        mTransaction.commit( );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater( ).inflate( R.menu.navigation_user, menu );
        return true;

    }

    @Override
    public boolean onSupportNavigateUp() {
       // NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );
       // return NavigationUI.navigateUp( navController, mAppBarConfiguration )
        //        || super.onSupportNavigateUp( );
        return true;
    }
}
