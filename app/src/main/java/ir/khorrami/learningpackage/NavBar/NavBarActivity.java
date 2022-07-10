package ir.khorrami.learningpackage.NavBar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ir.khorrami.learningpackage.MessagesFragment;
import ir.khorrami.learningpackage.R;

public class NavBarActivity extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;
    TextView txtBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar2);
        ChangeStatusbarColor();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        txtBadge = findViewById(R.id.txtBadge);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottom_navigatin_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setBackground(null);
//        bottomNavigationView.getMenu().getItem(2).setChecked(false);


        //badge position
        MenuItem menuItem = bottomNavigationView.getMenu().getItem(1);
        Log.d("Icon position1 : ", String.valueOf(menuItem.getIcon().getBounds().centerX()));
        Log.d("Icon position2 : ", String.valueOf(menuItem.getIcon().getBounds().exactCenterX()));
        Log.d("Icon position3 : ", (String) menuItem.getTitle());
        Log.d("Icon position4 : ", String.valueOf(menuItem.getIcon().getCurrent().getBounds().right));
        Log.d("Icon position5 : ", String.valueOf(menuItem.getIcon().getCurrent().getIntrinsicWidth()));
        Log.d("Icon position6 : ", String.valueOf(menuItem.getIcon().getCurrent().getIntrinsicHeight()));
//        txtBadge.setLeft(24);
//        txtBadge.setTop(1);


//        BadgeDrawable badge =bottomNavigationView.getOrCreateBadge(R.id.messagesFragment);
////                BadgeDrawable.create(bottomNavigationView.getContext());
//               // bottomNavigationView.getOrCreateBadge(R.id.messagesFragment);
////        badge.setBadgeGravity(BadgeDrawable.TOP_START);
//        badge.setHorizontalOffset(12);
//        badge.setVerticalOffset(8);
//        badge.setBackgroundColor(Color.RED);
//        badge.setBadgeTextColor(Color.WHITE);
//        Canvas canvas = new Canvas();
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.RED);
//        canvas.drawCircle(50,50,45,paint);
//        badge.draw(canvas);
//
//        badge.setNumber(4);
        bottomNavigationView.setSelectedItemId(R.id.homeFragment);
    }

    private void ChangeStatusbarColor() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.my_statusbar_color));
    }

    @Override
    public void onClick(View view) {
        bottomNavigationView.setSelectedItemId(R.id.homeFragment);
        bottomNavigationView.performClick();

    }
}