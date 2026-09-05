package com.Kartoons;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"setupSaveRestart", "", "view", "Landroid/view/View;", "fragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "Kartoons"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class SettingsFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSaveRestart(final View view, final BottomSheetDialogFragment fragment, Plugin plugin) {
        Resources resources = plugin.getResources();
        ImageView saveBtn = (ImageView) view.findViewById(resources != null ? resources.getIdentifier("save", "id", "com.phisher98") : 0);
        if (saveBtn == null) {
            return;
        }
        Resources res = plugin.getResources();
        if (res != null) {
            int saveIconId = res.getIdentifier("save_icon", "drawable", "com.phisher98");
            if (saveIconId != 0) {
                saveBtn.setImageDrawable(res.getDrawable(saveIconId, null));
            }
            int outlineId = res.getIdentifier("outline", "drawable", "com.phisher98");
            if (outlineId != 0) {
                saveBtn.setBackground(res.getDrawable(outlineId, null));
            }
        }
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.Kartoons.SettingsFragmentKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragmentKt.setupSaveRestart$lambda$0(view, fragment, view2);
            }
        });
    }

    static final void setupSaveRestart$lambda$0(View $view, final BottomSheetDialogFragment $fragment, View it) {
        final Context ctx = $view.getContext();
        if (ctx == null) {
            return;
        }
        new AlertDialog.Builder(ctx).setTitle("Restart Required").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.Kartoons.SettingsFragmentKt$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragmentKt.setupSaveRestart$lambda$0$0($fragment, ctx, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.Kartoons.SettingsFragmentKt$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragmentKt.setupSaveRestart$lambda$0$1($fragment, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSaveRestart$lambda$0$0(BottomSheetDialogFragment $fragment, Context $ctx, DialogInterface dialogInterface, int i) {
        $fragment.dismiss();
        PackageManager packageManager = $ctx.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage($ctx.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            Intent restartIntent = Intent.makeRestartActivityTask(componentName);
            $ctx.startActivity(restartIntent);
            Runtime.getRuntime().exit(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSaveRestart$lambda$0$1(BottomSheetDialogFragment $fragment, DialogInterface d, int i) {
        d.dismiss();
        $fragment.dismiss();
    }
}
