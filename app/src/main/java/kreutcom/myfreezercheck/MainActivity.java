package kreutcom.myfreezercheck;
;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import kreutcom.myfreezercheck.Heladeras.AdaptadorHeladeraRecycleView;
import kreutcom.myfreezercheck.Heladeras.manejoHeladerasYListas;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout drawer;
    public Toolbar toolbar;

    public NavigationView navigationView;
    private DrawetSeleccionado drawerSeleccionado;

    public enum DrawetSeleccionado {
        LISTAHELADERAS, MASCOTAS, FINANCIERO;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
  //     setupNavigation();
/*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_host,
                    new manejoHeladerasYListas()).commit();
            navigationView.setCheckedItem(R.id.nav_cuenta);
        }
*/
    }

    // Setting Up One Time Navigation

    private void setupNavigation() {

        drawerSeleccionado = DrawetSeleccionado.LISTAHELADERAS;

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(this);


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_cuenta);
    }
/*
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(drawer, Navigation.findNavController(this, R.id.fragment_host));
    }
*/
/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_cuenta:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_lista_heladeras,
                        new manejoHeladerasYListas()).commit();
                break;
            case R.id.nav_mensajes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_lista_mascotas,
                        new ChatFragment()).commit();
                break;
            case R.id.nav_grafico_financiero:
           /*     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_lista_heladeras,
                        new ProfileFragment()).commit();

                break;
            case R.id.nav_settings:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_misgrupos:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setChecked(true);

        drawer.closeDrawers();

        int id = menuItem.getItemId();

        switch (id) {
            case R.id.nav_cuenta:
                if (drawerSeleccionado != DrawetSeleccionado.LISTAHELADERAS) {
                    //AQUI SE COMPLICA POR EL USO DE NAVIGATION CONTROLLER
                    //SOLUCIÓN SON 2, 1 HACERLO MAS DINÁMICO
                    //O SINO HACER 1 OTRO ENUM QUE CONTENGA A CADA 1 DE LAS VISTAS
                    drawerSeleccionado = DrawetSeleccionado.LISTAHELADERAS;
              //      navController.navigate(R.id.action_fragment_Mascotas_to_manejoHeladerasYListas);
                }
                break;
            case R.id.nav_mensajes:
                if (drawerSeleccionado != DrawetSeleccionado.MASCOTAS){
                    drawerSeleccionado = DrawetSeleccionado.MASCOTAS;
               //     navController.navigate(R.id.action_manejoHeladerasYListas_to_fragment_Mascotas);
                }
                break;

            case R.id.nav_grafico_financiero:
                if (drawerSeleccionado != DrawetSeleccionado.FINANCIERO) {
                    drawerSeleccionado = DrawetSeleccionado.FINANCIERO;
                }
                //       navController.navigate(R.id.thirdFragment);
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_misgrupos:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}