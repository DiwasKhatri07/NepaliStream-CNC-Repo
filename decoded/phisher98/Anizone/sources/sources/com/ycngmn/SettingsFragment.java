package com.ycngmn;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anizone/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ycngmn/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/ycngmn/AnizonePlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/ycngmn/AnizonePlugin;Landroid/content/SharedPreferences;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "restartApp", "Anizone"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/ycngmn/SettingsFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,77:1\n1#2:78\n43#3,8:79\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/ycngmn/SettingsFragment\n*L\n56#1:79,8\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final AnizonePlugin plugin;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull AnizonePlugin plugin, @NotNull SharedPreferences sharedPref) {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resources res = this.plugin.getResources();
        if (res == null) {
            return null;
        }
        int id = res.getIdentifier("anizone_settings_fragment", "layout", "com.phisher98");
        XmlResourceParser layout = res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Resources res = this.plugin.getResources();
        if (res == null) {
            return;
        }
        int spinnerId = res.getIdentifier("language_spinner", "id", "com.phisher98");
        int saveBtnId = res.getIdentifier("save_button", "id", "com.phisher98");
        final Spinner spinner = (Spinner) view.findViewById(spinnerId);
        Button saveBtn = (Button) view.findViewById(saveBtnId);
        List options = CollectionsKt.listOf(new String[]{"Default (0)", "English (1)", "Romaji (5)", "Japanese (8)", "Chinese Simplified (9)", "Chinese Traditional (38)"});
        final List values = CollectionsKt.listOf(new String[]{"0", "1", "5", "8", "9", "38"});
        ArrayAdapter adapter = new ArrayAdapter(requireContext(), R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) adapter);
        String currentPref = this.sharedPref.getString("anizone_title_language", "1");
        Integer numValueOf = Integer.valueOf(CollectionsKt.indexOf(values, currentPref));
        int it = numValueOf.intValue();
        if (!(it != -1)) {
            numValueOf = null;
        }
        int currentIndex = numValueOf != null ? numValueOf.intValue() : 0;
        spinner.setSelection(currentIndex);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ycngmn.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$1(spinner, values, this, view2);
            }
        });
    }

    static final void onViewCreated$lambda$1(Spinner $spinner, List $values, SettingsFragment this$0, View it) {
        int selectedIndex = $spinner.getSelectedItemPosition();
        String selectedValue = (String) $values.get(selectedIndex);
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putString("anizone_title_language", selectedValue);
        editor$iv.commit();
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
