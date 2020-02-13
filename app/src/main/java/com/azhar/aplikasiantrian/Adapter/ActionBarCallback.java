package com.azhar.aplikasiantrian.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.aplikasiantrian.Activity.LocketActivity;
import com.azhar.aplikasiantrian.Activity.MainActivity;
import com.azhar.aplikasiantrian.R;

import static android.content.Context.CLIPBOARD_SERVICE;

public class ActionBarCallback implements ActionMode.Callback {
    Context context;
    EditText editText;
    ClipboardManager clipboardManager;
    ClipData clipData;
    public ActionBarCallback(Context context,EditText editText){
        this.context = context;
        this.editText = editText;
        clipboardManager = (ClipboardManager)context.getSystemService(CLIPBOARD_SERVICE);

    }
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_delete) {
            clipData = ClipData.newPlainText("text","Ayam");
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(this.context, "Ayam", Toast.LENGTH_SHORT).show();
            editText.setText("Asau");
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
