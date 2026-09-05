package com.horis.cncverse;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: CNCVerseSettings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/CNC_Verse_Mobile/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\rH\u0003J%\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u0013*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u001aJ&\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\b\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0010\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/horis/cncverse/CNCVerseSettings;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/horis/cncverse/CNCVersePlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "studios", "", "Lcom/horis/cncverse/StudioOption;", "<init>", "(Lcom/horis/cncverse/CNCVersePlugin;Landroid/content/SharedPreferences;Ljava/util/List;)V", "enabledStudios", "", "", "isStudioEnabled", "", "option", "makeTvCompatible", "", "Landroid/view/View;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "getString", "findViewByName", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "restartApp", "getStudioRow", "Landroid/widget/RelativeLayout;", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCNCVerseSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CNCVerseSettings.kt\ncom/horis/cncverse/CNCVerseSettings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n777#2:204\n873#2,2:205\n1586#2:207\n1661#2,3:208\n1915#2,2:212\n1915#2,2:214\n1#3:211\n*S KotlinDebug\n*F\n+ 1 CNCVerseSettings.kt\ncom/horis/cncverse/CNCVerseSettings\n*L\n32#1:204\n32#1:205,2\n33#1:207\n33#1:208,3\n108#1:212,2\n115#1:214,2\n*E\n"})
public final class CNCVerseSettings extends BottomSheetDialogFragment {

    @NotNull
    private final Set<String> enabledStudios;

    @NotNull
    private final CNCVersePlugin plugin;

    @Nullable
    private final SharedPreferences sharedPref;

    @NotNull
    private final List<StudioOption> studios;

    public CNCVerseSettings(@NotNull CNCVersePlugin plugin, @Nullable SharedPreferences sharedPref, @NotNull List<StudioOption> list) {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.studios = list;
        Iterable $this$filter$iv = this.studios;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            StudioOption it = (StudioOption) element$iv$iv;
            if (isStudioEnabled(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            StudioOption it2 = (StudioOption) item$iv$iv;
            destination$iv$iv2.add(it2.getKey());
        }
        this.enabledStudios = CollectionsKt.toMutableSet((List) destination$iv$iv2);
    }

    private final boolean isStudioEnabled(StudioOption option) {
        SharedPreferences prefs = this.sharedPref;
        if (prefs != null && prefs.contains(option.getKey())) {
            return prefs.getBoolean(option.getKey(), false);
        }
        return true;
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        $this$makeTvCompatible.setPadding($this$makeTvCompatible.getPaddingLeft() + 10, $this$makeTvCompatible.getPaddingTop() + 10, $this$makeTvCompatible.getPaddingRight() + 10, $this$makeTvCompatible.getPaddingBottom() + 10);
        $this$makeTvCompatible.setBackground(getDrawable("outline"));
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
        TextView headerTw = (TextView) findViewByName(view, "header_tw");
        if (headerTw != null) {
            headerTw.setText(getString("header_tw"));
        }
        TextView header2Tw = (TextView) findViewByName(view, "header2_tw");
        if (header2Tw != null) {
            header2Tw.setText(getString("header2_tw"));
        }
        ImageButton saveBtn = (ImageButton) findViewByName(view, "save_btn");
        if (saveBtn != null) {
            makeTvCompatible(saveBtn);
        }
        if (saveBtn != null) {
            saveBtn.setImageDrawable(getDrawable("save_icon"));
        }
        LinearLayout scrollView = (LinearLayout) findViewByName(view, "list");
        Iterable $this$forEach$iv = this.studios;
        for (Object element$iv : $this$forEach$iv) {
            StudioOption option = (StudioOption) element$iv;
            if (scrollView != null) {
                scrollView.addView(getStudioRow(option));
            }
        }
        if (saveBtn != null) {
            saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.CNCVerseSettings$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CNCVerseSettings.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final CNCVerseSettings this$0, View it) {
        SharedPreferences sharedPreferences = this$0.sharedPref;
        SharedPreferences.Editor $this$onViewCreated_u24lambda_u241_u240 = sharedPreferences != null ? sharedPreferences.edit() : null;
        if ($this$onViewCreated_u24lambda_u241_u240 != null) {
            $this$onViewCreated_u24lambda_u241_u240.clear();
        }
        Iterable $this$forEach$iv = this$0.studios;
        for (Object element$iv : $this$forEach$iv) {
            StudioOption option = (StudioOption) element$iv;
            if ($this$onViewCreated_u24lambda_u241_u240 != null) {
                $this$onViewCreated_u24lambda_u241_u240.putBoolean(option.getKey(), this$0.enabledStudios.contains(option.getKey()));
            }
        }
        if ($this$onViewCreated_u24lambda_u241_u240 != null) {
            $this$onViewCreated_u24lambda_u241_u240.apply();
        }
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Restart Required").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.horis.cncverse.CNCVerseSettings$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CNCVerseSettings.onViewCreated$lambda$1$1(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.horis.cncverse.CNCVerseSettings$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CNCVerseSettings.onViewCreated$lambda$1$2(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$1(CNCVerseSettings this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$2(DialogInterface dialog, int i) {
        dialog.dismiss();
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Settings saved. Restart app to apply changes.", (Integer) null, 2, (Object) null);
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

    private final RelativeLayout getStudioRow(final StudioOption option) {
        RelativeLayout relativeLayout = new RelativeLayout(requireContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setPadding(0, 0, 0, 8);
        final CheckBox checkBox = new CheckBox(requireContext());
        checkBox.setId(View.generateViewId());
        RelativeLayout.LayoutParams $this$getStudioRow_u24lambda_u241_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$getStudioRow_u24lambda_u241_u240.addRule(20);
        $this$getStudioRow_u24lambda_u241_u240.addRule(15);
        checkBox.setLayoutParams($this$getStudioRow_u24lambda_u241_u240);
        TextView textView = new TextView(requireContext());
        textView.setId(View.generateViewId());
        textView.setText(option.getLabel());
        textView.setTextSize(16.0f);
        RelativeLayout.LayoutParams $this$getStudioRow_u24lambda_u242_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$getStudioRow_u24lambda_u242_u240.addRule(17, checkBox.getId());
        $this$getStudioRow_u24lambda_u242_u240.addRule(15);
        $this$getStudioRow_u24lambda_u242_u240.setMarginStart(16);
        textView.setLayoutParams($this$getStudioRow_u24lambda_u242_u240);
        checkBox.setChecked(this.enabledStudios.contains(option.getKey()));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.horis.cncverse.CNCVerseSettings$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CNCVerseSettings.getStudioRow$lambda$3(this.f$0, option, compoundButton, z);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.horis.cncverse.CNCVerseSettings$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CNCVerseSettings.getStudioRow$lambda$4(checkBox, view);
            }
        });
        relativeLayout.addView(checkBox);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStudioRow$lambda$3(CNCVerseSettings this$0, StudioOption $option, CompoundButton compoundButton, boolean checked) {
        if (checked) {
            this$0.enabledStudios.add($option.getKey());
        } else {
            this$0.enabledStudios.remove($option.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStudioRow$lambda$4(CheckBox $checkBox, View it) {
        $checkBox.setChecked(!$checkBox.isChecked());
    }
}
