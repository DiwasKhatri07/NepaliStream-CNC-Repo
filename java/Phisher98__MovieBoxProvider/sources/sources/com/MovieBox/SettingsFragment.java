package com.MovieBox;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBoxProvider/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J#\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/MovieBox/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/MovieBox/MovieBoxProviderPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/MovieBox/MovieBoxProviderPlugin;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "HOST_POOL", "", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "findView", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "restartApp", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/MovieBox/SettingsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,133:1\n1739#2:134\n1814#2,3:135\n37#3,2:138\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/MovieBox/SettingsFragment\n*L\n85#1:134\n85#1:135,3\n85#1:138,2\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final List<String> HOST_POOL;

    @NotNull
    private final MovieBoxProviderPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull MovieBoxProviderPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        Resources resources = this.plugin.getResources();
        if (resources == null) {
            throw new Exception("Unable to access plugin resources");
        }
        this.res = resources;
        this.HOST_POOL = CollectionsKt.listOf(new String[]{"https://api6.aoneroom.com", "https://api5.aoneroom.com", "https://api4.aoneroom.com", "https://api4sg.aoneroom.com", "https://api3.aoneroom.com"});
    }

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    private final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        int width;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int maxDialogWidth = (int) (500.0f * displayMetrics.density);
            if (displayMetrics.widthPixels > 0 && displayMetrics.widthPixels > maxDialogWidth) {
                width = maxDialogWidth;
            } else {
                width = (int) (displayMetrics.widthPixels * 0.9f);
            }
            $this$onStart_u24lambda_u240.setLayout(width, -2);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) throws Exception {
        int layoutId = this.res.getIdentifier("fragment_moviebox_settings", "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(layoutId);
        View view = inflater.inflate((XmlPullParser) layout, container, false);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            view.setBackground(this.res.getDrawable(drawableId, null));
        }
        ImageView saveIcon = (ImageView) findView(view, "saveIcon");
        ImageView hostIcon = (ImageView) findView(view, "hostIcon");
        View hostRow = findView(view, "hostRow");
        final TextView hostSubtitle = (TextView) findView(view, "hostSubtitle");
        saveIcon.setImageDrawable(getDrawable("save_icon"));
        hostIcon.setImageDrawable(getDrawable("settings_icon"));
        hostRow.setBackground(getDrawable("settings_item_background"));
        makeTvCompatible(saveIcon);
        Iterable $this$map$iv = this.HOST_POOL;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.removePrefix(it, "https://"));
            layoutId = layoutId;
        }
        Collection $this$toTypedArray$iv = (List) destination$iv$iv;
        final String[] hostNames = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        final Ref.IntRef currentHostIndex = new Ref.IntRef();
        currentHostIndex.element = RangesKt.coerceAtLeast(CollectionsKt.indexOf(this.HOST_POOL, this.sharedPref.getString("moviebox_host", this.HOST_POOL.get(4))), 0);
        hostSubtitle.setText("Current: " + hostNames[currentHostIndex.element]);
        hostRow.setOnClickListener(new View.OnClickListener() { // from class: com.MovieBox.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment settingsFragment = this.f$0;
                String[] strArr = hostNames;
                Ref.IntRef intRef = currentHostIndex;
                new AlertDialog.Builder(settingsFragment.requireContext()).setTitle("Select API Host").setSingleChoiceItems(strArr, intRef.element, new DialogInterface.OnClickListener() { // from class: com.MovieBox.SettingsFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onCreateView$lambda$1$0(intRef, settingsFragment, textView, strArr, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            }
        });
        saveIcon.setOnClickListener(new View.OnClickListener() { // from class: com.MovieBox.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment settingsFragment = this.f$0;
                new AlertDialog.Builder(settingsFragment.requireContext()).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.MovieBox.SettingsFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onCreateView$lambda$2$0(settingsFragment, dialogInterface, i);
                    }
                }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(Ref.IntRef $currentHostIndex, SettingsFragment this$0, TextView $hostSubtitle, String[] $hostNames, DialogInterface dialog, int which) {
        $currentHostIndex.element = which;
        String selected = this$0.HOST_POOL.get(which);
        this$0.sharedPref.edit().putString("moviebox_host", selected).apply();
        $hostSubtitle.setText("Current: " + $hostNames[which]);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    private final void restartApp() {
        Context context = requireContext().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            Intent restartIntent = Intent.makeRestartActivityTask(componentName);
            context.startActivity(restartIntent);
            Runtime.getRuntime().exit(0);
        }
    }
}
