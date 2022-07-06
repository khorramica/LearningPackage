package ir.khorrami.learningpackage.NavBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ir.khorrami.learningpackage.HomeFragment;
import ir.khorrami.learningpackage.R;

public class NavBarActivity extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar2);
        ChangeStatusbarColor();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottom_navigatin_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setBackground(null);
//        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
    }

    private void ChangeStatusbarColor() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }

    @Override
    public void onClick(View view) {
        bottomNavigationView.setSelectedItemId(R.id.mainFragment);
        bottomNavigationView.performClick();

    }
}