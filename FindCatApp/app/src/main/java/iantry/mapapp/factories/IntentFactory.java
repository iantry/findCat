package iantry.mapapp.factories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import iantry.mapapp.activities.CatActivity;

/**
 * Created by Andrey on 15.03.2017.
 */

public class IntentFactory {

    public static final String IMAGE_RES = "imageRes";
    public static final String NAME = "name";
    public static final String RACE = "race";
    public static final String DESC = "description";


    public static void startCatActivity(Context context, int imageRes, String name, String race, String desc){

        Intent catIntent = new Intent(context, CatActivity.class);
        catIntent.putExtra(IMAGE_RES, imageRes);
        catIntent.putExtra(NAME, name);
        catIntent.putExtra(RACE, race);
        catIntent.putExtra(DESC, desc);
        context.startActivity(catIntent);
    }

    public static void call(Context context){

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + "000000000"));
        try{
            context.startActivity(intent);
        }
        catch (Exception e){
           intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:000000000"));
           context.startActivity(intent);
        }
    }
}
