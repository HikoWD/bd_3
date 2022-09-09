package example.app.bd_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showFileProperties(File file){
        TextView absoluteTextView = findViewById(R.id.AbsoluteTextView);
        absoluteTextView.setText("Absolute: " + file.getAbsolutePath());
        TextView nameTextView = findViewById(R.id.NameTextView);
        nameTextView.setText("Name: " + file.getName());
        TextView externalTextView = findViewById(R.id.ExternalTextView);
        externalTextView.setText("External: " + Environment.getExternalStorageState());
        TextView readWriteTextView = findViewById(R.id.ReadWriteTextView);
        readWriteTextView.setText(String.format("Read/Write: %s/%s",
                file.canRead() ? "yes":"no",
                file.canWrite() ? "yes":"no"));
        TextView pathTextView = findViewById(R.id.PathTextView);
        pathTextView.setText("Path: " + file.getPath());
    }

    public void onGetFilesDirClick(View view) {
        File file = this.getFilesDir();
        showFileProperties(file);
    }

    public void onGetCacheDirClick(View view) {
        File file = this.getCacheDir();
        showFileProperties(file);
    }

    public void onGetExternalFilesDirClick(View view) {
        File file = this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        showFileProperties(file);
    }

    public void onGetExternalCacheDirClick(View view) {
        File file = this.getExternalCacheDir();
        showFileProperties(file);
    }

    public void onGetExternalStorageDirectoryClick(View view) {
        File file = Environment.getExternalStorageDirectory();
        showFileProperties(file);
    }

    public void onGetExternalStoragePublicDirectoryClick(View view) {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        showFileProperties(file);
    }
}