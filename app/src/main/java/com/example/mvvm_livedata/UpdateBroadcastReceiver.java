package com.example.mvvm_livedata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.mvvm_livedata.view.ui.ProjectListFragment;

/**
 * public class Update Broadcast Receiver
 *
 * This class is used for create pending intent
 *
 * @author Eugen Benčat
 * @version 1.0
 * @date 2019-2020
 */
public class UpdateBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(context);
        lbm.sendBroadcast(intent);

        // toast show  when alarm receiver is broadcasted
        Toast.makeText(context, "AlarmReceiver is broadcasted", Toast.LENGTH_LONG).show();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(ProjectListFragment.mMyBroadcastReceiver);
        context.sendBroadcast(broadcastIntent);

        
    }
}
