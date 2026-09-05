package com.cncverse;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: PlayZTVSettings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\bH\u0003J%\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u0013*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0014J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0013H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010 \u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/cncverse/PlayZTVSettings;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/cncverse/PlayZTVPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "playlistNames", "", "", "<init>", "(Lcom/cncverse/PlayZTVPlugin;Landroid/content/SharedPreferences;Ljava/util/List;)V", "enabledPlaylists", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "getString", "findViewByName", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "restartApp", "buildRow", "Landroid/widget/RelativeLayout;", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTVSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVSettings.kt\ncom/cncverse/PlayZTVSettings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,163:1\n777#2:164\n873#2,2:165\n1915#2,2:168\n1915#2,2:170\n1#3:167\n*S KotlinDebug\n*F\n+ 1 PlayZTVSettings.kt\ncom/cncverse/PlayZTVSettings\n*L\n36#1:164\n36#1:165,2\n89#1:168,2\n94#1:170,2\n*E\n"})
public final class PlayZTVSettings extends BottomSheetDialogFragment {

    @NotNull
    private final List<String> enabledPlaylists;

    @NotNull
    private final List<String> playlistNames;

    @NotNull
    private final PlayZTVPlugin plugin;

    @Nullable
    private final SharedPreferences sharedPref;

    public PlayZTVSettings(@NotNull PlayZTVPlugin plugin, @Nullable SharedPreferences sharedPref, @NotNull List<String> list) {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.playlistNames = list;
        Iterable $this$filter$iv = this.playlistNames;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            SharedPreferences sharedPreferences = this.sharedPref;
            if (sharedPreferences != null ? sharedPreferences.getBoolean(it, false) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        this.enabledPlaylists = CollectionsKt.toMutableList((List) destination$iv$iv);
    }

    @SuppressLint({"DiscouragedApi"})
    private final Drawable getDrawable(String name) {
        Resources resources = this.plugin.getResources();
        Integer id = resources != null ? Integer.valueOf(resources.getIdentifier(name, "drawable", "com.cncverse")) : null;
        if (id == null) {
            return null;
        }
        int it = id.intValue();
        Resources resources2 = this.plugin.getResources();
        if (resources2 == null) {
            return null;
        }
        return ResourcesCompat.getDrawable(resources2, it, (Resources.Theme) null);
    }

    @SuppressLint({"DiscouragedApi"})
    private final String getString(String name) {
        Resources resources = this.plugin.getResources();
        Integer id = resources != null ? Integer.valueOf(resources.getIdentifier(name, "string", "com.cncverse")) : null;
        if (id == null) {
            return null;
        }
        int it = id.intValue();
        Resources resources2 = this.plugin.getResources();
        if (resources2 != null) {
            return resources2.getString(it);
        }
        return null;
    }

    @SuppressLint({"DiscouragedApi"})
    private final <T extends View> T findViewByName(View view, String str) {
        Resources resources = this.plugin.getResources();
        Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier(str, "id", "com.cncverse")) : null;
        if (numValueOf != null) {
            return (T) view.findViewById(numValueOf.intValue());
        }
        return null;
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        $this$makeTvCompatible.setPadding($this$makeTvCompatible.getPaddingLeft() + 10, $this$makeTvCompatible.getPaddingTop() + 10, $this$makeTvCompatible.getPaddingRight() + 10, $this$makeTvCompatible.getPaddingBottom() + 10);
        $this$makeTvCompatible.setBackground(getDrawable("outline"));
    }

    @SuppressLint({"DiscouragedApi"})
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resources resources = this.plugin.getResources();
        Integer layoutId = resources != null ? Integer.valueOf(resources.getIdentifier("settings", "layout", "com.cncverse")) : null;
        if (layoutId == null) {
            return null;
        }
        int it = layoutId.intValue();
        Resources resources2 = this.plugin.getResources();
        return inflater.inflate((XmlPullParser) (resources2 != null ? resources2.getLayout(it) : null), container, false);
    }

    @RequiresApi(23)
    @SuppressLint({"UseSwitchCompatOrMaterialCode"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) findViewByName(view, "header_tw");
        if (textView != null) {
            textView.setText(getString("header_tw"));
        }
        TextView textView2 = (TextView) findViewByName(view, "header2_tw");
        if (textView2 != null) {
            textView2.setText(getString("header2_tw"));
        }
        ImageButton saveBtn = (ImageButton) findViewByName(view, "save_btn");
        if (saveBtn != null) {
            makeTvCompatible(saveBtn);
        }
        if (saveBtn != null) {
            saveBtn.setImageDrawable(getDrawable("save_icon"));
        }
        LinearLayout list = (LinearLayout) findViewByName(view, "list");
        Iterable $this$forEach$iv = this.playlistNames;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            if (list != null) {
                list.addView(buildRow(it));
            }
        }
        if (saveBtn != null) {
            saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVSettings$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PlayZTVSettings.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final PlayZTVSettings this$0, View it) {
        SharedPreferences.Editor $this$onViewCreated_u24lambda_u241_u240;
        SharedPreferences sharedPreferences = this$0.sharedPref;
        if (sharedPreferences != null && ($this$onViewCreated_u24lambda_u241_u240 = sharedPreferences.edit()) != null) {
            $this$onViewCreated_u24lambda_u241_u240.clear();
            Iterable $this$forEach$iv = this$0.enabledPlaylists;
            for (Object element$iv : $this$forEach$iv) {
                String it2 = (String) element$iv;
                $this$onViewCreated_u24lambda_u241_u240.putBoolean(it2, true);
            }
            $this$onViewCreated_u24lambda_u241_u240.apply();
        }
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Restart Required").setMessage("Changes saved. Restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.cncverse.PlayZTVSettings$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PlayZTVSettings.onViewCreated$lambda$1$1(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.cncverse.PlayZTVSettings$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PlayZTVSettings.onViewCreated$lambda$1$2(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$1(PlayZTVSettings this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$2(DialogInterface dlg, int i) {
        dlg.dismiss();
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Settings saved. Restart to apply changes.", (Integer) null, 2, (Object) null);
    }

    private final void restartApp() {
        ComponentName component;
        Context ctx = requireContext().getApplicationContext();
        Intent intent = ctx.getPackageManager().getLaunchIntentForPackage(ctx.getPackageName());
        if (intent == null || (component = intent.getComponent()) == null) {
            return;
        }
        ctx.startActivity(Intent.makeRestartActivityTask(component));
        Runtime.getRuntime().exit(0);
    }

    private final RelativeLayout buildRow(final String name) {
        RelativeLayout root = new RelativeLayout(requireContext());
        root.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        root.setPadding(0, 0, 0, 8);
        final CheckBox checkBox = new CheckBox(requireContext());
        checkBox.setId(View.generateViewId());
        RelativeLayout.LayoutParams $this$buildRow_u24lambda_u241_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$buildRow_u24lambda_u241_u240.addRule(20);
        $this$buildRow_u24lambda_u241_u240.addRule(15);
        checkBox.setLayoutParams($this$buildRow_u24lambda_u241_u240);
        checkBox.setChecked(this.enabledPlaylists.contains(name));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cncverse.PlayZTVSettings$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PlayZTVSettings.buildRow$lambda$1$1(this.f$0, name, compoundButton, z);
            }
        });
        TextView $this$buildRow_u24lambda_u242 = new TextView(requireContext());
        $this$buildRow_u24lambda_u242.setId(View.generateViewId());
        $this$buildRow_u24lambda_u242.setText(StringsKt.substringAfter$default(name, "playlist_", (String) null, 2, (Object) null));
        $this$buildRow_u24lambda_u242.setTextSize(16.0f);
        RelativeLayout.LayoutParams $this$buildRow_u24lambda_u242_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$buildRow_u24lambda_u242_u240.addRule(17, checkBox.getId());
        $this$buildRow_u24lambda_u242_u240.addRule(15);
        $this$buildRow_u24lambda_u242_u240.setMarginStart(16);
        $this$buildRow_u24lambda_u242.setLayoutParams($this$buildRow_u24lambda_u242_u240);
        $this$buildRow_u24lambda_u242.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVSettings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayZTVSettings.buildRow$lambda$2$1(checkBox, view);
            }
        });
        root.addView(checkBox);
        root.addView($this$buildRow_u24lambda_u242);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildRow$lambda$1$1(PlayZTVSettings this$0, String $name, CompoundButton compoundButton, boolean checked) {
        List<String> list = this$0.enabledPlaylists;
        if (checked) {
            list.add($name);
        } else {
            list.remove($name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildRow$lambda$2$1(CheckBox $checkBox, View it) {
        $checkBox.setChecked(!$checkBox.isChecked());
    }
}
