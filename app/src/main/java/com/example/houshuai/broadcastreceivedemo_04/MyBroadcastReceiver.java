package com.example.houshuai.broadcastreceivedemo_04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HouShuai on 2016/6/2.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
   /*
   * 获得短信内容
   * */
        Bundle extras = intent.getExtras();
        Object[] objects = (Object[]) extras.get("pdus");
        for (Object pdus:
                objects
             ) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus);
            String content = smsMessage.getDisplayMessageBody();
            String teleNum = smsMessage.getDisplayOriginatingAddress();
            if (teleNum != null && getAllListBlackList().contains(teleNum)) {

                abortBroadcast();
            } else {

            }

        }

    }


    public List<String> getAllListBlackList() {

        LinkedList<String> names = new LinkedList<>();
        Collections.addAll(names, "110", "119", "114");


        return names;
    }
}
