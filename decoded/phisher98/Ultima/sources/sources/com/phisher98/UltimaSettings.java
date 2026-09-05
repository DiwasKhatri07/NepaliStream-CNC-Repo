package com.phisher98;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.utils.AppContextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J#\u0010\u001f\u001a\u0002H \"\b\b\u0000\u0010 *\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0002\u0010!J\f\u0010\"\u001a\u00020#*\u00020\u0016H\u0002J\u001a\u0010$\u001a\u00020#H\u0007b\u0010\b%\u0012\f\b&\u0012\b\b\fJ\u0004\b\b('J\b\u0010(\u001a\u00020#H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/phisher98/UltimaSettings;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "plugin", "Lcom/phisher98/UltimaPlugin;", "getPlugin", "()Lcom/phisher98/UltimaPlugin;", "param1", "", "param2", "sm", "Lcom/phisher98/UltimaStorageManager;", "res", "Landroid/content/res/Resources;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getLayout", "Landroid/view/View;", "name", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getString", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "show", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "restartApp", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Settings.kt\ncom/phisher98/UltimaSettings\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,173:1\n29#2:174\n*S KotlinDebug\n*F\n+ 1 Settings.kt\ncom/phisher98/UltimaSettings\n*L\n128#1:174\n*E\n"})
public final class UltimaSettings {

    @NotNull
    private final AppCompatActivity activity;
    private BottomSheetDialog dialog;

    @Nullable
    private String param1;

    @Nullable
    private String param2;

    @NotNull
    private final UltimaPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final UltimaStorageManager sm;

    public UltimaSettings(@NotNull AppCompatActivity activity) throws Exception {
        this.activity = activity;
        UltimaPlugin companion = UltimaPlugin.INSTANCE.getInstance();
        if (companion == null) {
            throw new Exception("Plugin not initialized");
        }
        this.plugin = companion;
        this.sm = UltimaStorageManager.INSTANCE;
        Resources resources = this.plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    @NotNull
    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    @NotNull
    public final UltimaPlugin getPlugin() {
        return this.plugin;
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Unable to find drawable " + name);
    }

    private final String getString(String name) {
        int id = this.res.getIdentifier(name, "string", "com.phisher98");
        return this.res.getString(id);
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    @SuppressLint({"SetTextI18n"})
    public final void show() {
        this.dialog = new BottomSheetDialog(this.activity);
        BottomSheetDialog bottomSheetDialog = null;
        View settings = getLayout("settings", LayoutInflater.from(this.activity), null);
        ImageView saveBtn = (ImageView) findView(settings, "save");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings ultimaSettings = this.f$0;
                new AlertDialog.Builder(ultimaSettings.activity).setTitle("Restart Required").setMessage("Changes have been saved. Do you want to restart the app to apply them ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UltimaSettings.show$lambda$0$0(ultimaSettings, dialogInterface, i);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UltimaSettings.show$lambda$0$1(ultimaSettings, dialogInterface, i);
                    }
                }).show();
            }
        });
        ImageView configBtn = (ImageView) findView(settings, "config_img");
        configBtn.setImageDrawable(getDrawable("edit_icon"));
        makeTvCompatible(configBtn);
        configBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings.show$lambda$1(this.f$0, view);
            }
        });
        ImageView reorderBtn = (ImageView) findView(settings, "reorder_img");
        reorderBtn.setImageDrawable(getDrawable("edit_icon"));
        makeTvCompatible(reorderBtn);
        reorderBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings.show$lambda$2(this.f$0, view);
            }
        });
        ImageView appSettingsSyncBtn = (ImageView) findView(settings, "app_settings_sync_img");
        appSettingsSyncBtn.setImageDrawable(getDrawable("edit_icon"));
        makeTvCompatible(appSettingsSyncBtn);
        appSettingsSyncBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings.show$lambda$3(this.f$0, view);
            }
        });
        ImageView guideIcon = (ImageView) findView(settings, "guide_icon");
        guideIcon.setImageDrawable(getDrawable("ic_eye"));
        makeTvCompatible(guideIcon);
        guideIcon.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings.show$lambda$4(this.f$0, view);
            }
        });
        TextView deleteBtn = (TextView) findView(settings, "delete_img");
        deleteBtn.setText("Reset");
        makeTvCompatible(deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaSettings ultimaSettings = this.f$0;
                AppContextUtils.setDefaultFocus$default(AppContextUtils.INSTANCE, new AlertDialog.Builder(ultimaSettings.activity).setTitle("Reset Ultima").setMessage("This will delete all selected sections.").setPositiveButton("Reset", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaSettings$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UltimaSettings.show$lambda$5$0(this.f$0, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show(), 0, 1, (Object) null);
            }
        });
        BottomSheetDialog bottomSheetDialog2 = this.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog2 = null;
        }
        bottomSheetDialog2.setContentView(settings);
        BottomSheetDialog bottomSheetDialog3 = this.dialog;
        if (bottomSheetDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog3;
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0$0(UltimaSettings this$0, DialogInterface dialogInterface, int i) {
        this$0.plugin.reload();
        BottomSheetDialog bottomSheetDialog = null;
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved and Restarting...", (Integer) null, 2, (Object) null);
        BottomSheetDialog bottomSheetDialog2 = this$0.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.dismiss();
        this$0.restartApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0$1(UltimaSettings this$0, DialogInterface d, int i) {
        BottomSheetDialog bottomSheetDialog = null;
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved. Restart later to apply changes.", (Integer) null, 2, (Object) null);
        d.dismiss();
        BottomSheetDialog bottomSheetDialog2 = this$0.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.dismiss();
    }

    static final void show$lambda$1(UltimaSettings this$0, View it) {
        UltimaConfigureExtensions configure = new UltimaConfigureExtensions(this$0.activity);
        configure.show();
        BottomSheetDialog bottomSheetDialog = this$0.dialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
    }

    static final void show$lambda$2(UltimaSettings this$0, View it) {
        UltimaReorder reorder = new UltimaReorder(this$0.activity);
        reorder.show();
        BottomSheetDialog bottomSheetDialog = this$0.dialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
    }

    static final void show$lambda$3(UltimaSettings this$0, View it) {
        UltimaConfigureAppSettingsSync appSync = new UltimaConfigureAppSettingsSync(this$0.activity);
        appSync.show();
        BottomSheetDialog bottomSheetDialog = this$0.dialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
    }

    static final void show$lambda$4(UltimaSettings this$0, View it) {
        Uri uri = Uri.parse("https://github.com/phisher98/cloudstream-extensions-phisher/blob/master/docs/ULTIMA_SYNC_SETUP.md");
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        this$0.activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5$0(UltimaSettings this$0, DialogInterface dialogInterface, int i) {
        this$0.sm.deleteAllData();
        this$0.plugin.reload();
        BottomSheetDialog bottomSheetDialog = null;
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Sections cleared", (Integer) null, 2, (Object) null);
        BottomSheetDialog bottomSheetDialog2 = this$0.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.dismiss();
    }

    private final void restartApp() {
        Context context = this.activity.getApplicationContext();
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
