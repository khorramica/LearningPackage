package ir.khorrami.learningpackage.Permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.rx3.TedPermission;

import ir.khorrami.learningpackage.Login.LoginActivity;
import ir.khorrami.learningpackage.R;

public class PermissionActivity extends AppCompatActivity {

    private Button btnPermission,btnCameraPermission,btnStoragePermission;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        btnPermission = findViewById(R.id.btn_Permission);
        btnCameraPermission = findViewById(R.id.btn_Camera_Permission);
        btnStoragePermission = findViewById(R.id.btn_Storage_Permission);


        btnStoragePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
            }
        });

   btnCameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });


        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TedPermission.create()
                        .setRationaleTitle("Title")
                        .setRationaleMessage("Access to ACCESS_WIFI_STATE - CHANGE_WIFI_STATE - ACCESS_FINE_LOCATION")
                        .setDeniedCloseButtonText("رد")
                        .setRationaleConfirmText("متوجه شدم")
                        .setPermissions(Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.ACCESS_FINE_LOCATION)
                        .request()
                        .subscribe(tedPermissionResult -> {
                            if (tedPermissionResult.isGranted()) {
                                Toast.makeText(PermissionActivity.this, "Permission Successfully", Toast.LENGTH_SHORT).show();
//                                Intent i = new Intent(PermissionActivity.this, LoginActivity.class);
//                                startActivity(i);
//                                finish();
                            } else {
                                Toast.makeText(PermissionActivity.this, "Permission NOT Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }, throwable -> {
                        });

            }
        });


    }

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(PermissionActivity.this, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(PermissionActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(PermissionActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PermissionActivity.this, "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
            }
            else {
                Toast.makeText(PermissionActivity.this, "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PermissionActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PermissionActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}