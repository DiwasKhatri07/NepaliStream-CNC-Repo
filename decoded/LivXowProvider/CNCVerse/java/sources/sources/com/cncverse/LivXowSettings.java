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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: LivXowSettings.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\bH\u0003J%\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/cncverse/LivXowSettings;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/cncverse/LivXowPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "categoryNames", "", "", "<init>", "(Lcom/cncverse/LivXowPlugin;Landroid/content/SharedPreferences;Ljava/util/List;)V", "enabledCategories", "", "makeTvCompatible", "", "Landroid/view/View;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "getString", "findViewByName", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "restartApp", "getCategoryRow", "Landroid/widget/RelativeLayout;", "categoryName", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowSettings.kt\ncom/cncverse/LivXowSettings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n777#2:192\n873#2,2:193\n1915#2,2:196\n1915#2,2:198\n1#3:195\n*S KotlinDebug\n*F\n+ 1 LivXowSettings.kt\ncom/cncverse/LivXowSettings\n*L\n38#1:192\n38#1:193,2\n105#1:196,2\n112#1:198,2\n*E\n"})
public final class LivXowSettings extends BottomSheetDialogFragment {

    @NotNull
    private final List<String> categoryNames;

    @NotNull
    private final List<String> enabledCategories;

    @NotNull
    private final LivXowPlugin plugin;

    @Nullable
    private final SharedPreferences sharedPref;

    public LivXowSettings(@NotNull LivXowPlugin plugin, @Nullable SharedPreferences sharedPref, @NotNull List<String> list) {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.categoryNames = list;
        Iterable $this$filter$iv = this.categoryNames;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            SharedPreferences sharedPreferences = this.sharedPref;
            if (sharedPreferences != null ? sharedPreferences.getBoolean(it, false) : false) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        this.enabledCategories = CollectionsKt.toMutableList((List) destination$iv$iv);
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
            String string = getString("header_tw");
            if (string == null) {
                string = "LivXow";
            }
            headerTw.setText(string);
        }
        TextView header2Tw = (TextView) findViewByName(view, "header2_tw");
        if (header2Tw != null) {
            String string2 = getString("header2_tw");
            if (string2 == null) {
                string2 = "Select Categories";
            }
            header2Tw.setText(string2);
        }
        ImageButton saveBtn = (ImageButton) findViewByName(view, "save_btn");
        if (saveBtn != null) {
            makeTvCompatible(saveBtn);
        }
        if (saveBtn != null) {
            saveBtn.setImageDrawable(getDrawable("save_icon"));
        }
        LinearLayout scrollView = (LinearLayout) findViewByName(view, "list");
        Iterable $this$forEach$iv = this.categoryNames;
        for (Object element$iv : $this$forEach$iv) {
            String cat = (String) element$iv;
            if (scrollView != null) {
                scrollView.addView(getCategoryRow(cat));
            }
        }
        if (saveBtn != null) {
            saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowSettings$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LivXowSettings.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final LivXowSettings this$0, View it) {
        SharedPreferences sharedPreferences = this$0.sharedPref;
        SharedPreferences.Editor $this$onViewCreated_u24lambda_u241_u240 = sharedPreferences != null ? sharedPreferences.edit() : null;
        if ($this$onViewCreated_u24lambda_u241_u240 != null) {
            $this$onViewCreated_u24lambda_u241_u240.clear();
        }
        Iterable $this$forEach$iv = this$0.enabledCategories;
        for (Object element$iv : $this$forEach$iv) {
            String it2 = (String) element$iv;
            if ($this$onViewCreated_u24lambda_u241_u240 != null) {
                $this$onViewCreated_u24lambda_u241_u240.putBoolean(it2, true);
            }
        }
        if ($this$onViewCreated_u24lambda_u241_u240 != null) {
            $this$onViewCreated_u24lambda_u241_u240.apply();
        }
        LivXowProviderManager.INSTANCE.invalidateCache();
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Restart Required").setMessage("Settings saved. Restart the app to apply changes?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.cncverse.LivXowSettings$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LivXowSettings.onViewCreated$lambda$1$1(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.cncverse.LivXowSettings$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LivXowSettings.onViewCreated$lambda$1$2(dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$1(LivXowSettings this$0, DialogInterface dialogInterface, int i) {
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
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            context.startActivity(Intent.makeRestartActivityTask(componentName));
            Runtime.getRuntime().exit(0);
        }
    }

    private final RelativeLayout getCategoryRow(final String categoryName) {
        RelativeLayout relativeLayout = new RelativeLayout(requireContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setPadding(0, 0, 0, 8);
        final CheckBox checkBox = new CheckBox(requireContext());
        checkBox.setId(View.generateViewId());
        RelativeLayout.LayoutParams $this$getCategoryRow_u24lambda_u241_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$getCategoryRow_u24lambda_u241_u240.addRule(20);
        $this$getCategoryRow_u24lambda_u241_u240.addRule(15);
        checkBox.setLayoutParams($this$getCategoryRow_u24lambda_u241_u240);
        TextView textView = new TextView(requireContext());
        textView.setId(View.generateViewId());
        textView.setText(categoryName);
        textView.setTextSize(16.0f);
        RelativeLayout.LayoutParams $this$getCategoryRow_u24lambda_u242_u240 = new RelativeLayout.LayoutParams(-2, -2);
        $this$getCategoryRow_u24lambda_u242_u240.addRule(17, checkBox.getId());
        $this$getCategoryRow_u24lambda_u242_u240.addRule(15);
        $this$getCategoryRow_u24lambda_u242_u240.setMarginStart(16);
        textView.setLayoutParams($this$getCategoryRow_u24lambda_u242_u240);
        checkBox.setChecked(this.enabledCategories.contains(categoryName));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cncverse.LivXowSettings$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LivXowSettings.getCategoryRow$lambda$3(this.f$0, categoryName, compoundButton, z);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.LivXowSettings$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivXowSettings.getCategoryRow$lambda$4(checkBox, view);
            }
        });
        relativeLayout.addView(checkBox);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryRow$lambda$3(LivXowSettings this$0, String $categoryName, CompoundButton compoundButton, boolean checked) {
        if (!checked) {
            this$0.enabledCategories.remove($categoryName);
        } else {
            this$0.enabledCategories.add($categoryName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryRow$lambda$4(CheckBox $checkBox, View it) {
        $checkBox.setChecked(!$checkBox.isChecked());
    }
}
